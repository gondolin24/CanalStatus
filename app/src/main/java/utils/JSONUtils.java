package utils;


import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JSONUtils {

    private static JSONParser parser = new JSONParser();

    public static JSONObject getJsonObject(String jsonString) throws Exception {

        return (JSONObject) parser.parse(jsonString);

    }
}
