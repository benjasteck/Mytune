package Mytunes.BLL;

import Mytunes.BE.Category;
import Mytunes.BE.Playlist;
import Mytunes.BE.Song;

import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

public interface IBLLManager {
    public List<Song> getAllSongs() throws SQLException;

    Song createSong(Song song) throws SQLException;

    public List<Playlist>  getAllPlaylists();

    public Playlist createPlaylist(String name);

    public void deleteSong(Song song);

    public void deletePlaylist(Playlist playlist);

    public List<Song> getSongsFromPlaylist(Playlist playlist);

}
