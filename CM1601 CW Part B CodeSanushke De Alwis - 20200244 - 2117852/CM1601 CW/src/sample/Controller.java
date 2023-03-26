package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import java.io.IOException;


public class Controller {
    @FXML
    private Button playNextbutton;

    @FXML
    private Button Nextbutton;

    @FXML
    private Button nextGroupbutton;

    @FXML
    private Button secondnextGroupbutton;

    @FXML
    private Button quitButton;

    @FXML
    private Button page4_goBackButton;

    @FXML
    private Button page4_goBackBackButton;

    @FXML
    private Button page3_goBackButton;

    @FXML
    private Button page2_goBackButton;


    public void page_1() throws IOException {
        Stage stage = (Stage) playNextbutton.getScene().getWindow();
        stage.close();
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("menuePage.fxml"));
        primaryStage.setTitle("MAIN DISPLAY");
        primaryStage.setScene(new Scene(root, 720, 720));
        primaryStage.show();
        }


    public void page_2() throws IOException {
        Stage stage = (Stage) Nextbutton.getScene().getWindow();
        stage.close();
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("groupSelectPage.fxml"));
        primaryStage.setTitle("MAIN MENUE");
        primaryStage.setScene(new Scene(root, 680, 480));
        primaryStage.show();
    }

    public void page_3() throws IOException {
        Stage stage = (Stage) nextGroupbutton.getScene().getWindow();
        stage.close();
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("groupAGames.fxml"));
        primaryStage.setTitle("GROUP A TEAMS");
        primaryStage.setScene(new Scene(root, 680, 530));
        primaryStage.show();
    }

    public void page_4() throws IOException {
        Stage stage = (Stage) secondnextGroupbutton.getScene().getWindow();
        stage.close();
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("groupBGames.fxml"));
        primaryStage.setTitle("GROUP B TEAMS");
        primaryStage.setScene(new Scene(root, 680, 510));
        primaryStage.show();
    }

    public void page_4_back() throws IOException {
        Stage stage = (Stage) page4_goBackButton.getScene().getWindow();
        stage.close();
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("groupSelectPage.fxml"));
        primaryStage.setTitle("GROUP SELECTION");
        primaryStage.setScene(new Scene(root, 680, 720));
        primaryStage.show();
    }

    public void page_4_back_back() throws IOException {
        Stage stage = (Stage) page4_goBackBackButton.getScene().getWindow();
        stage.close();
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("groupSelectPage.fxml"));
        primaryStage.setTitle("GROUP SELECTION");
        primaryStage.setScene(new Scene(root, 680, 480));
        primaryStage.show();
    }


    public void page_3_back() throws IOException {
        Stage stage = (Stage) page3_goBackButton.getScene().getWindow();
        stage.close();
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("menuePage.fxml"));
        primaryStage.setTitle("MAIN MENUE");
        primaryStage.setScene(new Scene(root, 680, 720));
        primaryStage.show();
    }

    public void page_2_back() throws IOException {
        Stage stage = (Stage) page2_goBackButton.getScene().getWindow();
        stage.close();
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("startGamePage.fxml"));
        primaryStage.setTitle("MAIN DISPLAY");
        primaryStage.setScene(new Scene(root, 680, 820));
        primaryStage.show();
    }

    public void view_close_fn(){
        Stage stage = (Stage) quitButton.getScene().getWindow();
        stage.close();
    }

}
