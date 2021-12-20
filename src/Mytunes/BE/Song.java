package Mytunes.BE;


import Mytunes.BE.Category;

public class Song {
    public int id;
    private String title;
    private String artist;
    private Category category;
    private String filePath;
    private Integer seconds;

    public Song(int id, String title, String artist, Category category, Integer duration, String filePath){
        this.id = id;
        this.seconds = duration;
        this.artist = artist;
        this.title = title;
        this.category = category;
        this.filePath = filePath;
    }


    public int getMinute() {

        return this.seconds / 60;
    }

    public int getId() {
        return id;
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

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public Integer getSeconds() {
        return seconds;
    }

    public void setSeconds(Integer seconds) {
        this.seconds = seconds;
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

    //@Override
    //public String toString() {
        //return "Song{" + "id='" + id + "title='" + title + '\'' + ", artist='" + artist + '\'' + '}';
    //}

    @Override
    public String toString () {
        return String.format("%s", getTitle());
    }
}
