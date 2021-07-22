package pageObjects.main.page;

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
    @FindBy(xpath = "//*[@id=\"block_top_menu\"]/ul/li[1]/ul/li[2]/ul/li[3]/a")
    WebElement summerDressesTopBarButton;

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
}
