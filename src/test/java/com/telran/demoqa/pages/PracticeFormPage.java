package com.telran.demoqa.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.sql.Array;
import java.util.Collection;

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

    @FindBy(id = "subjectsInput")
    WebElement subjectInput;

    @FindBy(id = "react-select-2-option-0")
    WebElement selectIput;

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

    @FindBy(id = "uploadPicture")
    WebElement uploadPictureBtn;

    @FindBy(id = "currentAddress")
    WebElement addressInput;

    @FindBy(id = "state")
    WebElement stateDropBox;

    @FindBy(id = "react-select-3-input")
    WebElement stateBlock;

    @FindBy(id = "city")
    WebElement cityDropBox;

    @FindBy(id = "react-select-4-input")
    WebElement cityBlock;

    @FindBy(id = "example-modal-sizes-title-lg")
    WebElement modalTitle;

    @FindBy(id = "closeLargeModal")
    WebElement closeBtn;

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
                type(subjectInput,subjects[i]);
                selectIput.click();

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
        typeWithAction(addressInput, 0, 500, address);

        return this;
    }
    public PracticeFormPage inputState(String state) {
        stateDropBox.click();
        stateBlock.sendKeys(state);
        stateBlock.sendKeys(Keys.ENTER);
        return this;
    }

    public PracticeFormPage inputCity(String city){
        cityDropBox.click();
        cityBlock.sendKeys(city);
        cityBlock.sendKeys(Keys.ENTER);
        return this;
    }

    public PracticeFormPage uploadFile(String photoUrl) {
        uploadPictureBtn.sendKeys(photoUrl);
        pause(2000);
        return this;
    }

    public PracticeFormPage submit() {
        clickWithAction(submitBtn, 0, 500);
        return this;
    }

    public String getTitleFromDialog() {
        return modalTitle.getText();
    }

    public PracticeFormPage closeSucceusDialog() {
        closeBanner();
        closeBtn.click();
        return this;
    }
}
