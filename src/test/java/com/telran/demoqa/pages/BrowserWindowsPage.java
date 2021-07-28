package com.telran.demoqa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class BrowserWindowsPage extends PageBase{
    public BrowserWindowsPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(id="tabButton")
    WebElement newTabBtn;

    @FindBy(id = "sampleHeading")
    WebElement sampleText;

    @FindBy(id = "windowButton")
    WebElement newWindowBtn;

    @FindBy(id="messageWindowButton")
    WebElement messageWindowBtn;

    @FindBy(tagName = "body")
    WebElement windowsBody;

    public BrowserWindowsPage clickOnNewTabBtn() {
        newTabBtn.click();
        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        return this;
    }

    public String getTextFromNewTab() {
        return sampleText.getText();

    }

    public BrowserWindowsPage clickOnNewWindowBtn() {
        newWindowBtn.click();
        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        return this;
    }


    public BrowserWindowsPage clickOnMessageWindowBtn() {
        messageWindowBtn.click();
        pause(300);
       List<String> windows = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(windows.get(1));
        return this;
    }

    public String getTextFromMessageWindow() {
        return windowsBody.getText();
    }
}
