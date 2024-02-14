package base.steps;

import io.cucumber.java.ru.И;
import managers.PageManager;

public class SelectedCategoryPageSteps {
    private final PageManager pageManager = PageManager.getInstance();

    @И("^Выбрать подраздел \"(.+)\"$")
    public void chooseSubcategory(String btnName){
        pageManager.getSelectedCategoryPage().chooseSubcategory(btnName);
    }

}
