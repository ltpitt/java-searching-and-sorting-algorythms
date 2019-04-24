import org.json.JSONObject;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Logger;
import static java.util.Comparator.*;

public class SearchAlgorythms {

    static Logger logger = Logger.getLogger(SearchAlgorythms.class.getName());


    public int linearSearch(JSONObject json, String icao){
        int airportIndex = -1;
        ArrayList<Airport> airportsArrayList = Utilities.createAirportEntities(json);
        for (Airport currentAirport : airportsArrayList) {
            if (currentAirport.getIcao().equalsIgnoreCase(icao)) {
                System.out.println("Found an airport with ICAO code: " + icao);
                System.out.println(currentAirport);
                airportIndex = airportsArrayList.indexOf(currentAirport);
                break;
            }

        }
        return airportIndex;
    }

    public int binarySearch(JSONObject json){
        ArrayList<Airport> airportsArrayList = Utilities.createAirportEntities(json);
        airportsArrayList.sort(comparing(Airport::getCity));
        int airportIndex = -1;
        return airportIndex;
    }

    public static void main(String args[]) throws IOException {
        System.out.println("Retrieving data...");
        JSONObject json = new JSONObject();
        try {
            json = Utilities.readJsonFromUrl("https://raw.githubusercontent.com/mwgg/Airports/master/airports.json");
        } catch (Exception e) {
            logger.warning("Error retrieving data: " + e);
            json.append("Exception", e);
        }

        // Linear Search
        SearchAlgorythms sa = new SearchAlgorythms();
        System.out.println("Linear Search");
        System.out.println(sa.linearSearch(json, "EHAM"));

        // Binary Search


    }

}
