package Mytunes.DAL.fakeDAO;

import Mytunes.BE.Category;
import Mytunes.BE.Playlist;
import Mytunes.BE.Song;

import java.util.ArrayList;
import java.util.List;

public class Fake_PlaylistDAO {
    private List<Playlist> fakeDB = new ArrayList<>();

    public Fake_PlaylistDAO() {
        Playlist playlist1 = new Playlist(1, "playlist1");
        Playlist playlist2 = new Playlist(2, "testPlaylist2");
        Playlist playlist3 = new Playlist(3, "testPlaylist3");

        playlist1.addSong(new Song(1,"testing1", "no idea", new Category("rap"), 511,""));

        playlist2.addSong(new Song(1,"testing2", "no idea", new Category("rap"), 511,""));
        playlist2.addSong(new Song(2,"testing3", "no idea", new Category("rap"), 511, ""));

        playlist3.addSong(new Song(1,"testing4", "no idea", new Category("rap"), 511, ""));
        playlist3.addSong(new Song(2,"testing5", "no idea", new Category("rap"), 511, ""));
        playlist3.addSong(new Song(3,"testing6", "no idea", new Category("rap"), 511, ""));

        fakeDB.add(playlist1);
        fakeDB.add(playlist2);
        fakeDB.add(playlist3);
    }


    public List<Playlist> getAllPlaylists() {
        return fakeDB;
    }

    public Playlist createPlaylist(String name) {
        Playlist newPlaylist = new Playlist(fakeDB.size() + 1, name);
        fakeDB.add(newPlaylist);
        return newPlaylist;
    }
}
