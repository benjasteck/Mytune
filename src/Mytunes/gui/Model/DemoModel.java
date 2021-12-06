package Mytunes.gui.Model;

import Mytunes.BE.Song;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class DemoModel {

    public ObservableList<Song> songObservableList;

    public ObservableList<Song> GetSongObservableList() {
        songObservableList = FXCollections.observableArrayList();
        songObservableList.add(new Song("Wilder and Mind", "Mumford&Sons", "Rock", 5, 41));
        songObservableList.add(new Song("Awake My Soul", "Mumford&Sons", "Rock",4,30));
        songObservableList.add(new Song("The Cave", "Mumford&Sons", "Rock",3,12));
        songObservableList.add(new Song("Little Lion Man", "Mumford&Sons", "Rock",5,45));
        return songObservableList;
    }
}
