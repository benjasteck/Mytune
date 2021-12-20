package Mytunes.GUI.Controller;

import Mytunes.BE.Playlist;
import Mytunes.be.Song;

import Mytunes.GUI.Model.PlaylistModel;
import Mytunes.GUI.Model.SongModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class MainScreenController implements Initializable {

    @FXML
    private Button buttonBack;

    @FXML private TextField filterField;

    @FXML
    private Button buttonForward;

    @FXML
    private Button filterBtn;

    @FXML
    private Button buttonPlayPause;

    @FXML
    private TableColumn<Song, String> tableColumnCat;

    @FXML
    private TableColumn<Song, Integer> tableColumnTime;

    @FXML
    private TableColumn<Song, String> tableColumnArtist;

    @FXML
    private TableColumn<Song, String> tableColumnTitle;

    @FXML
    private TableView<Song> tableViewSongs;

    @FXML
    private TableView<Playlist> tableViewPlaylist;

    @FXML
    private TableColumn<Playlist, String> tableColumnTimeP;

    @FXML
    private TableColumn<Playlist, String> tableColumnName;

    @FXML
    private TableColumn<Playlist, Integer> tableColumnSongs;

    @FXML
    private Button buttonNewSong;

    @FXML
    private Button buttonNewPlaylist;

    @FXML
    private ListView<Song> listViewSongs;

    private MediaPlayer mediaPlayer;
    private Media media;
    private Parent root;
    private int played = 0;
    private Song actualSong;

    private SongModel songModel;
    private PlaylistModel playlistModel;
    ObservableList<Song> listOfSongsToShow;
    private final ObservableList<Song> dataList = FXCollections.observableArrayList();
    public Playlist currentPlaylist;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        songModel = SongModel.getInstance();
        playlistModel = PlaylistModel.getInstance();
        setButtons();
        setTableViews();
        listViewSongs.getItems().addAll();


        dataList.addAll((Song) songModel.getAllSongs());

        FilteredList<Song> filteredData = new FilteredList<>(dataList, b -> true);

        filterField.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(song1 -> {
                // If filter text is empty, display all song.

                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                // Compare title and artist of every song with filter text.
                String lowerCaseFilter = newValue.toLowerCase();

                if (song1.getArtist().toLowerCase().contains(lowerCaseFilter)) {
                    return true; // Filter artist.
                } else if (song1.getTitle().toLowerCase().contains(lowerCaseFilter)) {
                    return true; // Filter matches title.
                }
                else
                    return false; // Does not match.
            });
        });

        SortedList<Song> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(tableViewSongs.comparatorProperty());
        //show the new list of filtered songs
        tableViewSongs.setItems(sortedData);
    }

    private void setButtons(){
        Image imgPlay = new Image ("Mytunes/GUI/View/Assets/PlayButton.png");
        Image imgForward = new Image ("Mytunes/GUI/View/Assets/SkipButton.png");
        Image imgBack = new Image ("Mytunes/GUI/View/Assets/BackButton.png");

        ImageView viewPlay = new ImageView(imgPlay);
        ImageView viewForward = new ImageView(imgForward);
        ImageView viewBack = new ImageView(imgBack);
        viewPlay.setFitHeight(60);
        viewPlay.setFitWidth(60);
        viewForward.setFitHeight(50);
        viewForward.setFitWidth(50);
        viewBack.setFitHeight(50);
        viewBack.setFitWidth(50);
        buttonPlayPause.setGraphic(viewPlay);
        buttonForward.setGraphic(viewForward);
        buttonBack.setGraphic(viewBack);
    }
    private void setTableViews(){
        tableColumnTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        tableColumnArtist.setCellValueFactory(new PropertyValueFactory<>("artist"));
        tableColumnCat.setCellValueFactory(new PropertyValueFactory<>("category"));
        tableColumnTime.setCellValueFactory(new PropertyValueFactory<>("timeToString"));
        tableViewSongs.setItems(songModel.getAllSongs()); // setting up tableview for All songs (right one)

        refreshPlaylistTableView();// setting up tableview for All songs (left one)
    }

    @FXML
    public void buttonNewSong1 (ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Mytunes/GUI/View/NewsongView.fxml"));
        try {
            root = loader.load();
        } catch (IOException e) {}
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
    }



    @FXML
    public void toNewPlaylist(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Mytunes/GUI/View/NewplaylistView1.fxml"));
        try {
            root = loader.load();
        } catch (IOException e) {}
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
    }

    @FXML
    void toCloseApp(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    void toNextSong(ActionEvent event) {
        listViewSongs.getSelectionModel().selectNext();
        toPlayPause(event);
    }

    @FXML
    void toPlayPause(ActionEvent event) {
        Song songToPlay = listViewSongs.getSelectionModel().getSelectedItem();
        if (songToPlay == null){
            return;
        }
        if (songToPlay == actualSong){
            if (played == 1){
                mediaPlayer.pause();
                played = 0;
            }
            else {
                mediaPlayer.play();
                played = 1;
            }
        }  else {
                System.out.println(songToPlay.getFilePath());
                File f = new File(songToPlay.getFilePath());
               // File f = new File("C:/Users/ponce/IdeaProjects/Mytune/src/Mytunes/musicDemo/Venom.mp3");
                if (f.exists()) {
                    System.out.println("MP3 Exists");
                } else {
                    System.out.println("MP3 DONT EXISTS");
                }
                if (mediaPlayer != null){
                    mediaPlayer.stop();
                }
                media = new Media(f.toURI().toString());
                mediaPlayer = new MediaPlayer(media);
                mediaPlayer.play();
                actualSong = songToPlay;
                played = 1;
            }
    }

    @FXML
    void toPreviousSong(ActionEvent event) {
        listViewSongs.getSelectionModel().selectPrevious();

        toPlayPause(event);
    }

    @FXML
    void toDeleteSong(ActionEvent event) {
        Song songToDelete = tableViewSongs.getSelectionModel().getSelectedItem();
        songModel.deleteSong(songToDelete);
    }

    @FXML
    void toDeletePlaylist(ActionEvent event) {
        Playlist playlistToDelete = tableViewPlaylist.getSelectionModel().getSelectedItem();
        playlistModel.deletePlaylist(playlistToDelete);
    }


    @FXML
    void toShowSongsFromPlaylist(MouseEvent event) {
        listOfSongsToShow = FXCollections.observableArrayList();
        Playlist playlistToShow = tableViewPlaylist.getSelectionModel().getSelectedItem();
        List<Song> getSongsList = new ArrayList<>(playlistModel.updatelistViewOfThePlaylist(playlistToShow));
        listOfSongsToShow.addAll(getSongsList);
        listViewSongs.setItems(listOfSongsToShow);
        currentPlaylist = playlistToShow;

    }//TODO need to move some of the code to the PlaylistModel

    @FXML
    void toDeleteSongInPlaylist(ActionEvent event) {
        Song songToDelete = listViewSongs.getSelectionModel().getSelectedItem();
        Playlist chosenPlaylist = tableViewPlaylist.getSelectionModel().getSelectedItem();
        playlistModel.deleteSongFromPlaylist(chosenPlaylist, songToDelete);
        listOfSongsToShow.remove(songToDelete);
        refreshPlaylistTableView();
        
    }

    @FXML
    void toAddSongIntoPlaylist(ActionEvent event) {
        currentPlaylist = tableViewPlaylist.getSelectionModel().getSelectedItem();
        Song songToAdd = tableViewSongs.getSelectionModel().getSelectedItem();
        currentPlaylist.addSong(songToAdd);
        System.out.println(currentPlaylist);
        listViewSongs.refresh();
        tableViewPlaylist.refresh();
    } // TODO this is probably som bug but I cannot add first 2 songs into playlists
    //TODO listViewSong does not refresh when I add new song

    public void refreshPlaylistTableView(){
        tableViewPlaylist.refresh();
        tableColumnName.setCellValueFactory(new PropertyValueFactory<>("name"));
        tableColumnSongs.setCellValueFactory(new PropertyValueFactory<>("numberOfSongs"));
        tableColumnTimeP.setCellValueFactory(new PropertyValueFactory<>("totalTime"));
        tableViewPlaylist.setItems(playlistModel.getAllPlaylists());
    }

    public void searchClearFilterbtn(ActionEvent actionEvent) {
        filterField.clear();
        filterBtn.setText("Search");
    }
}

