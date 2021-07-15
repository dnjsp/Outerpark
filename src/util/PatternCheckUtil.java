package util;

import java.util.regex.Pattern;

public class PatternCheckUtil {
	public static final String idPattern = "^[a-zA-Z]+[a-zA-Z0-9]{5,19}$";
    public static final String passwordPattern = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[$@$!%*#?&])[A-Za-z\\d$@$!%*#?&]{8,20}$";
    public static final String mailPattern = "^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z]){3,20}@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z]){4,20}.[a-zA-Z]{2,3}$";
    
    public static boolean patternCheck(String str,String pattern){
    	return Pattern.matches(pattern,str);
    }
}
