package Mytunes.BE;

import Mytunes.DAL.DAO.SongDAO;

import java.sql.SQLException;

public class SongPlaylist {
    private int songid;
    private int listid;
    private int id;
    SongDAO songDAO = new SongDAO();

    public SongPlaylist(int songId, int playListId, int id) {
        this.id = id;
        this.listid = playListId;
        this.songid = songId;
    }


    public int getSongId() {
        return songid;
    }

    public int getPlayListId() {
        return listid;
    }

    public int getid() {
        return id;
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
