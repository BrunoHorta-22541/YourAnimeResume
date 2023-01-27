package pt.estig.twdm.pdm.youranimeresume.Data.LocalDatabase;

import android.content.Context;

import androidx.room.Room;
import androidx.room.RoomDatabase;

import pt.estig.twdm.pdm.youranimeresume.Data.Anime;
import pt.estig.twdm.pdm.youranimeresume.Data.LightNovel;
import pt.estig.twdm.pdm.youranimeresume.Data.Manga;

@androidx.room.Database(entities = {Anime.class, Manga.class, LightNovel.class}, version = 1)
public abstract class Database extends RoomDatabase {
    public abstract AnimeDAO getAnimeDAO();
    public abstract MangaDAO getMangaDAO();
    public abstract LightNovelDAO getLightNovelDAO();
    private static Database INSTANCE;
    public static Database getInstance(Context context){
        if(INSTANCE == null){
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            Database.class, "KeePocketDatabase").
            build();
        }
        return INSTANCE;
    }

}