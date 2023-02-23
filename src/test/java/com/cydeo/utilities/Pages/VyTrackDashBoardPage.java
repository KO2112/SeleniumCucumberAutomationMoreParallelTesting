package com.cydeo.utilities.Pages;

import com.cydeo.utilities.Properties.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VyTrackDashBoardPage {
    public VyTrackDashBoardPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//li[@id='user-menu']/a")
    public WebElement fullname;
    @FindBy(linkText = "Logout")
    public WebElement logoutlink;
    @FindBy(xpath = "//*[@id=\"container\"]/div[2]/div[1]/div/div/div[1]/div/h1")
    public WebElement dashboardtext;

    public void logout(){
        fullname.click();
        logoutlink.click();
    }
}
