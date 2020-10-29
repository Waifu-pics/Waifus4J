package Waifus4J;

import org.json.JSONObject;

import java.net.HttpURLConnection;
import java.net.URL;

public class Waifus4J {
    private static final String BaseURL = "https://waifu.pics/api";

    /**
     * Gets an SFW image from the API
     * Possible sfw endpoints at https://waifu.pics/docs
     * @param endpoint the endpoint to query
     * @return image URL
     */
    public String getSFWImage(String endpoint) {
        return makeRequest(false, endpoint);
    }

    /**
     * Gets an NSFW image from the API
     * Possible nsfw endpoints at https://waifu.pics/docs
     * @param endpoint the endpoint to query
     * @return image URL
     */
    public String getNSFWImage(String endpoint) {
        return makeRequest(true, endpoint);
    }

    private String makeRequest(boolean nsfw, String type) {
        String rating = nsfw ? "nsfw" : "sfw";

        try {
            URL url = new URL(String.format("%s/%s/%s", BaseURL, rating, type));
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");

            JSONObject json = new JSONObject(con.getResponseMessage());

            return json.getString("url");
        } catch (Exception ignored) {}

        return "";
    }
}
