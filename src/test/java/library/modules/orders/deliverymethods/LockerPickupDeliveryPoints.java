package library.modules.orders.deliverymethods;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import library.main.TestDrivers;

public class LockerPickupDeliveryPoints extends TestDrivers{

    public Locator openMapButton;
    public Locator addressInput;
    public Locator lockerPickupDeliveryPoint;

    public LockerPickupDeliveryPoints(Page page){
        this.page = page;
        this.openMapButton = page.locator("#change-delivery-point-locker-pickup");
        this.addressInput = page.locator("#delivery-point-find");
        this.lockerPickupDeliveryPoint = page.locator("//button[@data-code='LOCKER-001']");
    }

    public LockerPickupDeliveryPoints openMap(){
        openMapButton.click();
        return this;
    }

    public LockerPickupDeliveryPoints enterDeliveryPointsAddressName(String addressName){
        addressInput.fill(addressName);
        while (!lockerPickupDeliveryPoint.isVisible())
            addressInput.press("Enter");

        return this;
    }

    public LockerPickupDeliveryPoints selectDeliveryPoint(){
        lockerPickupDeliveryPoint.click();
        return this;
    }
}
