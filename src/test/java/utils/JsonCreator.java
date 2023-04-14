package utils;

import org.json.JSONObject;

import java.io.FileWriter;
import java.io.IOException;

public class JsonCreator {
    public static void createJsonFilewithBrowserAndOs(String browserName, String browserVersion){


        // Create a new JSON object
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("BrowserName", browserName);
        jsonObject.put("BrowserVersion", browserVersion);
        jsonObject.put("os", System.getProperty("os.name"));
        jsonObject.put("osVersion", System.getProperty("os.version"));

        // Write the JSON object to a file
        try (FileWriter fileWriter = new FileWriter("contextTestInfo.json")) {
            fileWriter.write(jsonObject.toString());
            System.out.println("JSON object has been written to the file.");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}