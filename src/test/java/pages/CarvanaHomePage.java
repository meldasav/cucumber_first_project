package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.utils.Driver;

public class CarvanaHomePage {
    public CarvanaHomePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(css = "a[data-cv-test='headerCarFinderLink']")
    public WebElement carFinderLink;

    @FindBy(css = "a[data-cv-test='headerTradesLink']")
    public WebElement sell_TradeLink;

    @FindBy(css="span[class*='HeaderFinancingstyles__MenuTitle-sc-3g0y8k-3']")
    public WebElement financingMenuButton;

    @FindBy(css = "a[data-cv-test='headerFinanceLoanCalc']")
    public WebElement autoLoanCalculatorLink;



}
