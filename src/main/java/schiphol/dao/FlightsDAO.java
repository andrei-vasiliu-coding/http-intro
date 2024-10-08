package schiphol.dao;

import org.springframework.http.ResponseEntity;
import org.springframework.web.reactive.function.client.WebClient;
import schiphol.model.Flight;
import schiphol.model.Flights;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

public class FlightsDAO {
    private WebClient client;
    private Properties properties;
//    private String appId;
//    private String apiKey;

    public FlightsDAO() {
        client = WebClient.create("https://api.schiphol.nl");
        initalize();
    }


    private void initalize() {
        properties = new Properties();

        String configFilePath = "config//flight.properties";

        File ConfigFile = new File(configFilePath);

        try (FileInputStream configFileReader = new FileInputStream(ConfigFile)) {

            properties.load(configFileReader);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
//            throw new RuntimeException(e);
            System.err.println("Unhandled IO Exception");
        }
    }

    private String getAppId() {
        return properties.getProperty("app_id");
    }

    private String getApiKey() {
        return properties.getProperty("app_key");
    }

    public List<Flight> getAllFlights() {
        ResponseEntity<Flights> response = client.get()
                .uri("/public-flights/flights")
                .headers(httpHeaders -> {
                    httpHeaders.set("Accept", "application/json");
                    httpHeaders.set("app_id", getAppId());
                    httpHeaders.set("app_key", getApiKey());
                    httpHeaders.set("ResourceVersion", "v4");
                })
                .retrieve()
                .toEntity(Flights.class)
                .block();

        if (response == null || !response.hasBody()) {
            throw new RuntimeException("Something went wrong while reaching out to Schiphol Flights API!");
        }

        // else
        return response.getBody().flights();
    }
}
