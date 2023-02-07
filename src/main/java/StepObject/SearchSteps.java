package StepObject;

import DataObject.SearchData;
import PageObject.SearchPage;
import io.qameta.allure.Step;

public class SearchSteps implements SearchPage, SearchData {
    @Step("Click on 'Search' button")
    public SearchSteps clickingOnSearchBtn(){
        searchBtn.click();
        return this;
    }

    @Step("Search with valid data in the search field")
    public SearchSteps inputValidData(){
        searchField.sendKeys(validData);
        searchBtnInLabel.click();
        return this;
    }

    @Step("Search with invalid data in the search field")
    public SearchSteps inputInvalidData(){
        clickingOnSearchBtn();
        searchField.sendKeys(invalidData);
        searchBtnInLabel.click();
        return this;
    }
}
