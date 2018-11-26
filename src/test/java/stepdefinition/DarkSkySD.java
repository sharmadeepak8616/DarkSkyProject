package stepdefinition;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import framework.web_pages.DarkSky.HomePage;
import org.testng.Assert;

public class DarkSkySD {

    HomePage darkSkyHomePage = new HomePage();


    @Given("^I am on Dark Sky webpage$")
    public void iAmOnDarkSkyWebpage() throws Throwable {
        //BeforeClass method already opening the web page
    }

    @When("^I enter zip code as (\\d+)$")
    public void enterZipCodeAsLocation(int zipCode) throws Throwable {
        darkSkyHomePage.enterLocation(zipCode);
    }

    @And("^I click on search button next to search bar$")
    public void iClickOnSearchButton() {
        darkSkyHomePage.clickOnSearchButton();
    }

    @Then("^I verify present temperature is between lowest and highest$")
    public void iVerifyPresentTemperatureIsBetweenLowestAndHighest() {
        darkSkyHomePage.verifyPresentTempBetweenLowHigh();
    }

    @Then("^I verify timeline is displayed with (\\d+) hours incremented for next (\\d+) hours$")
    public void iVerifyTempBarIncrement(int incrementBy, int forFutureHours) {
        darkSkyHomePage.verifyTemperatureBarValues(incrementBy, forFutureHours);
    }

    @When("^I expand todays timeline$")
    public void iExpandTodaysTimeLine() {
        darkSkyHomePage.clickOnTodaysTimeline();
    }

    @Then("^I verify lowest and highest temp is displayed correctly$")
    public void iVerifyLowHighTempIsDisplayedCorrectly() {
        darkSkyHomePage.verifyLowHighTempIsDisplayedCorrectlyInTodaysDetail();
    }


}
