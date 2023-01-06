package pt.estig.twdm.pdm.youranimeresume.Data;

public class Anime {
    private String name;
    private int totalepisodes;
    private int currentwatchedepisode;
    //image

    public Anime(String name, int totalepisodes, int currentwatchedepisode) {
        this.name = name;
        this.totalepisodes = totalepisodes;
        this.currentwatchedepisode = currentwatchedepisode;
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
}
