import org.json.JSONObject;

import java.io.IOException;
import java.util.Iterator;

public class LinearSearch {

    public static void main(String args[]) throws IOException {
        System.out.println("Retrieving data...");
        JSONObject json = JsonReader.readJsonFromUrl("https://raw.githubusercontent.com/mwgg/Airports/master/airports.json");
        Iterator<String> keys = json.keys();
        while(keys.hasNext()) {
            String key = keys.next();
            if (json.get(key) instanceof JSONObject) {
                String country = ((JSONObject) json.get(key)).getString("country");
                if (country.equalsIgnoreCase("us")) {
                    System.out.println("Found an airport in US:");
                    System.out.println(json.get(key));
                    break;
                }
            }
        }
    }

}
