package pt.estig.twdm.pdm.youranimeresume.ViewModels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

import pt.estig.twdm.pdm.youranimeresume.Data.Anime;
import pt.estig.twdm.pdm.youranimeresume.Data.DataSource;
import pt.estig.twdm.pdm.youranimeresume.Data.JAPIResponse;
import pt.estig.twdm.pdm.youranimeresume.Data.Repository.Repository;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AnimeViewModel extends AndroidViewModel {
    private Repository repository;

    public AnimeViewModel(@NonNull Application application) {
        super(application);
        this.repository = new Repository(application.getApplicationContext());
    }

    public LiveData<List<Anime>> getItems() {
        return repository.getAnimeLiveData();
    }

    public void refreshData() {
        repository.refreshAnimeList();
    }
    public void top5animes(){repository.list5topanimes();}
    public LiveData<List<Anime>> getAnimeBYAZ(){
        return this.repository.getAnimeAZ();
    }

    public LiveData<Anime> getAnimeWTID(long animeId){
        return this.repository.getAnimeFromID(animeId);
    }
}


