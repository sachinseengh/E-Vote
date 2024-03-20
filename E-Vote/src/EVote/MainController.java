package EVote;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
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
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
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
	private TextField voter_phoneno;
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

	@FXML
	private Label total_vote;

	@FXML
	private Label election_date;
	@FXML
	private Label name;
	@FXML
	private Label post;
	@FXML
	private Label win_by;

	@FXML
	private Label wish;

	@FXML
	private ImageView image_view;

	@FXML
	private TextField citizenshipno_txtfield;
	@FXML
	private Button check_btn;

	@FXML
	private Button retvoterregistration;

	@FXML
	private Button retloginpage;

	@FXML
	private Button returnfrom_result;
	@FXML
	private Label status;
	@FXML
	private Label reason_txt;
	@FXML
	private DatePicker date_datepicker;

	@FXML
	private Button admin_add_imagebtn;

	@FXML
	private TextField admin_election_code;

	@FXML
	private Label admin_image_name;

	@FXML
	private ImageView admin_register_imageview;

	@FXML
	private PasswordField admin_register_password;

	@FXML
	private TextField admin_register_phone;

	@FXML
	private Button admin_registerbtn;

	@FXML
	private Button admin_register_voterloginbtn;

	@FXML
	private TextField organization_name;
	@FXML
	private AnchorPane admin_registration;

	@FXML
	private Button admin_register_form;

	@FXML
	private Label org_name_error;
	@FXML
	private Label phone_error;
	@FXML
	private Label password_error;
	@FXML
	private Label election_code_error;
	@FXML
	private Label org_logo_error;

	@FXML
	private TextField login_organization_code;

	Parent root;

	// ---------------utility functions---------------------
	Utility_Functions uf = new Utility_Functions();

	public void minimize() {
		uf.minimize(minimize_btn);
	}

	public void togglefullscreen() {
		uf.togglefullscreen(fullscreen);
	}

	public void close() {
		uf.close();
	}

	// switch user
	public void switchUser(ActionEvent e) throws IOException {
		if (e.getSource() == admin_btn) {
			admin_registration.setVisible(false);
			admin_working_area.setVisible(true);
			voter_working_area.setVisible(false);
			voter_checkstatus_form.setVisible(false);
			published_result_form.setVisible(false);

		} else if (e.getSource() == admin_voter_login) {
			admin_registration.setVisible(false);
			admin_working_area.setVisible(false);
			voter_working_area.setVisible(true);

		} else if (e.getSource() == voter_registernow) {
			voter_registernow.getScene().getWindow().hide();
			registrationOpen();

		} else if (e.getSource() == voter_registrationstatus) {
			voter_working_area.setVisible(false);
			voter_checkstatus_form.setVisible(true);

		} else if (e.getSource() == voter_viewresult || e.getSource() == admin_viewresult) {

			admin_working_area.setVisible(false);
			published_result_form.setVisible(true);
			voter_working_area.setVisible(false);
		} else if (e.getSource() == retloginpage || e.getSource() == returnfrom_result) {

			voter_checkstatus_form.setVisible(false);
			voter_working_area.setVisible(true);
			published_result_form.setVisible(false);
		} else if (e.getSource() == retvoterregistration) {
			voter_registernow.getScene().getWindow().hide();
			registrationOpen();
		} else if (e.getSource() == admin_register_form) {

			admin_registration.setVisible(true);
			admin_working_area.setVisible(false);
			voter_working_area.setVisible(false);
			voter_checkstatus_form.setVisible(false);
			published_result_form.setVisible(false);
		}
	}

	public void setregisterAdminerrornull() {
		org_name_error.setText("");
		phone_error.setText("");
		password_error.setText("");
		election_code_error.setText("");
		org_logo_error.setText("");
	}

	public void clearallfield() {
		organization_name.setText("");
		admin_register_phone.setText("");
		admin_register_imageview.setImage(null);
		admin_election_code.setText("");
		admin_register_password.setText("");
		admin_image_name.setText("No file selected");

	}

	public void openLogin() {
		admin_registration.setVisible(false);
		admin_working_area.setVisible(true);
		voter_working_area.setVisible(false);
		voter_checkstatus_form.setVisible(false);
		published_result_form.setVisible(false);
	}

	File orgLogo;

	// ---------------passportsizephot-------------------------//
	public void insertorgLogo() {
		FileChooser can1chooser = new FileChooser();
		Stage stage = (Stage) admin_registration.getScene().getWindow();

		FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Image Files", "*.jpg", "*.jpeg",
				"*.png");
		can1chooser.getExtensionFilters().add(extFilter);

		orgLogo = can1chooser.showOpenDialog(stage);

		if (orgLogo != null) {
			try {
				Image image = new Image(orgLogo.toURI().toString(), 135, 99, false, true);
				admin_register_imageview.setImage(image);
				admin_image_name.setText(orgLogo.getName());

				// make all error null
				setregisterAdminerrornull();

			} catch (Exception e) {
			}
		}
	}

	public void adminimgintofolder(File file) throws IOException {
		Path imagePath = Paths.get("adminsimages");
		if (!Files.exists(imagePath)) {
			Files.createDirectories(imagePath);

		}

		// Copy the selected file to the "image" folder
		Path destinationPath = Paths.get("adminsimages", file.getName());

		Files.copy(file.toPath(), destinationPath, StandardCopyOption.REPLACE_EXISTING);

	}

	public void registerAdmin() {
		Adminsql as = new Adminsql();
		Validations validation = new Validations();

		if (organization_name.getText().equals("") || organization_name.getText().trim().isEmpty()
				|| organization_name.getText() == null) {
			org_name_error.setText("Organization name is Required");
		} else {
			if (!validation.letteronlyregex(organization_name.getText())) {
				org_name_error.setText("Invalid name");
			}
		}

		if (admin_register_phone.getText().equals("") || admin_register_phone.getText().trim().isEmpty()
				|| admin_register_phone.getText() == null) {
			phone_error.setText("Phone is required");
		} else {

			if (!validation.numberonly(admin_register_phone.getText())) {
				phone_error.setText("Invalid phone number");

			} else if (as.checkNumber(admin_register_phone.getText())) {
				phone_error.setText("Phone number already exists");

			}
		}

		if (admin_register_password.getText().equals("") || admin_register_password.getText().trim().isEmpty()
				|| admin_register_password.getText() == null) {
			password_error.setText("Password is required");
		} else {
			String password = admin_register_password.getText();

			if (password.length() < 6) {
				password_error.setText("Minimum password length is 6");

			} else if (!validation.hasAlphabet(password)) {
				password_error.setText("At least an alphabet is required");
			} else if (!validation.hasDigit(password)) {
				password_error.setText("At least one digit is required");
			} else if (!validation.hasSpecialCharacter(password)) {
				password_error.setText("At least one special character(_,@,#) is required");
			} else if (!validation.PasswordValidation(password)) {
				password_error.setText("Invalid password");
			}

		}

		if (admin_election_code.getText().equals("") || admin_election_code.getText().trim().isEmpty()
				|| admin_election_code.getText() == null) {
			election_code_error.setText("Election code  is required");
		} else {

			if (!validation.digitsonly(admin_election_code.getText())) {
				election_code_error.setText("Invalid Election code");

			} else {
				try {

					if (admin_election_code.getText().length() != 4) {
						election_code_error.setText("Only 4 digit is allowed");
					} else if (admin_election_code.getText().equals("0000")) {
						election_code_error.setText("Invalid election code");
					} else if (as.electionCode(admin_election_code.getText())) {
						election_code_error.setText("Election code already used");
					}

				} catch (Exception e) {
					System.out.print(e);
				}
			}
		}

		if (admin_image_name.getText().equals("No file selected")) {
			org_logo_error.setText("Organization logo Required");
		}

		if (org_name_error.getText().equals("") && phone_error.getText().equals("")
				&& password_error.getText().equals("") && election_code_error.getText().equals("")
				&& org_logo_error.getText().equals("")) {

			try {

				as.adminRegister(organization_name.getText(), admin_register_phone.getText(),
						admin_register_password.getText(), admin_election_code.getText(), admin_image_name.getText());

				adminimgintofolder(orgLogo);

				clearallfield();
				openLogin();
			} catch (Exception e) {
				e.getStackTrace();
			}

		}

	}

	public void registrationOpen() throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("Registration.fxml"));

		uf.MouseMovableScene(root);
	}

	public void adminLogin() {

		if (admin_username.getText().isEmpty() || admin_password.getText().isEmpty()
				|| admin_username.getText().equals("") || admin_password.getText().equals("")
				|| admin_username.getText().trim().isEmpty() || admin_password.getText().trim().isEmpty()) {

			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Login ");
			alert.setHeaderText(null);
			alert.setContentText("Fill the Blanks Fields");
			alert.showAndWait();

		} else {

			try {
				Conn c = new Conn();

				String sql = "select * from admin where phone='" + admin_username.getText() + "'" + "and password='"
						+ admin_password.getText() + "'";

				ResultSet rs = c.s.executeQuery(sql);

				if (rs.next()) {
					getAdminDetails.phone = admin_username.getText();

					admin_loginbtn.getScene().getWindow().hide();
					root = FXMLLoader.load(getClass().getResource("AdminDashboard.fxml"));

					uf.MouseMovableScene(root);

				} else {
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle(" Login Failed");
					alert.setHeaderText(null);
					alert.setContentText("Incorrect username or password");
					alert.show();
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void VoterLogin() {
		Validations validation = new Validations();
		
		
		if (login_organization_code.getText().isEmpty()||login_organization_code.getText().trim().isEmpty()
				|| login_organization_code.getText().equals("")) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Error");
			alert.setHeaderText(null);
			alert.setContentText("Empty organization code");
			alert.showAndWait();
			return;

		} 
		
		if (!validation.digitsonly(login_organization_code.getText())) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Error");
			alert.setHeaderText(null);
			alert.setContentText("Invalid Organization code");
			alert.showAndWait();
			return;

		} 
		

		if (voter_phoneno.getText().isEmpty() || voter_password.getText().isEmpty()
				|| voter_phoneno.getText().equals("") || voter_password.getText().equals("")
				|| voter_phoneno.getText().trim().isEmpty() || voter_password.getText().trim().isEmpty()
				|| login_organization_code.getText().equals("") || login_organization_code.getText().trim().isEmpty()
				|| login_organization_code.getText().isEmpty()) {

			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Login ");
			alert.setHeaderText(null);
			alert.setContentText("Fill the Blanks Fields");
			alert.showAndWait();

		} else {
			try {
				Conn c = new Conn();

				String sql = "select * from voter_login where phone='" + voter_phoneno.getText() + "'"
						+ " and password='" + voter_password.getText() + "' and org_code='"
						+ login_organization_code.getText() + "'";
				System.out.println(sql);

				ResultSet rs = c.s.executeQuery(sql);

				if (rs.next()) {

					// it can be used to show the name of voter in voter dashboard
					getDetails.org_code = login_organization_code.getText();
					getDetails.phone = voter_phoneno.getText();

					admin_loginbtn.getScene().getWindow().hide();
					root = FXMLLoader.load(getClass().getResource("VoterDashboard.fxml"));
					uf.MouseMovableScene(root);

				} else {
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle(" Login Failed");
					alert.setHeaderText(null);
					alert.setContentText("Incorrect phone or password");
					alert.show();
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void showResult() {

		String sql = "Select * from result";
		try {
			Conn c = new Conn();
			ResultSet rs = c.s.executeQuery(sql);
			if (rs.next()) {
				election_date.setText(String.valueOf(rs.getDate("election_date")));
				post.setText(rs.getString("post"));

				Image image = new Image("file:" + "candidateimage/" + rs.getString("winner_img"));

				image_view.setImage(image);

				name.setText(rs.getString("winner"));
				total_vote.setText(String.valueOf(rs.getInt("total_vote")));
				win_by.setText(String.valueOf(rs.getInt("winby")));
				wish.setText(rs.getString("wish"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void checkStatus() {
		String sql = "select * from status where citizenshipno='" + citizenshipno_txtfield.getText() + "'and dob='"
				+ date_datepicker.getValue().toString() + "'";
		System.out.print(sql);

		try {
			Conn c = new Conn();
			ResultSet rs = c.s.executeQuery(sql);
			if (rs.next()) {
				status.setText(rs.getString("status"));
				reason_txt.setText(rs.getString("remarks"));
			} else {
				status.setText("Details didn't match");
				reason_txt.setText("");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		setregisterAdminerrornull();
		// show result
		showResult();
	}

}
