package EVote;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class MainController implements Initializable {

    @FXML
    private Button admin_btn;

    @FXML
    private Button admin_loginbtn;

    @FXML
    private PasswordField admin_password;

    @FXML
    private TextField admin_username;

    @FXML
    private Button admin_viewresult;

    @FXML
    private Button admin_voter_login;

    @FXML
    private AnchorPane admin_working_area;

    @FXML
    private Button close_btn;

    @FXML
    private Label e_txt;

    @FXML
    private Button fullscreen;

    @FXML
    private AnchorPane logo_area;

    @FXML
    private Button minimize_btn;

    @FXML
    private Label vote_txt;

    @FXML
    private Button voter_loginbtn;

    @FXML
    private PasswordField voter_password;

    @FXML
    private Button voter_registernow;

    @FXML
    private Button voter_registrationstatus;

    @FXML
    private TextField voter_username;

    @FXML
    private Button voter_viewresult;

    @FXML
    private AnchorPane voter_working_area;
    
    //to minimize screen
    public void minimize(){
        Stage stage = (Stage)minimize_btn.getScene().getWindow();
        stage.setIconified(true);
    }
//    toggle fullscreen
    public void togglefullscreen() {
    	Stage stage = (Stage)fullscreen.getScene().getWindow();
    	
    	stage.setFullScreen(!stage.isFullScreen());
    	
    }
    
    //close the program
    public void close() {
    	System.exit(0);
    }
    
  //toggle function to switch between admin and voter
    private double x =0;
	 private double y=0; 
	 
    public void switchUser(ActionEvent e) throws IOException {
    	if(e.getSource()==admin_btn) {
    		admin_working_area.setVisible(true);
    		voter_working_area.setVisible(false);
    	}else if(e.getSource()== admin_voter_login) {
    		admin_working_area.setVisible(false);
    		voter_working_area.setVisible(true);
    	}else if(e.getSource()==voter_registernow) {
    		voter_registernow.getScene().getWindow().hide();
    		
    		Parent root = FXMLLoader.load(getClass().getResource("Registration.fxml"));
            
            Stage stage = new Stage();
            
            root.setOnMousePressed(new EventHandler<MouseEvent>(){
		           @Override
		           public void handle(MouseEvent event) {
		               x= event.getSceneX();
		               y= event.getSceneY();
		           }

		         });

		         root.setOnMouseDragged(new EventHandler<MouseEvent>(){
		           @Override
		           public void handle(MouseEvent event) {
		              stage.setX(event.getScreenX()-x);
		              stage.setY(event.getScreenY()-y);
		              
		              stage.setOpacity(0.9);
		           }

		         });
		         
		         root.setOnMouseReleased(new EventHandler<MouseEvent>(){
		           @Override
		           public void handle(MouseEvent event) {
		              stage.setOpacity(1);
		           }

		         });
		         
				
            stage.initStyle(StageStyle.TRANSPARENT);
            Scene scene = new Scene(root);
            
           stage.setScene(scene);
            stage.show();
    	}
    }
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		
		
	}
	
}
