package Mytunes.BLL;

import Mytunes.BE.Category;
import Mytunes.BE.Playlist;
import Mytunes.BE.Song;
import Mytunes.DAL.DALManager;
import Mytunes.DAL.IDALManager;

import java.util.List;

public class BLLManager implements  IBLLManager{

    private IDALManager dalManager;

    public BLLManager() {
        this.dalManager = new DALManager();
    }

    @Override
    public List<Song> getAllSongs() {
       return dalManager.getAllSongs();
    }

    @Override
    public Song createSong(String name, String artist, Category category, int time, String path) {
        return dalManager.createSong(name,  artist,  category, time, path);
    }

    @Override
    public List<Playlist> getAllPlaylists() {
        return dalManager.getAllPlaylists();
    }

    @Override
    public Playlist createPlaylist(String name) {
        return dalManager.createPlaylist(name);
    }

}
