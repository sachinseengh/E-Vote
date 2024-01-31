package EVote;

import java.sql.ResultSet;
import java.time.LocalDate;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

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
			int affectedrow=c.s.executeUpdate(sql);
			
			
			if(affectedrow > 0) {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Successfull");
				alert.setHeaderText(null);
				alert.setContentText("Registration form submitted successfully");
				alert.show();
				
			}else {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Failed");
				alert.setHeaderText(null);
				alert.setContentText("Registration form submission failed");
				alert.show();
			}
			
			
			
			
		}catch(Exception e) {
			
		}
		

	}

	
	
	
	public void changePassword(String newpassword) {
		try {
			Conn c = new Conn();
			String sql ="update voter_login set password = '"+newpassword+"' where phone = 'admin'";
			
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
}