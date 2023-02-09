package StepObject;

import PageObject.CartPage;
import io.qameta.allure.Step;

import java.util.Objects;

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

    @Step("Increase product quantity")
    public CartSteps increaseQuantity(){
        increaseBtn.click();
        return this;
    }

    @Step("Get actual price of the product")
    public double getActualPrice(){
        return Double.parseDouble(itemPrice.getOwnText());
    }

    @Step("Get increased price of the product")
    public double getFullPrice(){
        return Double.parseDouble(itemFullPrice.getOwnText());
    }

    @Step("Get total price of the product")
    public double getTotalPrice(){
        return Double.parseDouble(totalPrice.getOwnText());
    }

    @Step("Decrease product quantity")
    public CartSteps decreaseQuantity(){
        decreaseBtn.click();
        return this;
    }

    @Step("Delete product")
    public CartSteps deleteProduct(){
        deleteProdBtn.click();
        return this;
    }
}
