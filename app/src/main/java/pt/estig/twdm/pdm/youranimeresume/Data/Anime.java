package pt.estig.twdm.pdm.youranimeresume.Data;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Anime {
    @PrimaryKey
    private long id;
    private String name;
    private String Studio;
    private String Author;
    private String Synopis;
    private String image;
    private int rate;


    public Anime(long id, String name, String Studio, String Author, String Synopis, String image, int rate) {
        this.id = id;
        this.name = name;
        this.Studio = Studio;
        this.Author = Author;
        this.Synopis = Synopis;
        this.image = image;
        this.rate = rate;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getStudio() {
        return Studio;
    }

    public String getAuthor() {
        return Author;
    }

    public String getSynopis() {
        return Synopis;
    }

    public String getImage() {
        return image;
    }

    public int getRate() {
        return rate;
    }
}
