package pt.estig.twdm.pdm.youranimeresume.Data.Repository;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import pt.estig.twdm.pdm.youranimeresume.Data.Anime;
import pt.estig.twdm.pdm.youranimeresume.Data.DataSource;
import pt.estig.twdm.pdm.youranimeresume.Data.JAPI;
import pt.estig.twdm.pdm.youranimeresume.Data.JAPIResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Repository {
    private MutableLiveData<List<Anime>> animeLiveData = new MutableLiveData<>();
    private static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://my-json-server.typicode.com/BrunoHorta-22541/YourAnimeResume/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();
    private final Context mContext;
    public Repository(Context context){
        mContext = context;
    }
    private Executor executor = Executors.newSingleThreadExecutor();
    private JAPI japi = retrofit.create(JAPI.class);
    public LiveData<List<Anime>> getAnimeLiveData() {
        return animeLiveData;
    }
    public void refreshAnimeList() {
        DataSource.getService().getAnimes().enqueue(new Callback<List<Anime>>() {
            @Override
            public void onResponse(Call<List<Anime>> call, Response<List<Anime>> response) {
                if (response.isSuccessful()) {
                    animeLiveData.setValue(response.body());
                }else{
                    Toast.makeText(mContext, "Error fetching data: " + response.code(), Toast.LENGTH_LONG).show();
                }
            }
            @Override
            public void onFailure(Call<List<Anime>> call, Throwable t) {
                t.printStackTrace();
                Toast.makeText(mContext, "Error fetching data: " + t.getLocalizedMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }
}