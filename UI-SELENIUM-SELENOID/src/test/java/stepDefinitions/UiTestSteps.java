package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pageObjects.main.page.AccountPage;
import pageObjects.main.page.MainPage;
import util.driver.Driver;
import util.properties.PropertiesReader;

public class UiTestSteps {

    String driverName = PropertiesReader.getChrome();
//    String driverName = PropertiesReader.getFirefox();
    String mainPageURL = PropertiesReader.getResourceURL();

    Driver driverInstance;
    WebDriver driver;
    MainPage mainPage;
    AccountPage accountPage;

    @Given("I launch the browser")
    public void activateTheDriver() {
        driverInstance = Driver.getDriverInstance(driverName);
        driver = driverInstance.getDriver();
    }

    //example feature
    @When("I open test resource")
    public void openTestPage() {
        mainPage = new MainPage(driver);
        mainPage.openURL(PropertiesReader.getResourceURL());
    }
    @Then("The logo is present")
    public void theLogoIsPresent() {
        mainPage.checkIfLogoIsPresent();
    }

    //sign in flow
    @When("I open login page and enter correct credentials")
    public void signInUsingCorrectCredentials() {
        mainPage = new MainPage(driver);
        mainPage.openURL(mainPageURL);
        mainPage.tapTheSignInButton();

        accountPage = new AccountPage(driver);
        accountPage
                .enterCredentials()
                .pressSubmitButton();
    }
    @Then("The user is signed in and user name is displayed in the title sector")
    public void checkIfUserIsSignedIn() {
        accountPage.checkAccountTitle();
    }

    //add item to cart flow
    @When("I navigate to summer dresses catalog and add first item to the cart")
    public void openCatalogAndAddItemToCart() {
        mainPage = new MainPage(driver);
        mainPage.openURL(mainPageURL);
        mainPage
                .navigateToWomenTopBarOption()
                .tapOnSummerDressesButton();

    }
    @When("I can see proceed to checkout popup and I tap on proceed to checkout button")
    public void proceedThroughCheckoutPopup() {
//        mainPage = new MainPage(driver);
//        mainPage.openURL(mainPageURL);
//        mainPage.tapTheSignInButton();
//
//        accountPage = new AccountPage(driver);
//        accountPage
//                .enterCredentials()
//                .pressSubmitButton();
    }
    @Then("The item with specific SKU is added to cart")
    public void checkIfProductIsAddedToCart() {
//        accountPage.checkAccountTitle();
    }

    @Then("Close the browser")
    public void performDriverInstanceSafelyQuit() {
        driverInstance.saveExitDriver();
    }

}
