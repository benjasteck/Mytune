package Mytunes.BE;

public enum Category {
    Rap("Rap"),
    Rock("Rock"),
    Folk("Folk"),
    Pop("Pop"),
    Metal("Metal"),
    Electronic("Electronic"),
    Jazz("Jazz"),
    Dubstep("Dubstep"),
    Blues("Blues"),
    Techno("Techno"),
    Country("Country"),
    Latin("Latin"),
    Punk("Punk"),
    Classical("Classical"),
    Hardcore("Hardcore"),
    House("House"),
    Swing("Swing"),
    Hiphop("Hiphop");

    private String name;
    private int id;

    Category(String name, int id){
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public int getId(){return id;}

    @Override
    public String toString(){
        return this.name;
    }
}