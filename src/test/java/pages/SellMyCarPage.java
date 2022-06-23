package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.utils.Driver;

public class SellMyCarPage {
    public SellMyCarPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(css = ".kjhwtS")
    public WebElement getOfferText;

    @FindBy(css = " .lnhlkr")
    public WebElement wePickYourCarText;

    @FindBy(css = "button[data-cv-test='VINToggle']")
    public WebElement vinButton;

    @FindBy(css = "button[data-cv-test='heroGetMyOfferButton']")
    public WebElement getMyOfferButton;

    @FindBy(css = "div[data-cv-test='heroVinEntryInput'] input")
    public WebElement vinInputBox;

    @FindBy(css = "div[class*='gWWKAZ'] p")
    public WebElement weFoundYourPinText;
}
