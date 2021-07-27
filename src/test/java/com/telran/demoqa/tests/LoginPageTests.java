package com.telran.demoqa.tests;

import com.telran.demoqa.pages.HomePage;
import com.telran.demoqa.pages.LoginPage;
import org.testng.annotations.Test;

public class LoginPageTests extends TestBase{

    @Test
    public void loginPositiveTest(){
        new HomePage(driver).goToBookStore().goToLoginPage();
        new LoginPage(driver).login("uliankaqa", "@4R#,%+v@1.k")
                .verifyUserName("uliankaqa")
                .logout();
    }
}
