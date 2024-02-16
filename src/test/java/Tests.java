import base.BaseTests;
import org.junit.Test;

public class Tests extends BaseTests {


    @Test
    public void firstTest() {
        pageManager.getMainPage()
                .openCatalog()
                .chooseCategory("Комплектующие для ПК")
                .chooseSubcategory("Видеокарты")
                .setMinPrice("20000")
                .chooseManufacturer("Gigabyte")
                .waitLoadingEnd()
                .checkCountOfItems()
                .getFirstItemName()
                .enterSearchText()
                .checkCountOfItemsOnTop()
                .compareItemName();
    }

    @Test
    public void secondTest() {
        pageManager.getMainPage()
                .openCatalog()
                .chooseCategory("Периферия")
                .chooseSubcategory("Клавиатуры")
                .setMinPrice("2000")
                .chooseManufacturer("A4Tech")
                .waitLoadingEnd()
//                .checkCountOfItems()
                .getFirstItemName()
                .enterSearchText()
                .checkCountOfItemsOnTop()
                .compareItemName();
    }
}
