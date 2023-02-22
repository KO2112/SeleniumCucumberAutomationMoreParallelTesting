package com.cydeo.step_definition;

import com.cydeo.utilities.Pages.GoogleSearchPage;
import com.cydeo.utilities.Properties.Driver;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class GoogleStepDefinitions {
    GoogleSearchPage googleSearchPage = new GoogleSearchPage();
    @When("user types apple and clicks enter")
    public void user_types_and_clicks_enter2() {
        Driver.getDriver().findElement(By.xpath("//*[@id=\"L2AGLb\"]/div")).click();
        googleSearchPage.searchbox.sendKeys("apple" + Keys.ENTER);
    }
    @When("user types {string} and clicks enter")
    public void user_types_and_clicks_enter(String searchKeyword) {
        googleSearchPage.searchbox.sendKeys(searchKeyword + Keys.ENTER);
    }
    @Then("user sees {string} in the google title")
    public void user_sees_in_the_google_title(String string) {
        String expectedtitle =string +" - Google Search";
        String actualtitle = Driver.getDriver().getTitle();

        Assert.assertEquals("title is not as expected",expectedtitle,actualtitle);
    }
    @Then("user sees apple in the title")
    public void user_sees_apple_in_the_title() {
        String expectedtitle = "apple"+" - Google Search";
        String actualtitle = Driver.getDriver().getTitle();

        Assert.assertEquals("title is not as expected",actualtitle,expectedtitle);
    }
    @When("user is on Google search page")
    public void user_is_on_google_search_page() {
        Driver.getDriver().get("https://www.google.com");
    }
    @Then("user should see title is Google")
    public void user_should_see_title_is_google() {
        String expectedTitle= "Google";
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertEquals(actualTitle,expectedTitle);
        Driver.closedriver();
    }
}
