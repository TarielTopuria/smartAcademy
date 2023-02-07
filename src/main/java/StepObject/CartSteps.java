package StepObject;

import PageObject.CartPage;
import io.qameta.allure.Step;

public class CartSteps implements CartPage {
    @Step("Adding product to the Cart")
    public CartSteps addProductToCart(){
        addCartBtn.click();
        return this;
    }

    @Step("Go to cart")
    public CartSteps goToCart(){
        cartBtn.click();
        return this;
    }
}
