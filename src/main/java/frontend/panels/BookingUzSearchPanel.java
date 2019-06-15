package frontend.panels;

import frontend.pages.AbstractPage;
import net.serenitybdd.core.pages.WebElementFacade;

public class BookingUzSearchPanel extends AbstractPanel {

    private static final String FROM_BUTTON_LOCATOR = ".//button[./span[text()='%s'] and ./span[text()='%s']]";
    private static final String SELECT_DATE_INPUT_LOCATOR = ".//input[@name='date-hover']";
    private static final String SEARCH_BUTTON_LOCATOR = ".//div[@class='button']//button[@type='submit']";

    public BookingUzSearchPanel(final WebElementFacade panelBaseLocation, final AbstractPage rootPage) {
        super(panelBaseLocation, rootPage);
    }

    public void selectDestination(final String from, final String to) {
        final String fullLocator = String.format(FROM_BUTTON_LOCATOR, from, to);
        final WebElementFacade destinationButton = getRootPage().findBy(fullLocator);
        destinationButton.click();
    }

    public void clickSearchButton() {
        getRootPage().findBy(SEARCH_BUTTON_LOCATOR).click();
    }

    public void selectTravelDate(final String month, final String day) {
        //TODO Will be implemented later
    }
}
