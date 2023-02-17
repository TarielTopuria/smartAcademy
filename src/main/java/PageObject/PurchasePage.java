package PageObject;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public interface PurchasePage {
    SelenideElement
        nameInputField = $(By.name("name")),
        sendBtn = $(By.id("btn2")),
        codeInputField = $(By.name("personalId")),
        addressInputField = $(By.name("address")),
        phoneInputField = $(By.name("phone")),
        dateInputField = $(By.name("date")),
        emailInputField = $(By.name("email"));
}
