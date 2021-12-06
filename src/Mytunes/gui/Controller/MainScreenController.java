package Mytunes.gui.Controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

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
    private TableColumn<?, ?> tableColumnCat;

    @FXML
    private TableColumn<?, ?> tableColumnTime;

    @FXML
    private TableColumn<?, ?> tableColumnTitle;

    @FXML
    private TableView<?> tableViewSongs;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        Image imgPlay = new Image ("Mytunes/gui/View/Assets/PlayButton.png");
        Image imgForward = new Image ("Mytunes/gui/View/Assets/SkipButton.png");
        Image imgBack = new Image ("Mytunes/gui/View/Assets/BackButton.png");

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
