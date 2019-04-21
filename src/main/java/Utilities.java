import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;

import org.json.JSONException;
import org.json.JSONObject;

public final class Utilities {

    private static String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }

    public static JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
        InputStream is = new URL(url).openStream();
        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String jsonText = readAll(rd);
            JSONObject json = new JSONObject(jsonText);
            return json;
        } finally {
            is.close();
        }
    }

    public static ArrayList<Airport> createAirportEntities(JSONObject json) {
        ArrayList<Airport> airportsArrayList = new ArrayList<Airport>();
        Iterator<String> keys = json.keys();


        while (keys.hasNext()) {
            String key = keys.next();
            if (json.get(key) instanceof JSONObject) {
                String iataValue = "";
                try {
                     iataValue = ((JSONObject) json.get(key)).getString("iata");
                }
                catch(JSONException e){
                    //System.out.println(e);
                    //System.out.println(json.get(key));
                }
                Airport currentAirport = new Airport(((JSONObject) json.get(key)).getInt("elevation"),
                        ((JSONObject) json.get(key)).getString("country"),
                        iataValue,
                        ((JSONObject) json.get(key)).getString("city"),
                        ((JSONObject) json.get(key)).getString("tz"),
                        ((JSONObject) json.get(key)).getString("name"),
                        ((JSONObject) json.get(key)).getString("icao"),
                        ((JSONObject) json.get(key)).getString("state"),
                        ((JSONObject) json.get(key)).getFloat("lat"),
                        ((JSONObject) json.get(key)).getFloat("lon"));
                airportsArrayList.add(currentAirport);
            }
        }
        return airportsArrayList;
    }

    /**
     * Create a private constructor because no one should ever create a {@link Utilities} object.
     * This class is only meant to hold static variables and methods, which can be accessed
     * directly from the class name Utilities (and an object instance of QueryUtils is not needed).
     */
    private Utilities(){

    }

}