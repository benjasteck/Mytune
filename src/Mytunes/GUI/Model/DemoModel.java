package Mytunes.GUI.Model;

import Mytunes.BE.Category;
import Mytunes.BE.Song;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class DemoModel {

    public ObservableList<Song> songObservableList;

    public ObservableList<Song> getSongObservableList() {
        songObservableList = FXCollections.observableArrayList();
        songObservableList.add(new Song("Wilder and Mind", "Mumford&Sons", new Category("Rock"), 339));
        songObservableList.add(new Song("Awake My Soul", "Mumford&Sons", new Category("Rock"),254));
        songObservableList.add(new Song("The Cave", "Mumford&Sons", new Category("Rock"),276));
        songObservableList.add(new Song("Little Lion Man", "Mumford&Sons", new Category("Rock"),218));
        songObservableList.add(new Song("Bobobo opening", "GOD", new Category("Rock"),59));
        return songObservableList;
        // this TEST method makes demo observable list for Controller
    }
}
