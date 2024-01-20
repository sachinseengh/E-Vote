package EVote;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.fxml.Initializable;

public class AdminDashboardController implements Initializable{
    @FXML
    private TextField admin_candidate_one_name;

    @FXML
    private TextField admin_candidate_two_name;

    @FXML
    private Button admin_changepass_btn;

    @FXML
    private AnchorPane admin_changepassword_form;

    @FXML
    private CheckBox admin_confirmshow_checkbox;

    @FXML
    private PasswordField admin_cp_confirm;

    @FXML
    private TextField admin_cp_current;

    @FXML
    private PasswordField admin_cp_new;

    @FXML
    private AnchorPane admin_endresult_form;

    @FXML
    private CheckBox admin_newshow_checkbox;

    @FXML
    private AnchorPane admin_result_form;

    @FXML
    private AnchorPane admin_strtvoting_form;

    @FXML
    private AnchorPane admin_voter_result_form;

    @FXML
    private ImageView candidate_one_image;

    @FXML
    private ImageView candidate_two_img;

    @FXML
    private Button close_btn;

    @FXML
    private Button fullscreen_btn;

    @FXML
    private Button minimize_btn;

    @FXML
    private Button nav_changepassword_btn;

    @FXML
    private Button nav_logout_btn;

    @FXML
    private Button nav_publishresult_btn;

    @FXML
    private Button nav_startvoting_btn;

    @FXML
    private Button nav_verifyvoter_btn;

    @FXML
    private Button nav_voter_btn;

    @FXML
    private TextField position_name;

    @FXML
    private ImageView published_result_img;

    @FXML
    private Label published_result_name;

    @FXML
    private Label published_result_post;

    @FXML
    private Label published_result_vote;

    @FXML
    private Label published_result_wonby;

    @FXML
    private Button publishres_endvoting_btn;

    @FXML
    private Label publishres_numbervoted;

    @FXML
    private Button publishres_refresh_btn;

    @FXML
    private Label publishres_totalvoter;

    @FXML
    private Button start_election_btn;

    @FXML
    private TextField verification_address_txt;

    @FXML
    private TextField verification_citizenshpno_txt;

    @FXML
    private DatePicker verification_date_txt;

    @FXML
    private TextField verification_id_txt;

    @FXML
    private TextField verification_name_txt;

    @FXML
    private Button verification_reject_btn;

    @FXML
    private TextArea verification_remarks_txt;

    @FXML
    private TableView<?> verification_tableview;

    @FXML
    private Button verification_verify_btn;

    @FXML
    private TableColumn<?, ?> verificationtable_col_address;

    @FXML
    private TableColumn<?, ?> verificationtable_col_citizenbackimg;

    @FXML
    private TableColumn<?, ?> verificationtable_col_citizenfrontimg;

    @FXML
    private TableColumn<?, ?> verificationtable_col_citizenshipno;

    @FXML
    private TableColumn<?, ?> verificationtable_col_dob;

    @FXML
    private TableColumn<?, ?> verificationtable_col_employeeidimage;

    @FXML
    private TableColumn<?, ?> verificationtable_col_id;

    @FXML
    private TableColumn<?, ?> verificationtable_col_name;

    @FXML
    private TableColumn<?, ?> verificationtable_col_path;

    @FXML
    private AnchorPane verifyvoter_form;

    @FXML
    private TextField voter_address_txt;

    @FXML
    private ImageView voter_citizenshipback_img;

    @FXML
    private ImageView voter_citizenshipfront_img;

    @FXML
    private TextField voter_citizenshipno_txt;

    @FXML
    private Button voter_delete_btn;

    @FXML
    private DatePicker voter_dob_txt;

    @FXML
    private ImageView voter_employeeid_img;

    @FXML
    private AnchorPane voter_form;

    @FXML
    private TextField voter_id_txt;

    @FXML
    private TextField voter_name_txt;

    @FXML
    private ImageView voter_photo_img;

    @FXML
    private TableColumn<?, ?> voter_tablecol_address;

    @FXML
    private TableColumn<?, ?> voter_tablecol_citizenno;

    @FXML
    private TableColumn<?, ?> voter_tablecol_citizenshipback;

    @FXML
    private TableColumn<?, ?> voter_tablecol_citizenshipfront;

    @FXML
    private TableColumn<?, ?> voter_tablecol_dob;

    @FXML
    private TableColumn<?, ?> voter_tablecol_employeeidimg;

    @FXML
    private TableColumn<?, ?> voter_tablecol_id;

    @FXML
    private TableColumn<?, ?> voter_tablecol_name;

    @FXML
    private TableColumn<?, ?> voter_tablecol_photo;

    @FXML
    private TableView<?> voter_tableview;

    @FXML
    private Label voter_total_txt;
    
    @FXML
    private Label position_error;
    
    @FXML
    private Label candidateone_error;
    @FXML
    private Label candidatetwo_error;
    
    @FXML
    private Label candidateone_img_error;
    @FXML
    private Label candidatetwo_img_error;
    
    @FXML 
    private Label imageone_name;
    @FXML 
    private Label imagetwo_name;
    
    
    public void errorset() {
    	position_error.setText("");
    	candidateone_error.setText("");
    	candidatetwo_error.setText("");
    	candidateone_img_error.setText("");
    	candidatetwo_img_error.setText("");
    }
    
    
	    

	
	    public void minimize(){
	        Stage stage = (Stage)minimize_btn.getScene().getWindow();
	        stage.setIconified(true);
	    }
//	    toggle fullscreen
	    public void togglefullscreen() {
	    	Stage stage = (Stage)fullscreen_btn.getScene().getWindow();
	    	
	    	stage.setFullScreen(!stage.isFullScreen());
	    	
	    }
	    
	    //close the program
	    public void close() {
	    	System.exit(0);
	    }
	    
	    public void startElection() {
	    	if(position_name.getText().equals("") 		
	    			|| position_name.getText().trim().isEmpty()|| 
	    			position_name.getText()== null){
	    		position_error.setText("Fill the position ");	
	    		
	    	}else {
	    		
	    		String position =position_name.getText();
	    		Matcher result = letteronlyregex(position);
	    		
	    		if(!result.matches()) {
//	    		
	    			position_error.setText("Position can only contains letters");
	    		}
	    	}
	    		
	    		if(admin_candidate_one_name.getText().equals("") 		
		    			|| admin_candidate_one_name.getText().trim().isEmpty()|| 
		    			admin_candidate_one_name.getText()== null){
	    			
	    			candidateone_error.setText("Fill candidate Name ");
	    			
		    		}else {
		    			String candidate_one =admin_candidate_one_name.getText();
			    		Matcher candidate1 = letteronlyregex(candidate_one);
			    		
			    		if(!candidate1.matches()) {
//			    			
			    			candidateone_error.setText("Candidate can only contains letters ");
			    			
		    		      }
	    		
	    	}	
	    		
	    	
	    	}
	    
	    
	    

	  
	   
	    	
	    public Matcher letteronlyregex(String txt) {
	    	
	    	String regex ="^[a-zA-Z\\s]+$";
	    	Pattern pattern= Pattern.compile(regex);
	    	Matcher matcher = pattern.matcher(txt);
	    	
	    	
	    	
	    	return matcher;
	    }
	

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	
	errorset();
		
	}
	
}