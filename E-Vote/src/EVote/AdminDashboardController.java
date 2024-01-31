package EVote;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.ResultSet;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.filechooser.FileNameExtensionFilter;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
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
	private AnchorPane admin_strtvoting_form;

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
	private TextField verification_dob_txt;

	@FXML
	private DatePicker verification_date_txt;

	@FXML
	private TextField verification_phone_txt;

	@FXML
	private TextField verification_name_txt;

	@FXML
	private Button verification_reject_btn;

	@FXML
	private TextArea verification_reason_txt;

	@FXML
	private TableView<GetUnVerified> verification_tableview;

	@FXML
	private Button verification_verify_btn;

	@FXML
	private TableColumn<GetUnVerified, String> verificationtable_col_address;
	@FXML
	private TableColumn<GetUnVerified, String> verificationtable_col_id;
	@FXML
	private TableColumn<GetUnVerified, String> verificationtable_col_email;

	@FXML
	private TableColumn<GetUnVerified, String> verificationtable_col_citizenbackimg;

	@FXML
	private TableColumn<GetUnVerified, String> verificationtable_col_citizenfrontimg;

	@FXML
	private TableColumn<GetUnVerified, String> verificationtable_col_citizenshipno;

	@FXML
	private TableColumn<GetUnVerified, String> verificationtable_col_dob;

	@FXML
	private TableColumn<GetUnVerified, String> verificationtable_col_employeeidimage;

	@FXML
	private TableColumn<GetUnVerified, String> verificationtable_col_phone;

	@FXML
	private TableColumn<GetUnVerified, String> verificationtable_col_name;

	@FXML
	private TableColumn<GetUnVerified, String> verificationtable_col_photo;

	@FXML
	private AnchorPane verifyvoter_form;

	@FXML
	private TextField voter_address_txt;
	
	@FXML
	private TextField voter_email;
	
	@FXML
	private TextField voter_phone;

	@FXML
	private ImageView voter_citizenshipback_img;
	@FXML
	private ImageView zoomedimage;

	@FXML
	private ImageView voter_citizenshipfront_img;
	
	@FXML
	private ImageView voter_zoomedimage;

	@FXML
	private TextField voter_citizenshipno_txt;

	@FXML
	private Button voter_delete_btn;

	@FXML
	private TextField voter_dob_txt;

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
	private Label voter_photo_name;
	
	@FXML
	private Label voter_employeeid_name;
	@FXML
	private Label voter_citizenshipfront_name;
	@FXML
	private Label voter_citizenshipback_name;
	

	@FXML
	private TextField unverified_id;

	@FXML
	private TextField unverified_email;

	@FXML
	private TableColumn<GetVoters, String> voter_tablecol_address;

	@FXML
	private TableColumn<GetVoters, String> voter_tablecol_citizenno;

	@FXML
	private TableColumn<GetVoters, String> voter_tablecol_citizenshipback;

	@FXML
	private TableColumn<GetVoters, String> voter_tablecol_citizenshipfront;

	@FXML
	private TableColumn<GetVoters, String> voter_tablecol_dob;
	
	
	@FXML
	private TableColumn<GetVoters, String> voter_tablecol_phone;
	@FXML
	private TableColumn<GetVoters, String> voter_tablecol_email;

	@FXML
	private TableColumn<GetVoters, String> voter_tablecol_employeeidimg;

	@FXML
	private TableColumn<GetVoters, Integer> voter_tablecol_id;

	@FXML
	private TableColumn<GetVoters, String> voter_tablecol_name;

	@FXML
	private TableColumn<GetVoters, String> voter_tablecol_photo;

	@FXML
	private TableView<GetVoters> voter_tableview;

	@FXML
	private ImageView review_citizenback;

	@FXML
	private ImageView review_citizenfront;

	@FXML
	private ImageView review_employeeid;

	@FXML
	private ImageView review_photo;

	@FXML
	private Label voter_total_txt;

	@FXML
	private Label position_error;

	@FXML
	private Label verification_id_txt;

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
	private Label unverified_error;
	@FXML
	private Label imagetwo_name;

	@FXML
	private Label remarks_txt;

	@FXML
	private AnchorPane admin_election_details_form;

	@FXML
	private AnchorPane admin_result_form;

	@FXML
	private Label confirm_pass_error;

	@FXML
	private Label current_pass_error;

	@FXML
	private Label new_pass_error;

	@FXML
	private Label photo_name;

	@FXML
	private Label employeeid_name;
	@FXML
	private Label citizenshipfront_name;
	@FXML
	private Label citizenshipback_name;
	
	@FXML
	private Label votererror_txt;
	
	@FXML
	private TextField search_txtfield;

	/*----------------------switch user-----------------------------------------*/
	public void switchscene(ActionEvent e) {
		if (e.getSource() == nav_startvoting_btn) {

			startelectionorshowdetails();

			admin_changepassword_form.setVisible(false);
			voter_form.setVisible(false);
			admin_result_form.setVisible(false);
			verifyvoter_form.setVisible(false);

			nav_startvoting_btn.setStyle("-fx-background-color:rgb(15, 120, 149);");
			nav_verifyvoter_btn.setStyle("-fx-background-color:transparent;");
			nav_publishresult_btn.setStyle("-fx-background-color:transparent;");
			nav_voter_btn.setStyle("-fx-background-color:transparent;");
			nav_changepassword_btn.setStyle("-fx-background-color:transparent;");

		} else if (e.getSource() == nav_verifyvoter_btn) {
			admin_strtvoting_form.setVisible(false);
			admin_changepassword_form.setVisible(false);
			voter_form.setVisible(false);
			admin_result_form.setVisible(false);
			verifyvoter_form.setVisible(true);

			admin_election_details_form.setVisible(false);

			nav_startvoting_btn.setStyle("-fx-background-color:transparent;");
			nav_verifyvoter_btn.setStyle("-fx-background-color:rgb(15, 120, 149);");
			nav_publishresult_btn.setStyle("-fx-background-color:transparent;");
			nav_voter_btn.setStyle("-fx-background-color:transparent;");
			nav_changepassword_btn.setStyle("-fx-background-color:transparent;");

		} else if (e.getSource() == nav_publishresult_btn) {
			admin_strtvoting_form.setVisible(false);
			admin_changepassword_form.setVisible(false);
			voter_form.setVisible(false);
			admin_result_form.setVisible(true);
			verifyvoter_form.setVisible(false);
			admin_election_details_form.setVisible(false);

			nav_startvoting_btn.setStyle("-fx-background-color:transparent;");
			nav_verifyvoter_btn.setStyle("-fx-background-color:transparent;");
			nav_publishresult_btn.setStyle("-fx-background-color:rgb(15, 120, 149);");
			nav_voter_btn.setStyle("-fx-background-color:transparent;");
			nav_changepassword_btn.setStyle("-fx-background-color:transparent;");

		} else if (e.getSource() == nav_voter_btn) {
			admin_strtvoting_form.setVisible(false);
			admin_changepassword_form.setVisible(false);
			voter_form.setVisible(true);
			admin_result_form.setVisible(false);
			verifyvoter_form.setVisible(false);
			admin_election_details_form.setVisible(false);

			nav_startvoting_btn.setStyle("-fx-background-color:transparent;");
			nav_verifyvoter_btn.setStyle("-fx-background-color:transparent;");
			nav_publishresult_btn.setStyle("-fx-background-color:tranparent;");
			nav_voter_btn.setStyle("-fx-background-color:rgb(15, 120, 149);");
			nav_changepassword_btn.setStyle("-fx-background-color:transparent;");

		} else if (e.getSource() == nav_changepassword_btn) {
			admin_strtvoting_form.setVisible(false);
			admin_changepassword_form.setVisible(true);
			voter_form.setVisible(false);
			admin_result_form.setVisible(false);
			verifyvoter_form.setVisible(false);
			admin_election_details_form.setVisible(false);

			nav_startvoting_btn.setStyle("-fx-background-color:transparent;");
			nav_verifyvoter_btn.setStyle("-fx-background-color:transparent;");
			nav_publishresult_btn.setStyle("-fx-background-color:tranparent;");
			nav_voter_btn.setStyle("-fx-background-color:transparent;");
			nav_changepassword_btn.setStyle("-fx-background-color:rgb(15, 120, 149);");
		}

	}

	/*------------------Start voting of admin dashboard----------------------------*/

	// ---------------------error null at
	// first--------------------------------------
	public void errorset() {
		position_error.setText("");
		candidateone_error.setText("");
		candidatetwo_error.setText("");
		candidateone_img_error.setText("");
		candidatetwo_img_error.setText("");
	}

