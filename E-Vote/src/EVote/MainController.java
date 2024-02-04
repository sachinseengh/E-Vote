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
	private Label status;
	@FXML
	private Label reason_txt;
	@FXML
	private DatePicker date_datepicker;

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
			admin_working_area.setVisible(true);
			voter_working_area.setVisible(false);
			voter_checkstatus_form.setVisible(false);
			published_result_form.setVisible(false);

		} else if (e.getSource() == admin_voter_login) {
			admin_working_area.setVisible(false);
			voter_working_area.setVisible(true);

		} else if (e.getSource() == voter_registernow) {
			voter_registernow.getScene().getWindow().hide();
			registrationOpen();

		} else if (e.getSource() == voter_registrationstatus) {
			voter_working_area.setVisible(false);
			voter_checkstatus_form.setVisible(true);

		} else if (e.getSource() == voter_viewresult) {

//    		i will call a function which is there is result then the result 
			// and if there is result then result

			published_result_form.setVisible(true);
			voter_working_area.setVisible(false);
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

				String sql = "select * from admin where username='" + admin_username.getText() + "'" + " and password='"
						+ admin_password.getText() + "'";

				ResultSet rs = c.s.executeQuery(sql);

				if (rs.next()) {

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
		if (voter_phoneno.getText().isEmpty() || voter_password.getText().isEmpty()
				|| voter_phoneno.getText().equals("") || voter_password.getText().equals("")
				|| voter_phoneno.getText().trim().isEmpty() || voter_password.getText().trim().isEmpty()) {

			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Login ");
			alert.setHeaderText(null);
			alert.setContentText("Fill the Blanks Fields");
			alert.showAndWait();

		} else {
			try {
				Conn c = new Conn();

				String sql = "select * from voter_login where phone='" + voter_phoneno.getText() + "'"
						+ " and password='" + voter_password.getText() + "'";

				ResultSet rs = c.s.executeQuery(sql);

				if (rs.next()) {

					// it can be used to show the name of voter in voter dashboard
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
			if(rs.next()) {
				status.setText(rs.getString("status"));
				reason_txt.setText(rs.getString("remarks"));
			}else {
				status.setText("Details didn't match");
				reason_txt.setText("");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		// show result
		showResult();
	}

}
