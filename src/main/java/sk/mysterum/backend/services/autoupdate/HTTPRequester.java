package sk.mysterum.backend.services.autoupdate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HTTPRequester{

    private HttpURLConnection getConnection() throws IOException {
        URL url = new URL("http://ivik.synology.me/ver");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        con.setConnectTimeout(5000);
        con.setReadTimeout(5000);
        return con;
    }

    public void makeRequest() throws IOException {
        HttpURLConnection conn = getConnection();
        BufferedReader reader;
        String line;
        StringBuffer content = new StringBuffer();

        if (conn.getResponseCode() == 200){
            reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            while ((line = reader.readLine()) != null){
                content.append(line);
            }

            reader.close();
        } else {
            reader = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
            while ((line = reader.readLine()) != null){
                content.append(line);
            }
        }

        {conn.disconnect();}
    }

}
