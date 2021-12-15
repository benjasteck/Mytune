package Mytunes.DAL.DAO;

import Mytunes.BE.Song;
import jdk.internal.icu.impl.StringPrepDataReader;

import javax.sound.sampled.AudioFileFormat;
import java.io.File;
import java.nio.file.Path;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SongDAO<list> {
    Connection con;
    private StringPrepDataReader AudioFileIO;

    public SongDAO(Connection con) {
        this.con = con;

    }


    public List<Song> AllSongsList = new ArrayList<Song>(); // this List should contain ALL the songs ever created

    public List<Song> getAllSongs(ArtistsDAO artistsDAO, CategoriesDAO categoriesDAO) throws SQLException {
        ArrayList<Song> allsongs = new ArrayList<>();

        String sql = "SELECT * FROM Song;";
        Statement statement = con.createStatement();
        if (statement.execute(sql)) {
            ResultSet resultSet = statement.getResultSet();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int artistid = resultSet.getInt("artistid");
                String artist = artistsDAO.getArtistById(artistid).getName();
                String title = resultSet.getString("title");
                int time = resultSet.getInt("time");
                String filepath = resultSet.getString("filepath");
                int categoryid = resultSet.getInt("categoryid");
                String category = categoriesDAO.getCategoryById(categoryid).getCategoryName();

                Song song = new Song(id, title, artist, category, time, filepath);
                allsongs.add(song);

            }
        }

        return allsongs;
    }

    public Song createSong(String title, String artist, String category, String filePath, ArtistsDAO artistsDAO, CategoriesDAO categoriesDAO) throws SQLException {
        //todo set all parameters here and and return a sung consisting of id, title, artist, category time and filepath
        // it should not have the DAOs
        Song song;
        int id = 0;
        int artistid = artistsDAO.createArtist(artist);
        int categoryid = categoriesDAO.createNewCategory(category);
        String sql = ("INSERT INTO Song VALUES (?,?,?,?,?)");
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, title);
            statement.setInt(2, artistid);
            statement.setInt(3, categoryid);
            statement.setInt(4, getSongTime(Path.of(filePath)));
            statement.setString(5, filePath);
            int created = statement.executeUpdate();
            ResultSet resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                id = resultSet.getInt(1);
            }
            if (created != 0) {
                song = new Song(id, title, artist, category, getSongTime(Path.of(filePath)), filePath);
            } else song = null;

        return song;
    }

    public void deleteSong(int id, SongPlaylistDAO song_playListDAO, ArtistsDAO artistsDAO, CategoriesDAO categoriesDAO) throws SQLException {
        //todo delete the song by id
        String sql = "DELETE FROM Song WHERE id = ?";
        //delete artist if he only has one song that was deleted
        if (artistsDAO.artistOccurrences(songArtistId(id)) > 1) {
        } else artistsDAO.deleteArtist(songArtistId(id));
        //delete category if it only belongs to one song that was deleted
        if (categoriesDAO.categoryOccurrences(id) > 1) {
        } else categoriesDAO.deleteCategory(id);
        //delete song from all playlists
        song_playListDAO.deleteFromAllPlayLists(id);
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
    }

    public void updateSong(String title, int id, String artist, String category, ArtistsDAO artistsDAO, CategoriesDAO categoriesDAO) throws SQLException {
        //todo set new parameters and execute them.
        artistsDAO.updateArtist(songArtistId(id), artist);
        categoriesDAO.updateCategory(songCategoryId(id), category);
        String sql = "UPDATE Song SET title = ?,artistid = ?, categoryid= ? WHERE id=? ";

            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, title);
            statement.setString(2, artist);
            statement.setString(3, category);
            statement.setInt(4, id);
            statement.executeUpdate();

    }

    public int getSongTime(Path filePath) {
        //todo get the time of the song using filepath and implement it
        File file = new File("filename.mp3");
        AudioFileFormat baseFileFormat = new MpegAudioFileReader().getAudioFileFormat(file);
        Map properties = baseFileFormat.properties();
        int duration = (int) properties.get("duration");
        return duration;

    }

    private int songArtistId(int id) throws SQLException {
        //todo get songs artist id and return it.
        int artistid = 0;
        String sql = "SELECT FROM Song WHERE id = ?";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getResultSet();
            while (resultSet.next()) {
                artistid = resultSet.getInt("artistid");
            }

        return artistid;
    }

    private int songCategoryId(int id) throws SQLException {
        //todo get song category id and return it
        int songCategoryid = 0;
        String sql = "SELECT FROM Song WHERE id = ?";

            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getResultSet();
            while (resultSet.next()) {
                songCategoryid = resultSet.getInt("categoryid");
            }

        return songCategoryid;

    }

}
