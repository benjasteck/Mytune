
package Mytunes.GUI.Controller;

import Mytunes.BE.Category;
import Mytunes.GUI.Model.EnumModel;
import Mytunes.GUI.Model.SongModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class NewSongController implements Initializable {

    @FXML
    private Button buttonSaveSong;

    @FXML
    private Button buttonCancelSong;

    @FXML
    private TextField textFieldArtist;

    @FXML
    private TextField textFieldFile;

    @FXML
    private TextField textFieldTime;

    @FXML
    private TextField textFieldTitle;

    @FXML
    private ChoiceBox<Category> choiceBoxCategory;

    MainScreenController mainScreenController;

    SongModel songModel;
    EnumModel enumModel;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        songModel = SongModel.getInstance();
        enumModel = new EnumModel();
        choiceBoxCategory.getItems().addAll(enumModel.getCategoryObservableList());


    }

    public void buttonSwitchToMainScene(ActionEvent event) throws IOException {
        songModel.createSong(textFieldTitle.getText().trim(), textFieldArtist.getText(), choiceBoxCategory.getSelectionModel().getSelectedItem(), Integer.parseInt(textFieldTime.getText()), textFieldFile.getText().trim());
        Stage stage = (Stage) buttonSaveSong.getScene().getWindow();
        stage.close();
    }

    @FXML
    void toCancelSceneSong(ActionEvent event) {
        textFieldArtist.clear();
        textFieldFile.clear();
        textFieldTime.clear();
        textFieldTitle.clear();
        Stage stage = (Stage) buttonCancelSong.getScene().getWindow();
        stage.close();
    }
}