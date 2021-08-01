package com.telran.demoqa.tests;

import com.telran.demoqa.data.StudentData;
import com.telran.demoqa.pages.HomePage;
import com.telran.demoqa.pages.PracticeFormPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class StudentRegistrationTest extends TestBase{
    @BeforeMethod
    public void ensurePrecondition(){
        new HomePage(driver).goToFormsMenu().selectPracticeForm();
    }

    @Test
    public void fillStudentRegistrationFormTest(){
        new PracticeFormPage(driver).fillPersonalDate(StudentData.FIRST_NAME,
                StudentData.LAST_NAME, StudentData.E_MAIL, StudentData.TEL_NUM)
                .selectGender(StudentData.GENDER)
                .typeOfDate(StudentData.DATE)
                .addSubject(StudentData.SUBJECTS)
                .chooseHobbies(StudentData.HOBBIES)
                .uploadFile(StudentData.PHOTO_URL)
                .typeAddress(StudentData.ADDRESS)
                .inputState(StudentData.STATE)
                .inputCity(StudentData.CITY).submit();
    }
}
