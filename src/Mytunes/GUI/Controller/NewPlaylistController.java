package Mytunes.GUI.Controller;

import Mytunes.GUI.Model.PlaylistModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class NewPlaylistController implements Initializable {

    @FXML
    private Button buttonCancel;

    @FXML
    private Button saveButtonPlaylist;

    @FXML
    private TextField TextFieldNamePlaylist;

    PlaylistModel playlistModel;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    playlistModel = PlaylistModel.getInstance();
    }

    @FXML
    void toCancelScene(ActionEvent event) {
        Stage stage = (Stage) buttonCancel.getScene().getWindow();
        stage.close();
    }

    @FXML
    void toSavePlaylist(ActionEvent event) {
        playlistModel.createPlaylist(TextFieldNamePlaylist.getText());
        Stage stage = (Stage) saveButtonPlaylist.getScene().getWindow();
        stage.close();
    }


}