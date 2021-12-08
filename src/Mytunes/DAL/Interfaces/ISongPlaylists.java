package Mytunes.DAL.Interfaces;

import Mytunes.BLL.SongBLL;
import Mytunes.DAL.DAO.ArtistsDAO;
import Mytunes.DAL.DAO.CategoriesDAO;

import java.sql.SQLException;
import java.util.List;

public interface ISongPlaylists {
    void addSongToPlayList(int songId, int playListId) throws SQLException;

    void removeSongFromPlayList(int songId, int playListId, int rank) throws SQLException;

    List<SongBLL> getAllSongsForGivenPlayList(int playListID, ArtistsDAO artistsDAO, CategoriesDAO categoriesDA) throws SQLException;

    void moveSongUp(int playListId, int songRank) throws SQLException;

    void moveSongDown(int playListId, int songRank) throws SQLException;

    void deleteFromAllPlayLists(int songId) throws SQLException;
}
