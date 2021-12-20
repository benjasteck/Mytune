package Mytunes.BLL;

import Mytunes.BE.Playlist;
import Mytunes.BE.Song;
import Mytunes.DAL.DALManager;

import java.sql.SQLException;
import java.util.List;

public class BLLManager implements  IBLLManager{

    private DALManager dalManager;

    public BLLManager() {
        this.dalManager = new DALManager();
    }

    @Override
    public List<Song> getAllSongs() throws SQLException {
       return dalManager.getAllSongs();
    }

    @Override
    public Song createSong(Song song) throws SQLException {
        return dalManager.createSong(song);
    }

    @Override
    public List<Playlist> getAllPlaylists() {
        return dalManager.getAllPlaylists();
    }

    @Override
    public Playlist createPlaylist(String name) {
        return dalManager.createPlaylist(name);
    }


    public void deleteSong(Song song){
        dalManager.deleteSong(song);
    }

    public void deletePlaylist(Playlist playlist){
        dalManager.deletePlaylist(playlist);
    }

    public List<Song> getSongsFromPlaylist(Playlist playlist){ return dalManager.getSongsFromPlaylist(playlist);}

}
