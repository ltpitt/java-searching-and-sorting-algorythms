import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

public class LinearSearch {

    public static void main(String args[]) throws IOException {
        System.out.println("Retrieving data...");
        JSONObject json = Utilities.readJsonFromUrl("https://raw.githubusercontent.com/mwgg/Airports/master/airports.json");
        ArrayList<Airport> airportsArrayList = Utilities.createAirportEntities(json);
        for (Airport currentAirport : airportsArrayList) {
            if (currentAirport.getCountry().equalsIgnoreCase("US")) {
                System.out.println("Found an airport in US:");
                System.out.println(currentAirport);
                break;
            }

        }
    }

}
