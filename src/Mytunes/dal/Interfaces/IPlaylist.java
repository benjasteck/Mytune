package Mytunes.dal.Interfaces;

import Mytunes.BLL.PlayListBLL;

import java.sql.SQLException;
import java.util.List;

public interface IPlaylist {
    PlayListBLL createPlayList(String name) throws SQLException;

    void deletePlayList(String name) throws SQLException;

    List<PlayListBLL> getAllPlayLists() throws SQLException;
}