package library.testdata.productcard;

import lombok.Getter;

@Getter
public enum ProductCardData {
    ADRESS_NAME("Sample Street 1"),
    STORE_NAME("Store 1 - Downtown"),
    STORE_OPEN_HOURS("Mon-Fri: 09:00-18:00, Sat: 10:00-14:00"),
    INSTALLMENT_SLOGAN("Pay later within 30 days");

    private final String value;
    ProductCardData(String value){
        this.value = value;
    }
}

