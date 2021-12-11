package Mytunes.BE;

import Mytunes.BE.Song;

import java.util.List;

public class Playlist {
    private String name;
    private List<Mytunes.BE.Song> songList;

    public Playlist (String name, List<Mytunes.BE.Song> songList){
        this.name = name;
        this.songList = songList;
    }
    public Playlist (String name) {
        this.name = name;
    }

    public List<Mytunes.BE.Song> getSongList() {
        return songList;
    }

    public void setSongList(List<Mytunes.BE.Song> songList) {
        this.songList = songList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void addSong(Song m){
        this.songList.add(m);
    }
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
