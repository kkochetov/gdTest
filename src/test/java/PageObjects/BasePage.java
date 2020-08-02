package PageObjects;

import com.codeborne.selenide.Selenide;

public abstract class BasePage {
    private String pagePath;

    BasePage(String pagePath)
    {
        this.pagePath = pagePath;
    }

    public void goTo() {
        Selenide.open(pagePath);
    }

    public void isOnPage() {

    };
}
