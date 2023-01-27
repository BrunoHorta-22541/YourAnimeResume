package pt.estig.twdm.pdm.youranimeresume.Data;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Manga {
    @PrimaryKey
    private long id;
    private String name;
    private String publisher;
    private String Author;
    private String Synopis;
    private String image;
    private int rate;

    public Manga(long id, String name, String publisher, String Author, String Synopis, String image, int rate) {
        this.id = id;
        this.name = name;
        this.publisher = publisher;
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

    public String getPublisher() {
        return publisher;
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
