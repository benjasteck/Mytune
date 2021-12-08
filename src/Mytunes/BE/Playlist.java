package Mytunes.BE;
import java.util.ArrayList;

import java.util.List;

public class Playlist {
    private String name;
    private ArrayList<Song> songList = new ArrayList<>();

    public void addSong(Song m){
        this.songList.add(m);
    }
    public void removeSong(Song s){
        this.songList.remove(s);
    }

    public void setName(String name) {
        this.name = name;
    }
    public int getSongs()
    {
        return songList.size();
    }
}
