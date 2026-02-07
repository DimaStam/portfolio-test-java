package library.modules.orders.add;

import lombok.Data;

@Data
public class DeliveryDto {
    protected String userEmail;
    protected String userFirstName;
    protected String userLastName;
    protected String companyName;
    protected String streetAddress;
    protected String houseNumber;
    protected String apartmentNumber;
    protected String postCode;
    protected String premiumPostCode;
    protected String city;
    protected String phoneNumber;
}
