package Mytunes.GUI.Model;

import Mytunes.BE.Playlist;
import Mytunes.BE.Song;
import Mytunes.BLL.PlayListBLL;
import Mytunes.BLL.SongBLL;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class DemoModel {

    private SongBLL songmanager;
    private PlayListBLL playlistmanager;
    public ObservableList<Song> songObservableList;
    public ObservableList<Playlist> playlistObservableList;


    public DemoModel(){
        songObservableList = FXCollections.observableArrayList();
        playlistObservableList = FXCollections.observableArrayList();
        songmanager = new SongBLL();
        playlistmanager = new PlayListBLL();
        songObservableList.addAll(songmanager.getAllSongs());
        playlistObservableList.addAll(playlistmanager.getAllPlayLists());
    } // this method gets all the songs from SongBLL and add them to observable list for GUI
        // this method also gets all the playlist from PlaylistBLL and add them to observable list for GUI

    public ObservableList<Song> GetAllSongs() {
        return songObservableList;
    }

    public ObservableList<Playlist> getAllPlaylists(){
        return playlistObservableList;
    }

    public void updateListOfSongs(){
        //songObservableList.clear();
        //songObservableList.addAll(songmanager.getAllSongs());
        songObservableList.setAll(songmanager.getAllSongs());
        // one of this should work
        // TODO does not update the tableview or observable list
    }

    public Song createSong(Song songis) {
        return songmanager.createSong(songis);
    }


}