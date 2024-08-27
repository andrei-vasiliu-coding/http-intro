package schiphol.model.designpattern;

public class Flight {
    private String flightName;
    private String id;
    private String scheduledDate;
    private int terminal;
    private String actualLandingTime;
    private String aircraftType;


    protected Flight(FlightBuilder builder) {
        this.flightName = builder.flightName;
        this.id = builder.id;
        this.scheduledDate = builder.scheduledDate;
        this.terminal = builder.terminal;
        this.actualLandingTime = builder.actualLandingTime;
        this.aircraftType = builder.aircraftType;
    }

    public String getFlightName() {
        return flightName;
    }

    public String getId() {
        return id;
    }

    public int getTerminal() {
        return terminal;
    }

    public String getScheduledDate() {
        return scheduledDate;
    }

    public String getActualLandingTime() {
        return actualLandingTime;
    }

    public String getAircraftType() {
        return aircraftType;
    }

    public static class FlightBuilder {
        private String flightName;
        private String id;
        private String scheduledDate;
        private int terminal;
        private String actualLandingTime;
        private String aircraftType;


        public FlightBuilder flightName(String flightName) {
            this.flightName = flightName;
            return this;
        }

        public FlightBuilder id(String id) {
            this.id = id;
            return this;
        }

        public FlightBuilder scheduledDate(String scheduledDate) {
            this.scheduledDate = scheduledDate;
            return this;
        }

        public FlightBuilder terminal(int terminal) {
            this.terminal = terminal;
            return this;
        }

        public FlightBuilder actualLandingTime(String actualLandingTime) {
            this.actualLandingTime = actualLandingTime;
            return this;
        }

        public FlightBuilder aircraftType(String aircraftType) {
            this.aircraftType = aircraftType;
            return this;
        }

        public Flight build() {
            return new Flight(this);
        }
    }
}
