package EVote;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.filechooser.FileNameExtensionFilter;

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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.fxml.Initializable;

public class AdminDashboardController implements Initializable {
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
	private ImageView candidate_two_image;

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
	
	
	
	/*------------------Start voting of admin dashboard----------------------------*/               

	//---------------------error null at first--------------------------------------
	public void errorset() {
		position_error.setText("");
		candidateone_error.setText("");
		candidatetwo_error.setText("");
		candidateone_img_error.setText("");
		candidatetwo_img_error.setText("");
	}

	//----------------------minimize screen------------------------------------------
	public void minimize() {
		Stage stage = (Stage) minimize_btn.getScene().getWindow();
		stage.setIconified(true);
	}

   //--------------------toggle fullscreen---------------------------------------------
	
	public void togglefullscreen() {
		Stage stage = (Stage) fullscreen_btn.getScene().getWindow();

		stage.setFullScreen(!stage.isFullScreen());
	}

	//------------------ close the program----------------------------------------------
	public void close() {
		System.exit(0);
	}

	File selectedFile_one;
	File selectedFile_two;

	//-----------------------------insert candidate one image-----------------------------
	public void insertImageone() {
		FileChooser can1chooser = new FileChooser();
		Stage stage = (Stage) admin_strtvoting_form.getScene().getWindow();

		FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Image Files", "*.jpg", "*.jpeg",
				"*.png");
		can1chooser.getExtensionFilters().add(extFilter);

		selectedFile_one = can1chooser.showOpenDialog(stage);

		candidateimgadd(selectedFile_one, candidate_one_image, imageone_name);
	}
	//-----------------------------insert candidate one image-----------------------------
	public void insertImagetwo() {
		FileChooser can2chooser = new FileChooser();
		Stage stage = (Stage) admin_strtvoting_form.getScene().getWindow();

		FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Image Files", "*.jpg", "*.jpeg",
				"*.png");
		can2chooser.getExtensionFilters().add(extFilter);

		selectedFile_two = can2chooser.showOpenDialog(stage);
		candidateimgadd(selectedFile_two, candidate_two_image, imagetwo_name);
	}
    
	//------save the image to the imageview and set label with image name--------------
	public void candidateimgadd(File selectedFile, ImageView imageview, Label label) {

		if (selectedFile != null) {
			try {	
				Image image = new Image(selectedFile.toURI().toString(), 140, 142, false, true);
				imageview.setImage(image);
				label.setText(selectedFile.getName());
				
				// make all error null
				position_error.setText("");
				candidateone_error.setText("");
				candidatetwo_error.setText("");
				candidateone_img_error.setText("");
				candidatetwo_img_error.setText("");
			} catch (Exception e) {
			}
		}
	}

	
	
	//-------------save candidates image into folder on submit-------------------------
	public void candidateimgmoveintofolder(File file) throws IOException {
		Path imagePath = Paths.get("candidateimage");
		if (!Files.exists(imagePath)) {
			Files.createDirectories(imagePath);

		}

		 // Copy the selected file to the "image" folder
		Path destinationPath = Paths.get("candidateimage", file.getName());

		Files.copy(file.toPath(), destinationPath, StandardCopyOption.REPLACE_EXISTING);

	}

	

	//----------------pattern to check letter only-----------------------------
	public Matcher letteronlyregex(String txt) {
		String regex = "^[a-zA-Z\\s]+$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(txt);
		return matcher;
	}

	//----------------remove all error when key is typed----------------------
	public void removeerrorwhiletyping() {
		position_error.setText("");
		candidateone_error.setText("");
		candidatetwo_error.setText("");
		candidateone_img_error.setText("");
		candidatetwo_img_error.setText("");
	}
	
	
	//-----------------startelectionbuttonfunction-----------------------------
	public void startElection() {
		
		 						//checkposition
		if (position_name.getText().equals("") || position_name.getText().trim().isEmpty()
				|| position_name.getText() == null) {
			position_error.setText("Fill the position ");
		} else {
			String position = position_name.getText();
			Matcher result = letteronlyregex(position);

			if (!result.matches()) {		
				position_error.setText("Position can only contains letters");
			}
		}
								//candidate name
		if (admin_candidate_one_name.getText().equals("") || admin_candidate_one_name.getText().trim().isEmpty()
				|| admin_candidate_one_name.getText() == null) {

			candidateone_error.setText("Fill candidate Name ");

		} else {
			String candidate_one = admin_candidate_one_name.getText();
			Matcher candidate1 = letteronlyregex(candidate_one);

			if (!candidate1.matches()) {
		    			
				candidateone_error.setText("Candidate can only contains letters ");
			}

		}
								//candidate two name
		if (admin_candidate_two_name.getText().equals("") || admin_candidate_two_name.getText().trim().isEmpty()
				|| admin_candidate_two_name.getText() == null) {

			candidatetwo_error.setText("Fill candidate Name ");

		} else {
			String candidate_one = admin_candidate_two_name.getText();
			Matcher candidate1 = letteronlyregex(candidate_one);

			if (!candidate1.matches()) {	    			
				candidatetwo_error.setText("Candidates can only contains letters ");
			}

		}
								//candidate one image
		if(imageone_name.getText().equals("No image Selected")) {
			candidateone_img_error.setText("candidate image not selected");
		}
								//candidate two image
		if(imagetwo_name.getText().equals("No image Selected")) {
			candidatetwo_img_error.setText("candidate image not selected");
		}
		
		
		                    //save function to save into folder
		try {
			candidateimgmoveintofolder(selectedFile_one);
			candidateimgmoveintofolder(selectedFile_two);
		} catch (Exception e) {
			
		}

	}

	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		errorset();

	}

}
