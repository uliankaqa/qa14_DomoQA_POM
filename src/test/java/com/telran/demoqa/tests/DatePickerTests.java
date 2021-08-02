package com.telran.demoqa.tests;

import com.telran.demoqa.pages.DatePickerPage;
import com.telran.demoqa.pages.HomePage;
import com.telran.demoqa.pages.navigationMenu.SidePanelPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DatePickerTests extends TestBase{

    @BeforeMethod
    public void ensurePrecondition(){
        new HomePage(driver).goToWidgetsPage();
        new SidePanelPage(driver).selectDatePicker();
    }

    @Test
    public void datePickerTestWithSelect(){
        new DatePickerPage(driver).selectDateToInput("May", "2021", "4");
        Assert.assertTrue(new DatePickerPage(driver).getDate().contains("05/04/2021"));
    }

    @Test
    public void dataPickerDateAndTimeTest(){
       // new DatePickerPage(driver).selectData("May", "2021", "4").selectTime("12:45");
       // Assert.assertTrue(new DatePickerPage(driver).getDateAndTime().contains("May 4, 2021 12:45 PM"));
    }
}
