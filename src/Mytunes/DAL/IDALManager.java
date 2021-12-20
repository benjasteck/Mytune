package Mytunes.DAL;

import Mytunes.BE.Category;
import Mytunes.BE.Playlist;
import Mytunes.BE.Song;
import Mytunes.BE.Song;

import java.sql.SQLException;
import java.util.List;

public interface IDALManager {
    public List<Song> getAllSongs() throws SQLException;

    Song createSong(Song song) throws SQLException;

    public List<Playlist> getAllPlaylists();

    public Playlist createPlaylist(String name);

    public List<Song> getSongsFromPlaylist(Playlist playlist);
}
