package com.telran.demoqa.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Collection;

public class AlertPage extends PageBase{
    public AlertPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(id = "timerAlertButton")
    WebElement timerAlertBtn;

    @FindBy(id = "confirmButton")
    WebElement confirmAlertBtn;

    @FindBy(id = "confirmResult")
    WebElement confirmResult;

    @FindBy(id = "promtButton")
    WebElement promtAlertButton;

    @FindBy(id = "promptResult")
    WebElement promtResult;


    public AlertPage clickTimerAlertBtn() {
        timerAlertBtn.click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        Alert myAlert = wait.until(ExpectedConditions.alertIsPresent());
        myAlert.accept();
        return this;
    }

    public AlertPage clickConfirmAlertBtn() {
        confirmAlertBtn.click();
        return this;
    }

    public AlertPage clickOnConfirmBtn(String text) {
        if(text != null && text.equals("Cancel")){
            driver.switchTo().alert().dismiss();
        }else if(text != null && text.equals("Ok")){
            driver.switchTo().alert().accept();
        }
        return this;
    }

    public String getConfirmResult() {
        return confirmResult.getText();
    }

    public AlertPage clickMessageAlertBtn() {
        promtAlertButton.click();
        return this;
    }

    public AlertPage sendTextToAlert(String message) {
        if(message != null){
            driver.switchTo().alert().sendKeys(message);
        }
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();
        return this;
    }

    public String getConfirmMessageResult() {
        return promtResult.getText();
    }
}
