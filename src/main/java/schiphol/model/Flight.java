package schiphol.model;

public record Flight(String flightName, String id, String scheduledDate, int terminal, String actualLandingTime,
                     AircraftType aircraftType) {
}
