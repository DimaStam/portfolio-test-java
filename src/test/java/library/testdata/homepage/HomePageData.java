package library.testdata.homepage;

import lombok.Getter;

@Getter
public enum HomePageData {

    TEXT_WITH_INFORMATION_ABOUT_OPENING_TIME_IT("We are available Mon-Fri 09:00-18:00"),
    OPENING_TIME_FROM_MONDAY_TO_FRIDAY_PL("Mon-Fri: 09:00-18:00"),
    OPENING_TIME_FROM_SATURDAY_TO_SUNDAY_PL("Sat-Sun: 10:00-14:00"),
    BLOG_SECTION_TITLE_TEXT("BLOG"),
    TEXT_BUTTON_NAVIGATE_TO_BLOG_IT("Go to blog"),
    TEXT_BUTTON_NAVIGATE_TO_BLOG_PL("Go to blog"),
    TEXT_BUTTON_NAVIGATE_TO_BLOG_STORE2("Go to tips");

    private final String value;

    HomePageData(String value) {
        this.value = value;
    }
}
