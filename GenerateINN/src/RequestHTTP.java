import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.JsonObject;
import org.json.JSONArray;
import org.json.JSONObject;


/*
 * Класс RequestHTTP
 * Создается запрос к api и считывается json
 *
 * Создано 10.03.2019
 *
 * Автор Сунгатуллин Радик Ильдарович
 */


public class RequestHTTP<exception> {


    public static void callMe() throws Exception {
        String url = "https://randomuser.me/api/?results=30";
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        con.setRequestMethod("GET");

        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'GET' request to URL : " + url);
        System.out.println("Response Code : " + responseCode);
        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        System.out.println(response.toString());

    }

}