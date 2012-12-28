package rutgers.cs213.android.util;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import rutgers.cs213.android.model.Tag;

/**
 * @author Brian Battell
 *
 */
public class PhotoAlbumTokenizer {

	/** Parses data into tokens
	 * 
	 * 
	 */
	
	/**
	 * Tokenize User Input strings in array of tokens
	 * @author Brian Battell
	 * @param Input		User Input
	 * 
	 * @return String[]	Array of Strings
	 */
	public static String[] Tokenize(String Input) {
		ArrayList<String> tokens = new ArrayList<String>();
		String token = "";
		boolean quoteOn = false;
		for(int i = 0; i < Input.length(); i++) {
			char character = Input.charAt(i);
			if (character == '"') {
				if (quoteOn){
					quoteOn = false;
				}
				else	
					quoteOn = true;
			}
			else if (character == ' ' && !quoteOn) {
				tokens.add(token);
				token = "";
			}
			else
				token = token + character;
				
		}
		
		if (quoteOn) {
			//last token invalid
			token = "";
		}
		
		if (token.length() > 0)
			tokens.add(token);
		
		String[] strtokens = new String[tokens.size()];
		tokens.toArray(strtokens);
		return strtokens;
	}
	
	/**
	 * Tokenize Tag Input strings in array of tokens
	 * @author Brian Battell
	 * @param Input		Sting Input 
	 * 
	 * @return String[]	Array of Tag objects
	 */
	public static Tag[] TokenizeTag(String Input) {
		ArrayList<Tag> tokens = new ArrayList<Tag>();
		String token = "";
		boolean quoteOn = false;
		for(int i = 0; i < Input.length(); i++) {
			char character = Input.charAt(i);
			if (character == '"') {
				if (quoteOn){
					quoteOn = false;
				}
				else	
					quoteOn = true;
			}
			else if (character == ' ' && !quoteOn) {
				Tag curr_tag = makeTag(token);
				if (curr_tag != null)
					tokens.add(curr_tag);
				token = "";
			}
			else
				token = token + character;
				
		}
		
		if (quoteOn) {
			//last token invalid
			token = "";
		}
		
		if (token.length() > 0) {
			Tag curr_tag = makeTag(token);
			if (curr_tag != null)
				tokens.add(curr_tag);
		}
		
		Tag[] arr_tokens = new Tag[tokens.size()];
		tokens.toArray(arr_tokens);
		return arr_tokens;
	}
	
	/**
	 * Create Tag from input string
	 * @author Brian Battell
	 * @param Input		String Input
	 * 
	 * @return Tag object
	 */
	public static Tag makeTag(String Input) {
		Tag tag = null;
		String[] strtag = Input.split(":");
		if (strtag.length == 2) {
			String type = strtag[0];
			String value = strtag[1];
			tag = new Tag(type, value);
		}
		else if (strtag.length == 1) {
			String value = strtag[0];
			tag = new Tag("", value);
		}
		return tag;
	}
	
	/**
	 * Date valid Input string for date
	 * @author Brian Battell
	 * @param Input		String DateString
	 * 
	 * @return boolean (true or false)
	 */ 
	public static boolean isDateValid(String DateString) {
		boolean isDate = false;
		String[] strdate = DateString.split("/");
		if (strdate.length < 3)
			return isDate;
		
		if ((!isNumber(strdate[0])) || (!isNumber(strdate[1])) || (!isNumber(strdate[2])))
			return isDate;
		
		int month = Integer.parseInt(strdate[0]);
		int day = Integer.parseInt(strdate[1]);
		int year = Integer.parseInt(strdate[2]);
		
		if (((month < 1) || (month > 12)) || ((day < 1) || (day > 31)) || (strdate[2].length() != 4))
			return isDate;
		
		try {
			Calendar date = Calendar.getInstance();
			date.set(year, month - 1, day);
                        date.setLenient(false);
			date.getTime();
			isDate = true;
		}
		catch (Exception ex) {
			return isDate;
		}
		
		return isDate;
		
	}
    
	/**
	 * Get Date object from input string
	 * @author Brian Battell
	 * @param Input	 String DateString
	 * 
	 * @return Date
	 */
	public static Date dateFromString(String DateString) {
		Date date = null;
		if (isDateValid(DateString)) {
		
			String[] strdate = DateString.split("/");
			
			int month = Integer.parseInt(strdate[0]);
			int day = Integer.parseInt(strdate[1]);
			int year = Integer.parseInt(strdate[2]);
			
			try {
				Calendar cal = Calendar.getInstance();
				cal.set(year, month - 1, day);
				date = cal.getTime();
			}
			catch (Exception ex) {
				return date;
			}
		}
		return date;
	}
	
	/**
	 * Is a valid numberic stringe
	 * @author Brian Battell
	 * @param Input		String number
	 * 
	 * @return boolean (true or false)
	 */ 
	private static boolean isNumber(String number) {
		try {
			Integer.parseInt(number);
			return true;
		}
		catch (NumberFormatException ex) {
			return false;
		}
	}
}
