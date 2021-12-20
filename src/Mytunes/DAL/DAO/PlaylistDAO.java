package Mytunes.DAL.DAO;

import Mytunes.BE.Playlist;
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


    public int createPlaylist(Playlist playlist) throws SQLException{
        String name = playlist.getName();
        try(Connection connection = databaseConnector.getConnection()){
            String sql = "INSERT INTO Playlists(NAME) OUTPUT inserted.ID VALUES (?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, name);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            return resultSet.getInt("ID");
        } catch (SQLException exception){
            throw new SQLException(exception);}
    }

    public void deletePlaylist(String name) throws SQLException {
        String sql = "DELETE FROM playlists WHERE name =?";
        try (Connection connection = databaseConnector.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, name);
            preparedStatement.executeUpdate();
        }
    }

    public List<Playlist> getAllPlaylists() throws SQLException {
        ArrayList<Playlist> allPlaylists = new ArrayList<>();
        try (Connection connection = databaseConnector.getConnection()) {
            String sql = "SELECT * FROM Playlist;";
            Statement statement = connection.createStatement();
            if (statement.execute(sql)) {
                ResultSet resultSet = statement.getResultSet();
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("name");

                    Playlist playList = new Playlist(id, name);
                    allPlaylists.add(playList);

                }
            }
        }
        return allPlaylists;
    }

    public Playlist getPlaylist(int id) throws SQLException {
        String sql = "SELECT *  FROM playlists WHERE Id=?";
        Playlist playlist = null;
        try (Connection connection = databaseConnector.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getResultSet();
            if (resultSet.next()) {
                String name = resultSet.getString("Name");
                int songs = resultSet.getInt(3);
                String time = resultSet.getString(4);
                playlist = new Playlist(id, name, songs, time);
            }
        }
        return playlist;
    }

    public void updatePlaylist(Playlist playlist) throws SQLException {
        int id = playlist.getId();
        String name = playlist.getName();
        String sql = "UPDATE playlist SET name=? WHERE id = ?";
        try (Connection connection = databaseConnector.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();

        }
    }
}
