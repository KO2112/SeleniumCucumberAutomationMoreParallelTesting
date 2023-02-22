package com.cydeo.step_definition;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Pages.DropdownsPage;
import com.cydeo.utilities.Properties.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class DataTableStepDefinitions {
    DropdownsPage dropdownsPage = new DropdownsPage();
    @Then("user should see fruits i like")
    public void user_should_see_fruits_i_like(List<String> fruits) {
        System.out.println(fruits);

    }
    @Given("User is on the dropdowns page of practice tool")
    public void user_is_on_the_dropdowns_page_of_practice_tool() {
        Driver.getDriver().get("https://practice.cydeo.com/dropdown");
    }
    @Then("User should see below info in month dropdown")
    public void user_should_see_below_info_in_month_dropdown(List<String> expectedmonth) {
       List<String> actualoptionsstring = BrowserUtils.dropdownOptionsAsString(dropdownsPage.dropdownlist);
        Assert.assertEquals(expectedmonth,actualoptionsstring);
    }
}
