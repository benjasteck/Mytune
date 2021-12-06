package Mytunes.dal.Interfaces;

import Mytunes.BLL.PlayList;

import java.sql.SQLException;
import java.util.List;

public interface IPlaylist {
    PlayList createPlayList(String name) throws SQLException;

    void deletePlayList(String name) throws SQLException;

    List<PlayList> getAllPlayLists() throws SQLException;
}
