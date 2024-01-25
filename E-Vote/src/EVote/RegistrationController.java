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
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class RegistrationController implements Initializable{

	
	 @FXML
	    private Label address_error;

	    @FXML
	    private AnchorPane center_form;

	    @FXML
	    private Button citizenshipback_addbtn;

	    @FXML
	    private Label citizenshipback_error;

	    @FXML
	    private Label citizenshipback_name;

	    @FXML
	    private Button citizenshipfront_addbtn;

	    @FXML
	    private Label citizenshipfront_error;

	    @FXML
	    private Label citizenshipfront_img;

	    @FXML
	    private Label citizenshipno_error;

	    @FXML
	    private Label dateofbirth_error;

	    @FXML
	    private Label email_error;

	    @FXML
	    private Label employee_id_error;

	    @FXML
	    private Label employee_id_img;

	    @FXML
	    private Button employeeid_addbtn;

	    @FXML
	    private Label fullname_error;

	    @FXML
	    private TextField fullname_txtfield;
	    
	    @FXML
	    private TextField email_txt;
	    
	    @FXML
	    private TextField phone_txtfield;
	    
	    @FXML
	    private DatePicker datepicker_txtfield;
	    
	    @FXML
	    private TextField citizenshipno_txtfield;
	    
	    @FXML
	    private TextField address_txtfield;
	    
	    @FXML
	    private TextField password_textfield;

	    @FXML
	    private AnchorPane left_form;

	    @FXML
	    private Label passportphoto_img;

	    @FXML
	    private Button passportsizephoto_btn;

	    @FXML
	    private Label passpost_error;

	    @FXML
	    private Label password_error;

	    @FXML
	    private Label phone_error;

	    @FXML
	    private FontAwesomeIcon register_closebtn;

	    @FXML
	    private Button register_fullscreenbtn;

	    @FXML
	    private FontAwesomeIcon register_minimizebtn;

	    @FXML
	    private Button register_voter_login;

	    @FXML
	    private Button reset_btn;

	    @FXML
	    private Button submit_btn;
	    @FXML
	    private Button register_minimize_btn;

	
	  //----------------utility function------------------------//  
	    Utility_Functions uf = new Utility_Functions();
	    
    public void minimize(){
       uf.minimize(register_minimize_btn);
    } 
    public void togglefullscreen() {
        uf.togglefullscreen(register_fullscreenbtn);	
    }
    public void close() {
    	uf.close();
    }
    
    //------------------switch_user------------------------------//
  //toggle function to switch between admin and voter
   
    public void switchUser(ActionEvent e) throws IOException {
    	
    	if(e.getSource()==register_voter_login) {
    	
    	register_voter_login.getScene().getWindow().hide();
    		
    		Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));
    		
    		Utility_Functions utility = new Utility_Functions();
    		
    		utility.MouseMovableScene(root);
    		
    	}
    	}
    
	
    //-----------set-Register's-error--------------------------//
    
    public void seterrornull() {
    	fullname_error.setText("");
    	citizenshipback_error.setText("");
    	citizenshipfront_error.setText("");
    	employee_id_error.setText("");
    	passpost_error.setText("");
    	citizenshipno_error.setText("");
    	password_error.setText("");
    	email_error.setText("");
    	phone_error.setText("");
    	dateofbirth_error.setText("");
    	address_error.setText("");
    }
    
    
    public void submit() {
    	Validations validation= new Validations();
    	if(fullname_txtfield.getText().equals("")|| fullname_txtfield.getText().trim().isEmpty()
    			|| fullname_txtfield.getText()==null) {
    		fullname_error.setText("Name is required");
    	}else {
    		if(!validation.letteronlyregex(fullname_error.getText())) {
    			fullname_error.setText("Invalid name");
    		}
    	}
    	
    	if(email_txt.getText().equals("")|| email_txt.getText().trim().isEmpty()
    			|| fullname_txtfield.getText()==null) {
    		email_error.setText("Email is required");
    	}else {
            if(!validation.emailvalidation(email_txt.getText())) {
            	email_error.setText("Invalid email");
            }
    	}
    	
    	if(phone_txtfield.getText().equals("")|| phone_txtfield.getText().trim().isEmpty()
    			|| phone_txtfield.getText()==null) {
    		phone_error.setText("Phone is required");
    	}else {
            
            if(!validation.numberonly(phone_txtfield.getText())) {
            	phone_error.setText("Invalid phone number");
            }
            
    	}
    	
       //Date picker code
    	
    	if(address_txtfield.getText().equals("")|| address_txtfield.getText().trim().isEmpty()
    			|| address_txtfield.getText()==null) {
    		address_error.setText("address is required");
    	}else {
            //Phone Validation's code
    	}
    	
    	
    	if(password_textfield.getText().equals("")|| password_textfield.getText().trim().isEmpty()
    			|| password_textfield.getText()==null) {
    		password_error.setText("Password is required");
    	}else{
    		String password = password_textfield.getText();
    		
    		if(password.length()<6) {
    			password_error.setText("Minimum password length is 6");

    		
    		}else if(!validation.hasAlphabet(password)) {
    			password_error.setText("At least an alphabet is required");
    		}else if(!validation.hasDigit(password)) {
    			password_error.setText("At least one digit is required");
    		}else if(!validation.hasSpecialCharacter(password)) {
    			password_error.setText("At least one special character(_,@,#) is required");
    		}else if(!validation.PasswordValidation(password)) {
    			password_error.setText("Invalid password");
    		}
            
    	}
    	
    	if(citizenshipno_txtfield.getText().equals("")|| citizenshipno_txtfield.getText().trim().isEmpty()
    			|| citizenshipno_txtfield.getText()==null) {
    		citizenshipno_error.setText("Citizenshipno is required");
    	}else {
            if(!validation.citizenshipnovalidator(citizenshipno_txtfield.getText())) {
            	citizenshipno_error.setText("Invalid Citizenshipno");
            }
    	}
    	
    	
    	if(passportphoto_img.getText().equals("No file selected")) {
    		passpost_error.setText("Passport size image Required");
    	}
    	if(employee_id_img.getText().equals("No file selected")) {
    		employee_id_error.setText("Passport size image Required");
    	}
    	if(citizenshipfront_img.getText().equals("No file selected")) {
    		citizenshipfront_error.setText("Passport size image Required");
    	}
    	if(citizenshipback_name.getText().equals("No file selected")) {
    		citizenshipback_error.setText("Passport size image Required");
    	}
    	
        
    }
    
    @Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	
    	
    	//set error null at start
		seterrornull();
	}
	
	
	
	
	
}