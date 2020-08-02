package PageObjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class LoginPage extends BasePage {

    public LoginPage() {
        super("/release-17/auth/login");
    }

//region PageElements
    private SelenideElement loginField(){
        return $x("//input[@id='username']");
    }

    private SelenideElement passwordField(){
        return $x("//input[@id='password']");
    }

    private SelenideElement loginButton(){
        return $x("//button[@id='login_button']");
    }

    private SelenideElement rememberCheckBox(){
        return $x("//input[@id='remember']");
    }

    private SelenideElement errorLabel(){
        return $x("//div[@id='error']");
    }
//endregion

//region LoginPageMethods
    public void setLoginAndPassword(String login, String password){
        loginField().setValue(login);
        passwordField().setValue(password);
    }

    public void login() {
        loginButton().click();
    }

    public void isErrorNotVisible(){
        errorLabel().shouldNotBe(Condition.visible);
    }

    public void isErrorVisible(String errorText){
        errorLabel().shouldHave(Condition.text(errorText));
    }

    public void setRememberCheckBox(){
        rememberCheckBox().click();
    }

    public void checkRememberCheckBox(Boolean selected){
        if (selected) {
            rememberCheckBox().shouldBe(Condition.checked);
        } else {
            rememberCheckBox().shouldNotBe(Condition.checked);
        }
    }

    public void checkLoginText(String text){
        loginField().shouldHave(Condition.value(text));
    }


    @Override
    public void isOnPage() {
        loginField().shouldBe(Condition.visible);
        passwordField().shouldBe(Condition.visible);
        loginButton().shouldBe(Condition.visible);
    }

//endregion


}
