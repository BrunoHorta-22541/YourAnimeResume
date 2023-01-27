package pt.estig.twdm.pdm.youranimeresume.ViewModels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import pt.estig.twdm.pdm.youranimeresume.Data.Anime;
import pt.estig.twdm.pdm.youranimeresume.Data.Manga;
import pt.estig.twdm.pdm.youranimeresume.Data.Repository.Repository;

public class MangaViewModel extends AndroidViewModel {
    private Repository repository;

    public MangaViewModel(@NonNull Application application) {
        super(application);
        this.repository = new Repository(application.getApplicationContext());
    }
    public void refreshData() {
        repository.refreshMangaList();
    }
    public void top5Mangas(){repository.list5topanimes();}
    public LiveData<List<Manga>> getMangaBYAZ(){
        return this.repository.getMangaAZ();
    }

    public LiveData<Manga> getMangaWTID(long mangaId){
        return this.repository.getMangaFromID(mangaId);
    }
}
