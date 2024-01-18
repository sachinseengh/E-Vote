package EVote;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

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
    
    //toggle function to switch between admin and voter
    public void togglefullscreen() {
    	Stage stage = (Stage)fullscreen.getScene().getWindow();
    	
    	stage.setFullScreen(!stage.isFullScreen());
    	
    }
    
    //close the program
    public void close() {
    	System.exit(0);
    }
    
  //switch scene
    public void switchUser(ActionEvent e) {
    	if(e.getSource()==admin_btn) {
    		admin_working_area.setVisible(true);
    		voter_working_area.setVisible(false);
    	}else if(e.getSource()== admin_voter_login) {
    		admin_working_area.setVisible(false);
    		voter_working_area.setVisible(true);
    	}
    }
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		
		
	}
	
}
