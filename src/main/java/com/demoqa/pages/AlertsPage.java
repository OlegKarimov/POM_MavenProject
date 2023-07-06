package com.demoqa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class AlertsPage extends BasePage{

    @FindBy(id = "alertButton")
    WebElement alertButton;
    public AlertsPage clickButtonToSeeAlert(){
        click(alertButton);
        driver.switchTo().alert().accept();
        return this;
    };

    public AlertsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "promtButton")
    WebElement promtButton;

    public AlertsPage sendMessageToAlert(String message) {
        click(promtButton);

        if (message != null) {
            driver.switchTo().alert().sendKeys(message);
            driver.switchTo().alert().accept();
        }
        return this;
    }

//---------------------------------------------------------------------------------------------
    @FindBy(id = "promptResult")
    WebElement promptResult;

    public AlertsPage assertMessage(String message) {
        Assert.assertTrue(promptResult.getText().contains(message));
        return this;
    }

//---------------------------------------------------------------------------------------------
    @FindBy(id = "timerAlertButton")
    WebElement timerAlertButton;
    public AlertsPage clickButtontAfter5Seconds() {
        click(timerAlertButton);
        pause(6000);
        driver.switchTo().alert().accept();
        return this;
    }

//---------------------------------------------------------------------------------------------
    @FindBy(id = "confirmButton")
    WebElement confirmButton;
    @FindBy(id = "confirmResult")
    WebElement confirmResult;
    public AlertsPage clickButtontConfirmBox() {
        clickWithJSExecutor(confirmButton, 0, 100);
        pause(1000);
        driver.switchTo().alert().accept();
        Assert.assertTrue(confirmResult.getText().contains("Ok"));
//        System.out.println(confirmResult.getText());
        return this;
    }
}