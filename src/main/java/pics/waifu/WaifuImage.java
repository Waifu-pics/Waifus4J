package pics.waifu;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.URLConnection;

public class WaifuImage {
    public byte[] buffer;
    public String mimeType;
    public String filename;
    public String extension;

    WaifuImage(BufferedInputStream stream, String url) throws Exception {
        this.mimeType = URLConnection.guessContentTypeFromStream(stream);
        this.buffer = stream.readAllBytes();
        this.filename = url.substring(Constants.BaseURL.length());

        this.extension = filename.substring(filename.lastIndexOf(".") + 1).trim();
    }
}
