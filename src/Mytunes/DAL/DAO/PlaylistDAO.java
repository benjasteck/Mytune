package Mytunes.DAL.DAO;

import Mytunes.BLL.PlayListBLL;
import Mytunes.DAL.database.DbConnector;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PlaylistDAO {
    DbConnector databaseConnector;

    public PlaylistDAO() {
        databaseConnector = new DbConnector();
    }


    public int createPlayList(String name) throws SQLException {
       //todo return name and id of a playlist
        return 1;
    }

    public void deletePlaylist(String name) throws SQLException{
    //todo delete a playlist by name.
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
