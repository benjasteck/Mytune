package Mytunes.BE;

import java.util.ArrayList;
import java.util.List;

public class Playlist {
    private String name;
    private ArrayList<Song> songList;

    public Playlist (String name, ArrayList<Song> songList){
        this.name = name;
        this.songList = new ArrayList<Song>();
    }
    public Playlist (String name) {
        this.name = name;
    }

    public List<Song> getSongList() {
        return songList;
    }

    //public void setSongList( List<Song> songList) {this.songList = songList;}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Song findSong(String title){
        for (Song checkedSong : songList)
        {
            if (checkedSong.getTitle().equals(title));
            return checkedSong;
        }
        return null;
    }

    public boolean addSong(Song songToAdd){
        if(findSong(songToAdd.getTitle()) == null){
            songList.add(songToAdd);
            System.out.println("the song with the title" + songToAdd.getTitle() + "was added to the playlist");
            return true;
        }
        else{
            System.out.println("the song with the title" + songToAdd.getTitle() + "WAS NOT added to the playlist");
        }
        return false;
    }

    /*public void addSong(Song m){

        this.songList.add(m);
    }*/
    public void removeSong(Song s){
        this.songList.remove(s);
    }
    public Integer getNumberOfSongs()
    {
        return songList.size();
    }
    public String getTotalTime(){
        int time = 0;
        for (Song s : songList){
            time = time + s.getDuration();
        }
        return String.format((time / 60) + ":" + (time % 60));
    }
}
