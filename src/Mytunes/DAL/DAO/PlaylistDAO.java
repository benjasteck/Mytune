package Mytunes.DAL.DAO;

import Mytunes.BLL.PlayListBLL;
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

    public void deletePlaylist(String name) throws SQLException{
    //todo delete a playlist by name.
        String sql = "DELETE FROM playlists WHERE name =?";
        try (Connection connection = databaseConnector.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, name);
            preparedStatement.executeUpdate();
        }
    }

    public List<PlayListBLL> getAllPlaylists() throws SQLException{

        ArrayList<PlayListBLL> allPlaylists = new ArrayList<>();
        try (Connection connection = databaseConnector.getConnection()) {

            String sql = "SELECT * FROM Playlist;";
            Statement statement = connection.createStatement();
            if(statement.execute(sql))
            {
                ResultSet resultSet = statement.getResultSet();
                while (resultSet.next())
                {
                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("name");

                    Mytunes.BLL.PlayListBLL playList = new PlayListBLL(id, name);
                    allPlaylists.add(playList);

                }
            }
        }
        return allPlaylists;
    }
}
