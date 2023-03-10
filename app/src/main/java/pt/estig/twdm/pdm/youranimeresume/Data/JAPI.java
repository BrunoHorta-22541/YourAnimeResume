package pt.estig.twdm.pdm.youranimeresume.Data;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface JAPI {


    @GET("Anime")
    Call<List<Anime>> getAnimes();

    @GET("Anime")
    Call<List<Anime>> gettopAnimes();

    @GET("Manga")
    Call<List<Manga>> getMangas();

    @GET("LightNovel")
    Call<List<LightNovel>> getLightNovels();

}
