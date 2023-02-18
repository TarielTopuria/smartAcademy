import DataObject.PurchaseData;
import PageObject.PurchasePage;
import StepObject.CartSteps;
import StepObject.PurchaseSteps;
import Utilis.ChromeRunner;
import io.qameta.allure.*;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.*;
import static com.codeborne.selenide.Selenide.sleep;

public class PurchaseTest extends ChromeRunner implements PurchasePage, PurchaseData {
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
                .clearFields()
                .inputName(testName)
                .clickSendBtn();
        sleep(400);
        Assert.assertNotEquals(steps.getNameFieldColor(), "rgb(255, 0, 0)", "Verify if the field is filled, \"კომპანიის სახელწოდება\" should no longer be red.");
    }

    @Test(priority = 8)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Negative test case: Checking that entering string in the field \"საიდენტიფიკაციო კოდი\" is not possible.")
    public void checkStringInCode(){
        steps
                .clearFields()
                .inputCode(simpleString);
        Assert.assertEquals(steps.getCodeFieldValue(), "", "Verify that entering string in the field \"საიდენტიფიკაციო კოდი\" is not possible.");
    }

    @Test(priority = 9)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Negative test case: Checking that entering less than 11 digits in the field \"საიდენტიფიკაციო კოდი\" is not possible.")
    public void checkLessDigitsInCode(){
        steps
                .clearFields()
                .inputCode(lessElevenDigits)
                .clickSendBtn();
        sleep(400);
        Assert.assertEquals(steps.getCodeFieldColor(), "rgb(255, 0, 0)", "Verify tht while entering less than 11 digits in the \"საიდენტიფიკაციო კოდი\" field, it turns red.");
    }

    @Test(priority = 10)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Negative test case: Checking that while entering 12 digits in the field \"საიდენტიფიკაციო კოდი\", 11 characters should be entered in the field.")
    public void checkTwelveDigitsInCode(){
        steps
                .clearFields()
                .inputCode(twelveDigits);
        Assert.assertEquals(steps.getCodeFieldValue().length(), 11, "Verify that while entering 12 digits in the field \"საიდენტიფიკაციო კოდი\", 11 characters should be entered in the field.");
    }

    @Test(priority = 11)
    @Severity(SeverityLevel.NORMAL)
    @Description("Positive test case: Checking that if the field is filled, \"საიდენტიფიკაციო კოდი\" should no longer be red.")
    public void checkFilledCodeFieldColor(){
        steps
                .clearFields()
                .inputCode(elevenDigits)
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
                .clearFields()
                .inputAddress(testAddress)
                .clickSendBtn();
        sleep(400);
        Assert.assertNotEquals(steps.getAddressFieldColor(), "rgb(255, 0, 0)", "Verify if the field is filled, \"ფაქტიური მისამართი\" should no longer be red.");
    }

    @Test(priority = 13)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Negative test case: Checking that entering string in the field \"საკონტაქტო ნომერი\" is not possible.")
    public void checkStringInPhone(){
        steps
                .clearFields()
                .inputPhone(simpleString);
        Assert.assertEquals(steps.getPhoneFieldValue(), "", "Verify that entering string in the field \"საკონტაქტო ნომერი\" is not possible.");
    }

    @Test(priority = 14)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Negative test case: Checking that entering less than 9 digits in the field \"საკონტაქტო ნომერი\" is not possible.")
    public void checkLessDigitsInPhone(){
        steps
                .clearFields()
                .inputPhone(lessNineDigits)
                .clickSendBtn();
        sleep(400);
        Assert.assertEquals(steps.getPhoneFieldColor(), "rgb(255, 0, 0)", "Verify tht while entering less than 9 digits in the \"საკონტაქტო ნომერი\" field, it turns red.");
    }

    @Test(priority = 15)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Negative test case: Checking that while entering 12 digits in the field \"საკონტაქტო ნომერი\", 9 characters should be entered in the field.")
    public void checkTwelveDigitsInPhone(){
        steps
                .clearFields()
                .inputPhone(twelveDigits)
                .clickSendBtn();
        sleep(400);
        Assert.assertEquals(steps.getPhoneFieldValue().length(), 9, "Verify that while entering 12 digits in the field \"კომპანიის სახელწოდება\", 9 characters should be entered in the field.");
    }

    @Test(priority = 16)
    @Severity(SeverityLevel.NORMAL)
    @Description("Positive test case: Checking that while entering 9 digits in the field \"საკონტაქტო ნომერი\", field should no longer be red.")
    public void checkNineDigitsInPhone(){
        steps
                .clearFields()
                .inputPhone(nineDigits)
                .clickSendBtn();
        Assert.assertNotEquals(steps.getPhoneFieldColor(), "rgb(255, 0, 0)", "Verify that while entering 9 digits in the field \"საკონტაქტო ნომერი\", field should no longer be red.");
    }

    @Test(priority = 17)
    @Severity(SeverityLevel.NORMAL)
    @Description("Negative test case: Checking that while entering less than 5 characters in the field \"როდის გსურთ შეკვეთის მიღება?\", field field turns red.")
    public void checkLessInDate(){
        steps
                .clearFields()
                .inputDate(lessFiveCharacters)
                .clickSendBtn();
        sleep(400);
        Assert.assertEquals(steps.getDateFieldColor(), "rgb(255, 0, 0)", "Verify that while entering less than 5 characters in the field \"საკონტაქტო ნომერი\", field should be red.");
    }

    @Test(priority = 18)
    @Severity(SeverityLevel.NORMAL)
    @Description("Positive test case: Checking that while entering 5 or more characters in the field \"როდის გსურთ შეკვეთის მიღება?\", field should no longer be red.")
    public void checkFiveCharacterInDate(){
        steps
                .clearFields()
                .inputDate(fiveCharacters)
                .clickSendBtn();
        sleep(400);
        Assert.assertNotEquals(steps.getDateFieldColor(), "rgb(255, 0, 0)", "Verify that while entering 5 digits in the field \"საკონტაქტო ნომერი\", field should no longer be red.");
    }

    @Test(priority = 19)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Positive test case: Checking that if the value is set in the valid format for  \"ელ.ფოსტა\" (test data: {validEmail}) the field should no longer be red.")
    public void checkValidEmail(){
        steps
                .clearFields()
                .inputEmail(validEmail)
                .clickSendBtn();
        sleep(400);
        Assert.assertNotEquals(steps.getEmailFieldColor(), "rgb(255, 0, 0)", "Verify that if the value is set in the valid format for  \"ელ.ფოსტა\" (test data: {validEmail}) the field should no longer be red.");
    }

    @Test(priority = 20)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Negative test case: Checking that if the value is set in the invalid format for  \"ელ.ფოსტა\" (test data: {emailWithoutAsperand}) the field should be red.")
    public void checkEmailWithoutAsperand(){
        steps
                .clearFields()
                .inputEmail(emailWithoutAsperand)
                .clickSendBtn();
        sleep(400);
        Assert.assertEquals(steps.getEmailFieldColor(), "rgb(255, 0, 0)", "Verify that if the value is set in the invalid format for  \"ელ.ფოსტა\" (test data: {emailWithoutAsperand}) the field should be red.");
    }

    @Test(priority = 21)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Negative test case: Checking that if the value is set in the invalid format for  \"ელ.ფოსტა\" (test data: {emailWithoutDomain}) the field should be red.")
    public void checkEmailWithoutDomain(){
        steps
                .clearFields()
                .inputEmail(emailWithoutDomain)
                .clickSendBtn();
        sleep(400);
        Assert.assertEquals(steps.getEmailFieldColor(), "rgb(255, 0, 0)", "Verify that if the value is set in the invalid format for  \"ელ.ფოსტა\" (test data: {emailWithoutDomain}) the field should be red.");
    }

    @Test(priority = 22)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Negative test case: Checking that if the value is set in the invalid format for  \"ელ.ფოსტა\" (test data: {emailWithoutHost}) the field should be red.")
    public void checkEmailWithoutHost(){
        steps
                .clearFields()
                .inputEmail(emailWithoutHost)
                .clickSendBtn();
        sleep(400);
        Assert.assertEquals(steps.getEmailFieldColor(), "rgb(255, 0, 0)", "Verify that if the value is set in the invalid format for  \"ელ.ფოსტა\" (test data: {emailWithoutHost}) the field should be red.");
    }
}
