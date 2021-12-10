package Mytunes.DAL.DAO;

import Mytunes.BLL.ArtistBLL;
import Mytunes.DAL.database.DbConnector;

import java.sql.*;

public class ArtistsDAO {
    DbConnector databaseConnector;

    public ArtistsDAO() {
        databaseConnector = new DbConnector();
    }

    public int createArtist(String name) throws SQLException {
        //todo when artist is searched for or submitted, it should return the id of that artist. if this one does not exist it should create an id and return it.
        int artistid = 0;
        String sql = "SELECT * FROM artists WHERE Name = ?";
        try (Connection connection = databaseConnector.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, name);
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getResultSet();
            while (resultSet.next()) {
                artistid = resultSet.getInt("artistId");
                return artistid;
            }
            String sql1 = "INSERT INTO artists VALUES (?)";
            PreparedStatement preparedStatement1 = connection.prepareStatement(sql1, Statement.RETURN_GENERATED_KEYS);
            preparedStatement1.setString(1,name);
            preparedStatement1.executeUpdate();
            ResultSet resultSet1 = preparedStatement1.getGeneratedKeys();
            while (resultSet1.next()) {
                artistid = resultSet.getInt(1);
            }

        }
        return artistid;
    }

    public void deleteArtist(int id) throws SQLException {
    //todo making it able to delete from artist cloumn.
        String sql = "DELETE FROM artists WHERE Id = ?";
        try (Connection connection = databaseConnector.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        }
    }


    public void updateArtist(int id, String name) throws SQLException {
    //todo abiltity to update the artist
        String sql = "UPDATE TABLE SET Name=? WHERE Id = ?";
        try (Connection connection = databaseConnector.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();

        }
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