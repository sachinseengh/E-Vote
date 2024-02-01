package EVote;

import java.sql.ResultSet;
import java.time.LocalDate;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

class Votersql {

	public void RegisterVoter(String fullname, String email, String phone, String localDate, String address,
			String voter_password, String citizenshipno, String passportsize_photo, String employee_id,
			String citizenship_front, String citizenship_back) {

		String sql = "insert into unverified_voters values ('" + fullname + "','" + email + "'," + "'" + phone + "','"
				+ localDate + "','" + address + "'," + "'" + voter_password + "','" + citizenshipno + "','"
				+ passportsize_photo + "','" + employee_id + "','" + citizenship_front + "','" + citizenship_back
				+ "')";

		try {
			Conn c = new Conn();
			int affectedrow = c.s.executeUpdate(sql);

			if (affectedrow > 0) {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Successfull");
				alert.setHeaderText(null);
				alert.setContentText("Registration form submitted successfully");
				alert.show();

			} else {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Failed");
				alert.setHeaderText(null);
				alert.setContentText("Registration form submission failed");
				alert.show();
			}

		} catch (Exception e) {

		}

	}

	public void changePassword(String newpassword) {
		try {
			Conn c = new Conn();
			String sql = "update voter_login set password = '" + newpassword + "' where phone = '" + getDetails.phone
					+ "' and id='" + getDetails.id + "'";

			int affectedrow = c.s.executeUpdate(sql);

			if (affectedrow > 0) {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Successfull");
				alert.setHeaderText(null);
				alert.setContentText("Password Changed successfully");
				alert.show();

			} else {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Failed");
				alert.setHeaderText(null);
				alert.setContentText("Failed to change password");
				alert.show();
			}
		} catch (Exception e) {

		}

	}

	public String checkPassword() {
		String password = null;
		try {
			Conn c = new Conn();
			String sql = "select password from voter_login where phone='" + getDetails.phone + "' and id ='"
					+ getDetails.id + "'";
			ResultSet rs = c.s.executeQuery(sql);

			if (rs.next()) {
				password = rs.getString("password");
			}
			return password;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public void showcandidate(ImageView candidate_one, RadioButton candidate_one_radio, ImageView candidate_two,
			RadioButton candidate_two_radio,Label position,Label electiondate) {
		String sql = "select * from election";

		try {
			Conn c = new Conn();
			ResultSet rs = c.s.executeQuery(sql);

			if (rs.next()) {
				Image c_one = new Image("file:" + "candidateimage/" +rs.getString("candidate_one_img"));
				candidate_one.setImage(c_one);
				
				Image c_two = new Image("file:" + "candidateimage/" +rs.getString("candidate_two_img"));
				candidate_two.setImage(c_two);
				
				candidate_one_radio.setText(rs.getString("candidate_one_name"));
				candidate_two_radio.setText(rs.getString("candidate_two_name"));
				position.setText(rs.getString("position"));
				electiondate.setText(String.valueOf(rs.getDate("Election_date")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
