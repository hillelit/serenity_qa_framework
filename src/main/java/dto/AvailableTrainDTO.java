package dto;

import lombok.Data;

@Data
public class AvailableTrainDTO {

    private String trainNumber;
    private String from;
    private String to;
    private String departure;
    private String arrival;
    private String starTime;
    private String endTime;
    private String inTransit;
}
