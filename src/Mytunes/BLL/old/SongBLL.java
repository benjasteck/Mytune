package Mytunes.BLL.old;

import Mytunes.BE.Song;
import Mytunes.DAL.DAO.SongDAO;
import Mytunes.DAL.fakeDAO.Fake_SongDAO;

import java.util.ArrayList;
import java.util.List;

public class SongBLL  {

    SongDAO songdatabase;
    Fake_SongDAO temporarilySongDatabase;

    public SongBLL(int id, String title, String artist, String category, String time, String filepath) {
    }

    public void createSong (Song song){
        //return songdatabase.createSong(song);
        temporarilySongDatabase.getAllSongs().add(song);
    } // this method should create a new song
  // TODO need to alter this

    public SongBLL (){

    } // temporarily like this




    public void deleteSongByName(String name){
        temporarilySongDatabase.getAllSongs().removeIf(song -> song.getTitle().equals(name));
    } // this method remove the song by name


    public List<Song> getAllSongs() {
        //return songdatabase.getAllSongs();
        return temporarilySongDatabase.getAllSongs(); // temporarily like this
        // TODO This does not work - problems with the method in SongDAO
    }

    public void printNumberOfSongs(){
        System.out.println(temporarilySongDatabase.getAllSongs().size());
        for (Song song:temporarilySongDatabase.getAllSongs()) {
            System.out.println(song);
        }
        System.out.println();
    }
}
