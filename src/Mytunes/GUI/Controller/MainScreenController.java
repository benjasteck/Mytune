package Mytunes.GUI.Controller;

import Mytunes.BE.Playlist;
import Mytunes.BE.Song;
import Mytunes.GUI.Model.old.MainModel;
import Mytunes.GUI.Model.PlaylistModel;
import Mytunes.GUI.Model.SongModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainScreenController implements Initializable {

    @FXML
    private Button buttonBack;

    @FXML
    private Button buttonForward;

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
    private TableColumn<?, ?> tableColumnTimeP;

    @FXML
    private TableColumn<Playlist, String> tableColumnName;

    @FXML
    private TableColumn<Playlist, Integer> tableColumnSongs;

    @FXML
    private Button buttonNewSong;

    @FXML
    private Button buttonNewPlaylist;

    MainModel demoModel;
    private MediaPlayer mediaPlayer;
    private Media media;
    private Parent root;

    private SongModel songModel;
    private PlaylistModel playlistModel;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        songModel = SongModel.getInstance();
        playlistModel = PlaylistModel.getInstance();
        setButtons();
        setTableViews();

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

        tableColumnName.setCellValueFactory(new PropertyValueFactory<>("name"));
        tableColumnSongs.setCellValueFactory(new PropertyValueFactory<>("numberOfSongs"));
        tableViewPlaylist.setItems(playlistModel.getAllPlaylists());// setting up tableview for All songs (left one)
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

    public void updateTableViewSongs(){

        tableViewSongs.getItems().clear();
        tableViewSongs.refresh();
        tableColumnTitle.setCellValueFactory(new PropertyValueFactory<Song, String>("title"));
        tableColumnArtist.setCellValueFactory(new PropertyValueFactory<Song, String>("artist"));
        tableColumnCat.setCellValueFactory(new PropertyValueFactory<Song, String>("category"));
        tableColumnTime.setCellValueFactory(new PropertyValueFactory<Song, Integer>("timeToString"));
        tableViewSongs.setItems(songModel.getAllSongs());
    }
    public void updateTableViewPlaylist(){
        tableViewPlaylist.getItems().clear();
        tableViewPlaylist.refresh();
        tableColumnName.setCellValueFactory(new PropertyValueFactory<>("name"));
        tableColumnSongs.setCellValueFactory(new PropertyValueFactory<>("numberOfSongs"));
        tableViewPlaylist.setItems(playlistModel.getAllPlaylists());
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

    }

    @FXML
    void toPlayPause(ActionEvent event) {

    }

    @FXML
    void toPreviousSong(ActionEvent event) {

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
}

