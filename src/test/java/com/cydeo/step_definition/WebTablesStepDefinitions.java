package com.cydeo.step_definition;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Pages.WebTableLoginPage;
import com.cydeo.utilities.Properties.ConfigurationReader;
import com.cydeo.utilities.Properties.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.util.Map;

public class WebTablesStepDefinitions {
    WebTableLoginPage webTableLoginPage = new WebTableLoginPage();
    @Given("user is on the login page of web table app")
    public void user_is_on_the_login_page_of_web_table_app() {
        String url = ConfigurationReader.getProperty("web.table.url");
        Driver.getDriver().get(url);
    }
    @When("user enters username {string}")
    public void user_enter(String string){
        webTableLoginPage.inputusernamee.sendKeys(string);
    }
    @When("user enters password {string}")
    public void user_enters(String string) {
        webTableLoginPage.inputpassword.sendKeys(string);
    }
    @When("user clicks to login button")
    public void user_clicks_to_login_button() {
        webTableLoginPage.loginbutton.click();
    }
    @Then("user should see url contains orders")
    public void user_should_see_url_contains_orders(){
        BrowserUtils.verifyURLContains("orders");
    }

    @When("user enters username {string} password {string} and logins")
    public void userEntersUsernamePasswordAndLogins(String username, String password) {
        webTableLoginPage.login(username,password);
    }
    @When("User enters below credentials")
    public void user_enters_below_credentials(Map<String,String> credentials) {
//        webTableLoginPage.inputusernamee.sendKeys(credentials.get("username"));
//        webTableLoginPage.inputpassword.sendKeys(credentials.get("password"));
        webTableLoginPage.login(credentials.get("username"),credentials.get("password"));
    }
}

