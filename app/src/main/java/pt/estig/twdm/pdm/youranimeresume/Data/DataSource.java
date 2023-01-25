package pt.estig.twdm.pdm.youranimeresume.Data;

import java.util.List;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DataSource {

    private static final String endpoint = "https://my-json-server.typicode.com/BrunoHorta-22541/YourAnimeResume/";

    private static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://my-json-server.typicode.com/BrunoHorta-22541/YourAnimeResume/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    private static JAPI japi = retrofit.create(JAPI.class);
    public static JAPI getService() {
        return japi;
    }

}
