package com.telran.demoqa.tests;

import com.telran.demoqa.data.UserData;
import com.telran.demoqa.pages.HomePage;
import com.telran.demoqa.pages.LoginPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPageTests extends TestBase{

    @BeforeMethod
    public void ensurePrecondition(){
        new HomePage(driver).goToBookStore().goToLoginPage();
    }
    @Test
    public void loginPositiveTest(){

        new LoginPage(driver).login(UserData.USER_NAME, UserData.USER_PASSWORD)
                .verifyUserName(UserData.USER_NAME)
                .logout();
    }
}
