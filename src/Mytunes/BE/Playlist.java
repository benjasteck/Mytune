package Mytunes.BE;

import java.util.ArrayList;
import java.util.List;

public class Playlist {
    private int id;
    private String name;
    private ArrayList<Song> songList;

    public Playlist(int id, String name) {
        this.id = id;
        this.name = name;
        this.songList = new ArrayList<Song>();
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

    public Song findSong(int id) {
        for (Song checkedSong : songList) {
            if (checkedSong.getId() == id)
                return checkedSong;
        }
        return null;
    }

    public boolean addSong(Song songToAdd) {
        if (findSong(songToAdd.getId()) == null) {
            songList.add(songToAdd);
            return true;
        } else {
        }
        return false;
    }

    public void removeSong(Song s) {
        this.songList.remove(s);
    }

    public Integer getNumberOfSongs() {
        return songList.size();
    }

    public String getTotalTime() {
        int time = 0;
        for (Song s : songList) {
            time = time + s.getDuration();
        }
        return String.format((time / 60) + ":" + (time % 60));
    }

    @Override
    public String toString(){
        return String.format("Name of the playlist: " + getName() + "list of songs: " + getSongList());
    }
}
