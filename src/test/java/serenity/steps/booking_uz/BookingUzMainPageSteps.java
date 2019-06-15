package serenity.steps.booking_uz;

import dto.AvailableTrainDTO;
import dto.SearchCriteriaDTO;
import frontend.pages.BookingUzMainPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;

import java.util.List;

public class BookingUzMainPageSteps extends ScenarioSteps {

    private BookingUzMainPage bookingUzMainPage;

    public BookingUzMainPageSteps(final Pages pages) {
        bookingUzMainPage = pages.getPage(BookingUzMainPage.class);
    }

    @Step
    public void navigateToSite(final String url) {
        bookingUzMainPage.openAt(url);
    }

    @Step
    public void selectTravelDestination(final String from, final String to) {
        bookingUzMainPage.getBookingUzSearchPanel().selectTravelDate(from, to);
    }

    @Step
    public void clickSearchButton() {
        bookingUzMainPage.getBookingUzSearchPanel().clickSearchButton();
    }

    @Step
    public void performTicketSearch(final SearchCriteriaDTO searchCriteria) {
        final String[] destination = searchCriteria.getFrom().split("-");
        bookingUzMainPage.getBookingUzSearchPanel().selectDestination(destination[0], destination[1]);
        bookingUzMainPage.getBookingUzSearchPanel().clickSearchButton();
    }

    @Step
    public List<AvailableTrainDTO> getSearchResults() {
        return bookingUzMainPage.getBookingUzSearchResultsPanel().getSearchResults();
    }
}
