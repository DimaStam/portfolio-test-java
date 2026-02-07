package library.testdata.orders;

import lombok.Getter;

@Getter
public enum ProductData {
    TEST_PRODUCT_NAME("Sample Product Name"),
    INSTALLMENT_TEXT("Pay later within 30 days"),
    STOCK_TEXT("In stock online");


    private final String value;
    ProductData(String value){
        this.value = value;
    }
}
