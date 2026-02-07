#!/bin/bash
set -euo pipefail

# Supported args: --send_slack_report=0|1
send_slack_report=1
declare -A valid_args
valid_args=( ["send_slack_report"]=1 )

for arg in "$@"; do
  key=$(echo "$arg" | cut -f1 -d=)
  value=$(echo "$arg" | cut -f2 -d=)

  if [[ $key == *"--"* ]]; then
    v="${key/--/}"
    if [[ ${valid_args[$v]:-} ]]; then
      declare "$v"="$value"
    else
      echo "Unknown argument: $v"
    fi
  fi
done

ALLURE_RESULTS_DIRECTORY='../target/allure-results'
ALLURE_SERVER="${ALLURE_SERVER:-https://allure.example.test}"
PROJECT_ID="${1:-}"

if [ -z "$PROJECT_ID" ]; then
  echo "Usage: $0 <project_id> [--send_slack_report=0|1]"
  exit 1
fi

echo "send_slack_report: $send_slack_report"
echo "allure-push.sh: CREATE PROJECT $PROJECT_ID"

curl -s --location --request POST "$ALLURE_SERVER/allure-docker-service/projects" \
  --header 'Content-Type: application/json' \
  --data-raw "{
  \"id\": \"$PROJECT_ID\"
}"

DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" >/dev/null 2>&1 && pwd )"
# shellcheck disable=SC2010
FILES_TO_SEND=$(ls -dp "$DIR"/$ALLURE_RESULTS_DIRECTORY/* | grep -v /$)
if [ -z "$FILES_TO_SEND" ]; then
  echo "No allure results found in $ALLURE_RESULTS_DIRECTORY"
  exit 1
fi

FILES=''
for FILE in $FILES_TO_SEND; do
  FILES+="-F files[]=@$FILE "
done

echo "allure-push.sh: SEND-RESULTS"
curl -s -X POST "$ALLURE_SERVER/allure-docker-service/send-results?project_id=$PROJECT_ID" \
  -H 'Content-Type: multipart/form-data' $FILES -ik

echo "allure-push.sh: GENERATE-REPORT"
EXECUTION_NAME='execution_from_bash_script'
EXECUTION_FROM='allure-push.sh'
EXECUTION_TYPE='script'

MAX_RETRIES=5
COUNTER=0

while [ $COUNTER -lt $MAX_RETRIES ]; do
  RESPONSE=$(curl -s -X GET "$ALLURE_SERVER/allure-docker-service/generate-report?project_id=$PROJECT_ID&execution_name=$EXECUTION_NAME&execution_from=$EXECUTION_FROM&execution_type=$EXECUTION_TYPE" $FILES)
  if [[ "$RESPONSE" == *"Try later"* ]]; then
    RANDOM_SLEEP=$(( RANDOM % 15 + 1 ))
    echo "Response contains 'Try later!', retrying after $RANDOM_SLEEP seconds..."
    sleep $RANDOM_SLEEP
    ((COUNTER++))
  else
    echo "Response does not contain 'Try later!', exiting loop."
    break
  fi
done

ALLURE_REPORT=$(grep -o '"report_url":"[^"]*' <<< "$RESPONSE" | grep -o '[^"]*$')
ALLURE_FINAL_REPORT="${ALLURE_REPORT:-}"

echo "Test report was pushed to the Allure server."
echo "Report url: $ALLURE_FINAL_REPORT"

if [ "$send_slack_report" == "1" ] && [ -n "$ALLURE_FINAL_REPORT" ]; then
  SCRIPT_DIR="$(dirname "$0")"
  bash "$SCRIPT_DIR"/slack-report.sh "$PROJECT_ID" "$ALLURE_FINAL_REPORT"
fi
