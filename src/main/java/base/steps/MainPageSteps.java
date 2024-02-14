package base.steps;

import io.cucumber.java.ru.И;
import managers.PageManager;

public class MainPageSteps {
    private final PageManager pageManager = PageManager.getInstance();

    @И("^Открыть меню Каталог$")
    public void openCatalog() {
        pageManager.getMainPage().openCatalog();
    }

    @И("^Выбрать раздел \"(.+)\"$")
    public void chooseCategory(String btnName) {
        pageManager.getMainPage().chooseCategory(btnName);
    }
}
