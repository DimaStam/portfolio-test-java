package library.testdata;

public enum AssertionCustomMessages {

    VALIDATION_MESSAGE_ERROR_PL("This field is required."),
    VALIDATION_MESSAGE_ERROR_IT("This field is required.");

    private final String value;

    AssertionCustomMessages(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
