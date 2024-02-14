package base.steps;

import io.cucumber.java.ru.И;
import io.qameta.allure.Step;
import managers.PageManager;


public class SelectedCategoryListPageSteps {
    private final PageManager pageManager = PageManager.getInstance();

    @И("^Задать параметр поиска по цене от \"(.+)\" рублей$")
    public void setMinPrice(String price) {
        pageManager.getSelectedCategoryListPage().setMinPrice(price);
    }

    @И("^Выбрать производителя \"(.+)\"$")
    public void сhooseManufacturer(String name) {
        pageManager.getSelectedCategoryListPage().сhooseManufacturer(name);
    }

    @И("^Дождаться выполнения поиска$")
    public void waitLoadingEnd() {
        pageManager.getSelectedCategoryListPage().waitLoadingEnd();
    }

    @И("^Проверить, что в поисковой выдаче не более 24 товаров значение из выпадающего списка Товаров на странице внизу страницы$")
    public void checkCountOfItems() {
        pageManager.getSelectedCategoryListPage().checkCountOfItems();
    }

    @И("^Сохранить наименование первого товара в списке$")
    public void getFirstItemName() {
        pageManager.getSelectedCategoryListPage().getFirstItemName();
    }

    @И("^В поисковую строку ввести запомненное значение, выполнить поиск$")
    public void enterSearchText() {
        pageManager.getSelectedCategoryListPage().enterSearchText();
    }

    @И("^Проверить, что в поисковой выдаче не более 1 товара$")
    public void checkCountOfItemsOnTop() {
        pageManager.getSelectedCategoryListPage().checkCountOfItemsOnTop();
    }

    @И("^Проверить, что наименование товара соответствует сохраненному значению$")
    public void compareItemName() {
        pageManager.getSelectedCategoryListPage().compareItemName();
    }
}