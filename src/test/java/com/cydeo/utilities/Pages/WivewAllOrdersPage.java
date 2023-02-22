package com.cydeo.utilities.Pages;

import com.cydeo.utilities.Properties.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WivewAllOrdersPage extends BasePage{
    public WivewAllOrdersPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//table[@class='table is-fullwidth']//tr[1]/td[1]")
    public WebElement newCustomersCell;


}
