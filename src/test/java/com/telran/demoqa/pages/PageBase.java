package com.telran.demoqa.pages;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class PageBase {
   protected WebDriver driver;

    public PageBase(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void type(WebElement elem, String text){
        if(text != null){
            elem.click();
            elem.clear();
            elem.sendKeys(text);
        }
    }

    public void clickWithAction(WebElement elem, int x, int y) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy("+x + ", "+ y + ")");
        elem.click();

    }
    public void pause(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void takeScreenshotField(WebElement element) throws IOException {
        element.isSelected();
        File screenshotEmptyField = element.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshotEmptyField, new File(System
                .getProperty("user.dir") + "/screenshots/" + new Random().nextInt() + ".png"));
    }

}
