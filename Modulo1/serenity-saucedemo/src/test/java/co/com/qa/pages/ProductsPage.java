package co.com.qa.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

public class ProductsPage extends PageObject {

    @FindBy(className = "title")
    private WebElementFacade lblTitle;

    public boolean isTitleVisible() {
        return lblTitle.isVisible();
    }

    public String getTitleText() {
        return lblTitle.getText().trim();
    }
}
