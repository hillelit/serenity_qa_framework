package frontend.pages;

import frontend.panels.BookingUzSearchPanel;
import frontend.panels.BookingUzSearchResultsPanel;
import org.openqa.selenium.WebDriver;

public class BookingUzMainPage extends AbstractPage {

    private static final String SEARCH_PANEL_LOCATOR = "//div[@id='search-frm']";
    private static final String SEARCH_RESULTS_PANEL_LOCATOR = "//div[@id='train-list']";

    public BookingUzMainPage(final WebDriver driver) {
        super(driver);
    }

    public BookingUzSearchPanel getBookingUzSearchPanel() {
        return new BookingUzSearchPanel(findBy(SEARCH_PANEL_LOCATOR), this);
    }

    public BookingUzSearchResultsPanel getBookingUzSearchResultsPanel() {
        return new BookingUzSearchResultsPanel(findBy(SEARCH_RESULTS_PANEL_LOCATOR), this);
    }
}
