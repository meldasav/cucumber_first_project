package steps;

import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.*;
import utils.utils.ActionsUtil;
import utils.utils.Driver;
import utils.utils.DropdownHandler;
import utils.utils.Waiter;

public class CarvanaSteps {

    WebDriver driver;
    CarvanaHomePage carvanaHomePage;
    CarvanaCarFinderPage carvanaCarFinderPage;
    CarvanaCarFinderNextPage carvanaCarFinderNextPage;
    SellMyCarPage sellMyCarPage;
    CarvanaLoanCalculatorPage carvanaLoanCalculatorPage;

    @Before
    public void setup() {
        driver = Driver.getDriver();
        carvanaHomePage = new CarvanaHomePage();
        carvanaCarFinderPage = new CarvanaCarFinderPage();
        carvanaCarFinderNextPage = new CarvanaCarFinderNextPage();
        sellMyCarPage = new SellMyCarPage();
        carvanaLoanCalculatorPage=new CarvanaLoanCalculatorPage();
    }

    @Given("user is on {string}")
    public void user_is_on(String url) {
        driver.get(url);

    }

    @When("user clicks on {string} menu item")
    public void user_clicks_on_menu_item(String clickMenuItem) {
        switch (clickMenuItem) {
            case "CAR FINDER":
                Waiter.waitForVisibilityOfElement(driver,carvanaHomePage.carFinderLink,4);
                carvanaHomePage.carFinderLink.click();
                break;
            case "SELL/TRADE":
                Waiter.pause(3);
                carvanaHomePage.sell_TradeLink.click();
                break;
            case "AUTO LOAN CALCULATOR":
                Waiter.waitForVisibilityOfElement(driver,carvanaHomePage.autoLoanCalculatorLink,2);
                carvanaHomePage.autoLoanCalculatorLink.click();
        }

    }

    @Then("user should be navigated to {string}")
    public void user_should_be_navigated_to(String url) {
        switch (url) {
            case "https://www.carvana.com/help-me-search/":
            case "https://www.carvana.com/help-me-search/qa":
            case "https://www.carvana.com/sell-my-car":
                Assert.assertEquals(url, driver.getCurrentUrl());
                break;
        }


    }

    @Then("user should see {string} text")
    public void user_should_see_text(String headingText) {
        switch (headingText) {
            case "https://www.carvana.com/help-me-search/":
                Assert.assertTrue(carvanaCarFinderPage.heading1.isDisplayed());
                Assert.assertEquals(headingText, carvanaCarFinderPage.heading1.getText());
                Assert.assertTrue(carvanaCarFinderPage.heading3.isDisplayed());
                Assert.assertEquals(headingText, carvanaCarFinderPage.heading3.getText());
                break;
            case "https://www.carvana.com/help-me-search/qa":
                Assert.assertTrue(carvanaCarFinderNextPage.headlineText.isDisplayed());
                Assert.assertEquals(headingText, carvanaCarFinderNextPage.headlineText.getText());
                Assert.assertTrue(carvanaCarFinderNextPage.subHeadingText.isDisplayed());
                Assert.assertEquals(headingText, carvanaCarFinderNextPage.subHeadingText.getText());
                break;
            case "https://www.carvana.com/sell-my-car":
                Assert.assertTrue(sellMyCarPage.getOfferText.isDisplayed());
                Assert.assertEquals(headingText, sellMyCarPage.getOfferText.getText());
                Assert.assertTrue(sellMyCarPage.wePickYourCarText.isDisplayed());
                Assert.assertEquals(headingText, sellMyCarPage.wePickYourCarText.getText());
                Assert.assertTrue(sellMyCarPage.weFoundYourPinText.isDisplayed());
                Waiter.waitUntilTextToBePresentInElement(driver, 3, sellMyCarPage.weFoundYourPinText,headingText);
                Assert.assertEquals(headingText, sellMyCarPage.weFoundYourPinText.getText());
        }

    }

    @Then("user should see {string} link")
    public void user_should_see_link(String carFinderText) {
        Assert.assertTrue(carvanaCarFinderPage.tryCarFinderLink.isDisplayed());
        Assert.assertEquals(carFinderText, carvanaCarFinderPage.tryCarFinderLink.getText());


    }

    @When("user clicks on {string} link")
    public void user_clicks_on_link(String link) {
        if ("TRY CAR FINDER".equals(link)) {
            carvanaCarFinderPage.tryCarFinderLink.click();
        }

    }

    @When("user clicks on {string} button")
    public void userClicksOnButton(String Button) {
        switch (Button) {
            case "VIN":
                Waiter.pause(2);
                sellMyCarPage.vinButton.click();
                break;
            case "GET MY OFFER":
                sellMyCarPage.getMyOfferButton.click();
                break;
        }
    }

    @And("user enters vin number as {string}")
    public void userEntersVinNumberAs(String vinNumber) {
        sellMyCarPage.vinInputBox.sendKeys(vinNumber);

    }

    @When("user hovers over on {string} menu item")
    public void userHoversOverOnMenuItem(String buttonText) {
        Assert.assertEquals(buttonText,carvanaHomePage.financingMenuButton.getText());
        Waiter.pause(2);
        ActionsUtil.moveToElement(carvanaHomePage.financingMenuButton);
    }

    @When("user enters {string} as {string}")
    public void userEntersAs(String costText, String cost) {
        switch (costText){
            case "Cost of Car I want":
                Assert.assertTrue(costText,carvanaLoanCalculatorPage.costOfCarInputBox.isDisplayed());
                carvanaLoanCalculatorPage.costOfCarInputBox.sendKeys(cost);
                break;
            case "What is Your Down Payment?":
                carvanaLoanCalculatorPage.downPayment.sendKeys(cost);
                break;
        }
    }

    @And("user selects {string} as {string}")
    public void userSelectsAs(String scoreText, String score) {
        switch (scoreText) {
            case "What’s Your credit Score?":
            DropdownHandler.selectOptionByIndex(carvanaLoanCalculatorPage.creditScoreBox, 0);
            break;
            case "Choose Your Loan Terms":
                Waiter.pause(2);
            DropdownHandler.selectOptionByIndex(carvanaLoanCalculatorPage.loanTerm,1);
            break;
        }
    }
    @Then("user should see the monthly payment as {string}")
    public void userShouldSeeTheMonthlyPaymentAs(String payment) {
        Assert.assertTrue(carvanaLoanCalculatorPage.monthlyPayment.isDisplayed());
        Assert.assertEquals(payment,carvanaLoanCalculatorPage.monthlyPayment.getText());
    }
}