package EVote;

import java.sql.ResultSet;
import java.util.Date;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

class Adminsql {

	public void adminRegister(String org_name, String phone, String password, String election_code, String logo) {

		String sql = "insert into admins_details(org_name,phone,password,election_code,logo) " + "values('" + org_name
				+ "','" + phone + "','" + password + "','" + election_code + "','" + logo + "')";

		String sql2 = "insert into admin(phone,password,election_code) values('" + phone + "','" + password + "','"
				+ election_code + "')";

		try {

			Conn c = new Conn();
			int affected_row = c.s.executeUpdate(sql);

			if (affected_row > 0) {
				c.s.executeUpdate(sql2);
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Success");
				alert.setHeaderText(null);
				alert.setContentText("Registered successfully ! You can Login with you phone and password");
				alert.show();
			} else {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Failed");
				alert.setHeaderText(null);
				alert.setContentText("Registration Failed!");
				alert.show();
				return;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean checkNumber(String number) {
		String sql = "Select phone from admin where phone='" + number + "'";
		int count = 0;
		try {
			Conn c = new Conn();
			ResultSet rs = c.s.executeQuery(sql);
			if (rs.next()) {
				count++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (count == 0) {
			return false;
		} else {
			return true;
		}

	}

	public boolean electionCode(String code) {
		String sql = "Select election_code from admin where election_code='" + code + "'";
		int count = 0;
		try {
			Conn c = new Conn();
			ResultSet rs = c.s.executeQuery(sql);
			if (rs.next()) {
				count++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (count == 0) {
			return false;
		} else {
			return true;
		}

	}

	public void startElection(String position, String candidate_one_name, String candidate_one_img,
			String candidate_two_name, String candidate_two_img) {

		Date date = new Date();
		java.sql.Date votingdate = new java.sql.Date(date.getTime());

		try {
			Conn c = new Conn();

			

			String sql = "INSERT INTO election (org_code, position, candidate_one_name, candidate_one_img, candidate_two_name, candidate_two_img, Election_date) VALUES ('"
					+ getAdminDetails.election_code + "','" + position + "','" + candidate_one_name + "','"
					+ candidate_one_img + "','" + candidate_two_name + "','" + candidate_two_img + "','" + votingdate
					+ "')";
			

			c.s.executeUpdate(sql);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public String checkPassword() {
		String password = null;
		try {
			Conn c = new Conn();
			String sql = "select password from admin where phone='"+getAdminDetails.phone+"'";
		
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

	public void changePassword(String newpassword) {
		try {
			Conn c = new Conn();
			String sql = "update admin set password = '" + newpassword + "' where phone = '"+getAdminDetails.phone+"'";

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

}