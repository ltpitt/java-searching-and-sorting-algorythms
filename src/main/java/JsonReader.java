import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;

import org.json.JSONException;
import org.json.JSONObject;

public final class JsonReader {

    private static String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }

    public static JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
        JSONObject json = new JSONObject();
        try {
            InputStream is = new URL(url).openStream();
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String jsonText = readAll(rd);
            json = new JSONObject(jsonText);
            is.close();
        } catch(Exception e) {
            json.append("Exception", e);
            System.out.println(e);
        }
        return json;
    }


    /**
     * Create a private constructor because no one should ever create a {@link JsonReader} object.
     * This class is only meant to hold static variables and methods, which can be accessed
     * directly from the class name JsonReader (and an object instance of JsonReader is not needed).
     */
    private JsonReader(){

    }

}