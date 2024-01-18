package EVote;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class MainController implements Initializable {

    @FXML
    private Label e_txt;
    
    @FXML
    private Label vote_txt;
    
    @FXML
    private Button minimize_btn;
    

    @FXML
    private Button close_btn;
    

    @FXML
    private Button fullscreen;
    
    public void minimize(){
        Stage stage = (Stage)minimize_btn.getScene().getWindow();
        stage.setIconified(true);
    }
    
    public void togglefullscreen() {
    	Stage stage = (Stage)fullscreen.getScene().getWindow();
    	stage.setFullScreen(!stage.isFullScreen());
    }
    
    
    public void close() {
    	System.exit(0);
    }
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		
		
	}
	
}
