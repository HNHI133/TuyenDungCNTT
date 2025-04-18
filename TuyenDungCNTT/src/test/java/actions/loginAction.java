package actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ui.loginPageUI;

import java.time.Duration;

public class loginAction {

    loginPageUI loginPageUI;
    WebDriver driver;
    public loginAction(WebDriver driver) {
        this.driver = driver;
        loginPageUI = new loginPageUI(driver);
    }

    public void clickButtonUserLogin() {
        loginPageUI.buttonUserLogin().click();
    }

    public void inputDataUserLogin(String email, String password) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement textUserEmail = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(loginPageUI.TextUserEmail())));
        textUserEmail.sendKeys(email);
        loginPageUI.TextUserPassword().sendKeys(password);
    }

    public void clickUserLogin() {
        loginPageUI.buttonLogin().click();
    }
}
