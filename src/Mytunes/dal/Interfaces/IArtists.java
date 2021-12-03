package Mytunes.dal.Interfaces;

import java.sql.SQLException;

public interface IArtists {
    int createArtist(String name) throws SQLException;

    void deleteArtist(int id) throws SQLException;

    void updateArtist(int id, String name) throws SQLException;

    Artist getArtistById(int artistId) throws SQLException;
}
