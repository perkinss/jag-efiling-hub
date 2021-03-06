package hub.support;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class Resource {

    public static String bodyOf(String uri) throws Exception {
        URL url = new URL( uri );
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        if (connection.getResponseCode() < 400) {
            InputStream inputStream = connection.getInputStream();
            byte[] response = new byte[inputStream.available()];
            inputStream.read(response);

            return new String(response);
        } else {
            InputStream inputStream = connection.getErrorStream();
            byte[] response = new byte[inputStream.available()];
            inputStream.read(response);

            return new String(response);
        }
    }
}
