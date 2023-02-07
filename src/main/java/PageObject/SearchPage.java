package PageObject;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.*;

public interface SearchPage {
    SelenideElement
        searchBtn = $(By.linkText("პროდუქტის ძიება")),
        searchBtnInLabel = $(By.className("search_button")),
        searchField = $(By.name("search")),
        resultItemTitles = $(By.className("prod_title")),
        searchResults = $(By.xpath("/html/body/div[5]/div/h4"));
}
