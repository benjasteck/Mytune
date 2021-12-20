package Mytunes.DAL.DAO;

import Mytunes.BLL.old.SongBLL;
import Mytunes.DAL.database.DbConnector;
import Mytunes.be.SongPlaylist;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SongPlaylistDAO {
    DbConnector databaseConnector;

    public SongPlaylistDAO() {
        databaseConnector = new DbConnector();
    }

    public void addSongToPlayList(int songid, int listid) throws SQLException {
        //todo add a song to the playlist by songId and the playlist id and increase value
        String sql = "INSERT INTO song_playlist VALUES(?,?, ?)";
        try (Connection connection = databaseConnector.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, songid);
            preparedStatement.setInt(2, listid);
            preparedStatement.setInt(3, lastIdInThePlayList(listid) + 1);
            preparedStatement.executeUpdate();
        }
    }

    private int lastIdInThePlayList(int listid) throws SQLException {
        //todo get last value(incrementing id in database) in a playlist and return it
        int id = 0;
        String sql = "SELECT id FROM song_playlist where [playlist id] = ? ORDER BY id ASC";
        try (Connection connection = databaseConnector.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, listid);
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getResultSet();
            while (resultSet.next()) {
                id = resultSet.getInt("id");
            }
        }
        return id;
    }

    public void removeSongFromPlayList(int songid, int listid, int id) throws SQLException {
        //todo remove songs from playlist by using song id, playlist id and the value
        String sql = "DELETE FROM song_playlist WHERE [Song id]=? AND [Playlist id]=? AND id= ?";
        try (Connection connection = databaseConnector.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, songid);
            preparedStatement.setInt(2, listid);
            preparedStatement.setInt(3, id);
            preparedStatement.executeUpdate();
        }
    }

    public List<SongBLL> getAllSongsForGivenPlayList(int listID, ArtistsDAO artistsDAO, CategoriesDAO categoriesDAO) throws SQLException {
        //todo get all song in a playlist defined by its id and return all song.
        List<SongBLL> allSongsFromSamePlayList = new ArrayList<>();
        String sql = "SELECT FROM song_playlist WHERE listid=? ORDERED BY id ASC";
        try (Connection connection = databaseConnector.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, listID);
            ResultSet resultSet = preparedStatement.getResultSet();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int artistid = resultSet.getInt("artistid");
                String artist = artistsDAO.getArtistById(artistid).getName();
                String title = resultSet.getString("title");
                String time = resultSet.getString("time");
                String filepath = resultSet.getString("filepath");
                int categoryid = resultSet.getInt("category");
                //String category = categoriesDAO.getCategoryById(categoryid).getCategoryName();

                //SongBLL song = new SongBLL(id, title, artist, category, time, filepath);
                //allSongsFromSamePlayList.add(song);

            }
        }
        return allSongsFromSamePlayList;
    }

    public void moveSongDown(int listid, int songid, PlaylistDAO playlistDAO, SongPlaylist songPlaylist) throws SQLException {
        if (songPlaylist.getid() == 1)
            switchFirstLast(playlistDAO.getPlaylist(songPlaylist.getPlayListId()));
        else {
            String sql = "UPDATE song_playlist SET id = CASE id WHEN ? THEN ? WHEN ? THEN ? ELSE id END WHERE [playlist id]=?";
            try (Connection connection = databaseConnector.getConnection()) {
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setInt(1, songPlaylist.getid());
                preparedStatement.setInt(2, songPlaylist.getid() - 1);
                preparedStatement.setInt(3, songPlaylist.getid() - 1);
                preparedStatement.setInt(4, songPlaylist.getid());
                preparedStatement.setInt(5, songPlaylist.getPlayListId());
                preparedStatement.executeUpdate();
            }
        }

    }


    public void moveSongUp(int listid, int songid, PlaylistDAO playlistDAO, SongPlaylist songPlaylist) throws SQLException {
        //todo the same as before but up
        if (songPlaylist.getid() == lastid(playlistDAO.getPlaylist(songPlaylist.getPlayListId()))) {
            switchFirstLast(playlistDAO.getPlaylist(songPlaylist.getPlayListId()));
        } else {
            String sql = "UPDATE song_playlist SET id = CASE id WHEN ? THEN ? WHEN ? THEN ? ELSE id END WHERE [playlist id]=?";
            try (Connection connection = databaseConnector.getConnection()) {
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setInt(1, songPlaylist.getid());
                preparedStatement.setInt(2, songPlaylist.getid() + 1);
                preparedStatement.setInt(3, songPlaylist.getid() + 1);
                preparedStatement.setInt(4, songPlaylist.getid());
                preparedStatement.setInt(5, songPlaylist.getPlayListId());
                preparedStatement.executeUpdate();
            }
        }

    }

    private void switchFirstLast(Mytunes.BE.Playlist playlist) throws SQLException {
        String sql = "UPDATE song_playlist SET Rank = CASE Rank WHEN ? THEN ? WHEN ? THEN ? ELSE Rank END WHERE [playList Id]=?";
        try (Connection connection = databaseConnector.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, 1);
            preparedStatement.setInt(2, lastid(playlist));
            preparedStatement.setInt(3, lastid(playlist));
            preparedStatement.setInt(4, 1);
            preparedStatement.setInt(5, playlist.getId());
            preparedStatement.executeUpdate();
        }
    }

    public void deleteFromAllPlayLists(int songid) throws SQLException {
        //todo delete a song specified by id from all playlists
        String sql = "DELETE FROM Song_Playlist WHERE [Song id]=?";
        try (Connection connection = databaseConnector.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, songid);
            preparedStatement.executeUpdate();
        }
    }

    List<Integer> getIdSongInPlayList(int songid, int listid) throws SQLException {
        //todo return all values in a given playlist defined by id and connect them to a song id
        List<Integer> allValues = new ArrayList<>();
        String sql = "SELECT FROM song_playlist WHERE songid=? AND [Playlist Id]=?";
        try (Connection connection = databaseConnector.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, songid);
            preparedStatement.setInt(2, listid);
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getResultSet();
            while (resultSet.next()) {
                int ranking = resultSet.getInt(2);
                allValues.add(ranking);
            }
        }
        return allValues;
    }

    private int lastid(Mytunes.BE.Playlist playList) throws SQLException {
        int id = 0;
        String sql = "SELECT id FROM song_playlist where [playlist id] = ? ORDER BY id ASC";
        try (Connection connection = databaseConnector.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, playList.getId());
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getResultSet();
            while (resultSet.next()) {
                id = resultSet.getInt("id");
            }
        }
        return id;
    }
}
