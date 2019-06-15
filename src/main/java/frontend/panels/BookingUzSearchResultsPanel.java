package frontend.panels;

import dto.AvailableTrainDTO;
import frontend.pages.AbstractPage;
import net.serenitybdd.core.pages.WebElementFacade;

import java.util.List;
import java.util.stream.Collectors;

public class BookingUzSearchResultsPanel extends AbstractPanel {

    private static final String SEARCH_RESULT_LIST = ".//tr[not(@class='no-place') and position() > 1]";

    public BookingUzSearchResultsPanel(final WebElementFacade panelBaseLocation, final AbstractPage rootPage) {
        super(panelBaseLocation, rootPage);
    }

    public List<AvailableTrainDTO> getSearchResults() {
        return getRootPage().findAll(SEARCH_RESULT_LIST)
                .stream()
                .map(row -> {
                    final AvailableTrainDTO oneRowData = new AvailableTrainDTO();

                    final WebElementFacade trainNumber = row.findBy(".//td[@class='num']/div");
                    final WebElementFacade from = row.findBy(".//td[@class='station']/div[@class='name' and position()=2]");
                    final WebElementFacade to = row.findBy(".//td[@class='station']/div[@class='name' and position()=3]");
                    final WebElementFacade departureDate = row.findBy("(.//td[@class='date']//span[text()='Отправление']/following-sibling::span)[1]");
                    final WebElementFacade arrivalDate = row.findBy("(.//td[@class='date']//span[text()='Прибытие']/following-sibling::span)[1]");
                    final WebElementFacade departureTime = row.findBy("(.//td[@class='time']//div)[1]");
                    final WebElementFacade arrivalTime = row.findBy("(.//td[@class='time']//div)[2]");
                    final WebElementFacade duration = row.findBy(".//td[@class='duration']");

                    oneRowData.setTrainNumber(trainNumber.getText());
                    oneRowData.setFrom(from.getText());
                    oneRowData.setTo(to.getText());
                    oneRowData.setDeparture(departureDate.getText());
                    oneRowData.setArrival(arrivalDate.getText());
                    oneRowData.setDeparture(departureTime.getText());
                    oneRowData.setStarTime(arrivalTime.getText());
                    oneRowData.setEndTime(departureTime.getText());
                    oneRowData.setInTransit(duration.getText());
                    return oneRowData;

                }).collect(Collectors.toList());

    }
}
