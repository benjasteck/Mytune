package Mytunes.DAL.DAO;

import Mytunes.BLL.old.PlayListBLL;
import Mytunes.DAL.database.DbConnector;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PlaylistDAO {
    DbConnector databaseConnector;

    public PlaylistDAO() {
        databaseConnector = new DbConnector();
    }


    public PlayListBLL createPlayList(String name) throws SQLException {
        //todo return name and id of a playlist
        PlayListBLL playlist = null;
        String sql = "INSERT INTO playlists VALUES (?) ";
        try (Connection connection = databaseConnector.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, name);
            preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                playlist = new PlayListBLL(id, name);
            }
        }
        return playlist;
    }

    public void deletePlaylist(String name) throws SQLException {
        //todo delete a playlist by name.
        String sql = "DELETE FROM playlists WHERE name =?";
        try (Connection connection = databaseConnector.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, name);
            preparedStatement.executeUpdate();
        }
    }

    public List<PlayListBLL> getAllPlaylists() throws SQLException {

        ArrayList<PlayListBLL> allPlaylists = new ArrayList<>();
        try (Connection connection = databaseConnector.getConnection()) {

            String sql = "SELECT * FROM Playlist;";
            Statement statement = connection.createStatement();
            if (statement.execute(sql)) {
                ResultSet resultSet = statement.getResultSet();
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("name");

                    PlayListBLL playList = new PlayListBLL(id, name);
                    allPlaylists.add(playList);

                }
            }
        }
        return allPlaylists;
    }

    public Mytunes.BE.Playlist getPlaylist(int id) throws SQLException {
        Mytunes.BE.Playlist playList = null;
        String sql = "SELECT *  FROM playlists WHERE Id=?";
        try (Connection connection = databaseConnector.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getResultSet();
            if (resultSet.next()) {
                String name = resultSet.getString("Name");
                int songs = resultSet.getInt(3);
                String time = resultSet.getString(4);
                playList = new Mytunes.BE.Playlist(id, name, songs, time);
            }
        }
        return playList;
    }
}
