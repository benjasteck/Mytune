package Mytunes.BE;



public class Song {
    String title;
    String artist;
    String category;

    private static int minute;
    private static int second;

    public Song(String title, String artist){
        this.minute = (int)((System.currentTimeMillis() / 1000) /60 ) % 60;
        this.second =(int)(System.currentTimeMillis() /1000) % 60;
        this.artist = artist;
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void TimeToString(){
        String.format(this.minute +":"+ this.second);
    }
}
