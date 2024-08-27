package schiphol;

import schiphol.dao.FlightsDAO;

public class Main {
    public static void main(String[] args) {
//        Flight flight = new Flight.FlightBuilder()
//                .flightName("from İstanbul to Toronto")
//                .id("1")
//                .build();
//
//        System.out.println(flight.getFlightName());
//        System.out.println(flight.getActualLandingTime());

        FlightsDAO flightsDAO = new FlightsDAO();

        System.out.println(flightsDAO.getAllFlights());
    }
}
