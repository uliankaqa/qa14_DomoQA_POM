package com.telran.demoqa.tests;

import com.telran.demoqa.pages.AlertPage;
import com.telran.demoqa.pages.HomePage;
import com.telran.demoqa.pages.navigationMenu.SidePanelPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AlertsTests extends TestBase{
    @BeforeMethod
    public void ensurePrecondition(){
        new HomePage(driver).goToFrameAlertAndWindowPage();
        new SidePanelPage(driver).selectAlert();
    }

    @Test
    public void alertWaitTest(){
        new AlertPage(driver).clickTimerAlertBtn();
    }

    @Test
    public void cancelAlertTest(){
        new AlertPage(driver).clickConfirmAlertBtn().clickOnConfirmBtn("Cancel");
        Assert.assertTrue(new AlertPage(driver).getConfirmResult().contains("Cancel"));
    }

    @Test
    public void alertSendTextTest(){
        new AlertPage(driver).clickMessageAlertBtn().sendTextToAlert("Hello World");
        Assert.assertTrue(new AlertPage(driver).getConfirmMessageResult().contains("Hello World"));
    }
}
