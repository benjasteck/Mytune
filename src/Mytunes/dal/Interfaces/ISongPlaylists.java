package Mytunes.dal.Interfaces;

import java.sql.SQLException;
import java.util.List;

public interface ISongPlaylists {
    void addSongToPlayList(int songId, int playListId) throws SQLException;

    void removeSongFromPlayList(int songId, int playListId, int rank) throws SQLException;

    List<Song> getAllSongsForGivenPlayList(int playListID, ArtistsDAO artistsDAO, CategoriesDAO categoriesDA) throws SQLException;

    void moveSongUp(int playListId, int songRank) throws SQLException;

    void moveSongDown(int playListId, int songRank) throws SQLException;

    void deleteFromAllPlayLists(int songId) throws SQLException;
}
