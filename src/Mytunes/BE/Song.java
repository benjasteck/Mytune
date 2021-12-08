package Mytunes.BE;



public class Song {
    private String title;
    private String artist;
    private Category category;
    //private String filePath;

    private Integer seconds;

    public Song(String title, String artist, Category category, Integer minute, Integer seconds){
        this.seconds =(minute * 60) + seconds;
        this.artist = artist;
        this.title = title;
        this.category = category;
    }

    public Song(String title, String artist, Category category, Integer duration){
        this.seconds = duration;
        this.artist = artist;
        this.title = title;
        this.category = category;
    }

    public int getMinute() {

        return this.seconds / 60;
    }


    public int getSecond() {
        return this.seconds % 60;
    }
    public int getDuration(){
        return this.seconds;
    }

    public void setDuration(int second) {
        this.seconds = second;
    }

    public String getTimeToString(){
        return String.format(getMinute()+":"+ getSecond());
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Song{" + "title='" + title + '\'' + ", artist='" + artist + '\'' + '}';
    }
}
