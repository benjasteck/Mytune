package Mytunes.DAL.DAO;

import Mytunes.BE.Song;
import Mytunes.BLL.SongBLL;
import Mytunes.DAL.database.DbConnector;

import java.nio.file.Path;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SongDAO<list> {
    DbConnector databaseConnector;

    public SongDAO() {
        databaseConnector = new DbConnector();
    }

    public List<Song> AllSongsList = new ArrayList<Song>(); // this List should contain ALL the songs ever created

    public List<Song> getAllSongs(ArtistsDAO artistsDAO, CategoriesDAO categoriesDAO) throws SQLException {
        //todo go throu all song and return allsongs consisting of id, title, artist, category, time and filepath
        return null;
    }

    public Song createSong(String title, String artist, String category, String filePath, ArtistsDAO artistsDAO, CategoriesDAO categoriesDAO) throws SQLException {
        //todo set all parameters here and and return a sung consisting of id, title, artist, categorym time and filepath
        return null;
    }

    public void deleteSong(int id, SongPlaylistDAO song_playListDAO, ArtistsDAO artistsDAO, CategoriesDAO categoriesDAO) throws SQLException {
    //todo delete the song by id

    }

    public void updateSong(String title, int id, String artist, String category, ArtistsDAO artistsDAO, CategoriesDAO categoriesDAO) throws SQLException {
    //todo set new parameters and execute them.
    }

    public int getSongTime(Path filePath) {
        //todo get the time of the song using filepath and implement it
        return 1;
    }

    private int songArtistId(int id) throws SQLException {
        //todo get songs artist id and return it.
        return 1;
    }

    private int songCategoryId(int id) throws SQLException {
        //todo get song category id and return it
        return 1;
    }

}