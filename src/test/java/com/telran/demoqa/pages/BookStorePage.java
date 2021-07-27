package com.telran.demoqa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Collection;

public class BookStorePage extends PageBase {
    public BookStorePage(WebDriver driver) {
        super(driver);
    }
    @FindBy(id="login")
    WebElement loginBtn;
    @FindBy(id="searchBox")
    WebElement searchInput;
    @FindBy(xpath = "//span[@class='mr-2']/a")
    WebElement nameOfBook;
    @FindBy(css = ".rt-tr-group:nth-child(1) .rt-td:nth-child(2)")
    WebElement firstTitle;

    @FindBy(css=".text-right.fullButton")
    WebElement addToCollectionBtn;
    @FindBy(css=".show #item-3")
    WebElement profileBtn;

    public WebElement getNameOfBook (){
        return nameOfBook;
    }
    public LoginPage goToLoginPage(){
        loginBtn.click();
        return new LoginPage(driver).verifyLoginPage();
    }

    public BookStorePage typeInSearchFieldInput(String text){
        type(searchInput, text);
        return this;
    }

    public String takeNameOfBook() {
        pause(500);
        return nameOfBook.getText();
    }

    public String verifyEmptyField() {
        return firstTitle.getText();
    }

    public BookStorePage clickByFirstBook() {
        nameOfBook.click();
        return this;
    }

    public BookStorePage addToYourCollection() {
        clickWithAction(addToCollectionBtn, 0, 500);
        pause(500);
        driver.switchTo().alert().accept();
        return this;
    }


}
