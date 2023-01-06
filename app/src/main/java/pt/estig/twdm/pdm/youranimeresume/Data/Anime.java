package pt.estig.twdm.pdm.youranimeresume.Data;

public class Anime {
    private String name;
    private int totalepisodes;
    private int currentwatchedepisode;
    private String Studio;
    private String Author;
    //image


    public Anime(String name, int totalepisodes, int currentwatchedepisode, String studio, String author) {
        this.name = name;
        this.totalepisodes = totalepisodes;
        this.currentwatchedepisode = currentwatchedepisode;
        Studio = studio;
        Author = author;
    }
    public String getName() {
        return name;
    }

    public int getTotalepisodes() {
        return totalepisodes;
    }

    public int getCurrentwatchedepisode() {
        return currentwatchedepisode;
    }


    public String getStudio() {
        return Studio;
    }

    public String getAuthor() {
        return Author;
    }

}
