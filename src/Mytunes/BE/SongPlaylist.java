package Mytunes.be;

import Mytunes.DAL.DAO.SongDAO;

import java.sql.SQLException;

public class SongPlaylist {
    int songid;
    int listid;
    SongDAO songDAO = new SongDAO();

    public int getSongId() {
        return songid;
    }


    public int getPlayListId() {
        return listid;
    }


    public int getid() {
        return id;
    }


    int id;

    public SongPlaylist(int songId, int playListId, int id) {
        this.id = id;
        this.listid = playListId;
        this.songid = songId;
    }

    public String toString() {
        String toString = null;
        try {
            toString = songDAO.getSongById(songid).toString();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return toString;
    }


}
