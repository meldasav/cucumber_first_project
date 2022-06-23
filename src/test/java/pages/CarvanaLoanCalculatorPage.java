package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.utils.Driver;

public class CarvanaLoanCalculatorPage {
    public CarvanaLoanCalculatorPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(css = "input[name='vehiclePrice']")
    public WebElement costOfCarInputBox;

    @FindBy(id="creditBlock")
    public WebElement creditScoreBox;

    @FindBy(css = "select[name='loanTerm']")
    public WebElement loanTerm;

    @FindBy(css="input[name='downPayment']")
    public WebElement downPayment;

    @FindBy(css = "div[class*='is-monthly-display']")
    public WebElement monthlyPayment;
}
