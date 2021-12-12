package Mytunes.GUI.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class NewPlaylistController implements Initializable {

    @FXML
    private Button buttonCancel;

    @FXML
    private Button saveButtonPlaylist;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    void toCancelScene(ActionEvent event) {
        Stage stage = (Stage) buttonCancel.getScene().getWindow();
        stage.close();
    }

    @FXML
    void toSavePlaylist(ActionEvent event) {
        //mainScreenController.updateTableViewPlaylist();
        Stage stage = (Stage) saveButtonPlaylist.getScene().getWindow();
        stage.close();
    }
}