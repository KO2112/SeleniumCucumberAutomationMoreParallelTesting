package com.cydeo.utilities.pomdesignexplicitywait;

import com.cydeo.utilities.Pages.LibaryLoginPage;
import com.cydeo.utilities.Properties.Driver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Prompractice {
    LibaryLoginPage libaryLoginPage;

    @BeforeMethod
    public void setUpMethod(){
        Driver.getDriver().get("https://library1.cydeo.com");
        libaryLoginPage = new LibaryLoginPage();
    }

    @Test(invocationCount = 5)
    public void requires_field_error_message_test(){
        libaryLoginPage.signInButton.click();
        Assert.assertTrue(libaryLoginPage.errorMessage.isDisplayed());
//        Driver.closedriver();
    }

    @Test
    public void invalidemailformaterrormessage(){
        libaryLoginPage.inputusername.sendKeys("wrongemail");
        libaryLoginPage.signInButton.click();
        Assert.assertTrue(libaryLoginPage.errormessage2.isDisplayed());
    }
    @Test
    public void librarynegativelogintest() throws InterruptedException{
        libaryLoginPage.inputusername.sendKeys("wrong@gmail.com");
        libaryLoginPage.inputPassword.sendKeys("wrongpassword");
        libaryLoginPage.signInButton.click();
        Thread.sleep(2000);
        Assert.assertTrue(libaryLoginPage.errormessge3.isDisplayed());

    }
}
