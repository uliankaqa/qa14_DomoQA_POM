package com.telran.demoqa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class LoginPage extends PageBase{
    public LoginPage(WebDriver driver) {
        super(driver);
    }
    //id="userName"
    @FindBy(id="userName")
    WebElement userName;
    //id="password"
    @FindBy(id="password")
    WebElement pswd;
    //id="login"
    @FindBy(id="login")
    WebElement loginBtn;
    @FindBy(className = "main-header")
    WebElement loginHeader;

    @FindBy(id="newUser")
    WebElement newUserBtn;

    public LoginPage verifyLoginPage(){
        Assert.assertEquals(loginHeader.getText(), "Login");
        return  this;
    }
    public ProfilePage login(String name, String password){
        type(userName, name);
        type(pswd, password);
        loginBtn.click();
        return new ProfilePage(driver);
    }

    public LoginPage loginNegative(String name, String password){
        type(userName, name);
        type(pswd, password);
        loginBtn.click();
        return this;
    }
    public RegisterPage clickOnNewUserButton(){
        newUserBtn.click();
        return new RegisterPage(driver);
    }
}
