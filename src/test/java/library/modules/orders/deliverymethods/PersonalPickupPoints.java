package library.modules.orders.deliverymethods;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import library.main.TestDrivers;

public class PersonalPickupPoints extends TestDrivers {

    private Locator addressInput;
    private Locator openMap;
    private Locator personalPickupDeliveryPoint;

    public PersonalPickupPoints(Page page){
        this.page = page;
        this.addressInput = page.locator("#delivery-point-storelocator-find");
        this.openMap = page.locator("#change-delivery-point-store_delivery");
        this.personalPickupDeliveryPoint = page.locator("//div[@class='availability-popup-map']//button[@data-code='STORE-001']");
    }

    public PersonalPickupPoints openStoreLocatorMap(){
        openMap.click();
        return this;
    }

    public PersonalPickupPoints enterPersonalPickupAddressName(String addressName){
        addressInput.fill(addressName);
        while (!personalPickupDeliveryPoint.isVisible())
            addressInput.press("Enter");
        return this;
    }

    public PersonalPickupPoints selectDeliveryPoint(){
        personalPickupDeliveryPoint.click();
        return this;
    }
}