//	--------------utility functions-------------
	Utility_Functions uf = new Utility_Functions();

	public void minimize() {
		uf.minimize(minimize_btn);
	}

	public void togglefullscreen() {
		uf.togglefullscreen(fullscreen_btn);
	}

	public void close() {
		uf.close();
	}

	public void logout() {
		uf.logout(nav_logout_btn);
	}

	File selectedFile_one;
	File selectedFile_two;

	// -----------------------------insert candidate one
	// image-----------------------------
	public void insertImageone() {
		FileChooser can1chooser = new FileChooser();
		Stage stage = (Stage) admin_strtvoting_form.getScene().getWindow();

		FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Image Files", "*.jpg", "*.jpeg",
				"*.png");
		can1chooser.getExtensionFilters().add(extFilter);

		selectedFile_one = can1chooser.showOpenDialog(stage);

		candidateimgadd(selectedFile_one, candidate_one_image, imageone_name);
	}

	// -----------------------------insert candidate one
	// image-----------------------------
	public void insertImagetwo() {
		FileChooser can2chooser = new FileChooser();
		Stage stage = (Stage) admin_strtvoting_form.getScene().getWindow();

		FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Image Files", "*.jpg", "*.jpeg",
				"*.png");
		can2chooser.getExtensionFilters().add(extFilter);

		selectedFile_two = can2chooser.showOpenDialog(stage);
		candidateimgadd(selectedFile_two, candidate_two_image, imagetwo_name);
	}

	// ------save the image to the imageview and set label with image
	// name--------------
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

	// -------------save candidates image into folder on
	// submit-------------------------
	public void candidateimgmoveintofolder(File file) throws IOException {
		Path imagePath = Paths.get("candidateimage");
		if (!Files.exists(imagePath)) {
			Files.createDirectories(imagePath);

		}

		// Copy the selected file to the "image" folder
		Path destinationPath = Paths.get("candidateimage", file.getName());

		Files.copy(file.toPath(), destinationPath, StandardCopyOption.REPLACE_EXISTING);

	}

	// ----------------remove all error when key is typed----------------------
	public void removeerrorwhiletyping() {
		position_error.setText("");
		candidateone_error.setText("");
		candidatetwo_error.setText("");
		candidateone_img_error.setText("");
		candidatetwo_img_error.setText("");
	}

	// -----------------startelectionbuttonfunction-----------------------------
	public void startElection() {

		Validations validation = new Validations();
		// checkposition
		if (position_name.getText().equals("") || position_name.getText().trim().isEmpty()
				|| position_name.getText() == null) {
			position_error.setText("Fill the position ");
		} else {
			String position = position_name.getText();
			Boolean result = (Boolean) validation.letteronlyregex(position);

			if (!result) {
				position_error.setText("Position can only contains letters");
			}
		}
		// candidate name
		if (admin_candidate_one_name.getText().equals("") || admin_candidate_one_name.getText().trim().isEmpty()
				|| admin_candidate_one_name.getText() == null) {

			candidateone_error.setText("Fill candidate Name ");

		} else {
			String candidate_one = admin_candidate_one_name.getText();
			Boolean candidate1 = (Boolean) validation.letteronlyregex(candidate_one);

			if (!candidate1) {

				candidateone_error.setText("Candidate can only contains letters ");
			}

		}
		// candidate two name
		if (admin_candidate_two_name.getText().equals("") || admin_candidate_two_name.getText().trim().isEmpty()
				|| admin_candidate_two_name.getText() == null) {

			candidatetwo_error.setText("Fill candidate Name ");

		} else {
			String candidate_one = admin_candidate_two_name.getText();
			Boolean candidate1 = (Boolean) validation.letteronlyregex(candidate_one);

			if (!candidate1) {
				candidatetwo_error.setText("Candidates can only contains letters ");
			}

		}
		// candidate one image
		if (imageone_name.getText().equals("No image Selected")) {
			candidateone_img_error.setText("candidate image not selected");
		}
		// candidate two image
		if (imagetwo_name.getText().equals("No image Selected")) {
			candidatetwo_img_error.setText("candidate image not selected");
		}

		// save function to save into folder

		if (position_error.getText().equals("") && candidateone_error.getText().equals("")
				&& candidatetwo_error.getText().equals("") && candidateone_img_error.getText().equals("")
				&& candidatetwo_img_error.getText().equals("")) {
			try {
				candidateimgmoveintofolder(selectedFile_one);
				candidateimgmoveintofolder(selectedFile_two);
			} catch (Exception e) {

			}

			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Start Election Confirmation");
			alert.setHeaderText(null);
			alert.setContentText("Do you Want to Start Election?");

			Optional<ButtonType> option = alert.showAndWait();

			if (option.get().equals(ButtonType.OK)) {
				Adminsql election = new Adminsql();
				election.startElection(position_name.getText(), admin_candidate_one_name.getText(),
						imageone_name.getText(), admin_candidate_two_name.getText(), imagetwo_name.getText());

			}

		}
	}

	// it is used to check whether a election is going on or not
	public void startelectionorshowdetails() {
		try {
			Conn c = new Conn();
			String sql = "select count(*) as row_count from election";

			ResultSet rs = c.s.executeQuery(sql);
			Integer row = null;
			while (rs.next()) {
				row = rs.getInt("row_count");
			}

			if (row == 0) {
				admin_strtvoting_form.setVisible(true);

			} else {
				admin_election_details_form.setVisible(true);
			}

		} catch (Exception ae) {
			ae.printStackTrace();
		}
	}

	/*---------------------Change Password-------------------------*/

	Validations validation = new Validations();

	public void passworderrorset() {
		current_pass_error.setText("");
		new_pass_error.setText("");
		confirm_pass_error.setText("");
	}

	public void shownewpass() {
		validation.showPassword(admin_newshow_checkbox, admin_cp_new);
	}

	public void showconfirmpass() {
		validation.showPassword(admin_confirmshow_checkbox, admin_cp_confirm);
	}

	public void changepassword() {
		Adminsql as = new Adminsql();

		ChangePassword cp = new ChangePassword();
		cp.changepassword(admin_cp_current, admin_cp_new, admin_cp_confirm, current_pass_error, new_pass_error,
				confirm_pass_error);

	}

	/*---------------------Verify-voter---------------------------*/
	// FOR TABLE DATA
	ObservableList<GetUnVerified> listdata;

	public ObservableList<GetUnVerified> dataList() {
		Conn c = new Conn();
		listdata = FXCollections.observableArrayList();
		String sql = "select * from unverified_voters";

		try {
			ResultSet result = c.s.executeQuery(sql);
			GetUnVerified data;
			while (result.next()) {
				data = new GetUnVerified(result.getInt("id"), result.getString("email"), result.getString("phone"),
						result.getString("fullname"), result.getString("dob"), result.getString("address"),
						result.getString("citizenshipno"), result.getString("photo"), result.getString("employee_id"),
						result.getString("citizenship_front"), result.getString("citizenship_back"));
				listdata.add(data);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listdata;

	}

	// To show data
	public void showUnverified() {
		ObservableList<GetUnVerified> showList = dataList();

		verificationtable_col_phone.setCellValueFactory(new PropertyValueFactory<>("Phone"));
		verificationtable_col_name.setCellValueFactory(new PropertyValueFactory<>("Name"));
		verificationtable_col_dob.setCellValueFactory(new PropertyValueFactory<>("Dob"));
		verificationtable_col_citizenshipno.setCellValueFactory(new PropertyValueFactory<>("Citizenshipno"));
		verificationtable_col_photo.setCellValueFactory(new PropertyValueFactory<>("Photo"));
		verificationtable_col_employeeidimage.setCellValueFactory(new PropertyValueFactory<>("Employeeid"));
		verificationtable_col_citizenfrontimg.setCellValueFactory(new PropertyValueFactory<>("Citizenshipfront"));
		verificationtable_col_citizenbackimg.setCellValueFactory(new PropertyValueFactory<>("Citizenshipback"));
		verificationtable_col_address.setCellValueFactory(new PropertyValueFactory<>("Address"));
		verificationtable_col_id.setCellValueFactory(new PropertyValueFactory<>("Id"));
		verificationtable_col_email.setCellValueFactory(new PropertyValueFactory<>("Email"));

		verification_tableview.setItems(showList);

	}

	public void selectUnverified() {

		GetUnVerified data = verification_tableview.getSelectionModel().getSelectedItem();

		int num = verification_tableview.getSelectionModel().getSelectedIndex();

		if ((num - 1) < -1)
			return;

		unverified_id.setText(String.valueOf(data.getId()));
		unverified_email.setText(data.getEmail());

		verification_phone_txt.setText(data.getPhone());
		verification_name_txt.setText(data.getName());
		verification_dob_txt.setText(data.getDob());
		verification_address_txt.setText(data.getAddress());
		verification_citizenshpno_txt.setText(data.getCitizenshipno());

		photo_name.setText(data.getPhoto());
		employeeid_name.setText(data.getEmployeeid());
		citizenshipfront_name.setText(data.getCitizenshipfront());
		citizenshipback_name.setText(data.getCitizenshipback());

		try {
			Image photoimage = new Image("file:" + "votersimages/" + photo_name.getText());
			review_photo.setImage(photoimage);

			Image employeeidimage = new Image("file:" + "votersimages/" + employeeid_name.getText());
			review_employeeid.setImage(employeeidimage);

			Image citizenshipfrontimage = new Image("file:" + "votersimages/" + citizenshipfront_name.getText());
			review_citizenfront.setImage(citizenshipfrontimage);

			Image citizenshipbackimage = new Image("file:" + "votersimages/" + citizenshipback_name.getText());
			review_citizenback.setImage(citizenshipbackimage);
		} catch (Exception e) {

		}

	}

	/*-------------------Zoom photo for review-------------------------*/
	public void Zoomphoto() {
		zoomUnverifiedImage(photo_name.getText());
	}

	public void ZoomEmployeeid() {
		zoomUnverifiedImage(employeeid_name.getText());
	}

	public void Zoomcitizenfront() {
		zoomUnverifiedImage(citizenshipfront_name.getText());
	}

	public void Zoomcitizenback() {
		zoomUnverifiedImage(citizenshipback_name.getText());
	}

	public void zoomUnverifiedImage(String imagename) {
		Image photoimage = new Image("file:" + "votersimages/" + imagename);
		zoomedimage.setImage(photoimage);
	}

	/*----------------Approve or reject unverified--------------*/

	public void approve() {
		if (unverified_id.getText().equals("")
				|| unverified_id.getText() == null && unverified_id.getText().isEmpty()) {

			unverified_error.setText("Select a row from the table");
		} else {

			Conn c = new Conn();

			String sql = "insert into status (id,phone,citizenshipno,dob,remarks,status) values ('"
					+ Integer.parseInt(unverified_id.getText()) + "','" + verification_phone_txt.getText() + "','"
					+ verification_citizenshpno_txt.getText() + "','" + verification_dob_txt.getText() + "','"
					+ verification_reason_txt.getText() + "','Approved')";

			String sql2 = "insert into voters values('" + Integer.parseInt(unverified_id.getText()) + "','"
					+ verification_name_txt.getText() + "','" + unverified_email.getText() + "','"
					+ verification_phone_txt.getText() + "','" + verification_dob_txt.getText() + "','"
					+ verification_address_txt.getText() + "','" + verification_citizenshpno_txt.getText() + "','"
					+ photo_name.getText() + "','" + employeeid_name.getText() + "','" + citizenshipfront_name.getText()
					+ "','" + citizenshipback_name.getText() + "')";

			String password = null;
			try {

				String sql3 = "select password from unverified_voters where id ='"
						+ Integer.parseInt(unverified_id.getText()) + "'";
				ResultSet rs = c.s.executeQuery(sql3);
				if (rs.next()) {
					password = rs.getString("password");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

			String sql4 = " insert into voter_login values ('" + Integer.parseInt(unverified_id.getText()) + "','"
					+ verification_phone_txt.getText() + "','" + password + "')";

			try {
				int affectedrow1 = c.s.executeUpdate(sql);
				int affectedrow2 = c.s.executeUpdate(sql2);
				int affectedrow4 = c.s.executeUpdate(sql4);

				if (affectedrow1 > 0 && affectedrow2 > 0 && affectedrow4 > 0) {
					String sql5 = "delete from unverified_voters where id='" + Integer.parseInt(unverified_id.getText())
							+ "'";
					int affectedrow5 = c.s.executeUpdate(sql5);

					if (affectedrow5 > 0) {
						Alert alert = new Alert(AlertType.INFORMATION);
						alert.setTitle("Approved");
						alert.setHeaderText(null);
						alert.setContentText("Voter Approved successfully");
						alert.show();
						showUnverified();
						showVoters();
					}

				} else {
					Alert alert = new Alert(AlertType.ERROR);
					alert.setTitle("Error");
					alert.setHeaderText(null);
					alert.setContentText("Something went Wrong");
					alert.show();
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}

	public void reject() {
		if (unverified_id.getText().equals("")
				|| unverified_id.getText() == null && unverified_id.getText().isEmpty()) {

			unverified_error.setText("Select a row from the table");
		} else {
			if (verification_reason_txt.getText().equals("")
					|| verification_reason_txt.getText() == null && verification_reason_txt.getText().isEmpty()) {
				remarks_txt.setText("Reason Required for Rejection");
			} else {
				Conn c = new Conn();
				String sql = "delete from unverified_voters where id='" + Integer.parseInt(unverified_id.getText())
						+ "'";
				try {
					int affectedrow = c.s.executeUpdate(sql);
					showUnverified();

					if (affectedrow > 0) {
						Alert alert = new Alert(AlertType.INFORMATION);
						alert.setTitle("Rejected");
						alert.setHeaderText(null);
						alert.setContentText("Voter Approved Rejected");
						alert.show();
						showUnverified();
					}
				} catch (Exception e) {

				}
			}

		}
	}

	
	/*--------------------------------voter table-------------------*/
	// FOR TABLE DATA
		
	ObservableList<GetVoters> voterlistdata;

	public ObservableList<GetVoters> voterdataList() {
		Conn c = new Conn();
		voterlistdata = FXCollections.observableArrayList();
		String sql = "select * from  voters";

		try {
			ResultSet result = c.s.executeQuery(sql);
			GetVoters data;
			while (result.next()) {
				data = new GetVoters(result.getInt("id"), result.getString("email"), result.getString("phone"),
						result.getString("name"), result.getString("dob"), result.getString("address"),
						result.getString("citizenshipno"), result.getString("photo"), result.getString("employee_id"),
						result.getString("citizenshipfront"), result.getString("citizenshipback"));
				voterlistdata.add(data);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return voterlistdata;

	}

	// To show data
	public void showVoters() {
		ObservableList<GetVoters> showList = voterdataList();

		voter_tablecol_phone.setCellValueFactory(new PropertyValueFactory<>("Phone"));
		voter_tablecol_name.setCellValueFactory(new PropertyValueFactory<>("Name"));
		voter_tablecol_dob.setCellValueFactory(new PropertyValueFactory<>("Dob"));
		voter_tablecol_citizenno.setCellValueFactory(new PropertyValueFactory<>("Citizenshipno"));
		voter_tablecol_photo.setCellValueFactory(new PropertyValueFactory<>("Photo"));
		voter_tablecol_employeeidimg.setCellValueFactory(new PropertyValueFactory<>("Employeeid"));
		voter_tablecol_citizenshipfront.setCellValueFactory(new PropertyValueFactory<>("Citizenshipfront"));
		voter_tablecol_citizenshipback.setCellValueFactory(new PropertyValueFactory<>("Citizenshipback"));
		voter_tablecol_address.setCellValueFactory(new PropertyValueFactory<>("Address"));
		voter_tablecol_id.setCellValueFactory(new PropertyValueFactory<>("Id"));
		voter_tablecol_email.setCellValueFactory(new PropertyValueFactory<>("Email"));

		voter_tableview.setItems(showList);

	}

	public void selectVoters() {

		GetVoters data = voter_tableview.getSelectionModel().getSelectedItem();

		int num = voter_tableview.getSelectionModel().getSelectedIndex();

		if ((num - 1) < -1)
			return;

		voter_id_txt.setText(String.valueOf(data.getId()));
		voter_email.setText(data.getEmail());

		voter_phone.setText(data.getPhone());
		voter_name_txt.setText(data.getName());
		voter_dob_txt.setText(data.getDob());
		voter_address_txt.setText(data.getAddress());
		voter_citizenshipno_txt.setText(data.getCitizenshipno());

		voter_photo_name.setText(data.getPhoto());
		voter_employeeid_name.setText(data.getEmployeeid());
		voter_citizenshipfront_name.setText(data.getCitizenshipfront());
		voter_citizenshipback_name.setText(data.getCitizenshipback());

		try {
			Image photoimage = new Image("file:" + "votersimages/" + voter_photo_name.getText());
			voter_photo_img.setImage(photoimage);

			Image employeeidimage = new Image("file:" + "votersimages/" + voter_employeeid_name.getText());
			voter_employeeid_img.setImage(employeeidimage);

			Image citizenshipfrontimage = new Image("file:" + "votersimages/" + voter_citizenshipfront_name.getText());
			voter_citizenshipfront_img.setImage(citizenshipfrontimage);

			Image citizenshipbackimage = new Image("file:" + "votersimages/" + voter_citizenshipback_name.getText());
			voter_citizenshipback_img.setImage(citizenshipbackimage);
		} catch (Exception e) {

		}

	}
	
	public void VoterSearch() {
		FilteredList<GetVoters> filter = new FilteredList<>(voterlistdata, e -> true);
		search_txtfield.textProperty().addListener((Observable, oldValue, newValue) -> {

			filter.setPredicate(predicateVoterData -> {
				if (newValue == null || newValue.isEmpty()) {
					return true;
				}
				String searchkey = newValue.toLowerCase();

				if (predicateVoterData.getId().toString().contains(searchkey)) {
					return true;
				} else if (predicateVoterData.getName().toLowerCase().contains(searchkey)) {
					return true;
				} else if (predicateVoterData.getCitizenshipno().toString().contains(searchkey)) {
					return true;
				} else if (predicateVoterData.getEmail().toLowerCase().contains(searchkey)) {
					return true;
					
				}else if(predicateVoterData.getDob().contains(searchkey)) {
					return true;
				}else if (predicateVoterData.getPhone().toLowerCase().contains(searchkey)) {
						return true;
					
				} else
					return false;

			});
		});

		SortedList<GetVoters> sortList = new SortedList<>(filter);
		sortList.comparatorProperty().bind(voter_tableview.comparatorProperty());
		voter_tableview.setItems(sortList);
	}

	
	/*------------zoom voter image-----------------------*/
	public void Zoomvoterphoto() {
		zoomVoterImage(voter_photo_name.getText());
	}

	public void ZoomvoterEmployeeid() {
		zoomVoterImage(voter_employeeid_name.getText());
	}

	public void Zoomvotercitizenfront() {
		zoomVoterImage(voter_citizenshipfront_name.getText());
	}

	public void Zoomvotercitizenback() {
		zoomVoterImage(voter_citizenshipback_name.getText());
	}
	
	public void zoomVoterImage(String imagename) {
		Image photoimage = new Image("file:" + "votersimages/" + imagename);
		voter_zoomedimage.setImage(photoimage);
	}
	
	/*------------------Delete voter --------------------------*/
	
	public void deletevoter() {
		if (voter_id_txt.getText().equals("")
				|| voter_id_txt.getText() == null && voter_id_txt.getText().isEmpty()) {

			votererror_txt.setText("Select a row from the table");
		} else {
			
			String delete_status = "delete from status where id ='"+voter_id_txt.getText()+"'";
			String delete_voterlogin="delete from voter_login where id ='"+voter_id_txt.getText()+"'";
			String delete_voter ="delete from voters where id = '"+voter_id_txt.getText()+"'";
			
			
			
			Alert alert  = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Confirmation");
			alert.setHeaderText(null);
			alert.setContentText("Are you sure want to delete the voter id ='"+voter_id_txt.getText()+"'");
			
			Optional<ButtonType> option = alert.showAndWait();

			if (option.get().equals(ButtonType.OK)) {
				try {
					Conn c = new Conn();
					
					int affectedrow1 = c.s.executeUpdate(delete_status);
					int affectedrow2 = c.s.executeUpdate(delete_voterlogin);
					int affectedrow3 = c.s.executeUpdate(delete_voter);
					
					
					if(affectedrow1>0 && affectedrow2>0 && affectedrow3>0) {
						
						Alert alert2  = new Alert(AlertType.INFORMATION);
						alert2.setTitle("Successfully deleted");
						alert2.setHeaderText(null);
						alert2.setContentText("Voter Deleted Successfully");
						alert2.show();
						showVoters();
						
					}else {
						Alert alert3  = new Alert(AlertType.ERROR);
						alert3.setTitle("Failed");
						alert3.setHeaderText(null);
						alert3.setContentText("Voter Deletion Failed");
						alert3.show();
					}
					
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
			
		
			
		}
	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		errorset();
		startelectionorshowdetails();

		// changepassword
		passworderrorset();

		// unverified
		showUnverified();
		
		
		//voters
		showVoters();
		
		//search voter
		VoterSearch();
	}

}
