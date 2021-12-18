package Mytunes.DAL.DAO;

import Mytunes.BLL.old.SongBLL;
import Mytunes.DAL.database.DbConnector;

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

    public void addSongToPlayList(int songid, int listid) throws SQLException {
    //todo add a song to the playlist by songId and the playlist id and increase value
        String sql = "INSERT INTO song_playlist VALUES(?,?, ?)";
        try (Connection connection = databaseConnector.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, songid);
            preparedStatement.setInt(2, listid);
            preparedStatement.setInt(3, lastIdInThePlayList(listid) + 1);
            preparedStatement.executeUpdate();
        }
    }

    private int lastIdInThePlayList(int listid) throws SQLException {
            //todo get last value(incrementing id in database) in a playlist and return it
        int id = 0;
        String sql = "SELECT FROM song_playlist where [Playlist id] = ?";
        try (Connection connection = databaseConnector.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, listid);
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getResultSet();
            while (resultSet.next()) {
                id = resultSet.getInt("id");
            }
        }
        return id;
    }

    public void removeSongFromPlayList(int songid, int listid, int id) throws SQLException {
    //todo remove songs from playlist by using song id, playlist id and the value
        String sql = "DELETE FROM song_playlist WHERE [Song id]=? AND [Playlist id]=? AND id= ?"; //will prob have to give value a new name in the db.
        try (Connection connection = databaseConnector.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, songid);
            preparedStatement.setInt(2, listid);
            preparedStatement.setInt(3, id);
            preparedStatement.executeUpdate();
        }
    }

    public List<SongBLL> getAllSongsForGivenPlayList(int listID, ArtistsDAO artistsDAO, CategoriesDAO categoriesDAO) throws SQLException {
        //todo get all song in a playlist defined by its id and return all song.
        List<SongBLL> allSongsFromSamePlayList = new ArrayList<>();
        String sql = "SELECT FROM song_playlist WHERE listid=? ORDERED BY id ASC";
        try (Connection connection = databaseConnector.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, listID);
            ResultSet resultSet = preparedStatement.getResultSet();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int artistid = resultSet.getInt("artistid");
                String artist = artistsDAO.getArtistById(artistid).getName();
                String title = resultSet.getString("title");
                String time = resultSet.getString("time");
                String filepath = resultSet.getString("filepath");
                int categoryid = resultSet.getInt("category");
                //String category = categoriesDAO.getCategoryById(categoryid).getCategoryName();

                //SongBLL song = new SongBLL(id, title, artist, category, time, filepath);
                //allSongsFromSamePlayList.add(song);

            }
        }
        return allSongsFromSamePlayList;
    }

    public void moveSongDown(int listid, int songid) throws SQLException {
            //todo enable the user to move the song down on the plalist list
        boolean possible = false;  //check if there is any song from the same playlist that has a higher rank
        String sql0 = "SELECT FROM song_playlist WHERE listid=? AND value>?ORDERED BY id ASC";
        try (Connection connection = databaseConnector.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql0);
            preparedStatement.setInt(1, listid);
            preparedStatement.setInt(2, songid);
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getResultSet();
            while (resultSet.next() && !possible) {
                possible = resultSet.getInt("id") != 0;
            }
            if (possible) {
                String sql = "UPDATE song_playlist SET id = ? WHERE id=? AND [Playlist id]= ?ORDERED BY id ASC";
                PreparedStatement preparedStatement0 = connection.prepareStatement(sql);
                preparedStatement0.setInt(1, songid + 1);
                preparedStatement0.setInt(2, songid);
                preparedStatement0.setInt(3, listid);
                preparedStatement0.executeUpdate();
                PreparedStatement preparedStatement1 = connection.prepareStatement(sql);
                preparedStatement1.setInt(1, songid);
                preparedStatement1.setInt(2, songid + 1);
                preparedStatement1.setInt(3, listid);
                preparedStatement1.executeUpdate();
            } else
                switchFirstLast(0, lastIdInThePlayList(listid), listid);
        }

    }

    public void moveSongUp(int listid, int songid) throws SQLException {
            //todo thame as before but up
        if (songid == 0) {
            switchFirstLast(0, lastIdInThePlayList(listid), listid);
        } else {
            String sql = "UPDATE song_playlist SET value = ? WHERE id=? AND [PlayList id]= ?";
            try (Connection connection = databaseConnector.getConnection()) {
                PreparedStatement preparedStatement0 = connection.prepareStatement(sql);
                preparedStatement0.setInt(1, songid - 1);
                preparedStatement0.setInt(2, songid);
                preparedStatement0.setInt(3, listid);
                preparedStatement0.executeUpdate();
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setInt(1, songid);
                preparedStatement.setInt(2, songid - 1);
                preparedStatement.setInt(3, listid);
                preparedStatement.executeUpdate();
            }
        }

    }

    private void switchFirstLast(int firstSongId, int lastSongId, int listid) throws SQLException {
        String sql = "UPDATE song_playlist SET value = ? WHERE [PlayList id]= ? AND id=?";
        try (Connection connection = databaseConnector.getConnection()) {
            PreparedStatement preparedStatement0 = connection.prepareStatement(sql);
            preparedStatement0.setInt(1, lastIdInThePlayList(listid));
            preparedStatement0.setInt(2, listid);
            preparedStatement0.setInt(3, 0);
            preparedStatement0.executeUpdate();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, 0);
            preparedStatement.setInt(2, listid);
            preparedStatement.setInt(3, lastIdInThePlayList(listid));
            preparedStatement.executeUpdate();
        }
    }

    public void deleteFromAllPlayLists(int songid) throws SQLException {
    //todo delete a song specified by id from all playlists
        String sql = "DELETE FROM Song_Playlist WHERE [Song id]=?";
        try (Connection connection = databaseConnector.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, songid);
            preparedStatement.executeUpdate();
        }
    }

    List<Integer> getIdSongInPlayList(int songid, int listid) throws SQLException {
            //todo return all values in a given playlist defined by id and connect them to a song id
        List<Integer> allValues = new ArrayList<>();
        String sql = "SELECT FROM song_playlist WHERE songid=? AND [Playlist Id]=?";
        try (Connection connection = databaseConnector.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, songid);
            preparedStatement.setInt(2, listid);
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getResultSet();
            while (resultSet.next()) {
                int ranking = resultSet.getInt(2);
                allValues.add(ranking);
            }
        }
        return allValues;
    }
}
