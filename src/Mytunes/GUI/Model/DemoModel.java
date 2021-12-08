package Mytunes.GUI.Model;

import Mytunes.BE.Playlist;
import Mytunes.BE.Song;
import Mytunes.BLL.SongBLL;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class DemoModel {

    private SongBLL songmanager;
    public ObservableList<Song> songObservableList;
    public ObservableList<Playlist> playlistObservableList;


    public DemoModel(){
        songObservableList = FXCollections.observableArrayList();
        songmanager = new SongBLL();
        songObservableList.addAll(songmanager.getAllSongs());
    } // this method gets all the songs from SongBLL and add them to observable list for GUI

    public ObservableList<Song> GetAllSongs() {
        return songObservableList;
    }

    public ObservableList<Playlist> getAllPlaylists(){
        playlistObservableList = FXCollections.observableArrayList();
        return playlistObservableList;
    }
}
