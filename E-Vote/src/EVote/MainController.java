package EVote;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
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
    
    @FXML
    private AnchorPane published_result_form;
    
    @FXML
    private AnchorPane voter_checkstatus_form; 
    
    @FXML
    private AnchorPane no_result_form;

    
    Parent root;
 
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
	 
	 
	 //switch user
    public void switchUser(ActionEvent e) throws IOException {
    	if(e.getSource()==admin_btn) {
    		admin_working_area.setVisible(true);
    		voter_working_area.setVisible(false);
    		voter_checkstatus_form.setVisible(false);
    		published_result_form.setVisible(false);
    		
    		
    	}else if(e.getSource()== admin_voter_login) {
    		admin_working_area.setVisible(false);
    		voter_working_area.setVisible(true);
    		
    		
    	}else if(e.getSource()==voter_registernow) {
    		voter_registernow.getScene().getWindow().hide();
    		registrationOpen();
    		
    	}else if(e.getSource()==voter_registrationstatus) {
    		voter_working_area.setVisible(false);
    		voter_checkstatus_form.setVisible(true);
    		
    		
    	}else if(e.getSource()==voter_viewresult) {
    		
//    		i will call a function which is there is result then the result 
    		//and if there is result then result 
    		
    		published_result_form.setVisible(true);
    		voter_working_area.setVisible(false);
    	}
    }
    
    
    public void registrationOpen() throws IOException {
    	root = FXMLLoader.load(getClass().getResource("Registration.fxml"));
        
    	MouseMovableScene();
    }
    
    public void adminLogin() {
    	
    	
    	if(admin_username.getText().isEmpty()|| admin_password.getText().isEmpty()
    			|| admin_username.getText().equals("") || admin_password.getText().equals("")
    		     || admin_username.getText().trim().isEmpty()|| admin_password.getText().trim().isEmpty()) {
    	
    		Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Login ");
            alert.setHeaderText(null);
            alert.setContentText("Fill the Blanks Fields");
            alert.showAndWait(); 
    		
    	}else{
    	
    	
    		try {
    		Conn c = new Conn();
    		
    		String sql ="select * from admin where username='"+admin_username.getText()+"'"
    				+ " and password='"+admin_password.getText()+"'";
    		
    		ResultSet rs=c.s.executeQuery(sql);
    		
    		if(rs.next()) {
    			
    			admin_loginbtn.getScene().getWindow().hide();
    			 root = FXMLLoader.load(getClass().getResource("AdminDashboard.fxml"));
    			 MouseMovableScene() ;
    		}else {
    			Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle(" Login Failed");
                alert.setHeaderText(null);
                alert.setContentText("Incorrect username or password");
                alert.show();
    		}
    		
    	}catch(Exception e){
    		e.printStackTrace();
    		}
    	}
    }
	
    public void MouseMovableScene() {
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
    @Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		
		
	}
	
}
