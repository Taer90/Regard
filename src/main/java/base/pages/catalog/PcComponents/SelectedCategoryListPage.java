package base.pages.catalog.PcComponents;

import base.pages.BasePage;
import io.qameta.allure.Step;
import managers.DriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.openqa.selenium.Keys.ENTER;

public class SelectedCategoryListPage extends BasePage {
    @FindBy(xpath = "//div[@aria-hidden='false']//input[@name='min']")
    private WebElement minPriceField;

    @FindBy(xpath = "//div[@class='rendererWrapper']//a")
    private WebElement firstItemLink;
    @FindBy(xpath = "//span[contains(@class,'countSetter')]")
    private WebElement countItems;
    @FindBy(xpath = "//div[contains(@class,'CardText_title')]")
    private WebElement firstItemName;
    @FindBy(xpath = "//div[contains(@class,'Card_row')]//div[contains(@class,'CardText_title')]")
    private WebElement firstItemNameAfterSearch;
    @FindBy(xpath = "//input[@aria-label = 'Поиск']")
    private WebElement searchField;
    @FindBy(xpath = "//span[contains(@class,'PageTitle_count')]")
    private WebElement countItemTop;
    String FirstItemName;

    @Step("Задать параметр поиска по цене от \"(.+)\" рублей")
    public SelectedCategoryListPage setMinPrice(String price) {
        minPriceField.sendKeys(price);
        return this;
    }

    @Step("Выбрать производителя \"(.+)\"")
    public SelectedCategoryListPage сhooseManufacturer(String name) {
        DriverManager.getInstance().getDriver().findElement(By.xpath("//label[text()='" + name + "']/../../..")).click();
        return this;
    }

    @Step("Дождаться выполнения поиска")
    public SelectedCategoryListPage waitLoadingEnd() {
//        try {
//            Thread.sleep(500);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//        elementWait(firstItemLink);
        elementWait(firstItemLink);
        return this;
    }

    @Step("Проверить, что в поисковой выдаче не более 24 товаров (значение из выпадающего списка 'Товаров на странице' внизу страницы)")
    public SelectedCategoryListPage checkCountOfItems() {
        Assert.assertEquals("по 24", countItems.getText());
        return this;
    }

    @Step("Сохранить наименование первого товара в списке")
    public SelectedCategoryListPage getFirstItemName() {
        FirstItemName = firstItemName.getText();
        return this;
    }

    @Step("В поисковую строку ввести запомненное значение, выполнить поиск")
    public SelectedCategoryListPage enterSearchText() {
        searchField.sendKeys(FirstItemName);
        searchField.sendKeys(ENTER);
        return this;
    }

    @Step("Проверить, что в поисковой выдаче не более 1 товара")
    public SelectedCategoryListPage checkCountOfItemsOnTop() {
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
        elementWait(firstItemNameAfterSearch);
        Assert.assertEquals("1 товар", countItemTop.getText());
        return this;
    }

    @Step("Проверить, что наименование товара соответствует сохраненному значению")
    public SelectedCategoryListPage compareItemName() {
        Assert.assertEquals(FirstItemName, firstItemNameAfterSearch.getText());
        return this;
    }


}
