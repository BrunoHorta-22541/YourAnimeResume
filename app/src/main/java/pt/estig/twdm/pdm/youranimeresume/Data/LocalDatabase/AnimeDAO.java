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
@Dao
public interface AnimeDAO {
    @Query("SELECT * FROM Anime")
    List<Anime> getAll();

    @Query("SELECT * FROM Anime ORDER BY rate LIMIT 5")
    LiveData<List<Anime>> gettopAnimes();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void createAnimes(List<Anime> animeList);

    @Query("SELECT * FROM Anime ORDER BY name ASC")
    LiveData<List<Anime>> getAnimesAZ();

    @Query("SELECT * FROM Anime WHERE id = :id")
    LiveData<Anime> getById(long id);

    @Delete
    void delete(Anime anime);

    @Update
    void updateCategory(Anime anime);


    @Insert
    void insertCategory(Anime anime);

}
