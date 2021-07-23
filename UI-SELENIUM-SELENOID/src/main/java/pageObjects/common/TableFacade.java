package pageObjects.common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.NoSuchElementException;

public class TableFacade {

    private WebElement _tableFacade;

    public TableFacade(WebElement tableFacade) {
        set_tableFacade(tableFacade);
    }

    public int getRowsSize() {
        List<WebElement> tableRows = _tableFacade.findElements(By.tagName("tr"));
        return tableRows.size();
    }

    public WebElement getElementFromCell(int row, int column, String elementLocator) {
        try {
            List<WebElement> tableRows = _tableFacade.findElements(By.tagName("tr"));
            WebElement requestedRow = tableRows.get(row - 1);
            List<WebElement> tableColumns = requestedRow.findElements(By.tagName("td"));
            WebElement requestedCell = tableColumns.get(column - 1);
            WebElement elementFromCell = requestedCell.findElement(By.cssSelector(elementLocator));
            return elementFromCell;
        } catch (NoSuchElementException exception) {
            throw new NoSuchElementException("Cannot find the element");
        }
    }

    public void set_tableFacade(WebElement tableFacade) {
        this._tableFacade = tableFacade;
    }

    public WebElement get_tableFacade() {
        return this._tableFacade;
    }


}
