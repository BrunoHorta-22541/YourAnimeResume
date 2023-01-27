package pt.estig.twdm.pdm.youranimeresume.Data.LocalDatabase;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

import pt.estig.twdm.pdm.youranimeresume.Data.Anime;
import pt.estig.twdm.pdm.youranimeresume.Data.LightNovel;
import pt.estig.twdm.pdm.youranimeresume.Data.Manga;

@Dao
public interface LightNovelDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void createLN(List<LightNovel> mangaList);
    @Query("SELECT * FROM LightNovel ORDER BY rate LIMIT 5")
    LiveData<List<LightNovel>> gettopLN();

    @Query("SELECT * FROM LightNovel ORDER BY name ASC")
    LiveData<List<LightNovel>> getLNAZ();

    @Query("SELECT * FROM LightNovel WHERE id = :id")
    LiveData<LightNovel> getById(long id);

}
