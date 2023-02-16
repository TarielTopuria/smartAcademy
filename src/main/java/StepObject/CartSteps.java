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

    @Step("Go to product section")
    public CartSteps goToProducts(){
        productBtn.click();
        return this;
    }

    @Step("Go to medical products section")
    public CartSteps goToMedicinePage(){
        medicineBtn.click();
        return this;
    }

    @Step("Go to gloves section")
    public CartSteps goToGloves(){
        glovesBtn.click();
        return this;
    }

    @Step("Add Gloves to Cart")
    public CartSteps addGloves(){
        glovesAddCart.click();
        glovesAddCart2.click();
        return this;
    }

    @Step("Clear Cart")
    public CartSteps clearCart(){
        clearCartBtn.click();
        return this;
    }

    @Step("Continue Purchase")
    public CartSteps continuePurchase(){
        continuePurchaseBtn.click();
        return this;
    }
}
