package Mytunes.BLL;

import Mytunes.BE.Category;
import Mytunes.BE.Playlist;
import Mytunes.BE.Song;
import Mytunes.DAL.DAO.PlaylistDAO;
import Mytunes.DAL.Interfaces.IPlaylist;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PlayListBLL {
    List<Playlist> playlistListDemo; // this is test list for playlists
    PlaylistDAO database;



    public PlayListBLL(int id, String name) {
    }

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
    } // temporarily like this

    private void SetUpTestPlaylist (){
       /* Playlist playlist1;
        playlistListDemo.add(playlist1 = new Playlist("testPlaylist1"));
        playlist1.addSong(new Song("testing", "no idea", new Category("rap"), 511));
        Playlist playlist2;
        playlistListDemo.add(playlist2 =new Playlist("testPlaylist2"));
        playlist1.addSong(new Song("testing", "no idea", new Category("rap"), 511));
        playlist2.addSong(new Song("testing", "no idea", new Category("rap"), 511));
        Playlist playlist3;
        playlistListDemo.add(playlist3 = new Playlist("testPlaylist3"));
        playlist3.addSong(new Song("testing", "no idea", new Category("rap"), 511));
        playlist3.addSong(new Song("testing", "no idea", new Category("rap"), 511));*/
    } // TODO this does not work at all

}
