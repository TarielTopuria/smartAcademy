package PageObject;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public interface CartPage {
    SelenideElement
        addCartBtn = $(By.className("add_cart")),
        addedItemText = $(By.id("toast-container")),
        cartBtn = $(By.className("cart_info")),
        itemTitle = $(By.className("item_title")),
        itemColor = $(By.className("item_col")),
        itemCode = $(By.className("item_id")),
        itemQuantity = $(By.name("quantity")),
        itemPrice = $(By.xpath("/html/body/div[5]/div/div[3]/div[6]/div[2]")),
        itemFullPrice = $(By.xpath("/html/body/div[5]/div/div[3]/div[7]/div[2]"));
}
