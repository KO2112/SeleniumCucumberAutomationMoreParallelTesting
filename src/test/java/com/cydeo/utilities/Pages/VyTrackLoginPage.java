package com.cydeo.utilities.Pages;

import com.cydeo.utilities.Properties.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VyTrackLoginPage {
    public VyTrackLoginPage(){
        PageFactory.initElements(Driver.getDriver(),this);

    }
    @FindBy(id = "prependedInput")
    public WebElement loginuser;
    @FindBy(id = "prependedInput2")
    public WebElement loginpass;
    @FindBy(id = "_submit")
    public WebElement loginbutton;

    public void login(String username, String password){
        loginuser.sendKeys(username);
        loginpass.sendKeys(password);
        loginbutton.click();
    }
}
