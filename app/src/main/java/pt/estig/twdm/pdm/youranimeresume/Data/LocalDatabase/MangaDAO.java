package pt.estig.twdm.pdm.youranimeresume.Data.LocalDatabase;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import pt.estig.twdm.pdm.youranimeresume.Data.Anime;
import pt.estig.twdm.pdm.youranimeresume.Data.Manga;

@Dao
public interface MangaDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void createMangas(List<Manga> mangaList);
    @Query("SELECT * FROM Manga ORDER BY rate LIMIT 5")
    LiveData<List<Manga>> gettopMangas();


    @Query("SELECT * FROM Manga ORDER BY name ASC")
    LiveData<List<Manga>> getMangasAZ();

    @Query("SELECT * FROM Manga WHERE id = :id")
    LiveData<Manga> getById(long id);


}
