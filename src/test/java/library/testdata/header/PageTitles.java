package library.testdata.header;

import lombok.Getter;

@Getter
public enum PageTitles {

    // Main page titles
    STORE1_IT_PAGE_TITLE("Store 1 - Home (IT)"),
    STORE1_PL_PAGE_TITLE("Store 1 - Home (PL)"),
    STORE2_PAGE_TITLE("Store 2 - Home"),

    // Category page titles
    ABOUT_US_PAGE_TITLE_IT("About Us (IT)"),
    ABOUT_US_PAGE_TITLE_PL("About Us (PL)"),
    BRANDS_TITLE_IT("Brands (IT)"),
    BRANDS_TITLE_PL("Brands (PL)"),
    BODY_TITLE_IT("Category Body (IT)"),
    CARE_TITLE_IT("Category Care (IT)"),
    CARE_TITLE_STORE1_PL("Category Care (Store 1)"),
    CARE_TITLE_STORE2_PL("Category Care (Store 2)"),
    CBD_TITLE_PL("Category CBD (PL)"),
    CHILD_TITLE_IT("Category Child (IT)"),
    CHILD_TITLE_PL("Category Child (PL)"),
    EXTERNAL_INFO_TITLE_PL("External Info"),
    CLUB_TITLE("Store 1 Club"),
    CONTACT_TITLE_IT("Contact (IT)"),
    CONTACT_TITLE_PL("Contact (PL)"),
    COOKIE_TITLE_IT("Cookies (IT)"),
    CONSUMER_RIGHTS_TITLE_PL("Consumer Rights (PL)"),
    DELIVERY_TITLE_IT("Delivery (IT)"),
    DELIVERY_TITLE_PL("Delivery (PL)"),
    DERMOCOSMETICS_TITLE_IT("Category A (IT)"),
    DERMOCOSMETICS_TITLE_PL("Category A (PL)"),
    DERMATOLOGY_TITLE_PL("Category B (PL)"),
    DIET_TITLE_PL("Category C (PL)"),
    EMPTY_MINI_CART_TITLE_IT("Cart is empty (IT)"),
    EMPTY_MINI_CART_TITLE_PL("Cart is empty (PL)"),
    FAQ_TITLE_IT("FAQ (IT)"),
    FAQ_TITLE_PL("FAQ (PL)"),
    HEALTH_TITLE_IT("Category Health (IT)"),
    HEALTH_TITLE_STORE2_PL("Category Health (Store 2)"),
    HEALTH_TITLE_STORE1_PL("Category Health (Store 1)"),
    HOUSE_TITLE_IT("Category House (IT)"),
    HOUSE_TITLE_PL("Category House (PL)"),
    HYGIENE_TITLE_IT("Category Hygiene (IT)"),
    HYGIENE_TITLE_PL("Category Hygiene (PL)"),
    LOGIN_PAGE_TITLE_IT("Login (IT)"),
    LOGIN_PAGE_TITLE_PL("Login (PL)"),
    MAKEUP_TITLE_IT("Category Makeup (IT)"),
    MAKEUP_TITLE_PL("Category Makeup (PL)"),
    MY_ACCOUNT_TITLE_IT("My Account (IT)"),
    MY_ACCOUNT_TITLE_PL("My Account (PL)"),
    OPTICIAN_TITLE_PL("Category Optics (PL)"),
    PAYMENT_TITLE_IT("Payment (IT)"),
    PAYMENT_TITLE_PL("Payment (PL)"),
    STORE2_GUIDE_TITLE("Store 2 Guide"),
    STORE2_LIST_TITLE("Store 2 List"),
    STORE2_REGULATION_TITLE("Store 2 Terms"),
    PERFUMERY_TITLE_IT("Category Perfume (IT)"),
    PERFUMERY_TITLE_PL("Category Perfume (PL)"),
    PRESCRIPTION_TITLE_PL("Category D (PL)"),
    PRIVACY_POLICY_TITLE_IT("Privacy Policy (IT)"),
    PRIVACY_POLICY_TITLE_PL("Privacy Policy (PL)"),
    PROMOTIONS_TITLE_PL("Promotions (PL)"),
    BANK_LIST_TITLE("Bank List"),
    REGULATION_TITLE_IT("Terms (IT)"),
    REGULATION_TITLE_PL("Terms (PL)"),
    RETURN_ONLINE_TITLE_PL("Returns (PL)"),
    RETURN_STATIONARY_TITLE_PL("Returns In Store (PL)"),
    RETURN_TITLE_IT("Returns (IT)"),
    RESERVATION_SERVICE_REGULATIONS_TITLE("Reservation Terms"),
    SUCCESS_PAGE_PL("Success"),
    VITAMINS_TITLE_PL("Category E (PL)"),
    WISHLIST_TITLE_IT("Wishlist (IT)"),
    WISHLIST_TITLE_PL("Wishlist (PL)"),
    WITHDRAWAL_TITLE_IT("Withdrawal Info (IT)");

    private final String value;

    PageTitles(String value) {
        this.value = value;
    }
}
