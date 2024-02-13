package managers;


import base.pages.MainPage;
import base.pages.catalog.PcComponents.SelectedCategoryListPage;
import base.pages.catalog.SelectedCategoryPage;

public class PageManager {
    private static PageManager INSTANCE = null;

    private MainPage mainPage;
    private SelectedCategoryPage selectedCategoryPage;
    private SelectedCategoryListPage selectedCategoryListPage;


    private PageManager() {
    }

    public static PageManager getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new PageManager();
        }
        return INSTANCE;
    }


    public MainPage getMainPage() {
        if (mainPage == null) {
            mainPage = new MainPage();
        }
        return mainPage;
    }

    public SelectedCategoryPage getSelectedCategoryPage() {
        if (selectedCategoryPage == null) {
            selectedCategoryPage = new SelectedCategoryPage();
        }
        return selectedCategoryPage;
    }

    public SelectedCategoryListPage getSelectedCategoryListPage() {
        if (selectedCategoryListPage == null) {
            selectedCategoryListPage = new SelectedCategoryListPage();
        }
        return selectedCategoryListPage;
    }


}
