package StepObject;

import DataObject.PurchaseData;
import PageObject.PurchasePage;
import io.qameta.allure.Step;

public class PurchaseSteps implements PurchasePage, PurchaseData {
    @Step("Clicking on 'გაგზავნა' button")
    public void clickSendBtn(){
        sendBtn.click();
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

    @Step("Input Name")
    public PurchaseSteps inputName(String value){
        nameInputField.sendKeys(value);
        return this;
    }

    @Step("Input Code")
    public PurchaseSteps inputCode(String value) {
        codeInputField.sendKeys(value);
        return this;
    }

    @Step("Input Address")
    public PurchaseSteps inputAddress(String value){
        addressInputField.sendKeys(value);
        return this;
    }

    @Step("Input phone")
    public PurchaseSteps inputPhone(String value){
        phoneInputField.sendKeys(value);
        return this;
    }

    @Step("Input Date")
    public PurchaseSteps inputDate(String value){
        dateInputField.sendKeys(value);
        return this;
    }

    @Step("Input email")
    public PurchaseSteps inputEmail(String value){
        emailInputField.sendKeys(value);
        return this;
    }

    @Step("Clear all fields")
    public PurchaseSteps clearFields(){
        nameInputField.clear();
        codeInputField.clear();
        addressInputField.clear();
        phoneInputField.clear();
        dateInputField.clear();
        emailInputField.clear();
        return this;
    }
}
