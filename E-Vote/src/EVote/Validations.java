package EVote;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;

class Validations{
	
	public Boolean letteronlyregex(String txt) {
		String regex = "^[a-zA-Z\\s]+$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(txt);
		return matcher.matches();
	}

	public Boolean hasDigit(String txt) {
		String regex = ".*\\d.*";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(txt);
		return matcher.matches();
	}

	public Boolean hasAlphabet(String txt) {
		String regex = ".*[a-zA-Z].*";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(txt);
		return matcher.matches();
	}

	public Boolean hasSpecialCharacter(String txt) {
		String regex = ".*[_#@#].*";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(txt);
		return matcher.matches();
	}

	public Boolean PasswordValidation(String txt) {
		String regex = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d_#@$]+$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(txt);
		return matcher.matches();
	}
	
	
	
	
	public Boolean numberonly(String txt) {
		String regex = "^(98|96|97)\\d{8}$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(txt);
		return matcher.matches();
	}
		
	
	public Boolean emailvalidation(String txt) {
		String regex = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,3}$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(txt);
		return matcher.matches();
	}
	
	public Boolean citizenshipnovalidator(String txt) {
		String regex = "^(\\d+/\\d+)|(\\d+-\\d+-\\d+-\\d+)|(\\d){8}$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(txt);
		return matcher.matches();
	}
	
	
	
	
	
	public void showPassword(CheckBox checkbox,PasswordField passwordfield) {
		if(checkbox.isSelected()) {
			passwordfield.setPromptText(passwordfield.getText());
			passwordfield.setText("");
		}else {
			passwordfield.setText(passwordfield.getPromptText());
			passwordfield.setPromptText("");
		
		}
		
	}
	
}