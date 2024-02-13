import base.BaseTests;
import org.junit.Test;

public class Tests extends BaseTests {


    @Test
    public void firstTest() {
        pageManager.getMainPage()
                .openCatalog()
                .chooseCategory("Комплектующие для ПК")
                .chooseCategory1("Видеокарты")
                .setMinPrice("20000")
                .сhooseManufacturer("Gigabyte")
                .waitLoadingEnd()
                .checkCountOfItems()
                .getFirstItemName()
                .enterSearchText()
                .checkCountOfItemsOnTop()
                .compareItemName();

    }
}
