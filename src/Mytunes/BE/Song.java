package Mytunes.BE;



public class Song {
    String title;
    String artist;
    String category;
    //String filePath;

    private static int minute;
    private static int second;

    public Song(String title, String artist, String category){
        //this.minute = (int)((System.currentTimeMillis() / 1000) /60 ) % 60;
        //this.second =(int)(System.currentTimeMillis() /1000) % 60;
        this.artist = artist;
        this.title = title;
        this.category = category;
    }


    public void TimeToString(){
        String.format(this.minute +":"+ this.second);
    }
}
