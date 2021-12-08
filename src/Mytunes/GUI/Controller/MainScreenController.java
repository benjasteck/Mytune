package Mytunes.GUI.Controller;

import Mytunes.BE.Playlist;
import Mytunes.BE.Song;
import Mytunes.GUI.Model.DemoModel;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

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
    private TableColumn<?, ?> tableColumnSongs;

    DemoModel demoModel;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        demoModel = new DemoModel();
        setButtons();

        tableColumnTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        tableColumnArtist.setCellValueFactory(new PropertyValueFactory<>("artist"));
        tableColumnCat.setCellValueFactory(new PropertyValueFactory<>("category"));
        tableColumnTime.setCellValueFactory(new PropertyValueFactory<>("time"));
        tableViewSongs.setItems(demoModel.GetAllSongs());
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

}
