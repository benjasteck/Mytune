package Mytunes.BLL;

import Mytunes.DAL.Interfaces.IArtists;

import java.sql.SQLException;

public class ArtistBLL implements IArtists {
    public ArtistBLL(int id, String name) {
    }

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
    public ArtistBLL getArtistById(int artistId) throws SQLException {
        return null;
    }
}
