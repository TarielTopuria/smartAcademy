import PageObject.CartPage;
import StepObject.CartSteps;
import Utilis.ChromeRunner;
import com.codeborne.selenide.Condition;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.sleep;

public class CartTest extends ChromeRunner implements CartPage {
    CartSteps steps = new CartSteps();

    @Test(priority = 1)
    @Severity(SeverityLevel.NORMAL)
    @Description("Positive test case: Checking that popup with text: 'პროდუქტი წარმატებით დაემატა კალათაში' is displayed")
    public void checkMessage(){
        steps.addProductToCart();
        sleep(200);
        Assert.assertTrue(addedItemText.isDisplayed(), "Verify that 'პროდუქტი წარმატებით დაემატა კალათაში' is displayed");
    }
    @Test(priority = 2)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Positive test case: Checking that product title in cart is displayed after adding the product")
    public void checkProductTitle(){
        steps.goToCart();
        sleep(200);
        Assert.assertTrue(itemTitle.isDisplayed(), "Verify that product title is displayed");
        Assert.assertTrue(itemTitle.is(Condition.not(Condition.empty)), "Verify that product title is not empty");
    }

    @Test(priority = 3)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Positive test case: Checking that product color in cart is displayed after adding the product")
    public void checkProductColor(){
        Assert.assertTrue(itemColor.isDisplayed(), "Verify that product color is displayed");
        Assert.assertTrue(itemColor.is(Condition.not(Condition.empty)), "Verify that product color is not empty"); // დასაზუსტებელია, უნდა ჩანდეს მხოლოდ სვეტი და ეს საკმარისია, თუ აუცილებლად უნდა იყოს ამ ველში ინფორმაცია?
    }

    @Test(priority = 4)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Positive test case: Checking that product code in cart is displayed after adding the product")
    public void checkProductCode(){
        Assert.assertTrue(itemCode.isDisplayed(), "Verify that product code is displayed");
        Assert.assertTrue(itemCode.is(Condition.not(Condition.empty)), "Verify that product code is not empty");
    }

    @Test(priority = 5)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Positive test case: Checking that product quantity in cart is displayed after adding the product")
    public void checkProductQuantity(){
        Assert.assertTrue(itemQuantity.isDisplayed(), "Verify that product quantity is displayed");
    }

    @Test(priority = 6)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Positive test case: Checking that product price in cart is displayed after adding the product")
    public void checkProductPrice(){
        Assert.assertTrue(itemPrice.isDisplayed(), "Verify that product price is displayed");
        Assert.assertTrue(itemPrice.is(Condition.not(Condition.empty)), "Verify that product price is not empty");
    }

    @Test(priority = 7)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Positive test case: Checking that product full price in cart is displayed after adding the product")
    public void checkProductFullPrice(){
        Assert.assertTrue(itemFullPrice.isDisplayed(), "Verify that product full price is displayed");
        Assert.assertTrue(itemFullPrice.is(Condition.not(Condition.empty)), "Verify that product full price is not empty");
    }

    @Test(priority = 8)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Positive test case: Checking that after increasing the quantity of the product, its full and total prices increases proportionally.")
    public void checkIncreasedPrice(){
        steps.increaseQuantity();
        Assert.assertEquals(steps.getActualPrice() * 2, steps.getFullPrice(), "Verify that after increasing the quantity of the product by one, its full price increases proportionally");
        Assert.assertEquals(steps.getActualPrice() * 2, steps.getTotalPrice(), "Verify that after increasing the quantity of the product by one, its total price increases proportionally");
    }

    @Test(priority = 9)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Positive test case: Checking that after decreasing the quantity of the product, its full and total prices decreases proportionally.")
    public void checkDecreasedPrice(){
        steps.decreaseQuantity();
        Assert.assertEquals(steps.getActualPrice(), steps.getFullPrice(), "Verify that after decreasing the quantity of the product by one, its full price decreases proportionally");
        Assert.assertEquals(steps.getActualPrice(), steps.getTotalPrice(), "Verify that after decreasing the quantity of the product by one, its total price decreases proportionally");
    }

    @Test(priority = 10)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Positive test case: Checking that the product can be deleted by clicking on the \"X\" button.")
    public void checkProductRemoval(){
        steps.deleteProduct();
        sleep(200);
        Assert.assertEquals(steps.getTotalPrice(), 0,"Verify that the product can be deleted by clicking on the \"X\" button.");
    }
}
