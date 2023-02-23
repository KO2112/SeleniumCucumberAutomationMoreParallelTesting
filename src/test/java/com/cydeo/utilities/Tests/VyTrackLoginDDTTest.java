package com.cydeo.utilities.Tests;

import com.cydeo.utilities.Pages.VyTrackDashBoardPage;
import com.cydeo.utilities.Pages.VyTrackLoginPage;
import com.cydeo.utilities.Properties.ConfigurationReader;
import com.cydeo.utilities.Properties.Driver;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class VyTrackLoginDDTTest {
    VyTrackLoginPage loginPage = new VyTrackLoginPage();
    VyTrackDashBoardPage dashBoardPage = new VyTrackDashBoardPage();
    @BeforeMethod
    public void setup(){
        Driver.getDriver().get("https://qa2.vytrack.com/user/login");
    }
    @After
    public void teardown(){
        Driver.closedriver();
    }
    @Test
    public void loginDDTTest() throws IOException {
        String filepath = "VyTrackQa2Users.xlsx";
        FileInputStream fileInputStream = new FileInputStream(filepath);
        XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
        XSSFSheet sheet = workbook.getSheet("data");

        for (int i=1;i<=sheet.getLastRowNum();i++) {
            String userName = sheet.getRow(i).getCell(0).toString();
            String password = sheet.getRow(i).getCell(1).toString();
            String firstname = sheet.getRow(i).getCell(2).toString();
            String lastname = sheet.getRow(i).getCell(3).toString();
            loginPage.login(userName,password);

            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 30);
            WebElement loadermask = Driver.getDriver().findElement(By.cssSelector("div[class='loader-mask shown']"));
            wait.until(ExpectedConditions.invisibilityOf(loadermask));

            String actualFullname = dashBoardPage.fullname.getText();

            XSSFCell resultcell = sheet.getRow(i).getCell(4);
            if (actualFullname.contains(firstname) && actualFullname.contains(firstname)) {
                System.out.println("pass");
                resultcell.setCellValue("pass");
            } else {
                System.out.println("fail");
                resultcell.setCellValue("fail");
            }
            wait.until(ExpectedConditions.visibilityOf(dashBoardPage.dashboardtext));
            dashBoardPage.logout();
        }
        FileOutputStream fileOutputStream = new FileOutputStream(filepath);
        workbook.write(fileOutputStream);

        fileOutputStream.close();
        workbook.close();
        fileInputStream.close();
    }


}
