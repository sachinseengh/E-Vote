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

	public void RegisterVoter(String org_code, String fullname, String email, String phone, String localDate,
			String address, String voter_password, String citizenshipno, String passportsize_photo, String employee_id,
			String citizenship_front, String citizenship_back) {

		String sql = "insert into unverified_voters(org_code,fullname,email,phone,dob,address,citizenshipno,photo,employee_id,citizenship_front,citizenship_back,password) values ("
				+ "'"+org_code+"','" + fullname + "','" + email + "'," + "'" + phone + "','" + localDate + "','" + address + "','"
				+ citizenshipno + "','" + passportsize_photo + "','" + employee_id + "','" + citizenship_front + "','"
				+ citizenship_back + "','" + voter_password + "')";

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
	
	
	
	public String setOrganizationName(String code) {
		Conn c= new Conn();
		String name =null;
		try {
			
			String sql ="select org_name from admins_details where org_code ='"+code+"'";
			ResultSet rs= c.s.executeQuery(sql);
			
			if(rs.next()) {
			  name= rs.getString("org_name");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return name;
	}

	public void changePassword(String newpassword) {
		try {
			Conn c = new Conn();
			String sql = "update voter_login set password = '" + newpassword + "' where phone = '" + getDetails.phone
					+ "'  and org_code='"+getDetails.org_code+"'";

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
			String sql = "select password from voter_login where phone='" + getDetails.phone + "' and org_code='"+getDetails.org_code+"'";
			System.out.println(sql);
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
			RadioButton candidate_two_radio, Label position, Label electiondate,Label org_name) {
		String sql = "select * from election where org_code='"+getDetails.org_code+"'";

		try {
			Conn c = new Conn();
			ResultSet rs = c.s.executeQuery(sql);

			if (rs.next()) {
				Image c_one = new Image("file:" + "candidateimage/" + rs.getString("candidate_one_img"));
				candidate_one.setImage(c_one);

				Image c_two = new Image("file:" + "candidateimage/" + rs.getString("candidate_two_img"));
				candidate_two.setImage(c_two);

				candidate_one_radio.setText(rs.getString("candidate_one_name"));
				candidate_two_radio.setText(rs.getString("candidate_two_name"));
				position.setText(rs.getString("position"));
				electiondate.setText(String.valueOf(rs.getDate("Election_date")));
				org_name.setText(getDetails.org_name);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void vote(String candidate) {
		String sql = "insert into votes(citizenshipno,votefor) values ('" + getDetails.citizenshipno + "','" + candidate
				+ "')";
		try {
			Conn c = new Conn();
			int affected_row = c.s.executeUpdate(sql);

			if (affected_row > 0) {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("successful");
				alert.setHeaderText(null);
				alert.setContentText("Voted Successfully");
				alert.show();

			} else {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Failed");
				alert.setHeaderText(null);
				alert.setContentText("Failed to vote");
				alert.show();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// for registration

	public boolean checkNumber(String number) {
		String sql = "Select phone from voters where phone='" + number + "' and  org_code='"+getAdminDetails.org_code+"'";
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

	public boolean checkCitizenshipno(String citizenshipno) {
		String sql = "Select citizenshipno from voters where citizenshipno='" + citizenshipno + "' and org_code='"+getAdminDetails.org_code+"'";
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

	public boolean checkOrgCode(String code) {
		String sql = "Select org_code from admin where org_code='" + code + "'";
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

	

}
