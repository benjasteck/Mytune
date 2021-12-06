package Mytunes.BE;

import Mytunes.dal.Interfaces.IArtists;

import java.sql.SQLException;

public class Artist implements IArtists {
    @Override
    public int createArtist(String name) throws SQLException {
        return 0;
    }

    @Override
    public void deleteArtist(int id) throws SQLException {

    }

    @Override
    public void updateArtist(int id, String name) throws SQLException {

    }

    @Override
    public Artist getArtistById(int artistId) throws SQLException {
        return null;
    }
}
