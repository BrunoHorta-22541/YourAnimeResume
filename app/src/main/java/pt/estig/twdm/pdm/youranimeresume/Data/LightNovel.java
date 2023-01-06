package pt.estig.twdm.pdm.youranimeresume.Data;

public class LightNovel {
    private String name;
    private int totalchapters;
    private int currentreadchapter;
    private String publisher;
    private String Author;

    public LightNovel(String name, int totalchapters, int currentreadchapter, String publisher, String author) {
        this.name = name;
        this.totalchapters = totalchapters;
        this.currentreadchapter = currentreadchapter;
        this.publisher = publisher;
        this.Author = author;
    }

    public String getName() {
        return name;
    }

    public int getTotalchapters() {
        return totalchapters;
    }

    public int getCurrentreadchapter() {
        return currentreadchapter;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getAuthor() {
        return Author;
    }
}
