package base.pages;

import io.qameta.allure.Step;
import managers.DriverManager;
import managers.PageManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    protected DriverManager driverManager = DriverManager.getInstance();
    protected PageManager pageManager = PageManager.getInstance();

    WebDriverWait wait = new WebDriverWait(DriverManager.getInstance().getDriver(), Duration.ofSeconds(10));


    public BasePage() {
        PageFactory.initElements(driverManager.getDriver(), this);

    }

    @Step
    //Проверка текущего url
    public void checkUrl(String url) {
        Assert.assertEquals(url, driverManager.getDriver().getCurrentUrl());
    }

    @Step
    public void elementWait(WebElement element) {
        DriverManager.getInstance().getDriver().manage().timeouts().implicitlyWait(Duration.ofMillis(100));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@class,'skeleton')]")));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[contains(@class,'skeleton')]")));
        DriverManager.getInstance().getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //wait.until(ExpectedConditions.visibilityOf(element));
        //wait.until(ExpectedConditions.elementToBeClickable(element));
    }

}