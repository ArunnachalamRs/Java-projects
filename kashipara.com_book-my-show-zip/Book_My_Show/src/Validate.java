import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validate {
	
	public static boolean validateText(String st ){
		
		
		if(st.length()>2){
			
			Pattern special = Pattern.compile ("[!@#$%&*()_+=|<>?{}\\[\\]~-]");			
			Pattern digit = Pattern.compile("[0-9]");
			
			Matcher hasSpecial = special.matcher(st);
			Matcher hasDigit = digit.matcher(st);
			
					return hasSpecial.find()||hasDigit.find(); 
			}
		
		else {
			return false;
		}
	}

}
