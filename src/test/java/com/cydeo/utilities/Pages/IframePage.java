package com.cydeo.utilities.Pages;

import com.cydeo.utilities.Properties.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IframePage {
    public IframePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(id = "demo")
    public WebElement textToDoubleClick;
}
