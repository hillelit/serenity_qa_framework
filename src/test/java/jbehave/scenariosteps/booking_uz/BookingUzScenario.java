package jbehave.scenariosteps.booking_uz;

import dto.AvailableTrainDTO;
import dto.SearchCriteriaDTO;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.model.ExamplesTable;
import org.junit.Assert;
import org.unitils.reflectionassert.ReflectionAssert;
import serenity.steps.booking_uz.BookingUzMainPageSteps;

import java.util.List;

public class BookingUzScenario {

    @Steps
    private BookingUzMainPageSteps bookingUzMainPageSteps;

    @Given("user proceeds to cite, using url: '$bookingUrl'")
    public void navigateToBookingSite(final String url) {
        bookingUzMainPageSteps.navigateToSite(url);
    }

    @When("user searches E-tickets, by next criteria: $criteria")
    public void performTicketsSearch(final ExamplesTable criteria) {
        final SearchCriteriaDTO searchCriteria = criteria.getRowsAs(SearchCriteriaDTO.class).get(0);
        bookingUzMainPageSteps.performTicketSearch(searchCriteria);
    }

    @Then("following trains are available to book: $expectedTrainList")
    public void verifyAvailableTrainList(final ExamplesTable expectedTrainList) {
        final List<AvailableTrainDTO> expectedResults = expectedTrainList.getRowsAs(AvailableTrainDTO.class);
        final List<AvailableTrainDTO> actualResults = bookingUzMainPageSteps.getSearchResults();
        ReflectionAssert.assertReflectionEquals("There are results displayed!",
                expectedResults, actualResults);
    }
}
