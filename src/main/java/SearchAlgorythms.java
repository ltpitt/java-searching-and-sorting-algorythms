import org.json.JSONObject;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Logger;
import static java.util.Comparator.*;

public class SearchAlgorythms {

    static Logger logger = Logger.getLogger(SearchAlgorythms.class.getName());


    public int linearSearch(JSONObject json, String cityToSearch){
        int airportIndex = -1;
        ArrayList<Airport> airportsArrayList = Utilities.createAirportEntities(json);
        for (Airport currentAirport : airportsArrayList) {
            if (currentAirport.getCity().equalsIgnoreCase(cityToSearch)) {
                airportIndex = airportsArrayList.indexOf(currentAirport);
                break;
            }

        }
        System.out.println(airportsArrayList.get(airportIndex));
        return airportIndex;
    }

    public int binarySearch(JSONObject json, String cityToSearch){
        ArrayList<Airport> airportsArrayList = Utilities.createAirportEntities(json);
        airportsArrayList.sort(comparing(Airport::getCity));
        int low = 0;
        int high = airportsArrayList.size() - 1;
        int mid = (low + high) / 2;
        int airportIndex = -1;
        while (low <= high) {
            if (airportsArrayList.get(mid).getCity().compareToIgnoreCase(cityToSearch) < 0) {
                low = mid + 1;
            } else if (airportsArrayList.get(mid).getCity().compareToIgnoreCase(cityToSearch) == 0) {
                airportIndex = mid;
                break;
            } else {
                high = mid - 1;
            }
            mid = (low + high) / 2;
        }
        System.out.println(airportsArrayList.get(airportIndex));
        return airportIndex;
    }

    public static void main(String args[]){
        System.out.println("Retrieving data...\n");
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
        System.out.println(sa.linearSearch(json, "Amsterdam"));
        // Binary Search
        System.out.println("\nBinary Search");
        System.out.println(sa.binarySearch(json, "Amsterdam"));

    }

}
