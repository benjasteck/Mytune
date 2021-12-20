package Mytunes.DAL;

import Mytunes.BE.Category;
import Mytunes.BE.Playlist;
import Mytunes.be.Song;

import java.util.List;

public interface IDALManager {
    public List<Song> getAllSongs();

    public Song createSong(String name, String artist, Category category, int time, String path);

    public List<Playlist> getAllPlaylists();

    public Playlist createPlaylist(String name);

    public List<Song> getSongsFromPlaylist(Playlist playlist);
}
