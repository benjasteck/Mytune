package Mytunes.BE;

public class Artist {
    private String name;
    private int id;

    public String getName() {
        return name;
    }
    public int getId(){return id;}

    public void setName(String name) {
        this.name = name;
    }

    public Artist(String name, int id) {
        this.name = name;
        this.id = id;
    }
}
