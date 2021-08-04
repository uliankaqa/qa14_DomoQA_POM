package com.telran.demoqa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.SortedMap;

public class BrokenLinksAndImagesPage extends PageBase{
    public BrokenLinksAndImagesPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(tagName = "a")
    List<WebElement> allLinks;

    @FindBy(tagName = "img")
    List<WebElement> allImages;

    public BrokenLinksAndImagesPage checkAllUrl() {
        String url = "";
        System.out.println("Total links on the page: "+ allLinks.size());
        Iterator<WebElement> iterator = allLinks.iterator();
        while (iterator.hasNext()){
            url = iterator.next().getText();
            System.out.println(url);
        }

        return this;
    }


    public BrokenLinksAndImagesPage checkBrokenLinks() {
        for(int i=0; i<allLinks.size(); i++){
            WebElement elem = allLinks.get(i);
            String url = elem.getAttribute("href");
            verifyLinks(url);
        }
        return this;
    }

    private void verifyLinks(String linkURL) {
        try {
            URL url = new URL(linkURL);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setConnectTimeout(5000);
            connection.connect();
            if (connection.getResponseCode() >= 400) {
                System.out.println(linkURL + " - " + connection.getResponseCode() + "is broken link");
            } else {
                System.out.println(linkURL + " - " + connection.getResponseCode());
            }
        }catch (Exception e ){
            System.out.println(linkURL + " - " + e.getMessage() + "is broken link");
        }
    }

    public BrokenLinksAndImagesPage checkBrikenImages() {
        System.out.println("Wir have : "+ allImages.size());
        for(int i=0; i<allImages.size(); i++){
            WebElement img = allImages.get(i);
            String imgURL = img.getAttribute("src");
            verifyLinks(imgURL);
           /* try {
                boolean imageDisplayed = (Boolean)( (JavascriptExecutor)driver)
                        .executeScript("return (typeOf arguments[0].naturalWidth != 'undefined' " +
                                "&& arguments[0].naturalWidth > 0);", img);
                if(imageDisplayed){
                    System.out.println("Display - OK!");
                    System.out.println("***********************");
                }else {
                    System.out.println("Display broken!");
                    System.out.println("*********************+");
                }
            }catch (Exception e){
                System.out.println("ERROR!");
                System.out.println("*********************+");
            }*/
        }
        return this;
    }
}
