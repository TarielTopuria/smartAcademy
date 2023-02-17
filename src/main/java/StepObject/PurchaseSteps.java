package StepObject;

import PageObject.PurchasePage;
import io.qameta.allure.Step;

public class PurchaseSteps implements PurchasePage {
    @Step("Clicking on 'გაგზავნა' button")
    public PurchaseSteps clickSendBtn(){
        sendBtn.click();
        return this;
    }

    @Step("Fill the \"კომპანიის სახელწოდება\" field")
    public PurchaseSteps fillNameField(){
        nameInputField.sendKeys("Test Name");
        return this;
    }
}
