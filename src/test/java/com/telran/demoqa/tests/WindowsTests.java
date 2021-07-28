package com.telran.demoqa.tests;

import com.telran.demoqa.pages.BrowserWindowsPage;
import com.telran.demoqa.pages.HomePage;
import com.telran.demoqa.pages.navigationMenu.SidePanelPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WindowsTests extends TestBase{

    @BeforeMethod
    public void ensurePrecondition(){
        new HomePage(driver).goToFrameAlertAndWindowPage();
        new SidePanelPage(driver).selectBrowserWindows();
    }

    @Test
    public void newTabTest(){
        new BrowserWindowsPage(driver).clickOnNewTabBtn();
        Assert.assertTrue(new BrowserWindowsPage(driver).getTextFromNewTab().contains("sample"));
    }

    @Test
    public void newWindowTest(){
        new BrowserWindowsPage(driver).clickOnNewWindowBtn();
        Assert.assertTrue(new BrowserWindowsPage(driver).getTextFromNewTab().contains("sample"));
    }

    @Test
    public void newWindowMessageTest(){
       new BrowserWindowsPage(driver).clickOnMessageWindowBtn();
       //System.out.println("Message:  "+ new BrowserWindowsPage(driver).getTextFromMessageWindow());
        // Assert.assertTrue(new BrowserWindowsPage(driver)
               // .getTextFromMessageWindow().contains("Knowledge increases by"));
    }
}
