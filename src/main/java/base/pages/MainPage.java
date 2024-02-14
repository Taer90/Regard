package base.pages;

import io.qameta.allure.Step;
import managers.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BasePage {

    @FindBy(xpath = "//button[contains(@class,'NavigationBar')]")
    private WebElement catalogButton;
    @FindBy(xpath = "//div[(text()='Комплектующие для ПК')and(contains(@class, 'Catalog_mainCategoryName'))]")
    private WebElement pcComponentsButton;

    @Step("Открыть меню Каталог")
    public MainPage openCatalog() {
        catalogButton.click();
        return pageManager.getMainPage();
    }

    @Step("Выбрать раздел /'btnName'/")
    public SelectedCategoryPage chooseCategory(String btnName) {
        DriverManager.getInstance().getDriver().findElement(By.xpath("//div[(text()='" + btnName + "')and(contains(@class, 'Catalog_mainCategoryName'))]")).click();
        return pageManager.getSelectedCategoryPage();
    }
}