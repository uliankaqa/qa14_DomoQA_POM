package com.telran.demoqa.tests;

import com.telran.demoqa.pages.HomePage;
import com.telran.demoqa.pages.SelectMenuPage;
import com.telran.demoqa.pages.navigationMenu.SidePanelPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SelectMenuTests extends TestBase{
    @BeforeMethod
    public void ensurePrecondition(){
        new HomePage(driver).goToWidgetsPage();
        new SidePanelPage(driver).selectSelectMenuBtn();
    }

    @Test
    public void clickOnSelectStyleMenu(){
        new SelectMenuPage(driver).clickOnOldStyle("Blue");
    }

    @Test
    public void clickOnMultiselectDropDownTest(){
        new SelectMenuPage(driver).clickMultiselectDropDown("Red");
    }
}
