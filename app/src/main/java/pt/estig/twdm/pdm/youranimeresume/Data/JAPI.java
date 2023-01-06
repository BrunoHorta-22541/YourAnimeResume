package pt.estig.twdm.pdm.youranimeresume.Data;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JAPI {
    @GET("/Anime")
    Call<JAPIResponse<Anime>> getAnime();

    @GET("/Manga")
    Call<JAPIResponse<Manga>> getManga();

    @GET("/LightNovel")
    Call<JAPIResponse<LightNovel>> getManga();
}
