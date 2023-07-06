package com.demoqa.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import javax.swing.*;

public class PractisFormPage extends BasePage{
    public PractisFormPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "firstName")
    WebElement firstName;
    @FindBy(id = "lastName")
    WebElement lastName;
    @FindBy(id = "userEmail")
    WebElement userEmail;
    @FindBy(id = "userNumber")
    WebElement userNumber;
    public PractisFormPage enterPersonalData(String fName, String lName, String email,String phNumber) {
        type(firstName,fName);
        type(lastName,lName);
        type(userEmail,email);
        typeWithJSExecutor(userNumber,phNumber,0,100);
        return this;
    }

    @FindBy(css = "[for='gender-radio-1']")
    WebElement male;

    @FindBy(css = "[for='gender-radio-2']")
    WebElement female;

    @FindBy(css = "[for='gender-radio-3']")
    WebElement other;
    public PractisFormPage selectGender(String gender) { // выбор RadioButton флажков
        if (gender.equals("Male")){
            click((male));
        } else if (gender.equals("Famele")) {
            click((female));
        } else {
            click((other));
        }
        return this;
    }

//----------------------------------------------------------------
    @FindBy(id = "dateOfBirthInput")
    WebElement dateOfBirthInput;
    public PractisFormPage typeDate(String bDay) {
        clickWithJSExecutor(dateOfBirthInput,0,100);

        selectOS();
        dateOfBirthInput.sendKeys(bDay);
        dateOfBirthInput.sendKeys(Keys.ENTER);
        return this;
    }

    public void selectOS() {
        String os = System.getProperty("os.name"); // проверяем название ОС
        System.out.println("My OS:" + os);

        if (os.startsWith("Mac")) {
            dateOfBirthInput.sendKeys((Keys.chord(Keys.COMMAND,"a")));
        }else  {
            dateOfBirthInput.sendKeys((Keys.chord(Keys.CONTROL,"a")));
        }
    }

//----------------------------------------------------------------
    @FindBy(id="subjectsInput")
    WebElement subjectsInput;
    public PractisFormPage sddSubject(String[] subjects) {
        for (int i = 0; i < subjects.length; i++) {
            if (subjects[i] != null) {
                type(subjectsInput, subjects[i]);
                subjectsInput.sendKeys(Keys.ENTER);
            }
        }
        return this;
    }
//----------------------------------------------------------------
    @FindBy(css = "[for='hobbies-checkbox-1']")
    WebElement sports;
    @FindBy(css = "[for='hobbies-checkbox-2']")
    WebElement reading;
    @FindBy(css = "[for='hobbies-checkbox-3']")
    WebElement music;
    public PractisFormPage selectHobby(String[] hobbies) { // выбор флажков
        for (int i = 0; i < hobbies.length; i++) {
            if (hobbies[i].equals("Sports")) {
                clickWithJSExecutor(sports,0,100);
            } if (hobbies[i].equals("Reading")) {
                clickWithJSExecutor(reading,0,100);
            } if (hobbies[i].equals("Music")){
                clickWithJSExecutor(music,0,100);
            }
        }
        return this;
    }

//----------------------------------------------------------------
    @FindBy(id = "uploadPicture")
    WebElement uploadPicture;
    public PractisFormPage uploadFile(String path) { // загрузка файла на сайт с ПК
        uploadPicture.sendKeys(path);
        return this;
    }

//----------------------------------------------------------------
    @FindBy(id = "currentAddress")
    WebElement currentAddress;
    public PractisFormPage enterAddress(String address) {
        type(currentAddress,address);
        return this;
    }

//----------------------------------------------------------------
    @FindBy(id = "state")
    WebElement stateContainer;
    @FindBy(id = "react-select-3-input")
    WebElement stateInput;
    public PractisFormPage selectState(String state) {
        click(stateContainer);
        stateInput.sendKeys(state);
        stateInput.sendKeys(Keys.ENTER);
        return this;
    }

//----------------------------------------------------------------
    @FindBy(id = "city")
    WebElement cityContainer;
    @FindBy(id = "react-select-4-input")
    WebElement cityInput;
    public PractisFormPage selectCity(String city) {
        click(cityContainer);
        cityInput.sendKeys(city);
        cityInput.sendKeys(Keys.ENTER);
        return this;
    }

//----------------------------------------------------------------
    @FindBy(id = "submit")
    WebElement submit;
    public PractisFormPage submit() {
        pause(1000);
        clickWithRectangle(submit, 2, 4);
        return this;
    }

//----------------------------------------------------------------

    public void clickWithRectangle(WebElement element,int x, int y){
        Rectangle rectangle = element.getRect();

        int offSetX = rectangle.getWidth() / x;
        int offSetY = rectangle.getHeight() / x;

        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        actions.moveByOffset(-offSetX,-offSetY).click().perform();
    }
}
