package Mytunes.be;

public class Song {
    private final int id;
    private String title;
    private String artist;
    private String category;
    private int time;

    public Song(int id,String title, String artist, String category, int time, String filePath){
        this.id = id;
        this.title = title;
        this.artist = artist;
        this.category = category;
        this.time = time;
    }
}
