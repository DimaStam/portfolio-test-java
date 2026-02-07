package library.modules.orders.add;

public class DeliveryFactory {
    public static DeliveryDto createDeliveryData(){
        DeliveryDto deliveryData = new DeliveryDto();
        deliveryData.setUserEmail("store.user@example.test");
        deliveryData.setUserFirstName("Test");
        deliveryData.setUserLastName("User");
        deliveryData.setCompanyName("Example Corp");
        deliveryData.setStreetAddress("Sample Street");
        deliveryData.setHouseNumber("1");
        deliveryData.setApartmentNumber("2");
        deliveryData.setPostCode("12345");
        deliveryData.setCity("Sample City");
        deliveryData.setPhoneNumber("555000000");
        return deliveryData;
    }

    public static DeliveryDto createPremiumDeliveryData(){
        DeliveryDto deliveryData = new DeliveryDto();
        deliveryData.setUserEmail("store.user@example.test");
        deliveryData.setUserFirstName("Test");
        deliveryData.setUserLastName("User");
        deliveryData.setCompanyName("Example Corp");
        deliveryData.setStreetAddress("Sample Street");
        deliveryData.setHouseNumber("1");
        deliveryData.setApartmentNumber("2");
        deliveryData.setPremiumPostCode("99999");
        deliveryData.setCity("Sample City");
        deliveryData.setPhoneNumber("555000000");
        return deliveryData;
    }
}
