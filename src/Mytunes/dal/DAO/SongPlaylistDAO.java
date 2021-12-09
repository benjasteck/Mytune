package Mytunes.dal.DAO;

import Mytunes.BLL.SongBLL;
import Mytunes.BLL.ArtistBLL;
import Mytunes.dal.database.DbConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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

    public List<SongBLL> getAllSongsForGivenPlayList(int playListID, ArtistsDAO artistsDAO, CategoriesDAO categoriesDAO) throws SQLException {
            //todo get all song in a playlist defined by its id and return all song.
        List<SongBLL> allSongsFromSamePlayList = new ArrayList<>();
        String sql = "SELECT FROM Song_Playlist WHERE listid=?";
        try (Connection connection = databaseConnector.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, playListID);
            ResultSet resultSet = preparedStatement.getResultSet();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String artist = resultSet.getString("artist");
                String title = resultSet.getString("title");
                String time = resultSet.getString("time");
                String filepath = resultSet.getString("filepath");
                String category = resultSet.getString("category");

                SongBLL song = new SongBLL(id, title, artist, category, time, filepath);
                allSongsFromSamePlayList.add(song);

            }
        }
            return allSongsFromSamePlayList;
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
