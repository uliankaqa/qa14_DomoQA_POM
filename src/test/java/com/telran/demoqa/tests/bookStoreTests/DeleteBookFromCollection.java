package com.telran.demoqa.tests.bookStoreTests;

import com.telran.demoqa.data.BooksData;
import com.telran.demoqa.data.UserData;
import com.telran.demoqa.pages.BookStorePage;
import com.telran.demoqa.pages.HomePage;
import com.telran.demoqa.pages.LoginPage;
import com.telran.demoqa.pages.navigationMenu.BookStoreApplication;
import com.telran.demoqa.tests.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DeleteBookFromCollection extends TestBase {
    @BeforeMethod
    public void ensurePrecondition(){
        new HomePage(driver).goToBookStore();
        new BookStorePage(driver).goToLoginPage();
        new LoginPage(driver).login(UserData.USER_NAME, UserData.USER_PASSWORD);
    }
    @Test
    public void deleteBookFromCollectionTest(){
        String text = BooksData.BOOK_FOR_SEARCH;
        new BookStorePage(driver)
                .typeInSearchFieldInput(text)
                .clickByFirstBook()
                .addToYourCollection();
        new BookStoreApplication(driver)
                .goToProfilePage()
                .clickOnTrashToDeleteBook();

    }
}
