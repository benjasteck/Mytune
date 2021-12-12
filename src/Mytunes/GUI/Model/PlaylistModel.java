package Mytunes.GUI.Model;

import Mytunes.BE.Category;
import Mytunes.BE.Playlist;
import Mytunes.BE.Song;
import Mytunes.BLL.BLLManager;
import Mytunes.BLL.IBLLManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class PlaylistModel {
    private static PlaylistModel single_instance = null;

    // Static method
    // Static method to create instance of Singleton class
    public static PlaylistModel getInstance()
    {
        if (single_instance == null)
            single_instance = new PlaylistModel();

        return single_instance;
    }

    private IBLLManager bllManager;
    public ObservableList<Playlist> playlistObservableList;

    public PlaylistModel() {
        bllManager = new BLLManager();
        playlistObservableList = FXCollections.observableArrayList();
        playlistObservableList.addAll(bllManager.getAllPlaylists());
    }

    public ObservableList<Playlist> getAllPlaylists() {
        return playlistObservableList;
    }

    public void createPlaylist(String name) {
        Playlist addedPlaylist = bllManager.createPlaylist(name);
        playlistObservableList.add(addedPlaylist);
    }
}
