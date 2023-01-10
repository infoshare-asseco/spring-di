package pl.infoshare.external;

import pl.infoshare.springdi.airports.model.Continent;
import pl.infoshare.springdi.airports.model.HttpAirportResponse;

public class MockedHttpClient {

    public HttpAirportResponse getAirport(String auth, String secret, String iata) {
        if (!auth.equals("0f1569b81a")) {
            throw new RuntimeException("Incorrect Auth");
        }
        if (!secret.equals("f095cbd5dc51999")) {
            throw new RuntimeException("Incorrect secret");
        }

        if (iata.equals("JFK")) {
            return new HttpAirportResponse(true, new HttpAirportResponse.Airport("Kennedy Airport", new HttpAirportResponse.AirportContinent(Continent.NA)));
        }
        if (iata.equals("LHR")) {
            return new HttpAirportResponse(true, new HttpAirportResponse.Airport("London Airport", new HttpAirportResponse.AirportContinent(Continent.EU)));
        }
        if (iata.equals("RIO")) {
            return new HttpAirportResponse(true, new HttpAirportResponse.Airport("Rio Airport", new HttpAirportResponse.AirportContinent(Continent.SA)));
        }

        return new HttpAirportResponse(false, null);
    }
}
