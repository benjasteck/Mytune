package Mytunes.BLL;

import Mytunes.BE.Playlist;
import Mytunes.BE.Song;
import Mytunes.DAL.DAO.PlaylistDAO;
import Mytunes.DAL.Interfaces.IPlaylist;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PlayListBLL {
    List<Playlist> playlistListDemo;
    PlaylistDAO database;

    public PlayListBLL createPlayList(String name)  {
        return null;
    }

    public void deletePlayList(String name) {

    }

    public List<Playlist> getAllPlayLists() {
        return playlistListDemo;
    }

    public void getAllSongsFromPlaylist() {

    }

    public PlayListBLL (){
        playlistListDemo = new ArrayList<>();
        SetUpTestPlaylist();
    }

    private void SetUpTestPlaylist (){
        playlistListDemo.add(new Playlist("testPlaylist"));

    }

}
