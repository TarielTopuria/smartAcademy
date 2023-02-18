import PageObject.PurchasePage;
import StepObject.CartSteps;
import StepObject.PurchaseSteps;
import Utilis.ChromeRunner;
import io.qameta.allure.*;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.*;

import static com.codeborne.selenide.Selenide.sleep;

public class PurchaseTest extends ChromeRunner implements PurchasePage {
    PurchaseSteps steps = new PurchaseSteps();
    CartSteps cartSteps = new CartSteps();

    @BeforeClass
    public void goToPurchasePage(){
        cartSteps
                .goToProducts()
                .goToMedicinePage()
                .goToGloves()
                .addGloves()
                .goToCart()
                .continuePurchase();
    }

    @Test(priority = 1)
    @Severity(SeverityLevel.NORMAL)
    @Description("Negative test case: Checking that if the field is empty, \"კომპანიის სახელწოდება\" turns red.")
    public void checkNameFieldColor(){
        steps.clickSendBtn();
        sleep(400);
        Assert.assertEquals(steps.getNameFieldColor(), "rgb(255, 0, 0)", "Verify if the field is empty, \"კომპანიის სახელწოდება\" turns red.");
    }

    @Test(priority = 2)
    @Severity(SeverityLevel.NORMAL)
    @Description("Negative test case: Checking that if the field is empty, \"საიდენტიფიკაციო კოდი\" turns red.")
    public void checkCodeFieldColor(){
        Assert.assertEquals(steps.getCodeFieldColor(), "rgb(255, 0, 0)", "Verify if the field is empty, \"საიდენტიფიკაციო კოდი\" turns red.");
    }

    @Test(priority = 3)
    @Severity(SeverityLevel.NORMAL)
    @Description("Negative test case: Checking that if the field is empty, \"ფაქტიური მისამართი\" turns red.")
    public void checkAddressFieldColor(){
        Assert.assertEquals(steps.getAddressFieldColor(), "rgb(255, 0, 0)", "Verify if the field is empty, \"ფაქტიური მისამართი\" turns red.");
    }

    @Test(priority = 4)
    @Severity(SeverityLevel.NORMAL)
    @Description("Negative test case: Checking that if the field is empty, \"საკონტაქტო ნომერი\" turns red.")
    public void checkPhoneFieldColor(){
        Assert.assertEquals(steps.getPhoneFieldColor(), "rgb(255, 0, 0)", "Verify if the field is empty, \"საკონტაქტო ნომერი\" turns red.");
    }

    @Test(priority = 5)
    @Severity(SeverityLevel.NORMAL)
    @Description("Negative test case: Checking that if the field is empty, \"როდის გსურთ შეკვეთის მიღება?\" turns red.")
    public void checkDateFieldColor(){
        Assert.assertEquals(steps.getDateFieldColor(), "rgb(255, 0, 0)", "Verify if the field is empty, \"როდის გსურთ შეკვეთის მიღება?\" turns red.");
    }

    @Test(priority = 6)
    @Severity(SeverityLevel.NORMAL)
    @Description("Negative test case: Checking that if the field is empty, \"ელ.ფოსტა\" turns red.")
    public void checkEmailFieldColor(){
        Assert.assertEquals(steps.getEmailFieldColor(), "rgb(255, 0, 0)", "Verify if the field is empty, \"ელ.ფოსტა\" turns red.");
    }

    @Test(priority = 7)
    @Severity(SeverityLevel.NORMAL)
    @Description("Positive test case: Checking that if the field is filled, \"კომპანიის სახელწოდება\" should no longer be red.")
    public void checkFilledNameFieldColor(){
        steps
                .fillNameField()
                .clickSendBtn();
        sleep(400);
        Assert.assertNotEquals(steps.getNameFieldColor(), "rgb(255, 0, 0)", "Verify if the field is filled, \"კომპანიის სახელწოდება\" should no longer be red.");
    }

