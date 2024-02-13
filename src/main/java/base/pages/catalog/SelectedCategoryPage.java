package base.pages.catalog;

import base.pages.BasePage;
import base.pages.catalog.PcComponents.SelectedCategoryListPage;
import io.qameta.allure.Step;
import managers.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class SelectedCategoryPage extends BasePage {

    @Step("Выбрать раздел 'btnName'")
    public SelectedCategoryListPage chooseCategory1(String btnName) {
        WebElement card = DriverManager.getInstance().getDriver().findElement(By.xpath("//img[@alt='" + btnName + "']/ancestor::a"));
        new Actions(DriverManager.getInstance().getDriver())
                .moveToElement(card)
                .click()
                .perform();
        return pageManager.getSelectedCategoryListPage();
    }
}
