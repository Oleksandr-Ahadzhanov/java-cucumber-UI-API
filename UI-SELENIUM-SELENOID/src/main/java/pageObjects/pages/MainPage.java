package pageObjects.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import pageObjects.common.BasePage;

public class MainPage extends BasePage {

    WebDriver driver;

    public MainPage(WebDriver driver) { super(driver);}

    @CacheLookup
    @FindBy(css = "div#header_logo")
    WebElement resourceLogo;
    @CacheLookup
    @FindBy(css = ".login")
    WebElement signInButton;
    @CacheLookup
    @FindBy(css = "div#block_top_menu a[title=Women]")
    WebElement womenTopBarButton;
    @CacheLookup
    @FindBy(xpath = "//a[@title=\"Women\"]/..//a[@title=\"Summer Dresses\"]")
    WebElement summerDressesTopBarButton;
    @CacheLookup
    @FindBy(xpath = "//ul[@class='product_list grid row']/li[1]")
    WebElement firstItemInCatalog;
    @CacheLookup
    @FindBy(xpath = "//ul[@class='product_list grid row']/li[2]")
    WebElement secondItemInCatalog;
    @CacheLookup
    @FindBy(xpath = "//ul[@class='product_list grid row']/li[1]//a[@title='Add to cart']/span")
    WebElement firstItemInCatalogAddToCartButton;
    @CacheLookup
    @FindBy(xpath = "//ul[@class='product_list grid row']/li[2]//a[@title='Add to cart']/span")
    WebElement secondItemInCatalogAddToCartButton;
    @CacheLookup
    @FindBy(css = "div#block_top_menu a[title=Women]")
    WebElement popUp;
    @CacheLookup
    @FindBy(xpath = "//a[@title='Proceed to checkout']/span")
    WebElement proceedToCheckoutButton;
    @CacheLookup
    @FindBy(xpath = "//span[@title='Continue shopping']/span")
    WebElement continueShoppingButton;

    public void checkIfLogoIsPresent() {
        boolean status = resourceLogo.isDisplayed();
        Assert.assertTrue(status);
    }

    public MainPage tapTheSignInButton() {
        waitForElementToBeClickable(signInButton);
        signInButton.click();
        return this;
    }

    public MainPage navigateToWomenTopBarOption() {
        waitForElementToBeClickable(womenTopBarButton);
        moveToElement(womenTopBarButton);
        return this;
    }

    public MainPage tapOnSummerDressesButton() {
        waitForElementToBeClickable(summerDressesTopBarButton);
        summerDressesTopBarButton.click();
        return this;
    }

    public MainPage addFirstProductToCart() {
        waitForElementToBeClickable(firstItemInCatalog);
        moveToElement(firstItemInCatalog);
        waitForElementToBeClickable(firstItemInCatalogAddToCartButton);
        firstItemInCatalogAddToCartButton.click();
        return this;
    }

    public MainPage checkIfPopupIsDisplayed() {
        waitForElementToBeClickable(popUp);
        Assert.assertTrue(popUp.isDisplayed());
        return this;
    }

    public MainPage tapOnContinueShoppingButton() {
        waitForElementToBeClickable(continueShoppingButton);
        continueShoppingButton.click();
        return this;
    }

    public MainPage addSecondProductToCart() {
        waitForElementToBeClickable(secondItemInCatalog);
        moveToElement(secondItemInCatalog);
        waitForElementToBeClickable(secondItemInCatalogAddToCartButton);
        secondItemInCatalogAddToCartButton.click();
        return this;
    }

    public void tapOnProceedToCheckoutButton() {
        waitForElementToBeClickable(proceedToCheckoutButton);
        proceedToCheckoutButton.click();
    }
}
