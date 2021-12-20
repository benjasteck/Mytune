package Mytunes.BE;
import Mytunes.BE.Song;

import java.util.ArrayList;
import java.util.List;

public class Playlist {
    private int id;
    private String name;
    private ArrayList<Song> songList;
    private String time;
    private int songs;

    public Playlist(int id, String name) {
        this.id = id;
        this.name = name;
        this.songList = new ArrayList<Song>();
    }

    public Playlist(int id, String name, int songs, String time) {
    }

    public List<Song> getSongList() {
        return songList;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getsongs(){return songs;}
    public void setsongs(int songs){this.songs = songs;}

    public String gettime(){return time;}

    public Integer getNumberOfSongs() {
        return songList.size();
    }



    //public void setSongList( List<Song> songList) {this.songList = songList;}



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

    public boolean removeSong(Song s) {
        return this.songList.remove(s);
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
    public int getId() {
        return id;
    }
}
