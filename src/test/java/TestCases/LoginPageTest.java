package TestCases;

import PageObjects.DashBoardPage;
import PageObjects.LoginPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest {
    private LoginPage loginPage = new LoginPage();
    private DashBoardPage dashBoardPage = new DashBoardPage();

    @BeforeMethod
    public void openPage(){
        loginPage.goTo();
    }

    @Test
    public void isLoginPageTest() {
        loginPage.isOnPage();
    }

    @Test
    public void SuccessLoginTest() {
        loginPage.setLoginAndPassword("tester","K35G3U");
        loginPage.login();
        loginPage.isErrorNotVisible();
        dashBoardPage.isOnPage();
    }

    @Test
    public void SuccessLogOutTest() {
        loginPage.setLoginAndPassword("tester","K35G3U");
        loginPage.login();
        dashBoardPage.logOut();
        loginPage.isOnPage();
    }

    @DataProvider(name = "WrongCredentials")
    public static Object[][] wrongCredentials() {
        return new Object[][]{
                //login, password, error message
                {"tester", "12345", "Неверное имя пользователя или пароль"},
                {"toster", "K35G3U", "Неверное имя пользователя или пароль"},
                {"@!@##$#$%", "!@#$%$#^#$_", "Неверное имя пользователя или пароль"},
                {"123548", "12345", "Неверное имя пользователя или пароль"},
                {"пользователь", "пароль", "Неверное имя пользователя или пароль"},
        };
    }

    @Test(dataProvider = "WrongCredentials")
    public void wrongCredentialsTest(String login, String password, String errorMessage) {
        loginPage.setLoginAndPassword(login,password);
        loginPage.login();
        loginPage.isErrorVisible(errorMessage);
    }

    @Test
    public void rememberCheckBoxTest(){
        loginPage.setLoginAndPassword("tester","K35G3U");
        loginPage.setRememberCheckBox();
        loginPage.login();
        dashBoardPage.logOut();
        loginPage.checkLoginText("tester");
        loginPage.checkRememberCheckBox(true);
    }
}
