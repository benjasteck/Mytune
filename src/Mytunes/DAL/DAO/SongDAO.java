package Mytunes.DAL.DAO;

import Mytunes.BE.Song;
import Mytunes.BLL.SongBLL;
import Mytunes.DAL.database.DbConnector;

import java.nio.file.Path;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SongDAO<list> {
    DbConnector databaseConnector;

    public SongDAO() {
        databaseConnector = new DbConnector();
    }

    public List<Song> AllSongsList = new ArrayList<Song>(); // this List should contain ALL the songs ever created

    public List<SongBLL> getAllSongs(ArtistsDAO artistsDAO, CategoriesDAO categoriesDAO) throws SQLException {
        ArrayList<SongBLL> allsongs = new ArrayList<>();
        try (Connection connection = databaseConnector.getConnection()) {

            String sql = "SELECT * FROM Song;";
            Statement statement = connection.createStatement();
            if(statement.execute(sql))
            {
                ResultSet resultSet = statement.getResultSet();
                while (resultSet.next())
                {
                    int id = resultSet.getInt("id");
                    String artist = resultSet.getString("artist");
                    String title = resultSet.getString("title");
                    String time = resultSet.getString("time");
                    String filepath = resultSet.getString("filepath");
                    String category = resultSet.getString("category");


                    SongBLL song = new SongBLL(id, artist, title, time, filepath, category);
                    allsongs.add(song);

                }
            }
        }
        return allsongs;
    }

    public Song createSong(String title, String artist, String category, String filePath, ArtistsDAO artistsDAO, CategoriesDAO categoriesDAO) throws SQLException {
        //todo set all parameters here and and return a sung consisting of id, title, artist, categorym time and filepath
        Song song;
        int id = 0;
        int artistid = artistsDAO.createArtist(artist);
        int categoryid = categoriesDAO.createNewCategory(category);
        String sql = ("INSERT INTO songs VALUES (?,?,?,?,?)");
        try (Connection connection = databaseConnector.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(sql);
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
        }
        return song;
    }

    public void deleteSong(int id, SongPlaylistDAO song_playListDAO, ArtistsDAO artistsDAO, CategoriesDAO categoriesDAO) throws SQLException {
    //todo delete the song by id
        String sql = "DELETE FROM songs WHERE Id = ?";
        try (Connection connection = databaseConnector.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        }

    }

    public void updateSong(String title, int id, String artist, String category, ArtistsDAO artistsDAO, CategoriesDAO categoriesDAO) throws SQLException {
    //todo set new parameters and execute them.
        artistsDAO.updateArtist(songArtistId(id), artist);
        categoriesDAO.updateCategory(songCategoryId(id), category);
        String sql = "UPDATE songs SET Title = ?,Artists = ?, Categories= ? WHERE id=? ";
        try (Connection connection = databaseConnector.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, title);
            statement.setString(2, artist);
            statement.setString(3, category);
            statement.setInt(4, id);
            statement.executeUpdate();
        }
    }

    public int getSongTime(Path filePath) {
        //todo get the time of the song using filepath and implement it
        return 1;
    }

    private int songArtistId(int id) throws SQLException {
        //todo get songs artist id and return it.
        int artistid = 0;
        String sql = "SELECT FROM songs WHERE id = ?";
        try (Connection connection = databaseConnector.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getResultSet();
            while (resultSet.next()) {
                artistid = resultSet.getInt("artist");
            }
        }
        return artistid;
    }

    private int songCategoryId(int id) throws SQLException {
        //todo get song category id and return it
        int songCategoryid = 0;
        String sql = "SELECT FROM songs WHERE id = ?";
        try (Connection connection = databaseConnector.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getResultSet();
            while (resultSet.next()) {
                songCategoryid = resultSet.getInt("category");
            }
        }
        return songCategoryid;

    }

}
