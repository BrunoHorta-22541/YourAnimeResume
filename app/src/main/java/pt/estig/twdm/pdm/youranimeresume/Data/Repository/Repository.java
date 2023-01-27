package pt.estig.twdm.pdm.youranimeresume.Data.Repository;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import pt.estig.twdm.pdm.youranimeresume.Data.Anime;
import pt.estig.twdm.pdm.youranimeresume.Data.DataSource;
import pt.estig.twdm.pdm.youranimeresume.Data.JAPI;
import pt.estig.twdm.pdm.youranimeresume.Data.JAPIResponse;
import pt.estig.twdm.pdm.youranimeresume.Data.LightNovel;
import pt.estig.twdm.pdm.youranimeresume.Data.LocalDatabase.AnimeDAO;
import pt.estig.twdm.pdm.youranimeresume.Data.LocalDatabase.Database;
import pt.estig.twdm.pdm.youranimeresume.Data.LocalDatabase.LightNovelDAO;
import pt.estig.twdm.pdm.youranimeresume.Data.LocalDatabase.MangaDAO;
import pt.estig.twdm.pdm.youranimeresume.Data.Manga;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Repository {
    private MutableLiveData<List<Anime>> animeLiveData = new MutableLiveData<>();
    private MutableLiveData<List<Manga>> mangaLiveData = new MutableLiveData<>();
    private MutableLiveData<List<LightNovel>> lNLiveData = new MutableLiveData<>();
    private AnimeDAO animeDAO;
    private MangaDAO mangaDAO;
    private LightNovelDAO lightNovelDAO;
    private Anime anime;
    private static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://my-json-server.typicode.com/BrunoHorta-22541/YourAnimeResume/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    private final Context mContext;
    public Repository(Context context){
        mContext = context;
        this.animeDAO = Database.getInstance(context).getAnimeDAO();
        this.mangaDAO = Database.getInstance(context).getMangaDAO();
        this.lightNovelDAO = Database.getInstance(context).getLightNovelDAO();

    }

    private Executor executor = Executors.newSingleThreadExecutor();
    private JAPI japi = retrofit.create(JAPI.class);

    //ANIME
    public LiveData<List<Anime>> getAnimeLiveData() {
        return animeLiveData;
    }
    public void refreshAnimeList() {
        DataSource.getService().getAnimes().enqueue(new Callback<List<Anime>>() {
            @Override
            public void onResponse(Call<List<Anime>> call, Response<List<Anime>> response) {
                if (response.isSuccessful()) {
                    executor.execute(() -> animeDAO.createAnimes(response.body()));
                }else{
                    //Toast.makeText(mContext, "Error fetching data: " + response.code(), Toast.LENGTH_LONG).show();
                }
            }
            @Override
            public void onFailure(Call<List<Anime>> call, Throwable t) {
                t.printStackTrace();
                //Toast.makeText(mContext, "Error fetching data: " + t.getLocalizedMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }
    public LiveData<List<Anime>> getAnimeAZ(){
        return this.animeDAO.getAnimesAZ();
    }
    public LiveData<List<Anime>> list5topanimes(){
        return animeDAO.gettopAnimes();
    }
    public LiveData<Anime> getAnimeFromID(long animeId){

        return animeDAO.getById(animeId);
    }

    //MANGA
    public void refreshMangaList() {
        DataSource.getService().getMangas().enqueue(new Callback<List<Manga>>(){

            @Override
            public void onResponse(Call<List<Manga>> call, Response<List<Manga>> response) {
                if (response.isSuccessful()) {
                    executor.execute(() -> mangaDAO.createMangas(response.body()));
                    mangaLiveData.setValue(response.body());
                }else{
                    //Toast.makeText(mContext, "Error fetching data: " + response.code(), Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<List<Manga>> call, Throwable t) {
                t.printStackTrace();
                //Toast.makeText(mContext, "Error fetching data: " + t.getLocalizedMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }
    public LiveData<List<Manga>> getMangaAZ(){
        return this.mangaDAO.getMangasAZ();
    }
    public LiveData<List<Manga>> list5topmangas(){
        return mangaDAO.gettopMangas();
    }
    public LiveData<Manga> getMangaFromID(long mangaId){

        return mangaDAO.getById(mangaId);
    }

    //LIGHT NOVEL
    public void refreshLNList(){
        DataSource.getService().getLightNovels().enqueue(new Callback<List<LightNovel>>() {
            @Override
            public void onResponse(Call<List<LightNovel>> call, Response<List<LightNovel>> response) {
                if (response.isSuccessful()) {
                    executor.execute(() -> lightNovelDAO.createLN(response.body()));
                    lNLiveData.setValue(response.body());
                }else{
                    //Toast.makeText(mContext, "Error fetching data: " + response.code(), Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<List<LightNovel>> call, Throwable t) {
                t.printStackTrace();
                //Toast.makeText(mContext, "Error fetching data: " + t.getLocalizedMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }
    public LiveData<List<LightNovel>> list5topLN(){
        return lightNovelDAO.gettopLN();
    }
    public LiveData<List<LightNovel>> getLNAZ(){
        return this.lightNovelDAO.getLNAZ();
    }
    public LiveData<LightNovel> getLNFromID(long lnId){

        return lightNovelDAO.getById(lnId);
    }

}