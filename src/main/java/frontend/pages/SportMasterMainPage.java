package frontend.pages;

import frontend.panels.SearchPanel;
import org.openqa.selenium.WebDriver;

public class SportMasterMainPage extends AbstractPage {

    private static final String SEARCH_PANEL_LOCATOR = "//div[@class='new-nav-header']";

    public SportMasterMainPage(final WebDriver driver) {
        super(driver);
    }

    public SearchPanel getSearchPanel() {
        return new SearchPanel(findBy(SEARCH_PANEL_LOCATOR), this);
    }
}
