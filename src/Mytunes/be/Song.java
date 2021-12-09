package Mytunes.BE;



public class Song {
    private String title;
    private String artist;
    private String category;
    //private String filePath;

    private Integer minute;
    private Integer second;

    public Song(String title, String artist, String category, Integer minute, Integer second, ){
        this.minute = (int)((System.currentTimeMillis() / 1000) /60 ) % 60;
        this.second =(int)(System.currentTimeMillis() /1000) % 60;
        this.artist = artist;
        this.title = title;
        this.category = category;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public int getSecond() {
        return second;
    }

    public void setSecond(int second) {
        this.second = second;
    }

    public void TimeToString(){
        String.format(getMinute()+":"+ getSecond());
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

}
