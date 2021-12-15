package Mytunes.BLL.old;

import Mytunes.BE.Song;
import Mytunes.DAL.DAO.SongDAO;

import java.util.ArrayList;
import java.util.List;

public class SongBLL  {

    SongDAO songdatabase;
    public List<Song> songListTest; // just test list of all Songs

    public SongBLL(int id, String title, String artist, String category, String time, String filepath) {
    }

    public void createSong (Song song){
        //return songdatabase.createSong(song);
        songListTest.add(song);
    } // this method should create a new song
  // TODO need to alter this

    public SongBLL (){
        songListTest = new ArrayList<>();
        SetUpTestSongs();

    } // temporarily like this




    public void deleteSongByName(String name){
        songListTest.removeIf(song -> song.getTitle().equals(name));
    } // this method remove the song by name

    /*public Song deleteSong(String name){
        return null;
    }*/ // Is this good method?

    private void SetUpTestSongs (){

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
