package Mytunes.BLL;

import Mytunes.dal.Interfaces.IPlaylist;

import java.sql.SQLException;
import java.util.List;

public class PlayListBLL implements IPlaylist {
    @Override
    public PlayListBLL createPlayList(String name) throws SQLException {
        return null;
    }

    @Override
    public void deletePlayList(String name) throws SQLException {

    }

    @Override
    public List<PlayListBLL> getAllPlayLists() throws SQLException {
        return null;
    }
}
