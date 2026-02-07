#!/bin/bash
set -euo pipefail

PROJECT_ID="${1:-}"
ALLURE_FINAL_REPORT="${2:-}"

if [ -z "$PROJECT_ID" ] || [ -z "$ALLURE_FINAL_REPORT" ]; then
  echo "Usage: $0 <project_id> <allure_report_url>"
  exit 1
fi

SUITES_JSON_URL=$(echo "$ALLURE_FINAL_REPORT" | sed 's/index.html/data\/suites.json/')
SUITES_JSON=$(wget -qO- "$SUITES_JSON_URL" || true)

base_url="${ALLURE_FINAL_REPORT}#suites"
report_url="$ALLURE_FINAL_REPORT"

MESSAGE_HEADER="Pipeline ${PROJECT_ID}"$'\n'
MESSAGE_HEADER+=":notebook: <${report_url}|Allure report>"$'\n'

declare -A symbols=( ["failed"]=":x:" ["broken"]=":large_yellow_square:" ["passed"]=":white_check_mark:" )
declare -A STATUS_MESSAGE=()
PASSED_TESTS=0
TOTAL_TESTS=0

process_json() {
  local json="$1"

  while read -r status; do
    if [[ "$status" != "null" ]]; then
      while read -r test; do
        name=$(jq -r '.name' <<< "$test")
        parentUid=$(jq -r '.parentUid' <<< "$test")
        uid=$(jq -r '.uid' <<< "$test")
        url="<${base_url}/${parentUid}/${uid}|${name}>"
        if [[ "$status" == "passed" ]]; then
          ((PASSED_TESTS++))
        else
          STATUS_MESSAGE[$status]+="${symbols[$status]} $url"$'\n'
        fi
        ((TOTAL_TESTS++))
      done < <(jq -c "select(.status==\"$status\")" <<< "$json")
    fi
  done < <(jq -r '.status' <<< "$json")

  while read -r child; do
    process_json "$child"
  done < <(jq -c '.children[]?' <<< "$json")
}

if [ -n "$SUITES_JSON" ]; then
  process_json "$SUITES_JSON"
fi

for status in "${!STATUS_MESSAGE[@]}"; do
  if [[ "$status" != "passed" ]]; then
    MESSAGE+=$'\n'"Tests with status $status:"$'\n'
    MESSAGE+=${STATUS_MESSAGE[$status]}
  fi
done

if [[ $TOTAL_TESTS -ne 0 ]]; then
  MESSAGE_HEADER+=" Passed: $PASSED_TESTS/$TOTAL_TESTS ${symbols["passed"]}"$'\n'
else
  MESSAGE_HEADER+=" Passed: 0/0 (no tests in report)"$'\n'
fi

MESSAGE=$(echo "$MESSAGE_HEADER $MESSAGE" | jq -Rs .)

CHANNEL="${CHANNEL:-}"
WEBHOOK_URL="${WEBHOOK_URL:-}"

if [ -z "$WEBHOOK_URL" ]; then
  echo "WEBHOOK_URL is not set; skipping report send."
  exit 0
fi

PAYLOAD="{\"channel\": \"$CHANNEL\", \"text\": $MESSAGE, \"pipelineId\": \"$PROJECT_ID\"}"
curl -s -X POST -H 'Content-type: application/json;charset=utf-8' --data "$PAYLOAD" "$WEBHOOK_URL"
