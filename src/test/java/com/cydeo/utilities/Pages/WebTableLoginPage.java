package com.cydeo.utilities.Pages;

import com.cydeo.utilities.Properties.ConfigurationReader;
import com.cydeo.utilities.Properties.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WebTableLoginPage {
    public WebTableLoginPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(className = "input")
    public WebElement inputusernamee;
    @FindBy(name = "password")
    public WebElement inputpassword;
    @FindBy(xpath = "//button[.='Login']")
    public WebElement loginbutton;
    public void login(){
        this.inputusernamee.sendKeys("Test");
        this.inputpassword.sendKeys("Tester");
        this.loginbutton.click();
    }

    /**
     *
     * @param username
     * @param password
     */
    public void login(String username, String password){
        inputpassword.sendKeys(password);
        inputusernamee.sendKeys(username);
        loginbutton.click();
    }
    public void loginwithconfig(){
        inputusernamee.sendKeys(ConfigurationReader.getProperty("web.table.username"));
        inputpassword.sendKeys(ConfigurationReader.getProperty("web.table.password"));
        loginbutton.click();

    }

}
