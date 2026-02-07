package library.pages.store1.listing;

import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.PlaywrightException;
import com.microsoft.playwright.options.BoundingBox;
import com.microsoft.playwright.options.LoadState;
import io.qameta.allure.Step;
import library.main.TestDrivers;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class ListingPage extends TestDrivers {

    private Locator topRightPaginationArrow;
    private Locator filtersDropdown;
    private Locator filtersArea;
    private Locator topLeftPaginationArrow;
    private Locator productTilesCount;
    private Locator productsGrid;
    private Locator minimalPriceSlider;
    private Locator maximumPriceSlider;
    private Locator showProductsFiltersButton;
    private Locator showProductsCountButton;
    private Locator show80ProductsListing;
    private Locator show120ProductsListing;
    private Locator sortProductsDropdown;
    private Locator selectSortAscendingPL;
    private Locator selectSortAscendingIT;
    private Locator selectSortDescendingPL;
    private Locator selectSortDescendingIT;
    private Locator promotedProductsFilterCount;
    private Locator shortDateFilterCount;
    private Locator promotedProductsCheckbox;
    private Locator shortDateCheckbox;
    private Locator promotedProductsPageCount;
    private Locator paginationInput;
    private Locator previousPageButton;
    private Locator showAllCategoriesButton;
    private String productPricesSelector;
    private String productCountQuerySelector80;
    private String productCountQuerySelector120;

    public ListingPage(Page page){
        this.page = page;
        this.topRightPaginationArrow = page.locator("//i[@class='arrow right']");
        this.filtersDropdown = page.locator("//div[@class='refine-toggle']");
        this.filtersArea = page.locator("//div[@class='facets-filters-container']");
        this.topLeftPaginationArrow = page.locator("//i[@class='arrow left']");
        this.productTilesCount = page.locator("//li[@class='ais-Hits-item']");
        this.productsGrid = page.locator("//ol[@class='ais-Hits-list']");
        this.minimalPriceSlider = page.locator("//div[@class='rheostat-handle rheostat-handle-lower']");
        this.maximumPriceSlider = page.locator("//div[@class='rheostat-handle rheostat-handle-upper']");
        this.showProductsFiltersButton = page.locator("//div[@class='d-inline-block refine-toggle show-nbHits action primary']");
        this.showProductsCountButton = page.locator("//div[@id='algolia-product-show']//div[@class='select-selected']");
        this.show80ProductsListing = page.locator("//div[@id='algolia-product-show']//div[@class='select-items']//div[@data-value='80']");
        this.show120ProductsListing = page.locator("//div[@id='algolia-product-show']//div[@class='select-items']//div[@data-value='120']");
        this.sortProductsDropdown = page.locator("//div[@id='algolia-sorts']//div[@class='select-selected']");
        this.selectSortAscendingPL = page.locator("//div[@id='algolia-sorts']//div[@class='select-items']//*[contains(text(),'Najniższa cena')]");
        this.selectSortAscendingIT = page.locator("//div[@id='algolia-sorts']//div[@class='select-items']//*[contains(text(),'Prezzo più basso')]");
        this.selectSortDescendingPL = page.locator("//div[@id='algolia-sorts']//div[@class='select-items']//*[contains(text(),'Najwyższa cena')]");
        this.selectSortDescendingIT = page.locator("//div[@id='algolia-sorts']//div[@class='select-items']//*[contains(text(),'Prezzo massimo')]");
        this.promotedProductsFilterCount = page.locator("//li[@class='ais-RefinementList-item']//input[@value='Promocja']/following-sibling::span[@class='ais-RefinementList-count']");
        this.shortDateFilterCount = page.locator("//li[@class='ais-RefinementList-item']//input[@value='Krótka data']/following-sibling::span[@class='ais-RefinementList-count']");
        this.promotedProductsCheckbox = page.locator("//li[@class='ais-RefinementList-item']//input[@value='Promocja']");
        this.shortDateCheckbox = page.locator("//li[@class='ais-RefinementList-item']//input[@value='Krótka data']");
        this.promotedProductsPageCount = page.locator("//span[@class='products-count products-count-up']");
        this.paginationInput = page.locator("//div[@id='algolia-left-container']//input[@class='primary-text']");
        this.previousPageButton = page.locator("//li[@class='ais-Pagination-item ais-Pagination-item--previousPage']");
        this.showAllCategoriesButton = page.locator("//div[@class='category-filter-more']");
        this.productPricesSelector = "//span[@data-item-price='lowPrice']";
        this.productCountQuerySelector80 = "document.querySelector('.ais-Hits-list').querySelectorAll('.ais-Hits-item:not(.banner)').length === 80";
        this.productCountQuerySelector120 = "document.querySelector('.ais-Hits-list').querySelectorAll('.ais-Hits-item:not(.banner)').length === 120";
    }

    public Locator getSubctegoryLocator(String subCategoryName){
        return page.locator("//div[@class='category-filter-container']//a[@class='ais-HierarchicalMenu-link ' and contains(text(), '" + subCategoryName + "')]");
    }

    public Locator getPromotionCheckbox(String checkboxValue){
        return page.locator("//li[@class='ais-RefinementList-item']//input[@value='" + checkboxValue + "']");
    }

    public Locator getPromotionFilterCount(String checkboxValue){
        return page.locator("//li[@class='ais-RefinementList-item']//input[@value='" + checkboxValue + "']/following-sibling::span[@class='ais-RefinementList-count']");
    }

    public Locator getSubCategoryFromFilter(String subCategoryURL){
        return page.locator("//div[@id='instant-search-facets-container']//div[@class='categories-widget']//a[contains(@href, '" + subCategoryURL + "')]");
    }

    @Step("Wait for products grid")
    public ListingPage waitForProductsGrid(){
        getProductsGrid().waitFor();
        return this;
    }

    @Step("Open filters dropdown")
    public ListingPage openFiltersDropdown(){
        filtersDropdown.waitFor();
        filtersDropdown.click();
        return this;
    }

    @Step("Wait for filter area")
    public ListingPage waitForFiltersArea(){
        page.waitForLoadState(LoadState.DOMCONTENTLOADED);
        filtersArea.waitFor();
        return this;
    }

    @Step("Drag minimal price slider")
    public ListingPage dragMinimalPriceSlider() {
        getMinimalPriceSlider().waitFor(new Locator.WaitForOptions().setTimeout(15000));
        BoundingBox box = getMinimalPriceSlider().boundingBox();
        page.mouse().click(box.x + box.width / 2, box.y + box.height / 2);
        page.mouse().down();
        page.mouse().move(box.x + 20, box.y + 0);
        page.mouse().up();
        return this;
    }

    @Step("Drag maximal price slider")
    public ListingPage dragMaximalPriceSlider(){
        getMaximumPriceSlider().waitFor(new Locator.WaitForOptions().setTimeout(15000));
        BoundingBox box = getMaximumPriceSlider().boundingBox();
        page.mouse().click(box.x + box.width / 2, box.y + box.height / 2);
        page.mouse().down();
        page.mouse().move(box.x - 245, box.y + 0);
        page.mouse().up();
        return this;
    }

    @Step("Click Show products after using filters")
    public ListingPage clickAcceptFiltersButton(){
        getShowProductsFiltersButton().waitFor();
        getShowProductsFiltersButton().click();
        return this;
    }

    @Step("Open Show products count ona  listing dropdown")
    public ListingPage openShowProductsCountDropdown(){
        getShowProductsCountButton().waitFor();
        getShowProductsCountButton().click();
        return this;
    }

    @Step("Click Show 50 products")
    public ListingPage clickShow80Products(){
        getShow80ProductsListing().click();
        return this;
    }

    @Step("Click Show 100 products")
    public ListingPage clickShow120Products(){
        getShow120ProductsListing().click();
        return this;
    }

    @Step("Open sorting dropdowm")
    public ListingPage openSortingDropdown(){
        getSortProductsDropdown().waitFor();
        getSortProductsDropdown().click();
        return this;
    }

    @Step("Click sort by lowest price and wait for response")
    public ListingPage clickSortByLowestPriceAndWaitForResponsePL(String request) {
        page.waitForResponse(response ->
                        response.url().contains(request) && response.status() == 200,
                () -> {
                    getSelectSortAscendingPL().click();
                });
        return this;
    }

    @Step("Click sort by lowest price and wait for response")
    public ListingPage clickSortByLowestPriceAndWaitForResponseIT(String request) {
        page.waitForResponse(response ->
                        response.url().contains(request) && response.status() == 200,
                () -> {
                    getSelectSortAscendingIT().click();
                });
        return this;
    }

    @Step("Click sort by highest price and wait for response")
    public ListingPage clickSortByHighestPriceAndWaitForResponsePL(String request) {
        page.waitForResponse(response ->
                        response.url().contains(request) && response.status() == 200,
                () -> {
                    getSelectSortDescendingPL().click();
                });
        return this;
    }

    @Step("Click sort by highest price and wait for response")
    public ListingPage clickSortByHighestPriceAndWaitForResponseIT(String request) {
        page.waitForResponse(response ->
                        response.url().contains(request) && response.status() == 200,
                () -> {
                    getSelectSortDescendingIT().click();
                });
        return this;
    }

    @Step("Validate prices is in range between 10 and 100")
    public boolean validatePrices(List<Double> prices) {
        for (double price : prices) {
            if (price < getMinimalSliderPrice() || price > getMaximalSliderPrice()) {
                return false;
            }
        }
        return true;
    }

    @Step("Check if prices is sorted from low to high")
    public boolean checkIsPricesSortedAsc(List<Double> prices){
        for (int i = 0; i < prices.size() - 1; i++) {
            if (prices.get(i) > prices.get(i + 1)) {
                return false;
            }
        }
        return true;
    }

    @Step("Check if prices is sorted from low to high")
    public boolean checkIsPricesSortedDesc(List<Double> prices){
        for (int i = 0; i < prices.size() - 1; i++) {
            if (prices.get(i) < prices.get(i + 1)) {
                return false;
            }
        }
        return true;
    }

    @Step("Get product prices after applying price filter")
    public List<Double> getProductPrices() {
        List<Double> cleanedPrices = new ArrayList<>();
        try {
            List<ElementHandle> priceElements = page.querySelectorAll(getProductPricesSelector());
            for (ElementHandle element : priceElements) {
                double price = parseNumberFromString(element.innerText());
                cleanedPrices.add(price);
            }
            System.out.println(cleanedPrices);
        } catch (PlaywrightException e) {
            System.out.println("Error occurred while querying elements: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Error occurred while parsing price: " + e.getMessage());
        }
        return cleanedPrices;
    }

    @Step("Get promoted products count in the filter")
    public int getPromotedProductsFilterCount(String checkboxValue){
        return (int) parseNumberFromString(getPromotionFilterCount(checkboxValue).textContent());
    }

    @Step("Get short date products count in the filter")
    public int getShortDateFilterCount(){
        return (int) parseNumberFromString(shortDateFilterCount.textContent());
    }

    @Step("Select promotions checkbox")
    public ListingPage selectPromotedProductsCheckbox(String checkboxValue){
        getPromotionCheckbox(checkboxValue).click();
        return this;
    }

    @Step("Select promotions checkbox")
    public ListingPage selectShortDateCheckbox(){
        getShortDateCheckbox().click();
        return this;
    }

    @Step("Get promoted products count at the top of the page")
    public int getProductsPageCount(){
        return (int) parseNumberFromString(promotedProductsPageCount.textContent());
    }

    @Step("Click top right pagination arrow")
    public ListingPage clickTopRightPaginationArrow(){
        page.waitForTimeout(2000);
        getTopRightPaginationArrow().click();
        return this;
    }

    @Step("Navigate to the page by entering number in the pagination input")
    public ListingPage navigateByFillingPaginationInput(String pageNumber){
        getPaginationInput().clear();
        getPaginationInput().fill(pageNumber);
        getPaginationInput().press("Enter");
        return this;
    }

    @Step("Navigate to the previous page")
    public ListingPage navigateToPreviousPage(){
        getPreviousPageButton().click();
        return this;
    }

    @Step("Navigate to the subcategory")
    public ListingPage navigateToSubCategoryPage(String subCategoryName){
        if (getShowAllCategoriesButton().isVisible()){
            getShowAllCategoriesButton().click();
        }
        getSubctegoryLocator(subCategoryName).click();
        return this;
    }

    @Step("Navigate to the subcategory from filter")
    public ListingPage selectSubCategoryFromFilter(String subCategoryURL){
        getSubCategoryFromFilter(subCategoryURL).click();
        return this;
    }

    @Step("Select subcategory and wait for response")
    public ListingPage selectSubcategoryAndWaitForResponse(String subCategoryURL, String request, int statusCode) {
        page.waitForResponse(response ->
                        response.url().contains(request) && response.status() == statusCode,
                () -> {
                    selectSubCategoryFromFilter(subCategoryURL);
                });
        return this;
    }

    @Step("wait for 80 products to load")
    public ListingPage waitFor80Products(){
        page.waitForFunction(getProductCountQuerySelector80());
        return this;
    }

    @Step("wait for 120 products to load")
    public ListingPage waitFor120Products(){
        page.waitForFunction(getProductCountQuerySelector120());
        return this;
    }

    private double parseNumberFromString(String text) {
        String normalizedText = text.replaceAll("[^\\d,]", "").replace(",", ".");
        return Double.parseDouble(normalizedText);
    }

    @Step("Get price under minimal price slider")
    private double getMinimalSliderPrice() {
        return parseNumberFromString(getMinimalPriceSlider().textContent());
    }

    @Step("Get price under maximal price slider")
    private double getMaximalSliderPrice() {
        return parseNumberFromString(getMaximumPriceSlider().textContent());
    }
}
