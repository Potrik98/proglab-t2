package proglab.t2.zumocontrol;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.InputStream;

public class Zumocontrol extends Application {
    @FXML
    TextArea logArea;

    private ArduinoController controller;

    public void start(Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        InputStream fxmlStream = Zumocontrol.class.getResourceAsStream("Zumocontrol.fxml");
        AnchorPane root = loader.load(fxmlStream);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Zumocontrol");
        stage.show();
    }

    @FXML
    private void initialize() {
        controller = new ArduinoController();
        logArea.appendText(controller.getStatus().concat("\n"));
    }

    @FXML
    private void action1(ActionEvent actionEvent) {
        controller.sendMessage("action1");
        logArea.appendText("Doing action 1\n");
    }

    @FXML
    private void action2(ActionEvent actionEvent) {
        controller.sendMessage("action2");
        logArea.appendText("Doing action 2\n");
    }
}
