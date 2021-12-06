package Mytunes.dal.DAO;

import Mytunes.BE.Song;
import Mytunes.dal.database.DbConnector;

import java.sql.SQLException;
import java.util.List;

public class SongPlaylistDAO {
        DbConnector databaseConnector;

        public SongPlaylistDAO() {
            databaseConnector = new DbConnector();
        }
    public void addSongToPlayList(int songId, int playListId) throws SQLException {
    //todo add a song to the playlist by songId and the playlist id and increase value
    }

    private int lastValueInThePlayList(int playListId) throws SQLException {
            //todo get last value(incrementing id in database) in a playlist and return it

    return 1;
    }

    public void removeSongFromPlayList(int songId, int playListId, int value) throws SQLException {
    //todo remove songs from playlist by using song id, playlist id and the value
    }

    public List<Song> getAllSongsForGivenPlayList(int playListID, ArtistsDAO artistsDAO, CategoriesDAO categoriesDAO) throws SQLException {
            //todo get all song in a playlist defined by its id and return all song.

            return null /*allSongsFromSamePlayList*/;
    }

    public void moveSongDown(int playListId, int songRank) throws SQLException {
            //todo enable the user to move the song down on the plalist list

    }

    public void moveSongUp(int playListId, int songRank) throws SQLException {
            //todo thame as before but up

    }

    public void deleteFromAllPlayLists(int songId) throws SQLException {
    //todo delete a song specified by id from all playlists
    }

    List<Integer> getValueSongInPlayList(int songId, int playListId) throws SQLException {
            //todo return all values in a given playlist defined by id and connect them to a song id
    return null /*allvalues*/;
    }
}
