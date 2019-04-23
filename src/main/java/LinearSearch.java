import org.json.JSONObject;

import javax.sound.sampled.Line;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Logger;

public class LinearSearch {
    static Logger logger = Logger.getLogger(LinearSearch.class.getName());

    public static void main(String args[]) throws IOException {
        System.out.println("Retrieving data...");
        JSONObject json = new JSONObject();
        try {
            json = Utilities.readJsonFromUrl("https://raw.githubusercontent.com/mwgg/Airports/master/airports.json");
        } catch(Exception e) {
            logger.warning("Error retrieving data: " + e);
            json.append("Exception", e);
        }
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
