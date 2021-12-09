package Mytunes.dal.DAO;

import Mytunes.dal.database.DbConnector;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import Mytunes.BLL.ArtistBLL;

public class ArtistsDAO {
    DbConnector databaseConnector;

    public ArtistsDAO() {
        databaseConnector = new DbConnector();
    }

    public List<ArtistBLL> getallartist() throws SQLException{
        ArrayList<ArtistBLL> allartists = new ArrayList<>();
        try (Connection connection = databaseConnector.getConnection()) {

            String sql = "SELECT * FROM Artists;";
            Statement statement = connection.createStatement();
            if(statement.execute(sql))
            {
                ResultSet resultSet = statement.getResultSet();
                while (resultSet.next())
                {
                    int id = resultSet.getInt("id");
                    int artistid = resultSet.getInt("artistid");
                    String name = resultSet.getString("name");

                    ArtistBLL artist = new ArtistBLL(id, artistid, name);
                    allartists.add(artist);

                }
            }
        }
        return allartists;

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