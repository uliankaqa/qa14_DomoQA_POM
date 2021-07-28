package com.telran.demoqa.tests;

import com.telran.demoqa.data.UserData;
import com.telran.demoqa.pages.BookStorePage;
import com.telran.demoqa.pages.HomePage;
import com.telran.demoqa.pages.LoginPage;
import com.telran.demoqa.pages.RegisterPage;
import com.telran.demoqa.pages.navigationMenu.BookStoreApplication;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationTests extends TestBase{
    @BeforeMethod
    public void ensurePrecondition(){
        new HomePage(driver).goToBookStore().pause(500);
        new BookStoreApplication(driver).goToLoginPage().clickOnNewUserButton();
    }

    @Test
    public void registerNewUserPositiveTest(){
        int i = (int) ((System.currentTimeMillis()/1000)%3600);
        new RegisterPage(driver).fillRegistrationForm( UserData.NEW_USER_FIRST_NAME,
                UserData.NEW_USER_LAST_NAME,
                UserData.NEW_USER_NAME + i,
                UserData.USER_PASSWORD+i)
                .clickOnCapcher()
                .clickOnRegisterBth();

       // Assert.assertEquals(new RegisterPage(driver).getMessageFromRegistrationAlert(), "User Register Successfully.");
    }
}