    @Test(priority = 8)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Negative test case: Checking that entering string in the field \"კომპანიის სახელწოდება\" is not possible.")
    public void checkStringInCode(){
        steps.inputStringInCode();
        Assert.assertEquals(steps.getCodeFieldValue(), "", "Verify that entering string in the field \"კომპანიის სახელწოდება\" is not possible.");
    }

    @Test(priority = 9)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Negative test case: Checking that entering less than 11 digits in the field \"კომპანიის სახელწოდება\" is not possible.")
    public void checkLessDigitsInCode(){
        steps
                .inputLessDigitsInCode()
                .clickSendBtn();
        sleep(400);
        Assert.assertEquals(steps.getCodeFieldColor(), "rgb(255, 0, 0)", "Verify tht while entering less than 11 digits in the \"საიდენტიფიკაციო კოდი\" field, it turns red.");
    }

    @Test(priority = 10)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Negative test case: Checking that while entering 12 digits in the field \"კომპანიის სახელწოდება\", 11 characters should be entered in the field.")
    public void checkTwelveDigitsInCode(){
        steps.inputTwelveDigitsInCode();
        Assert.assertEquals(steps.getCodeFieldValue().length(), 11, "Verify that while entering 12 digits in the field \"კომპანიის სახელწოდება\", 11 characters should be entered in the field.");
    }

    @Test(priority = 11)
    @Severity(SeverityLevel.NORMAL)
    @Description("Positive test case: Checking that if the field is filled, \"საიდენტიფიკაციო კოდი\" should no longer be red.")
    public void checkFilledCodeFieldColor(){
        steps
                .inputElevenDigitsInCode()
                .clickSendBtn();
        sleep(400);
        Assert.assertEquals(steps.getCodeFieldValue().length(), 11, "Verify that while entering 11 digits in the field \"საიდენტიფიკაციო კოდი\", 11 characters should be entered in the field.");
        Assert.assertNotEquals(steps.getCodeFieldColor(), "rgb(255, 0, 0)", "Verify if the field is filled, \"საიდენტიფიკაციო კოდი\" should no longer be red.");
    }

    @Test(priority = 12)
    @Severity(SeverityLevel.NORMAL)
    @Description("Positive test case: Checking that if the field is filled, \"ფაქტიური მისამართი\" should no longer be red.")
    public void checkFilledAddressFieldColor(){
        steps
                .fillAddressField()
                .clickSendBtn();
        sleep(400);
        Assert.assertNotEquals(steps.getAddressFieldColor(), "rgb(255, 0, 0)", "Verify if the field is filled, \"ფაქტიური მისამართი\" should no longer be red.");
    }

    @Test(priority = 13)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Negative test case: Checking that entering string in the field \"საკონტაქტო ნომერი\" is not possible.")
    public void checkStringInPhone(){
        steps.inputStringInPhone();
        Assert.assertEquals(steps.getPhoneFieldValue(), "", "Verify that entering string in the field \"საკონტაქტო ნომერი\" is not possible.");
    }

    @Test(priority = 14)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Negative test case: Checking that entering less than 9 digits in the field \"საკონტაქტო ნომერი\" is not possible.")
    public void checkLessDigitsInPhone(){
        steps
                .inputLessDigitsInPhone()
                .clickSendBtn();
        sleep(400);
        Assert.assertEquals(steps.getPhoneFieldColor(), "rgb(255, 0, 0)", "Verify tht while entering less than 9 digits in the \"საკონტაქტო ნომერი\" field, it turns red.");
    }

    @Test(priority = 15)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Negative test case: Checking that while entering 12 digits in the field \"საკონტაქტო ნომერი\", 9 characters should be entered in the field.")
    public void checkTwelveDigitsInPhone(){
        steps.inputTwelveDigitsInPhone();
        Assert.assertEquals(steps.getPhoneFieldValue().length(), 9, "Verify that while entering 12 digits in the field \"კომპანიის სახელწოდება\", 9 characters should be entered in the field.");
    }
}
