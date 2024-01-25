package EVote;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;

public class VoterDashboardController implements Initializable{
	
	  @FXML
	    private ToggleGroup candidate;

	    @FXML
	    private ImageView candidate_one_img;

	    @FXML
	    private RadioButton candidate_one_radio;

	    @FXML
	    private ImageView candidate_two_img;

	    @FXML
	    private RadioButton candidate_two_radio;

	    @FXML
	    private PasswordField changepassword_confirm;

	    @FXML
	    private Button changepassword_cpass_btn;

	    @FXML
	    private TextField changepassword_current;

	    @FXML
	    private PasswordField changepassword_new;

	    @FXML
	    private Button close_btn;

	    @FXML
	    private CheckBox cp_confpas_show_checkbox;

	    @FXML
	    private CheckBox cp_newpas_show_checkbox;

	    @FXML
	    private Label election_post_name;

	    @FXML
	    private Button fullscreen_btn;

	    @FXML
	    private Button minimize_btn;

	    @FXML
	    private Label mydetails_address_value;

	    @FXML
	    private ImageView mydetails_cb_image;

	    @FXML
	    private ImageView mydetails_cf_img;

	    @FXML
	    private Label mydetails_ctzshpno_value;

	    @FXML
	    private Label mydetails_dob_value;

	    @FXML
	    private Label mydetails_email_value;

	    @FXML
	    private Label mydetails_name_value;

	    @FXML
	    private Label mydetails_phone_value;

	    @FXML
	    private Label mydetails_username_value;

	    @FXML
	    private AnchorPane voter_changepass_form;

	    @FXML
	    private AnchorPane voter_mydetails_form;

	    @FXML
	    private Label voter_name_txt;

	    @FXML
	    private Button voter_nav_cpassword_btn;

	    @FXML
	    private Button voter_nav_details_btn;

	    @FXML
	    private Button voter_nav_logout_btn;

	    @FXML
	    private Circle voter_nav_profileimage;

	    @FXML
	    private Button voter_nav_vote_btn;

	    @FXML
	    private Button voter_vote_btn;

	    @FXML
	    private AnchorPane voter_vote_form;
	    
	    @FXML
	    private Label confirm_pass_error;
	    

	    @FXML
	    private Label current_pass_error;
	    @FXML
	    private Label new_pass_error;
	    
	//-----------------utility functions--------------
	    
	Utility_Functions uf = new Utility_Functions();
	
    public void close() {
    	uf.close();
    }
    public void minimize() {
    	uf.minimize(minimize_btn);
    }
	public void fullscreen() {
		uf.togglefullscreen(fullscreen_btn);
	}
	public void logout() {
		uf.logout(voter_nav_logout_btn);
	}
	
	public void switchScene(ActionEvent e) {
		if(e.getSource()==voter_nav_vote_btn) {
			voter_vote_form.setVisible(true);
			voter_mydetails_form.setVisible(false);
			voter_changepass_form.setVisible(false);
			
			voter_nav_vote_btn.setStyle("-fx-background-color:rgb(15, 120, 149);");
			voter_nav_details_btn.setStyle("-fx-background-color:transparent;");
			voter_nav_cpassword_btn.setStyle("-fx-background-color:transparent;");		
			
		}else if(e.getSource()==voter_nav_details_btn) {
			voter_vote_form.setVisible(false);
			voter_mydetails_form.setVisible(true);
			voter_changepass_form.setVisible(false);
				
			voter_nav_vote_btn.setStyle("-fx-background-color:transparent;");
			voter_nav_details_btn.setStyle("-fx-background-color:rgb(15, 120, 149);");
			voter_nav_cpassword_btn.setStyle("-fx-background-color:transparent;");
			
		}else if(e.getSource()==voter_nav_cpassword_btn) {
			voter_vote_form.setVisible(false);
			voter_mydetails_form.setVisible(false);
			voter_changepass_form.setVisible(true);
			
			voter_nav_vote_btn.setStyle("-fx-background-color:transparent;");
			voter_nav_details_btn.setStyle("-fx-background-color:transparent;");
			voter_nav_cpassword_btn.setStyle("-fx-background-color:rgb(15, 120, 149);");
		}
	}
	
	
	
	
	
	//------------change password---------------------
	Validations validation = new Validations();
	
	public void passworderrorsetnull() {
		current_pass_error.setText("");
		new_pass_error.setText("");
		confirm_pass_error.setText("");
	}
	
	
	public void shownewpass() {
		validation.showPassword(cp_newpas_show_checkbox,changepassword_new);
	}
	public void showconfirmpass() {
		validation.showPassword(cp_confpas_show_checkbox,changepassword_confirm);
	}
  

	public void changepassword() {
		Votersql vs = new Votersql();
				
		ChangePassword cp = new ChangePassword();
//		cp.changepassword(changepassword_current, changepassword_new, changepassword_confirm, current_pass_error,
//				new_pass_error, confirm_pass_error);

	}

	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		passworderrorsetnull();
	}
	
	
	
	
	
	
	
	
}

