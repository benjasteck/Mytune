package Mytunes.BE;

import java.util.ArrayList;
import java.util.List;

public class Playlist {
    String name;

    public List<Song> Playlist (String name){
        this.name = name;
        return Playlist(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
