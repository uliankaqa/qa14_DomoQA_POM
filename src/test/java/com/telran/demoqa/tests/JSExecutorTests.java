package com.telran.demoqa.tests;

import com.telran.demoqa.data.UserData;
import com.telran.demoqa.helpers.JSExecutor;
import com.telran.demoqa.pages.AlertPage;
import com.telran.demoqa.pages.HomePage;
import org.testng.annotations.Test;

public class JSExecutorTests extends TestBase{

    @Test
    public void executorTest(){
        new HomePage(driver).goToElementsPanel().selecttextBox();
        new JSExecutor(driver).typeDataWithExecutor("neuer", "ulitruli@gmail.com" )
                .clickOnSubmitJSE();
    }

    @Test
    public void checkBoxWithJSETest(){
        new HomePage(driver).goToFormsMenu().selectPracticeForm();
        new JSExecutor(driver).checkBoxJSE().alertWithJSE();
        new AlertPage(driver).acceptAlert();
        new JSExecutor(driver).refreshBrowser().getTitlePageJSE()
                .getURLPageJSE().scrollWithJSE();
    }

}
