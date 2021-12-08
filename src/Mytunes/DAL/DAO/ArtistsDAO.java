package Mytunes.DAL.DAO;

import Mytunes.DAL.database.DbConnector;

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

    public int getArtistById(int artistId) throws SQLException {
        //todo get the artist that matches the id and return the artist
    return 1;
    }

    }