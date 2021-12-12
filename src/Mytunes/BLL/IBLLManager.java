package Mytunes.BLL;

import Mytunes.BE.Category;
import Mytunes.BE.Playlist;
import Mytunes.BE.Song;

import java.util.List;

public interface IBLLManager {
    public List<Song> getAllSongs();

    public Song createSong(String name, String artist, Category category, int time, String path);

    public List<Playlist>  getAllPlaylists();

    public Playlist createPlaylist(String name);
}