package com.cydeo.step_definition;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Pages.BasePage;
import com.cydeo.utilities.Pages.OrderPage;
import com.cydeo.utilities.Pages.WebTableLoginPage;
import com.cydeo.utilities.Pages.WivewAllOrdersPage;
import com.cydeo.utilities.Properties.ConfigurationReader;
import com.cydeo.utilities.Properties.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;

public class OrderStepDefinitions {
    WebTableLoginPage webTableLoginPage = new WebTableLoginPage();
    BasePage basePage = new BasePage();
    OrderPage orderPage = new OrderPage();
    WivewAllOrdersPage wivewAllOrdersPage = new WivewAllOrdersPage();
    @Given("user is already logged in and on order page")
    public void user_is_already_logged_in_and_on_order_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("web.table.url"));
        webTableLoginPage.login();
        basePage.order.click();
    }
    @When("user selects product type {string}")
    public void user_selects_product_type(String string) {
        Select select = new Select(orderPage.dropdown);
        select.selectByVisibleText(string);

    }
//    @When("user enters quantity {string}")
//    public void user_enters_quantity(String string) {
//
//    }
    @And("user enters quantity {int}")
    public void userEntersQuantity(int arg0) {
        // accepting integer argument and sending it using sendkeys method
        // we concating with ""
        orderPage.inputquantitiy.clear();
        orderPage.inputquantitiy.sendKeys(arg0+"");
    }
    @When("user enters costumer name {string}")
    public void user_enters_costumer_name(String string) {
        orderPage.inputname.sendKeys(string);
    }
    @When("user enters street {string}")
    public void user_enters_street(String string) {
        orderPage.inputstreet.sendKeys(string);
    }
    @When("user enters city {string}")
    public void user_enters_city(String string) {
        orderPage.inputcity.sendKeys(string);
    }
    @When("user enters state {string}")
    public void user_enters_state(String string) {
        orderPage.inputstate.sendKeys(string);
    }
    @When("user enters zipcode {string}")
    public void user_enters_zipcode(String string) {
        orderPage.inputzip.sendKeys(string);
    }
    @When("user selects credit card type {string}")
    public void user_selects_credit_card_type(String expectedCardType) {
        List<WebElement> cardtypes = orderPage.cardType;
        BrowserUtils.clickRadioButton(cardtypes,expectedCardType);
    }
    @When("user enters credit card number {string}")
    public void user_enters_credit_card_number(String string) {
        orderPage.inputCard.sendKeys(string);
    }
    @When("user enters expiry date {string}")
    public void user_enters_expiry_date(String string) {
        orderPage.inputCardExp.sendKeys(string);
    }
    @When("user enters process order button")
    public void user_enters_process_order_button() {
        orderPage.buttonProcessOrder.click();
    }
    @Then("user should see {string} in first row of the web table")
    public void user_should_see_in_first_row_of_the_web_table(String expected) {
        Assert.assertEquals(wivewAllOrdersPage.newCustomersCell.getText(),expected);
    }
}
