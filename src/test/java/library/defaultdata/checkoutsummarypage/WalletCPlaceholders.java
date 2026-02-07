package library.defaultdata.checkoutsummarypage;

public enum WalletCPlaceholders {

    EMAIL_INPUT("Email"),
    PASSWORD_INPUT("Password"),
    CONTINUE_BUTTON_NAME("Continue"),
    LOGIN_BUTTON_NAME("Log in"),
    PLACE_ORDER_BUTTON_ID("submit-button-initial");

    private final String value;
    WalletCPlaceholders(String value){
        this.value = value;
    }

    public String getValue(){
        return value;
    }
}
