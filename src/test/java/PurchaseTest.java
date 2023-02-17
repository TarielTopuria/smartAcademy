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
        Assert.assertEquals(nameInputField.getCssValue("border-color"), "rgb(255, 0, 0)", "Verify if the field is empty, \"კომპანიის სახელწოდება\" turns red.");
    }

    @Test(priority = 2)
    @Severity(SeverityLevel.NORMAL)
    @Description("Negative test case: Checking that if the field is empty, \"საიდენტიფიკაციო კოდი\" turns red.")
    public void checkCodeFieldColor(){
        Assert.assertEquals(codeInputField.getCssValue("border-color"), "rgb(255, 0, 0)", "Verify if the field is empty, \"საიდენტიფიკაციო კოდი\" turns red.");
    }

    @Test(priority = 3)
    @Severity(SeverityLevel.NORMAL)
    @Description("Negative test case: Checking that if the field is empty, \"ფაქტიური მისამართი\" turns red.")
    public void checkAddressFieldColor(){
        Assert.assertEquals(addressInputField.getCssValue("border-color"), "rgb(255, 0, 0)", "Verify if the field is empty, \"ფაქტიური მისამართი\" turns red.");
    }

    @Test(priority = 4)
    @Severity(SeverityLevel.NORMAL)
    @Description("Negative test case: Checking that if the field is empty, \"საკონტაქტო ნომერი\" turns red.")
    public void checkPhoneFieldColor(){
        Assert.assertEquals(phoneInputField.getCssValue("border-color"), "rgb(255, 0, 0)", "Verify if the field is empty, \"საკონტაქტო ნომერი\" turns red.");
    }

    @Test(priority = 5)
    @Severity(SeverityLevel.NORMAL)
    @Description("Negative test case: Checking that if the field is empty, \"როდის გსურთ შეკვეთის მიღება?\" turns red.")
    public void checkDateFieldColor(){
        Assert.assertEquals(dateInputField.getCssValue("border-color"), "rgb(255, 0, 0)", "Verify if the field is empty, \"როდის გსურთ შეკვეთის მიღება?\" turns red.");
    }

    @Test(priority = 6)
    @Severity(SeverityLevel.NORMAL)
    @Description("Negative test case: Checking that if the field is empty, \"ელ.ფოსტა\" turns red.")
    public void checkEmailFieldColor(){
        Assert.assertEquals(emailInputField.getCssValue("border-color"), "rgb(255, 0, 0)", "Verify if the field is empty, \"ელ.ფოსტა\" turns red.");
    }

    @Test(priority = 7)
    @Severity(SeverityLevel.NORMAL)
    @Description("Negative test case: Checking that if the field is filled, \"კომპანიის სახელწოდება\" should no longer be red.")
    public void checkFilledNameFieldColor(){
        steps.fillNameField();
        sleep(400);
        Assert.assertNotEquals(nameInputField.getCssValue("border-color"), "rgb(255, 0, 0)", "Verify if the field is filled, \"კომპანიის სახელწოდება\" should no longer be red.");
    }
}
