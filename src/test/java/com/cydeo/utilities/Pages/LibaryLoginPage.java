package com.cydeo.utilities.Pages;

import com.cydeo.utilities.Properties.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LibaryLoginPage {
    public LibaryLoginPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//input[@id='inputEmail']")
    public WebElement inputusername;


    @FindBy(id = "inputPassword")
    public WebElement inputPassword;

    @FindBy(xpath = "//button[.='Sign in']")
    public WebElement signInButton;

    @FindBy(xpath = "//div[.='This field is required.']")
    public WebElement errorMessage;

    @FindBy(xpath = "//div[.='Please enter a valid email address.']")
    public WebElement errormessage2;

    @FindBy(xpath = "/html/body/form/div[2]/div")
    public WebElement errormessge3;
}
