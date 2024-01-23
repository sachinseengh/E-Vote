package EVote;

import java.sql.ResultSet;
import java.util.Date;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

class Adminsql {

	public void startElection(String position, String candidate_one_name, String candidate_one_img,
			String candidate_two_name, String candidate_two_img) {

		Date date = new Date();
		java.sql.Date votingdate = new java.sql.Date(date.getTime());

		try {
			Conn c = new Conn();

			String sql = "insert into election values(1,'" + position + "','" + candidate_one_name + "','"
					+ candidate_one_img + "'," + "'" + candidate_two_name + "','" + candidate_two_img + "','"
					+ votingdate + "')";

			c.s.executeUpdate(sql);

		} catch (Exception e) {

		}

	}

	public String checkPassword() {
		String password = null;
		try {
			Conn c = new Conn();
			String sql = "select password from admin where username='admin'";
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
			String sql ="update admin set password = '"+newpassword+"' where username = 'admin'";
			
			int affectedrow = c.s.executeUpdate(sql);
			
			if(affectedrow > 0) {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Successfull");
				alert.setHeaderText(null);
				alert.setContentText("Password Changed successfully");
				alert.show();
				
			}else {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Failed");
				alert.setHeaderText(null);
				alert.setContentText("Failed to change password");
				alert.show();
			}
		}catch(Exception e) {
			
		}

	}

}