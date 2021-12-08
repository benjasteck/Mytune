package Mytunes.GUI.Model;

import Mytunes.BE.Category;
import Mytunes.BE.Song;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class DemoModel {

    public ObservableList<Song> songObservableList;

    public ObservableList<Song> getSongObservableList() {
        songObservableList = FXCollections.observableArrayList();
        songObservableList.add(new Song("Wilder and Mind", "Mumford&Sons", new Category("Rock"), 5, 30));
        songObservableList.add(new Song("Awake My Soul", "Mumford&Sons", new Category("Rock"),4, 30));
        songObservableList.add(new Song("The Cave", "Mumford&Sons", new Category("Rock"),3, 30));
        songObservableList.add(new Song("Little Lion Man", "Mumford&Sons", new Category("Rock"),5, 30));
        songObservableList.add(new Song("Bobobo", "Mumford&Sons", new Category("Rock"),337));
        return songObservableList;
        // this TEST method makes demo observable list for Controller
    }
}
