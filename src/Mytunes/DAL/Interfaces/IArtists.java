package Mytunes.DAL.Interfaces;

import Mytunes.BLL.ArtistBLL;

import java.sql.SQLException;

public interface IArtists {
    int createArtist(String name) throws SQLException;

    void deleteArtist(int id) throws SQLException;

    void updateArtist(int id, String name) throws SQLException;

    ArtistBLL getArtistById(int artistId) throws SQLException;
}
