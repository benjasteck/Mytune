package Mytunes.DAL.fakeDAO;

import Mytunes.BE.Category;
import Mytunes.BE.Song;

import java.util.ArrayList;
import java.util.List;

public class Fake_SongDAO {
    private List<Song> fakeDB = new ArrayList<>();

    public Fake_SongDAO() {
        fakeDB.add(new Song(1,"Wilder and Mind", "Mumford&Sons", Category.Rock, 222, "src/Mytunes/musicDemo/BeatIt.mp3"));
        fakeDB.add(new Song(2,"Awake My Soul", "Mumford&Sons", Category.Rock,311, "src/Mytunes/musicDemo/KILLSHOT.mp3"));
        fakeDB.add(new Song(3,"The Cave", "Mumford&Sons", Category.Rock,237,"src/Mytunes/musicDemo/Radioactive.mp3"));
        fakeDB.add(new Song(4,"Little Lion Man", "Mumford&Sons", Category.Rock,430,"src/Mytunes/musicDemo/Venom.mp3"));
    }


    public List<Song> getAllSongs() {
        return fakeDB;
    }

    public Song createSong(String name, String artist, Category category, int time, String path) {
        Song newSong = new Song(fakeDB.size()+1,name, artist, category,time, path);
        fakeDB.add(newSong);
        return newSong;
    }

    public void deleteSong(Song song){
        fakeDB.remove(song);
    }
}
