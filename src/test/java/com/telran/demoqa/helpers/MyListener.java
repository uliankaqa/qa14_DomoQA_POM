package com.telran.demoqa.helpers;

import com.telran.demoqa.pages.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyListener extends AbstractWebDriverEventListener {

    public MyListener() {
    }

    Logger logger = LoggerFactory.getLogger(MyListener.class);

    @Override
    public void beforeFindBy(By by, WebElement element, WebDriver driver) {

        logger.info("Start search " + by);
    }

    @Override
    public void afterFindBy(By by, WebElement element, WebDriver driver) {

        logger.info(by + "found.");
    }

    @Override
    public void onException(Throwable throwable, WebDriver driver) {
        logger.error(throwable.toString());
        String screen = "screenshots/screen-" + (System.currentTimeMillis()/1000%3600) + ".png";
        new PageBase(driver).takeScreenshot(screen);
        logger.error(screen);

    }
}