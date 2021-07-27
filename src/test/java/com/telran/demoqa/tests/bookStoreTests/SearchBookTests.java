package com.telran.demoqa.tests.bookStoreTests;

import com.telran.demoqa.data.BooksData;
import com.telran.demoqa.pages.BookStorePage;
import com.telran.demoqa.pages.HomePage;
import com.telran.demoqa.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SearchBookTests extends TestBase {
    @BeforeMethod
    public void ensurePrecondition(){
        new HomePage(driver).goToBookStore();
    }
    @Test
    public void searchBookPositiveTest(){
        String text = BooksData.BOOK_FOR_SEARCH;
        BookStorePage bookStore = new BookStorePage(driver);
        bookStore.typeInSearchFieldInput(text).takeNameOfBook();
        Assert.assertTrue(bookStore.takeNameOfBook().contains(text));
        //bookStore.takeScreenshotField(bookStore.getNameOfBook());
    }

    @Test
    public void verifyEmptyFieldTest(){
        new BookStorePage(driver).typeInSearchFieldInput("  ").verifyEmptyField();
        Assert.assertTrue(new BookStorePage(driver).verifyEmptyField().contains(""));

    }
}
