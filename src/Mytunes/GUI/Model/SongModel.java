package Mytunes.GUI.Model;

import Mytunes.BE.Category;
import Mytunes.BE.Song;
import Mytunes.BLL.BLLManager;
import Mytunes.BLL.IBLLManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class SongModel {
    private static SongModel single_instance = null;

    // Static method
    // Static method to create instance of Singleton class
    public static SongModel getInstance()
    {
        if (single_instance == null)
            single_instance = new SongModel();

        return single_instance;
    }

    private BLLManager bllManager;
    public ObservableList<Song> songObservableList;

    public SongModel() {
        bllManager = new BLLManager();
        songObservableList = FXCollections.observableArrayList();
        songObservableList.addAll(bllManager.getAllSongs());
    }

    public ObservableList<Song> getAllSongs() {
        return songObservableList;
    }

    public void createSong(String name, String artist, Category category, int time, String path) {
        Song addedSong = bllManager.createSong(name,  artist,  category,  time, path);
        songObservableList.add(addedSong);
    }

    public void deleteSong(Song song){
        bllManager.deleteSong(song);
        songObservableList.remove(song);
    }
}
