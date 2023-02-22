package com.cydeo.utilities.WebDriverWaitPractices;
import com.cydeo.utilities.Pages.DynamicLoad7Page;
import com.cydeo.utilities.Pages.DynamicallyloadedPageElement;
import com.cydeo.utilities.Properties.Driver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WebDriverWaitPractice {
    @Test
    public void test(){
        Driver.getDriver().get("https://practice.cydeo.com/dynamic_loading/7");
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),10);
        wait.until(ExpectedConditions.titleIs("Dynamic title"));

        DynamicLoad7Page dynamicLoad7Page = new DynamicLoad7Page();

        Assert.assertTrue(dynamicLoad7Page.downMessage.isDisplayed());
    }
    @Test
    public void test2(){
        Driver.getDriver().get("https://practice.cydeo.com/dynamic_loading/1");
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),  10);
        DynamicallyloadedPageElement dynamicallyloadedPageElement = new DynamicallyloadedPageElement();
        dynamicallyloadedPageElement.startButton.click();
        wait.until(ExpectedConditions.invisibilityOf(dynamicallyloadedPageElement.loadingbar));
        dynamicallyloadedPageElement.username.sendKeys("tomsmith");
        dynamicallyloadedPageElement.password.sendKeys("incorrectpassword");
        dynamicallyloadedPageElement.submitbutton.click();

    }
}
