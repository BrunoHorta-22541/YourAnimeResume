package pt.estig.twdm.pdm.youranimeresume.ViewModels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import pt.estig.twdm.pdm.youranimeresume.Data.LightNovel;
import pt.estig.twdm.pdm.youranimeresume.Data.Manga;
import pt.estig.twdm.pdm.youranimeresume.Data.Repository.Repository;

public class LightNovelViewModel extends AndroidViewModel {
    private Repository repository;

    public LightNovelViewModel(@NonNull Application application) {
        super(application);
        this.repository = new Repository(application.getApplicationContext());
    }
    public void refreshData() {
        repository.refreshLNList();
    }
    public void top5LN(){repository.list5topanimes();}
    public LiveData<List<LightNovel>> getLNBYAZ(){
        return this.repository.getLNAZ();
    }

    public LiveData<LightNovel> getLNWTID(long mangaId){
        return this.repository.getLNFromID(mangaId);
    }
}
