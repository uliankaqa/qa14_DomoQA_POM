package com.telran.demoqa.pages.navigationMenu;

import com.telran.demoqa.pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SidePanelPage extends PageBase {
    public SidePanelPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[.='Browser Windows']")
    WebElement browserWindowsBtn;

    @FindBy(xpath = "//span[.='Alerts']")
    WebElement alertsBtn;

    @FindBy(xpath = "//span[.='Select Menu']")
    WebElement selectMenuBtn;

    @FindBy(xpath = "//span[.='Practice Form']")
    WebElement practiceFormBtn;

    @FindBy(xpath = "//span[.='Date Picker']")
    WebElement datePickerBtn;

    @FindBy(xpath = "//span[.='Droppable']")
    WebElement droppableBtn;

    public BrowserWindowsPage selectBrowserWindows(){
        clickWithAction(browserWindowsBtn, 0,300);
        return new BrowserWindowsPage(driver);
    }

    public AlertPage selectAlert(){
        clickWithAction(alertsBtn, 0, 300);
        return new AlertPage(driver);
    }

    public SidePanelPage selectSelectMenuBtn() {
        clickWithAction(selectMenuBtn, 0, 700);
        return this;
    }

    public PracticeFormPage selectPracticeForm() {
        clickWithAction(practiceFormBtn, 0, 300);
        return new PracticeFormPage(driver);
    }

    public DatePickerPage selectDatePicker() {
        clickWithAction(datePickerBtn, 0, 300);
        return new DatePickerPage(driver);
    }

    public DragAndDropPage selectDroppable() {
        clickWithAction(droppableBtn, 0, 300);
        return new DragAndDropPage(driver);
    }
}
