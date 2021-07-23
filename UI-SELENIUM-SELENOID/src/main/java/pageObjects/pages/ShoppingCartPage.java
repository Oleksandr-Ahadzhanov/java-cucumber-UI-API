package pageObjects.pages;

import lombok.SneakyThrows;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import pageObjects.common.BasePage;
import pageObjects.common.TableFacade;

public class ShoppingCartPage extends BasePage {

    WebDriver driver;

    String sku5 = "SKU : demo_5";
    String plusButtonLocator = "a[title=Add] span";
    String totalPriceLocator = "td.cart_total span";

    public Double priceBefore;
    public Double priceAfter;

    WebElement plusButton;
    WebElement totalPriseSector;

    TableFacade table;

    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }

    @CacheLookup
    @FindBy(css = "td.cart_description small.cart_ref")
    WebElement skuDescription;
    @CacheLookup
    @FindBy(css = "table#cart_summary tbody")
    WebElement cartTable;


    public void checkIfSpecificSKUisAddedToCart() {
        String actualSkuDescriptorText = skuDescription.getText();
        Assert.assertEquals(sku5,actualSkuDescriptorText);
    }

    public Double checkProductTotalPrice() {
        table = new TableFacade(cartTable);
        totalPriseSector = table.getElementFromCell(2,6,totalPriceLocator);
        String priceDefinition = totalPriseSector.getText();
        String priceDefinitionFormatted = priceDefinition.replaceAll("[^0-9.]", "");
        Double parsedPrise = Double.parseDouble(priceDefinitionFormatted);
        return parsedPrise;
    }

    public ShoppingCartPage increaseSecondItemQuantityToTwo() {
        table = new TableFacade(cartTable);
        plusButton = table.getElementFromCell(2,5,plusButtonLocator);
        plusButton.click();
        freeze(2);
        return this;
    }

    public void checkIfTotalPriseIsDoubled() {
        Assert.assertEquals(priceAfter,2*priceBefore,2);
    }
}
