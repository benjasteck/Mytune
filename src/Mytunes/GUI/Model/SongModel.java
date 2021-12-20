package Mytunes.GUI.Model;

import Mytunes.BE.Category;
import Mytunes.BE.Song;
import Mytunes.BLL.BLLManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.sql.SQLException;

public class SongModel {
    private static SongModel single_instance = null;

    // Static method
    // Static method to create instance of Singleton class
    public static SongModel getInstance() throws SQLException {
        if (single_instance == null)
            single_instance = new SongModel();

        return single_instance;
    }

    private BLLManager bllManager;
    public ObservableList<Song> songObservableList;

    public SongModel() throws SQLException {
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

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure you want to delete this song "  + " ?", ButtonType.YES, ButtonType.NO, ButtonType.CANCEL);
        alert.showAndWait();

        if (alert.getResult() == ButtonType.YES) {
            bllManager.deleteSong(song);
            songObservableList.remove(song);
        }

    }
}
