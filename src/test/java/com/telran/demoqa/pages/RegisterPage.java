package com.telran.demoqa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends PageBase{
    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "firstname")
    WebElement firstNameInput;

    @FindBy(id = "lastname")
    WebElement lastNameInput;

    @FindBy(id = "userName")
    WebElement userNameInput;

    @FindBy(id = "password")
    WebElement passwordInput;

    @FindBy(xpath = "//iframe[@title='reCAPTCHA']")
    WebElement recaptchaFrame;

    @FindBy(id = "register")
    WebElement registerBtn;
    @FindBy(className = "recaptcha-checkbox-border")
    WebElement notRobotCheckBox;
    public RegisterPage registerNewUser(String firstName, String lastName, String userName, String password){
        type(firstNameInput, firstName);
        type(lastNameInput, lastName);
        type(userNameInput, userName);
        type(passwordInput, password);
        driver.switchTo().frame(recaptchaFrame);
        notRobotCheckBox.click();
        driver.switchTo().parentFrame();
        registerBtn.click();
        return this;
    }
}
