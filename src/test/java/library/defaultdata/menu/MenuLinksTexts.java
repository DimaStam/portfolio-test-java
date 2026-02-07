package library.defaultdata.menu;

import lombok.Getter;

@Getter
public enum MenuLinksTexts {
    AILMENTS_AND_PREVENTION_PL("category-a"),
    BRANDS_URL_IT("category-brands-it"),
    BRANDS_URL_PL("category-brands-pl"),
    BODY_URL_IT("category-body-it"),
    CARE_URL_IT("category-care-it"),
    CARE_URL_PL("category-care-pl"),
    CBD_URL_PL("category-b"),
    CHILD_URL_IT("category-child-it"),
    CHILD_URL_PL("category-child-pl"),
    DERMOCOSMETICS_URL_IT("category-c"),
    DERMOCOSMETICS_URL_PL("category-c-pl"),
    DERMATOLOGY_PL("category-d"),
    DIET_URL_PL("category-e"),
    INTIMATE_HEALTH_PL("category-f"),
    HEALTH_URL_IT("category-health-it"),
    HEALTH_URL_PL("category-health-pl"),
    HOUSE_URL_IT("category-house-it"),
    HOUSE_URL_PL("category-house-pl"),
    HYGIENE_URL_IT("category-hygiene-it"),
    HYGIENE_URL_PL("category-hygiene-pl"),
    MAKEUP_URL_IT("category-g"),
    MAKEUP_URL_PL("category-g-pl"),
    MEDICAL_EQUIPMENT_AND_ACCESSORIES_PL("category-h"),
    OPTICIAN_URL_PL("category-i"),
    PERFUMERY_URL_IT("category-j"),
    PERFUMERY_URL_PL("category-j-pl"),
    PREGNANCY_AND_MOTHERHOOD_PL("category-k"),
    PRESCRIPTION_PL("category-l"),
    PROMOTIONS_URL_PL("promotions"),
    VITAMINS_URL_PL("category-m");

    private final String value;

    MenuLinksTexts(String value) {
        this.value = value;
    }
}
