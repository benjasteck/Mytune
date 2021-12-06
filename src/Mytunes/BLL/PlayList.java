package Mytunes.BLL;

import Mytunes.dal.Interfaces.IPlaylist;

import java.sql.SQLException;
import java.util.List;

public class PlayList implements IPlaylist {
    @Override
    public PlayList createPlayList(String name) throws SQLException {
        return null;
    }

    @Override
    public void deletePlayList(String name) throws SQLException {

    }

    @Override
    public List<PlayList> getAllPlayLists() throws SQLException {
        return null;
    }
}
