package Mytunes.BE;

import java.util.ArrayList;
import java.util.List;

public class Playlist {
    String name;
    List<Song> songList;

    public Playlist (String name, List<Song> songList){
        this.name = name;
        this.songList = songList;
        //return Playlist(name);
    }
    public Playlist (String name) {
        this.name = name;
    }

    public List<Song> getSongList() {
        return songList;
    }

    public void setSongList(List<Song> songList) {
        this.songList = songList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }  public void addSong(Song m){
        this.songList.add(m);
    }
    public void removeSong(Song s){
        this.songList.remove(s);
    }
    public int getNumberOfSongs()
    {
        return songList.size();
    }
}
