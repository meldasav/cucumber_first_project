package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.utils.Driver;

public class CarvanaCarFinderNextPage {
    public CarvanaCarFinderNextPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(css="div[data-qa='headline']")
    public WebElement headlineText;

    @FindBy(css="div[data-qa='sub-heading']")
    public WebElement subHeadingText;
}
