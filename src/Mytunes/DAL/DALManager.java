package Mytunes.DAL;

import Mytunes.BE.Category;
import Mytunes.BE.Playlist;
import Mytunes.BE.Song;
import Mytunes.DAL.DAO.PlaylistDAO;
import Mytunes.DAL.DAO.SongDAO;
import Mytunes.DAL.database.DbConnector;
import Mytunes.DAL.fakeDAO.Fake_PlaylistDAO;
import Mytunes.DAL.fakeDAO.Fake_SongDAO;

import java.util.List;

public class DALManager implements IDALManager {

    private DbConnector connector;
    private SongDAO songDAO;
    private PlaylistDAO playlistDAO;

    private Fake_SongDAO fakeSongDAO;
    private Fake_PlaylistDAO fakePlaylistDAO;

    public DALManager() {
        this.fakeSongDAO = new Fake_SongDAO();
        this.fakePlaylistDAO = new Fake_PlaylistDAO();

      /*  try {
           // this.connector = new DbConnector();
           // this.playlistDAO = new PlaylistDAO(connector.getConnection());
           // this.songDAO = new SongDAO(connector.getConnection());
        } catch (SQLServerException e) {
            e.printStackTrace();
        } */
    }

    @Override
    public List<Song> getAllSongs() {
        //return songDAO.getAllSongs();
        return fakeSongDAO.getAllSongs();
    }

    @Override
    public Song createSong(String name, String artist, Category category, int time, String path) {
       // return songDAO.createSong(name,artist,category,time);
        return fakeSongDAO.createSong(name,  artist,  category,  time, path);
    }

    @Override
    public List<Playlist> getAllPlaylists() {
        return fakePlaylistDAO.getAllPlaylists();
    }

    @Override
    public Playlist createPlaylist(String name) {
        return fakePlaylistDAO.createPlaylist(name);
    }
}
