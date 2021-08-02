package com.telran.demoqa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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

    @FindBy(css = ".react-datepicker__month-read-view")
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
        pause(500);
        new Select(selectMonth).selectByVisibleText(month);
        new Select(selectYear).selectByVisibleText(year);
        setDay(month, day);

        return this;
    }

    public DatePickerPage selectDate(String month, String year, String day){
        dateAndTimePickerInput.click();
        pause(500);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDateTime now = LocalDateTime.now();
        System.out.println("Current date: " + dtf.format(now));
        String[] dateNow = dtf.format(now).split("/");

        if(!month.equals(dateNow[1])) {
            selectElementOnDropDownByText(selectMonthWithTime, month);
        }
        if(!year.equals(dateNow[0])) {
            selectElementOnDropDownByText(selectYearWithTime, year);
        }
        if(!day.equals(dateNow[2])) {
            setDay(month, day);
        }
        return this;
    }

    private void setYear(WebElement elem, String year){
        new Select(elem).selectByVisibleText(year);
    }
    private void selectElementOnDropDownByText(WebElement elem, String text){
        elem.click();
        WebElement dropDown = driver.findElement(By.xpath(String.format("//div[.='%s']", text)));
        if(!dropDown.isSelected()) {
            dropDown.click();
        }
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
        WebElement selectedTime = driver.findElement(By.xpath(String.format("//li[.='%s']", time)));
        if(!selectedTime.isSelected()){
            selectedTime.click();
        }
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
