package com.cydeo.step_definition;


import com.cydeo.utilities.Properties.Driver;
import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {
//in the class we will be able to pass pre conditions and post to each scenario and each step

    //import from i.o cucumber java not junit
    //@Before(order = 1)
    public void setupScenario(){
        System.out.println("==== setting up browser using cucumber @Before");
    }
    //@Before(value = "@Login", order = 2)
    public void setUpScenarioForLogins(){
        System.out.println("======this will only apply to scenarios with @Login tag");

    }
    //@Before(value = "@db",order = 0)
    public void setupForDataBaseScenarios(){
        System.out.println("====== this will only apply to scenarios with DB tag");
    }
    @After
    public void tearDownScenario(Scenario scenario)throws InterruptedException{
        if (scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot)Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot,"image/png",scenario.getName());
        }
        Driver.closedriver();

    }

    //@BeforeStep
    public void setupstep(){
        System.out.println("------applying setup using @BeforeStep");
    }
    //@AfterStep
    public void afterstep(){
        System.out.println("------> applying tearDown using @AfterStep");
    }

}
