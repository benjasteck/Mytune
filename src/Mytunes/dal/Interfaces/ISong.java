package Mytunes.dal.Interfaces;

import Mytunes.BLL.SongBLL;
import Mytunes.dal.DAO.ArtistsDAO;
import Mytunes.dal.DAO.CategoriesDAO;
import Mytunes.dal.DAO.SongPlaylistDAO;
import com.microsoft.sqlserver.jdbc.SQLServerException;

import java.nio.file.Path;
import java.sql.SQLException;
import java.util.List;

public interface ISong {
    List<SongBLL> getAllSongs(ArtistsDAO artistsDAO, CategoriesDAO categoriesDAO) throws SQLServerException, SQLException;

    SongBLL createSong(String title, String artist, String category, String filePath, ArtistsDAO artistsDAO, CategoriesDAO categoriesDAO) throws SQLException;

    void deleteSong(int id, SongPlaylistDAO song_playListDAO, ArtistsDAO artistsDAO, CategoriesDAO categoriesDAO) throws SQLException;

    void updateSong(String title, int id, String newArtist, String newCategory, ArtistsDAO artistsDAO, CategoriesDAO categoriesDAO) throws SQLException;

    int getSongTime(Path filePath);

}