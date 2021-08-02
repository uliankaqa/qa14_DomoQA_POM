package com.telran.demoqa.pages;

import com.google.common.io.Files;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
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

    public void takeScreenshot(String pathToFiele) {
        File tmp = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        File screenshot = new File(pathToFiele);
        try {
            Files.copy(tmp,screenshot);
        }catch (IOException e) {
            e.fillInStackTrace();
        }
    }

    public void typeWithAction(WebElement element, int x, int y, String text) {
        if (text != null) {
            clickWithAction(element,x,y);
            element.clear();
            element.sendKeys(text);
        }
    }
    public void closeBanner() {
        driver.findElement(By.id("close-fixedban")).click();
    }

}
