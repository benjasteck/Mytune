package Mytunes.DAL.DAO;

import Mytunes.BLL.ArtistBLL;
import Mytunes.DAL.database.DbConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ArtistsDAO {
    DbConnector databaseConnector;

    public ArtistsDAO() {
        databaseConnector = new DbConnector();
    }

    public int createArtist(String name) throws SQLException {
        //todo when artist is searched for or submitted, it should return the id of that artist. if this one does not exist it should create an id and return it.
        return 1;
    }

    public void deleteArtist(int id) throws SQLException {
    //todo making it able to delete from artist cloumn.
    }


    public void updateArtist(int id, String name) throws SQLException {
    //todo abiltity to update the artist
    }

    public ArtistBLL getArtistById(int artistId) throws SQLException {
        //todo get the artist that matches the id and return the artist
        String sql = "SELECT FROM artist WHERE Id=?";
        ArtistBLL artist = null;
        try (Connection connection = databaseConnector.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, artistId);
            ResultSet resultSet = preparedStatement.getResultSet();
            while (resultSet.next()) {
                int id = resultSet.getInt("Id");
                String name = resultSet.getString("name");
                artist = new ArtistBLL(id, name);
            }

        }

        return artist;
    }

    }