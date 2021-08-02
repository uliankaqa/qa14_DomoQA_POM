package com.telran.demoqa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class DragAndDropPage extends PageBase{
    public DragAndDropPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(id = "draggable")
    WebElement dragMe;

    @FindBy(id = "droppable")
    WebElement dropHere;

    public DragAndDropPage actionDragMe() {
        Actions actions = new Actions(driver);
        pause(2000);
        actions.dragAndDrop(dragMe, dropHere).build().perform();
        assertDropped();
        return this;
    }

    public DragAndDropPage dragAndDropBy() {
        Actions actions = new Actions(driver);
        int xOffset1 = dragMe.getLocation().getX();
        int yOffset1 = dragMe.getLocation().getY();
        System.out.println("X_offset1 = " + xOffset1 + "Y_offset1 = " + yOffset1);

        int xOffset = dropHere.getLocation().getX();
        int yOffset = dropHere.getLocation().getY();
        System.out.println("X_offset = " + xOffset + "Y_offset2 = " + yOffset);

        xOffset = (xOffset - xOffset1) +50;
        yOffset = (yOffset - yOffset1)+100;

        actions.dragAndDropBy(dragMe, xOffset, yOffset).build().perform();
        pause(5000);
        assertDropped();
        return this;
    }

    public void assertDropped(){
        String textTo = dropHere.getText();
        if(textTo.equals("Dropped!")){
            System.out.println("PASS");
        }else {
            System.out.println("FAIL");
        }
    }

    public DragAndDropPage dragAndDropBy100(){
        Actions actions = new Actions(driver);
        actions.dragAndDropBy(dragMe,100,100).build().perform();
        return this;
    }
}
