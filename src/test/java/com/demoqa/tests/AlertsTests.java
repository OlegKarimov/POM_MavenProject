package com.demoqa.tests;

import com.demoqa.pages.AlertsPage;
import com.demoqa.pages.BasePage;
import com.demoqa.pages.HomePage;
import com.demoqa.pages.SidePanel;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AlertsTests extends TestBase {

    @BeforeMethod
    public void precondition() {
        new HomePage(driver).getAlertsFrameWindows();
        new SidePanel(driver).selectAlerts();
    }

    @Test
    public void sentMessageToAlertTest() {
        new AlertsPage(driver).sendMessageToAlert("Hello world!")
                .assertMessage("Hello world!");
    }

    @Test   // Click Button to see alert
    public void clickButtonToSeeAlertTest() {
        new AlertsPage(driver).clickButtonToSeeAlert();

    }

    @Test   // On button click, alert will appear after 5 seconds
    public void clickButtontAfter5SecondsTest() {
        new AlertsPage(driver).clickButtontAfter5Seconds();
    }

    @Test   // On button click, confirm box will appear
    public void clickButtontConfirmBoxTest() {

        new AlertsPage(driver).clickButtontConfirmBox();
    }
}