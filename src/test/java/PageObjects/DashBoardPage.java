package PageObjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class DashBoardPage extends BasePage {

    public DashBoardPage() {
        super("/release-17/#/?_k=andovt");
    }

//region PageElements
    private SelenideElement contentContainer(){
        return $x("//div[@id='page_content']");
    }

    private SelenideElement userMenu(){
        return $x("//span[@id='userName']/..");
    }

    private SelenideElement logoutButton(){
        return $x("//ul[@class='list-unstyled']/li[8]");
    }
//endregion

//region LoginPageMethods
    public void logOut(){
        userMenu().click();
        logoutButton().click();
    }

    @Override
    public void isOnPage() {
        contentContainer().shouldBe(Condition.visible);
    }
//endregion


}
