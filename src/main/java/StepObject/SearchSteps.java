package StepObject;

import PageObject.SearchPage;
import io.qameta.allure.Step;

public class SearchSteps implements SearchPage {
    @Step("Click on 'Search' button")
    public SearchSteps clickingOnSearchBtn(){
        searchBtn.click();
        return this;
    }

    @Step("Search with valid data in the search field")
    public SearchSteps inputValidData(){
        searchField.sendKeys("კალამი ბურთულიანი");
        searchBtnInLabel.click();
        return this;
    }

    @Step("Search with invalid data in the search field")
    public SearchSteps inputInvalidData(){
        clickingOnSearchBtn();
        searchField.sendKeys("satesto");
        searchBtnInLabel.click();
        return this;
    }
}
