package pageObjects.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import pageObjects.common.BasePage;
import util.properties.PropertiesReader;

public class AccountPage extends BasePage {

    WebDriver driver;

    String login = PropertiesReader.getUserLogin();
    String password = PropertiesReader.getUserPassword();
    String mockedUserName = PropertiesReader.getMockedUserName();

    public AccountPage(WebDriver driver) {
        super(driver);
//        if(!"Authentication".equals(driver.findElement(By.cssSelector(".page-heading")).getText())){
//            throw new IllegalStateException("This is not the login page");
//        }
    }

    @CacheLookup
    @FindBy(css = ".form-group #email")
    WebElement emailField;
    @CacheLookup
    @FindBy(css = ".form-group #passwd")
    WebElement passwordField;
    @CacheLookup
    @FindBy(css = "button#SubmitLogin")
    WebElement submitLogin;
    @CacheLookup
    @FindBy(css = ".account span")
    WebElement accountTitle;

    public AccountPage enterCredentials() {
        waitForElementToBeClickable(emailField);

        emailField.clear();
        emailField.sendKeys(login);
        passwordField.clear();
        passwordField.sendKeys(password);
        return this;
    }

    public AccountPage pressSubmitButton() {
        submitLogin.click();
        return this;
    }

    public void checkAccountTitle () {
        waitForElementToBeClickable(accountTitle);
        String currentUserName = accountTitle.getText();
        Assert.assertEquals("Expected and actual user's names are equal",mockedUserName,currentUserName);
    }
}
