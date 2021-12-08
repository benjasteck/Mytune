package Mytunes.BE;



public class Song {
    private String title;
    private String artist;
    private String category;
    //private String filePath;
    private Integer time;
    private Integer minute;
    private Integer second;

    public Song(String title, String artist, String category, Integer time){
        this.time = time;
        this.artist = artist;
        this.title = title;
        this.category = category;

        //this.minute = (int)((System.currentTimeMillis() / 1000) /60 ) % 60;
        //this.second =(int)(System.currentTimeMillis() /1000) % 60;
    }

    public Integer getTime() { return time; }

    public void setTime(Integer time) { this.time = time; }

    //public void TimeToString(){ String.format(getMinute()+":"+ getSecond()); }

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

    @Override
    public String toString() {
        return "Song{" + "title='" + title + '\'' + ", artist='" + artist + '\'' + '}';
    }
}
