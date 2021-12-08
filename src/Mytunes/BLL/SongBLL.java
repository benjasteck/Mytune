package Mytunes.BLL;

import Mytunes.BE.Category;
import Mytunes.BE.Song;
import Mytunes.DAL.DAO.ArtistsDAO;
import Mytunes.DAL.DAO.CategoriesDAO;
import Mytunes.DAL.DAO.SongDAO;
import Mytunes.DAL.DAO.SongPlaylistDAO;
import Mytunes.DAL.Interfaces.ISong;
import com.microsoft.sqlserver.jdbc.SQLServerException;

import java.nio.file.Path;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SongBLL  {

    SongDAO songdatabase;
    public List<Song> songListTest;

    /*public Song createSong (Song song){
        return songdatabase.createSong(song);
    } // this method should create a new song - it is connected to GUI
*/  // TODO need to alter this

    public void deleteSong(String name){

    }

    public SongBLL (){
        songListTest = new ArrayList<>();
        SetUpTestSongs();
    }

    private void SetUpTestSongs (){
        songListTest.add(new Song("Wilder and Mind", "Mumford&Sons", new Category("Rock"), 5));
        songListTest.add(new Song("Awake My Soul", "Mumford&Sons", new Category("Rock"),4));
        songListTest.add(new Song("The Cave", "Mumford&Sons", new Category("Rock"),3));
        songListTest.add(new Song("Little Lion Man", "Mumford&Sons",new Category("Rock"),5));
    }

    public List<Song> getAllSongs() {
        //return songdatabase.getAllSongs();
        return songListTest;
    }
}
