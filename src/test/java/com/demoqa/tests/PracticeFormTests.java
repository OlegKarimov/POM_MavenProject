package com.demoqa.tests;

import com.demoqa.data.StudentData;
import com.demoqa.pages.HomePage;
import com.demoqa.pages.PractisFormPage;
import com.demoqa.pages.SidePanel;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PracticeFormTests extends TestBase {

    @BeforeMethod
    public void precondition(){
        new HomePage(driver).getForms();
        new SidePanel(driver).selectPracticeForm();
    }

    @Test
    public void fillPracticeFormTest(){ // тест с данными. Плохо
        new PractisFormPage(driver).hideIframes(); // скрытие Footer
        new PractisFormPage(driver).enterPersonalData("Jack","Assdf","qwer@sdfg.sd","12345678910")
                .selectGender("Male")
                .typeDate("13 May 1984")
                .sddSubject(new String[]{"Maths", "Physics", "English"})
                .selectHobby(new String[]{"Sports","Reading","Music"})
                .uploadFile("C:/Users/AIT TR Student/Documents/QA/Projects/POM_MavenProject/picture.png")
                .enterAddress("Kiev")
                .selectState("NCR")
                .selectCity("Delhi")
                .submit();

    }
    @Test
    public void fillPracticeFormWithFinalDataTest(){ // тест без данными. Хорошо!!
        new PractisFormPage(driver).hideIframes(); // скрытие Footer
        new PractisFormPage(driver).enterPersonalData(StudentData.FIRST_NAME,StudentData.LAST_NAME,StudentData.EMAIL,StudentData.PHONE)
                .selectGender(StudentData.GENDER)
                .typeDate(StudentData.B_BAY)
                .sddSubject(StudentData.SUBJECTS)
                .selectHobby(StudentData.HOBBIES)
                .uploadFile(StudentData.PHOTO)
                .enterAddress(StudentData.ADDRESS)
                .selectState(StudentData.STATE)
                .selectCity(StudentData.CITY)
                .submit();
    }




}
