package com.telran.demoqa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.Collection;
import java.util.List;

public class DatePickerPage extends PageBase{
    public DatePickerPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "datePickerMonthYearInput")
    WebElement datePickerInput;

    @FindBy(css = ".react-datepicker__month-select")
    WebElement selectMonth;

    @FindBy(css = ".react-datepicker__month-dropdown")
    WebElement selectMonthWithTime;


    @FindBy(css = ".react-datepicker__year-select")
    WebElement selectYear;

    @FindBy(css = ".react-datepicker__year-read-view")
            //react-datepicker__month-read-view
    WebElement selectYearWithTime;

    @FindBy(css = ".react-datepicker__day")
    List<WebElement> selectDay;


    @FindBy(id = "dateAndTimePickerInput")
    WebElement dateAndTimePickerInput;

    @FindBy(css = ".react-datepicker__time-list-item ")
    List<WebElement> timeList;

    /*public DatePickerPage selectDateToInput(String month, String year, String day) {
        datePickerInput.click();
        setMonth(selectMonth, month);
        setYear(selectYear, year);
        setDay(month, day);
        return this;
    }*/

    public DatePickerPage selectDateToInput(String month, String year, String day) {
        datePickerInput.click();
        new Select(selectMonth).selectByVisibleText(month);
        new Select(selectYear).selectByVisibleText(year);
        setDay(month, day);
        return this;
    }

    public DatePickerPage selectData(String month, String year, String day){
        dateAndTimePickerInput.click();
        new Select(selectMonthWithTime).selectByVisibleText(month);
        new Select(selectYearWithTime).selectByVisibleText(year);
        if(getIndexElementWithDate(month,day)>= 0) {
            selectDay.get(getIndexElementWithDate(month,day)).click();
        }

        /*setMonth(selectMonthWithTime, month);
        setYear(selectYearWithTime, year);
        setDay(month, day);*/
        return this;
    }

    private void setYear(WebElement elem, String year){
        new Select(elem).selectByVisibleText(year);
    }
    private void setMonth(WebElement elem, String month){
        new Select(elem).selectByVisibleText(month);
    }
    private void setDay(String month, String day){
        if(getIndexElementWithDate(month,day)>= 0) {
            selectDay.get(getIndexElementWithDate(month,day)).click();
        }else{
            System.out.println("DatePickerPage.selectDateToInput: can't found a day : " + month + " , " + day);
        }
    }

    private int getIndexElementWithDate(String month, String day) {
        for (WebElement element: selectDay) {
            String[] days = element.getAttribute("aria-label").split(",");
           // System.out.println(element.getAttribute("aria-label"));
           // System.out.println(days[1]);
           if (days[1].contains(month) && days[1].contains(day)) {
                return selectDay.indexOf(element);
           }
        }
        return -1;
    }


    public String getDate() {
        System.out.println("Date :" + datePickerInput.getAttribute("value") );
        return datePickerInput.getAttribute("value");
    }

    public DatePickerPage selectTime(String time) {

        return this;
    }
    private int getIndexElementWithTime(String time){
        for (WebElement elem: timeList
             ) {
            if(elem.getText().equals(time)) return timeList.indexOf(elem);
        }
        return -1;
    }

    public String getDateAndTime() {
        return dateAndTimePickerInput.getAttribute("value");
    }
}
