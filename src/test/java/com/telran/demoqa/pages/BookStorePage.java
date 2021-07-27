package com.telran.demoqa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BookStorePage extends PageBase {
    public BookStorePage(WebDriver driver) {
        super(driver);
    }
    @FindBy(id="login")
    WebElement loginBtn;

    public LoginPage goToLoginPage(){
        loginBtn.click();
        return new LoginPage(driver).verifyLoginPage();
    }
}
