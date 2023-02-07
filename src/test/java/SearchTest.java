import PageObject.SearchPage;
import StepObject.SearchSteps;
import Utilis.ChromeRunner;
import com.codeborne.selenide.Condition;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchTest extends ChromeRunner implements SearchPage {
    SearchSteps steps = new SearchSteps();

    @Test(priority = 1)
    @Severity(SeverityLevel.BLOCKER)
    @Description("Positive test case: Clicking on the 'Search button' and checking that input field is visible.")
    public void searchFieldVisibilityTest(){
        steps.clickingOnSearchBtn();
        Assert.assertTrue(searchField.isDisplayed(), "Verify that 'Search field' is visible");
    }

    @Test(priority = 2)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Positive test case: Search with valid data in the search field.")
    public void searchWithValidData(){
        steps
                .inputValidData();
        Assert.assertTrue(resultItemTitles.is(Condition.text("კალამი ბურთულიანი")));
    }

    @Test(priority = 3)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Negative test case: Search with invalid data in the search field.")
    public void searchWithInvalidData(){
        steps
                .inputInvalidData();
        Assert.assertTrue(searchResults.is(Condition.text("ვერაფერი მოიძებნა")));
    }
}
