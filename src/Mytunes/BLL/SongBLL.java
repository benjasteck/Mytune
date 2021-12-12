package Mytunes.BLL;

import Mytunes.BE.Category;
import Mytunes.BE.Song;
import Mytunes.DAL.DAO.SongDAO;

import java.util.ArrayList;
import java.util.List;

public class SongBLL  {

    SongDAO songdatabase;
    public List<Song> songListTest; // just test list of all Songs

    public void createSong (Song song){
        //return songdatabase.createSong(song);
        songListTest.add(song);
    } // this method should create a new song
  // TODO need to alter this

    public SongBLL (){
        songListTest = new ArrayList<>();
        SetUpTestSongs();

    } // temporarily like this

    public SongBLL(int id, String artist, String title, String time, String filepath, String category) {
    }


    public void deleteSongByName(String name){
        songListTest.removeIf(song -> song.getTitle().equals(name));
    } // this method remove the song by name

    /*public Song deleteSong(String name){
        return null;
    }*/ // Is this good method?

    private void SetUpTestSongs (){
        songListTest.add(new Song("Wilder and Mind", "Mumford&Sons", new Category("Rock"), 222));
        songListTest.add(new Song("Awake My Soul", "Mumford&Sons", new Category("Rock"),311));
        songListTest.add(new Song("The Cave", "Mumford&Sons", new Category("Rock"),237));
        songListTest.add(new Song("Little Lion Man", "Mumford&Sons", new Category("Rock"),430));
    } // This is just test database - later this will be deleted

    public List<Song> getAllSongs() {
        //return songdatabase.getAllSongs();
        return songListTest; // temporarily like this
        // TODO This does not work - problems with the method in SongDAO
    }

    public void printNumberOfSongs(){
        System.out.println(songListTest.size());
        for (Song song:songListTest) {
            System.out.println(song);
        }
        System.out.println();
    }
}
