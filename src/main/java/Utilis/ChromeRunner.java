package Utilis;

import DataObject.Common;
import com.codeborne.selenide.Selenide;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import static com.codeborne.selenide.Selenide.open;

public class ChromeRunner implements Common {
    @BeforeTest(description = "Opening browser with BASEURL before each test")
    public static void chromeSetUp(){
        open(BASEURL);
    }

    @AfterTest(description = "Clearing cookies and other unimportant files after each test")
    public static void clearCookies(){
        Selenide.clearBrowserCookies();
        Selenide.clearBrowserLocalStorage();
    }
}
