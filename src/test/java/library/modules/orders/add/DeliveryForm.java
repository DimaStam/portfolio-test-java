package library.modules.orders.add;

import com.microsoft.playwright.Page;
import library.main.TestDrivers;

public class DeliveryForm extends TestDrivers {

    public DeliveryForm(Page page){
        this.page = page;
    }

    public DeliveryForm fillCheckoutDeliveryForm(DeliveryDto delivery){
        new DeliveryData(page)
                .fillUserEmail(delivery.getUserEmail())
                .fillUserFirstName(delivery.getUserFirstName())
                .fillUserLastName(delivery.getUserLastName())
                .fillCompany(delivery.getCompanyName())
                .fillStreetAddress(delivery.getStreetAddress())
                .fillHouseNumber(delivery.getHouseNumber())
                .fillApartmentNumber(delivery.getApartmentNumber())
                .fillPostCode(delivery.getPostCode())
                .fillCity(delivery.getCity())
                .fillPhoneNumber(delivery.getPhoneNumber());
        return this;
    }

    public DeliveryForm fillPremiumCheckoutDeliveryForm(DeliveryDto delivery){
        new DeliveryData(page)
                .fillUserEmail(delivery.getUserEmail())
                .fillUserFirstName(delivery.getUserFirstName())
                .fillUserLastName(delivery.getUserLastName())
                .fillCompany(delivery.getCompanyName())
                .fillStreetAddress(delivery.getStreetAddress())
                .fillHouseNumber(delivery.getHouseNumber())
                .fillApartmentNumber(delivery.getApartmentNumber())
                .fillPostCode(delivery.getPremiumPostCode())
                .fillCity(delivery.getCity())
                .fillPhoneNumber(delivery.getPhoneNumber());
        return this;
    }
}
