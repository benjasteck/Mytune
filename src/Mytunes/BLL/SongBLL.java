package Mytunes.BLL;

import Mytunes.dal.DAO.ArtistsDAO;
import Mytunes.dal.DAO.CategoriesDAO;
import Mytunes.dal.DAO.SongPlaylistDAO;
import Mytunes.dal.Interfaces.ISong;
import com.microsoft.sqlserver.jdbc.SQLServerException;

import java.nio.file.Path;
import java.sql.SQLException;
import java.util.List;

public class SongBLL implements ISong {
    @Override
    public List<SongBLL> getAllSongs(ArtistsDAO artistsDAO, CategoriesDAO categoriesDAO) throws SQLServerException, SQLException {
        return null;
    }

    @Override
    public SongBLL createSong(String title, String artist, String category, String filePath, ArtistsDAO artistsDAO, CategoriesDAO categoriesDAO) throws SQLException {
        return null;
    }

    @Override
    public void deleteSong(int id, SongPlaylistDAO song_playListDAO, ArtistsDAO artistsDAO, CategoriesDAO categoriesDAO) throws SQLException {

    }

    @Override
    public void updateSong(String title, int id, String newArtist, String newCategory, ArtistsDAO artistsDAO, CategoriesDAO categoriesDAO) throws SQLException {

    }

    @Override
    public int getSongTime(Path filePath) {
        return 0;
    }
}
