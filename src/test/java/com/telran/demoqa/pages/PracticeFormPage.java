package com.telran.demoqa.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.sql.Array;

public class PracticeFormPage extends PageBase {
    public PracticeFormPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//label[@for='gender-radio-1']")
    WebElement maleBtn;

    @FindBy(xpath = "//label[@for='gender-radio-2']")
    WebElement femaleBtn;

    @FindBy(xpath = "//label[@for='gender-radio-3']")
    WebElement otherBtn;

    @FindBy(id = "dateOfBirthInput")
    WebElement dateOfBirth;

    @FindBy(xpath = "//div[@id='subjectsContainer']/div/div[1]/div[@class='css-1g6gooi']")
    WebElement subjectInput;

    @FindBy(id = "react-select-2-option-0")
    WebElement selectInput;

    @FindBy(id="firstName")
    WebElement firstNameInput;

    @FindBy(id="lastName")
    WebElement lastNameInput;

    @FindBy(id = "userEmail")
    WebElement userEmailInput;

    @FindBy(id = "userNumber")
    WebElement userNumberInput;

    @FindBy(id = "submit")
    WebElement submitBtn;

    @FindBy(xpath="//input[@id='hobbies-checkbox-1']/../label")
    WebElement hobbySports;

    @FindBy(xpath="//input[@id='hobbies-checkbox-2']/../label")
    WebElement hobbyReading;

    @FindBy(xpath="//input[@id='hobbies-checkbox-3']/../label")
    WebElement hobbyMusics;


    public PracticeFormPage fillPersonalDate(String firstName, String lastName, String eMail, String telNum) {
        type(firstNameInput, firstName);
        type(lastNameInput, lastName);
        type(userEmailInput, eMail);
        type(userNumberInput, telNum);
        return this;
    }

    public PracticeFormPage selectGender(String gender) {
        if(gender.equals("Male")){
            maleBtn.click();
        }else if(gender.equals("Female")){
            femaleBtn.click();
        }else{
            otherBtn.click();
        }
        return this;
    }

    public PracticeFormPage typeOfDate(String date) {
        dateOfBirth.click();
        String os = System.getProperty("os.name");
        System.out.println("OS: " + os);
        if(os.startsWith("Mac")){
            dateOfBirth.sendKeys(Keys.chord(Keys.COMMAND, "a"));
        }else {
            dateOfBirth.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        }
        dateOfBirth.sendKeys(date);
        dateOfBirth.sendKeys(Keys.ENTER);
        return this;
    }

    public PracticeFormPage addSubject( String[] subjects) {
        for (int i=0; i<subjects.length; i++ ) {
            if(subjects[i] != null) {
                subjectInput.click();
               // subjectInput.sendKeys(subjects[i]);
                // selectInput.click();
                //subjectInput.sendKeys(Keys.ENTER);
            }
        }
        return this;
    }

    public PracticeFormPage chooseHobbies(String[] hobbies) {
        for (int i=0; i<hobbies.length; i++ ) {
            if(hobbies[i].equals("Music")){
                hobbyMusics.click();
            }
            if(hobbies[i].equals("Sports")){
                hobbySports.click();
            }
            if(hobbies[i].equals("Reading")){
                hobbyReading.click();
            }
        }
        return this;
    }
    public PracticeFormPage typeAddress(String address) {

        return this;
    }
    public PracticeFormPage inputState(String state) {

        return this;
    }

    public PracticeFormPage inputCity(String city){

        return this;
    }

    public PracticeFormPage uploadFile(String photoUrl) {

        return this;
    }

    public PracticeFormPage submit() {
        clickWithAction(submitBtn, 0, 500);
        return this;
    }
}
