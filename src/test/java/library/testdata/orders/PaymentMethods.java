package library.testdata.orders;

public final class PaymentMethods {
    // Store 1 PL payment methods (demo selectors)
    public static final String PaymentProviderCodePayment = "//div[@data-payment='code']";
    public static final String PaymentProviderWalletA = "//div[@data-payment='wallet-a']";
    public static final String PaymentProviderCard = "//div[@data-payment='card']";
    public static final String PaymentProviderCashOnDelivery = "//div[@data-payment='cash-on-delivery']";
    public static final String PaymentProviderBankTransfer = "//div[@data-payment='bank-transfer']";
    public static final String PaymentProviderWalletB = "//div[@data-payment='wallet-b']";
    public static final String PaymentProviderWalletC = "//div[@data-payment='wallet-c']";

    // Bank transfer list (demo selector)
    public static final String bankTransferDefaultXpath = "//li[@data-bank='bank-001']";

    // Alternate provider (demo selectors)
    public static final String AltProviderCodePayment = "//li[@data-gate='code']";
    public static final String AltProviderWalletA = "//li[@data-gate='wallet-a']";
    public static final String AltProviderCard = "//li[@data-gate='card']";
    public static final String AltProviderInstallment = "//li[@data-gate='installment']";
    public static final String AltProviderCashOnDelivery = "//div[@data-payment='cash-on-delivery']";
}
