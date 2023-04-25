package be.ehb.mavendemo;


import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.apache.commons.lang3.tuple.Pair;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        Pair<String, String> pair = Pair.of("Hello", "World");
        System.out.println(pair);

        String url = "https://api.chucknorris.io/jokes/random";
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url(url)
                .get()
                .build();

        try (Response response = client.newCall(request).execute()) {
            System.out.println(response.body().string());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
