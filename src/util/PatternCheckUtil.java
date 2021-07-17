package util;

import java.util.regex.Pattern;

public class PatternCheckUtil {
	private static PatternCheckUtil instance = new PatternCheckUtil();
	public static PatternCheckUtil getInstance() {
		return instance;
	}
	private PatternCheckUtil() {};
	
	public final String idPattern = "^[a-zA-Z]+[a-zA-Z0-9]{5,19}$";
    public final String passwordPattern = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[$@$!%*#?&])[A-Za-z\\d$@$!%*#?&]{8,20}$";
    public final String mailPattern = "^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z]){3,20}@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z]){4,20}.[a-zA-Z]{2,3}$";
    
    public boolean patternCheck(String str,String pattern){
    	return Pattern.matches(pattern,str);
    }
}
