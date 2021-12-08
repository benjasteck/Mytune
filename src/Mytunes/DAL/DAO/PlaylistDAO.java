package Mytunes.DAL.DAO;

import Mytunes.DAL.database.DbConnector;

import java.sql.SQLException;

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

    /*public List<Playlist> getAllPlaylists() throws SQLException{
    //todo return a list of playlists consisting of name and id
    return getAllPlaylists();
    }*/
}
