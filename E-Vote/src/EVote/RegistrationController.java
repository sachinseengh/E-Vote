package EVote;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class RegistrationController implements Initializable{

	
	@FXML
    private AnchorPane center_form;

    @FXML
    private AnchorPane left_form;

    @FXML
    private FontAwesomeIcon register_closebtn;

    @FXML
    private Button register_fullscreenbtn;

    @FXML
    private FontAwesomeIcon register_minimizebtn;

    @FXML
    private Button register_voter_login;
	
    public void minimize(){
        Stage stage = (Stage)register_minimizebtn.getScene().getWindow();
        stage.setIconified(true);
    }
//    toggle fullscreen
    public void togglefullscreen() {
    	Stage stage = (Stage)register_fullscreenbtn.getScene().getWindow();
    	
    	stage.setFullScreen(!stage.isFullScreen());
    	
    }
    
    //close the program
    public void close() {
    	System.exit(0);
    }
    
  //toggle function to switch between admin and voter
   
    public void switchUser(ActionEvent e) throws IOException {
    	
    	if(e.getSource()==register_voter_login) {
    	
    	register_voter_login.getScene().getWindow().hide();
    		
    		Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));
    		
    		Stage stage = new Stage();   		
            
            Scene scene = new Scene(root);
            
           stage.setScene(scene);
            stage.show();
    	}
    	}
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	
}