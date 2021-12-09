
        package Mytunes.GUI.Controller;
        import javafx.event.ActionEvent;
        import javafx.fxml.FXML;
        import javafx.fxml.FXMLLoader;
        import javafx.fxml.Initializable;
        import javafx.scene.Node;
        import javafx.scene.Parent;
        import javafx.scene.Scene;
        import javafx.scene.control.Button;
        import javafx.stage.Stage;
        import java.io.IOException;
        import java.net.URL;
        import java.util.ResourceBundle;

public class NewSongController implements Initializable {

    @FXML
    private Button buttonSaveSong;

    @FXML
    private Button buttonCancelSong;

    MainScreenController mainScreenController;

    @Override
    public void initialize(URL location, ResourceBundle resources) {


    }
    public void buttonSwitchToMainScene (ActionEvent event) throws IOException {
        //mainScreenController.updateTableViewSongs();
        Stage stage= (Stage) buttonSaveSong.getScene().getWindow();
        stage.close();
    }

    @FXML
    void toCancelSceneSong(ActionEvent event) {
        Stage stage= (Stage) buttonCancelSong.getScene().getWindow();
        stage.close();
    }
}