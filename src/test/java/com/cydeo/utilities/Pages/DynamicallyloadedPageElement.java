package com.cydeo.utilities.Pages;

import com.cydeo.utilities.Properties.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DynamicallyloadedPageElement {
    public DynamicallyloadedPageElement(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//*[@id=\"start\"]/button")
    public WebElement startButton;
    @FindBy(id = "loading")
    public WebElement loadingbar;
    @FindBy(id = "username")
    public WebElement username;
    @FindBy(id = "pwd")
    public WebElement password;
    @FindBy(xpath = "//*[@id=\"login\"]/div[4]/div/button")
    public WebElement submitbutton;
}
