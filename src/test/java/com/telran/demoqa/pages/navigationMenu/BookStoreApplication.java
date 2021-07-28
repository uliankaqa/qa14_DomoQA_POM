package com.telran.demoqa.pages.navigationMenu;

import com.telran.demoqa.pages.LoginPage;
import com.telran.demoqa.pages.PageBase;
import com.telran.demoqa.pages.ProfilePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BookStoreApplication extends PageBase {
    public BookStoreApplication(WebDriver driver) {
        super(driver);
    }


    @FindBy(css = ".show #item-0")
    WebElement loginBtn;

   // @FindBy(xpath = ".show #item-2")
    //WebElement bookStoreBtn;

    @FindBy(css=".show #item-3")
    WebElement profileBtn;

    //@FindBy(xpath = ".show #item-4")
    //WebElement bookStoreAPIBtn;

    public LoginPage goToLoginPage(){
        clickWithAction(loginBtn, 0, 700);
        return new LoginPage(driver);
    }

    public ProfilePage goToProfilePage() {
        clickWithAction(profileBtn, 0, 700);
        return new ProfilePage(driver);
    }

    public static class SidePanelPage extends PageBase{
        public SidePanelPage(WebDriver driver) {
            super(driver);
        }
    }
}
