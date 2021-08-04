package com.telran.demoqa.helpers;

import com.telran.demoqa.pages.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JSExecutor extends PageBase {
    private JavascriptExecutor js;
    public JSExecutor(WebDriver driver) {
        super(driver);
        js =(JavascriptExecutor) driver;
    }

    public JSExecutor typeDataWithExecutor(String newUserName, String newUserEmail) {
        js.executeScript("document.getElementById('userName').value='" + newUserName + "';");
        js.executeScript("document.getElementById('userName').style.border='1px solid red';");
        js.executeScript("document.getElementById('userName').style.border='"+ newUserEmail +"';");

        WebElement el = driver.findElement(By.id("userName"));

        return this;
    }

    public JSExecutor clickOnSubmitJSE(){
        js.executeScript("document.querySelector('#submit').style.backgroundColor='red';");
        js.executeScript("document.querySelector('footer').style.display='none'");
        pause(2000);

        js.executeScript("document.getElementById('submit').click();");
        return this;
    }

    public JSExecutor checkBoxJSE() {
        js.executeScript("document.getElementById('hobbies-checkbox-1').checked=false");
        js.executeScript("document.getElementById('hobbies-checkbox-1').checked=true");
        return this;
    }

    public JSExecutor alertWithJSE() {
        js.executeScript("alert('Handle checkbox');");
        return this;
    }

    public JSExecutor refreshBrowser(){
        js.executeScript("history.go(0);");
        return this;
    }

    public JSExecutor getTitlePageJSE() {
       // to get title of our page
        String text = js.executeScript("return document.title;").toString();
        System.out.println("*********"+"\n" + text);

        return this;
    }

    public JSExecutor getURLPageJSE() {
        // to get URL of our page
        String url = js.executeScript("return document.URL;").toString();
        System.out.println("URL -> " + url);
        return this;
    }

    public JSExecutor scrollWithJSE() {
        //to perform scroll with JavaScript
        //vertical down scrolling by 50 pixel
        js.executeScript("window.scrollBy(0, 50);");

        return this;
    }
}
