package com.telran.demoqa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SelectMenuPage extends PageBase{
    public SelectMenuPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(id = "oldSelectMenu")
    WebElement oldSelectMenuBtn;

    @FindBy(xpath = "(//div[@class=' css-1wy0on6'])[3]")
    WebElement multiselectDropDown;

    @FindBy(xpath = "//html")
    WebElement whiteSpace;

    public SelectMenuPage clickOnOldStyle(String style) {
        Select select = new Select(oldSelectMenuBtn);//HTML <select> tag
        select.selectByVisibleText(style);

        List<WebElement> options = select.getOptions();
        System.out.println(select.getFirstSelectedOption().getText() + "<---It is first");
        for (int i = 0; i < options.size(); i++) {
            System.out.println(options.get(i).getText());
        }
        return this;
    }
    public SelectMenuPage clickMultiselectDropDown(String text) {
        clickWithAction(multiselectDropDown, 0, 200);
        WebElement elem = driver.findElement(By.xpath(String.format("//div[.='%s']", text)));
        elem.click();
        whiteSpace.click();
        return this;
    }
}
