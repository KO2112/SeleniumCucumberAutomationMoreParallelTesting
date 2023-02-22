package com.cydeo.utilities.Tests;

import com.cydeo.utilities.Pages.IframePage;
import com.cydeo.utilities.Properties.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class IframeTest {
    @Test
    public void test1() throws InterruptedException{
        IframePage iframePage = new IframePage();
        Driver.getDriver().get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick2");
        Thread.sleep(1000);
        Driver.getDriver().findElement(By.id("accept-choices")).click();
        Driver.getDriver().switchTo().frame("iframeResult");
        iframePage.textToDoubleClick.click();
        Actions actions= new Actions(Driver.getDriver());
        actions.doubleClick(iframePage.textToDoubleClick).perform();
        System.out.println("iframePage.textToDoubleClick.getAttribute(\"style\") = " + iframePage.textToDoubleClick.getAttribute("style"));

    }
}
