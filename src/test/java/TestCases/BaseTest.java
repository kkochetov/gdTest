package TestCases;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public abstract class BaseTest {

    @BeforeClass
    public void setUp(){
        Configuration.baseUrl = "https://gdcloud.ru";

        Configuration.driverManagerEnabled = true;

        //Configuration for remote selenium
        //Configuration.driverManagerEnabled = false;
        //Configuration.remote = "http://localhost:4444/wd/hub";

        Configuration.browser = "CHROME";
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(true));
    }

    @AfterClass
    public void tearDown(){
        Selenide.closeWebDriver();
    }
}
