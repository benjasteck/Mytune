package Mytunes.DAL.DAO;

import Mytunes.BE.Category;
import Mytunes.DAL.database.DbConnector;
import Mytunes.BE.Song;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SongDAO<list> {
    private DbConnector dbConnector;

    public SongDAO() {
        dbConnector = new DbConnector();
    }


    public List<Song> getAllSongs() throws SQLException {
        ArrayList<Song> allSongs = new ArrayList<>();

        try (Connection connection = dbConnector.getConnection()) {
            String sql = "SELECT * FROM Song";
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                int id = resultSet.getInt("ID");
                String title = resultSet.getString("TITLE");
                String artist = resultSet.getString("ARTIST");
                String categoryString = resultSet.getString("CATEGORY");
                int duration = resultSet.getInt("DURATION");
                String filePath = resultSet.getString("FILEPATH");
                Category category = Category.valueOf(categoryString.trim());
                Song song = new Song(id, title, artist, category, duration, filePath);
                allSongs.add(song);
            }
        } catch (SQLException exception) {
            throw new SQLException(exception);        }
        return allSongs;
    }

    public Song createSong (Song song) throws SQLException {
        int id = 0;
        String title = song.getTitle();
        String artist = song.getArtist();
        String categoryString = song.getCategory().toString();
        int duration = song.getDuration();
        String filePath = song.getFilePath();

        try (Connection connection = dbConnector.getConnection()) {
            String sql = "INSERT INTO Song(TITLE, ARTIST, CATEGORY, DURATION, FILEPATH) OUTPUT inserted.ID VALUES (?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, title);
            preparedStatement.setString(2, artist);
            preparedStatement.setString(3, categoryString);
            preparedStatement.setInt(4, duration);
            preparedStatement.setString(5, filePath);
            int created = preparedStatement.executeUpdate();
            Category category = Category.valueOf(categoryString.trim());
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                id = resultSet.getInt(1);
            }
            if (created != 0) {
                song = new Song(id, title, artist, category, duration, filePath);
            } else song = null;

            return song;
        } catch (SQLException exception) {
            throw new SQLException(exception);
        }
    }

    public void updateSong (Song song) throws SQLException{

        int id = song.getId();
        String title = song.getTitle();
        String artist = song.getArtist();
        String genre = song.getCategory().toString();
        int time = song.getDuration();
        String source = song.getFilePath();

        try (Connection connection = dbConnector.getConnection()) {
            String sql = "UPDATE Song SET TITLE = ?, ARTIST = ?, GENRE = ?, TIME = ?, SOURCE = ? WHERE ID = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, title);
            preparedStatement.setString(2, artist);
            preparedStatement.setString(3, genre);
            preparedStatement.setInt(4, time);
            preparedStatement.setString(5, source);
            preparedStatement.setInt(6, id);
            preparedStatement.execute();
        } catch (SQLException exception) {
            throw new SQLException();
        }
    }

    public void deleteSong(Song song) throws SQLException{
        try (Connection connection = dbConnector.getConnection()) {
            String sqlPlaylists = "DELETE FROM SongsOnPlaylist WHERE SongiD=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlPlaylists);
            preparedStatement.setInt(1, song.getId());
            preparedStatement.execute();
            String sqlSong = "DELETE FROM Song WHERE id = ?";

            PreparedStatement preparedStatement2 = connection.prepareStatement(sqlSong);
            preparedStatement2.setInt(1, song.getId());
            preparedStatement2.execute();
        } catch (SQLException exception) {
            throw new SQLException(exception);
        }
    }

    public Song getSongById(int id) throws SQLException {
        Song song = null;
        String sql = "SELECT *  FROM Song WHERE id=?";
        try(Connection connection = dbConnector.getConnection()){PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);}
        return song;}
}
