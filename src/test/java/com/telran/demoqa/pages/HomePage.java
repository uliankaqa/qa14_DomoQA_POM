package com.telran.demoqa.pages;

import com.telran.demoqa.pages.navigationMenu.SidePanelPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

public class HomePage extends PageBase {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath="//div[@class='category-cards']/div[6]")
    /*---//div[@class='category-cards']/div[.='Book Store Application']---*/
    WebElement bookStoreBtn;

    @FindBy(xpath = "//div[@class='category-cards']/div[.='Alerts, Frame & Windows']")
    WebElement alertFrameWindowBtn;

    public BookStorePage goToBookStore(){
        clickWithAction(bookStoreBtn, 0, 500);
        return new BookStorePage(driver);
    }

    public SidePanelPage goToFrameAlertAndWindowPage(){
        clickWithAction(alertFrameWindowBtn, 0, 300);
        return new SidePanelPage(driver);
    }

}
