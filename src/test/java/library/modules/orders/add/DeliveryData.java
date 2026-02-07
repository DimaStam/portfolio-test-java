package library.modules.orders.add;

import com.microsoft.playwright.Page;
import library.main.TestDrivers;
import library.pages.store1.pl.orders.CheckoutDeliveryPage;

public class DeliveryData extends TestDrivers{

    protected CheckoutDeliveryPage checkoutDeliveryPage;

    public DeliveryData(Page page){
        this.page = page;
        this.checkoutDeliveryPage = new CheckoutDeliveryPage(page);
    }

    public DeliveryData fillUserEmail(String userEmail){
        if (checkoutDeliveryPage.getUserEmailField().isVisible()){
            checkoutDeliveryPage.getUserEmailField().fill(userEmail);
        }
        return this;
    }

    public DeliveryData fillUserFirstName(String userFirstName){
        checkoutDeliveryPage.getFirstName().fill(userFirstName);
        return this;
    }

    public DeliveryData fillUserLastName(String userLastName){
        checkoutDeliveryPage.getLastName().fill(userLastName);
        return this;
    }

    public DeliveryData fillCompany(String companyName){
        checkoutDeliveryPage.getCompany().fill(companyName);
        return this;
    }

    public DeliveryData fillStreetAddress(String streetAddress){
        checkoutDeliveryPage.getStreet().fill(streetAddress);
        return this;
    }

    public DeliveryData fillHouseNumber(String houseNumber){
        checkoutDeliveryPage.getHouseNumber().fill(houseNumber);
        return this;
    }

    public DeliveryData fillApartmentNumber(String apartmentNumber){
        checkoutDeliveryPage.getApartmentNumber().fill(apartmentNumber);
        return this;
    }

    public DeliveryData fillPostCode(String postCode){
        checkoutDeliveryPage.getPostCode().fill(postCode);
        return this;
    }

    public DeliveryData fillCity(String city){
        checkoutDeliveryPage.getCity().fill(city);
        return this;
    }

    public DeliveryData fillPhoneNumber(String phoneNumber){
        checkoutDeliveryPage.getPhoneNumber().fill(phoneNumber);
        return this;
    }
}
