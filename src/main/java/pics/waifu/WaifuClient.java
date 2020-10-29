package pics.waifu;

import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class WaifuClient {
    /**
     * Gets an SFW image from the API
     * Possible sfw endpoints at https://waifu.pics/docs
     * @param endpoint the endpoint to query
     * @return image URL
     */
    public String getSFWImage(Endpoints.SFW endpoint) {
        return getURL(false, endpoint.toString().toLowerCase());
    }

    /**
     * Gets an NSFW image from the API
     * Possible nsfw endpoints at https://waifu.pics/docs
     * @param endpoint the endpoint to query
     * @return image URL
     */
    public String getNSFWImage(Endpoints.NSFW endpoint) {
        return getURL(true, endpoint.toString().toLowerCase());
    }

    /**
     * Downloads an SFW image from the API
     * Possible sfw endpoints at https://waifu.pics/docs
     * @param endpoint the endpoint to query
     * @return file buffer
     */
    public WaifuImage downloadSFWImage(Endpoints.SFW endpoint) throws Exception {
        return getBuffer(getSFWImage(endpoint));
    }

    /**
     * Downloads an NSFW image from the API
     * Possible nsfw endpoints at https://waifu.pics/docs
     * @param endpoint the endpoint to query
     * @return file buffer
     */
    public WaifuImage downloadNSFWImage(Endpoints.NSFW endpoint) throws Exception {
        return getBuffer(getNSFWImage(endpoint));
    }

    private String getURL(boolean nsfw, String type) {
        String rating = nsfw ? "nsfw" : "sfw";

        try {
            URL url = new URL(String.format("%s/%s/%s", Constants.BaseURL, rating, type));
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");

            BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream()));

            JSONObject json = new JSONObject(reader.readLine());

            return json.getString("url");
        } catch (Exception ignored) {}

        return "";
    }

    private WaifuImage getBuffer(String url) throws Exception {
        BufferedInputStream stream = new BufferedInputStream(new URL(url).openStream());
        return new WaifuImage(stream, url);
    }
}
