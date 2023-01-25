package pt.estig.twdm.pdm.youranimeresume.Data;

public class Anime {
    private long id;
    private String name;
    private String Studio;
    private String Author;
    private String synopis;
    private String animeImage;
    private int rate;


    public Anime(long id,String name, String synopis, String studio, String author,String animeImage,int rate) {
        this.id = id;
        this.name = name;
        this.synopis = synopis;
        this.Studio = studio;
        this.Author = author;
        this.animeImage = animeImage;
        this.rate = rate;
    }

    public int getRate() {
        return rate;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }


    public String getSynopis() {
        return synopis;
    }

    public String getAnimeImage() {
        return animeImage;
    }

    public String getStudio() {
        return Studio;
    }

    public String getAuthor() {
        return Author;
    }

}
