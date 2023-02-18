package StepObject;

import DataObject.PurchaseData;
import PageObject.PurchasePage;
import io.qameta.allure.Step;

public class PurchaseSteps implements PurchasePage, PurchaseData {
    @Step("Clicking on 'გაგზავნა' button")
    public PurchaseSteps clickSendBtn(){
        sendBtn.click();
        return this;
    }
    @Step("Get name field border color")
    public String getNameFieldColor(){
        return nameInputField.getCssValue("border-color");
    }

    @Step("Get code field border color")
    public String getCodeFieldColor(){
        return codeInputField.getCssValue("border-color");
    }

    @Step("Get address field border color")
    public String getAddressFieldColor(){
        return addressInputField.getCssValue("border-color");
    }

    @Step("Get phone field border color")
    public String getPhoneFieldColor(){
        return phoneInputField.getCssValue("border-color");
    }

    @Step("Get date field border color")
    public String getDateFieldColor(){
        return dateInputField.getCssValue("border-color");
    }

    @Step("Get email field border color")
    public String getEmailFieldColor(){
        return emailInputField.getCssValue("border-color");
    }

    @Step("Get code field value")
    public String getCodeFieldValue(){
        return codeInputField.getAttribute("value");
    }

    @Step("Get phone field value")
    public String getPhoneFieldValue(){
        return phoneInputField.getAttribute("value");
    }

    @Step("Fill the \"კომპანიის სახელწოდება\" field")
    public PurchaseSteps fillNameField(){
        nameInputField.sendKeys(testName);
        return this;
    }

    @Step("Input string in the \"კომპანიის სახელწოდება\" field")
    public PurchaseSteps inputStringInCode(){
        codeInputField.sendKeys(simpleString);
        return this;
    }

    @Step("Input less than 11 digits in the \"კომპანიის სახელწოდება\" field")
    public PurchaseSteps inputLessDigitsInCode(){
        codeInputField.sendKeys(lessElevenDigits);
        return this;
    }

    @Step("Input 12 digits in the \"კომპანიის სახელწოდება\" field")
    public PurchaseSteps inputTwelveDigitsInCode(){
        codeInputField.sendKeys(twelveDigits);
        return this;
    }

    @Step("Input 11 digits in the \"კომპანიის სახელწოდება\" field")
    public PurchaseSteps inputElevenDigitsInCode(){
        codeInputField.sendKeys(elevenDigits);
        return this;
    }

    @Step("Fill the \"ფაქტიური მისამართი\" field")
    public PurchaseSteps fillAddressField(){
        addressInputField.sendKeys(testAddress);
        return this;
    }

    @Step("Input string in the \"საკონტაქტო ნომერი\" field")
    public PurchaseSteps inputStringInPhone(){
        phoneInputField.sendKeys(simpleString);
        return this;
    }

    @Step("Input less than 9 digits in the \"საკონტაქტო ნომერი\" field")
    public PurchaseSteps inputLessDigitsInPhone(){
        phoneInputField.sendKeys(lessNineDigits);
        return this;
    }

    @Step("Input 12 digits in the \"საკონტაქტო ნომერი\" field")
    public PurchaseSteps inputTwelveDigitsInPhone(){
        phoneInputField.sendKeys(twelveDigits);
        return this;
    }
}
