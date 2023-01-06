package pt.estig.twdm.pdm.youranimeresume.Data;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JAPI {
    @GET("#")
    Call<JAPIResponse<Anime>> getAnime();

    @GET("#")
    Call<JAPIResponse<Manga>> getManga();

    @GET("#")
    Call<JAPIResponse<LightNovel>> getManga();
}
