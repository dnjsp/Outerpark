package util;

import java.util.Random;

public class TemporaryPasswordUtil {
	
	public TemporaryPasswordUtil() {
		
	}
	public static String getTemporaryPassword() {
		Random rand = new Random();
		char pwCollection[] = new char[] {
				'1','2','3','4','5','6','7','8','9','0',
				'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z',
				'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z',
				'!','@','#','*'};
		String ranPw;
		do {
			ranPw = "";
			for(int i=0;i<10;i++) {
				int select =(int)rand.nextInt(pwCollection.length);
				ranPw += pwCollection[select];
			}	
			System.out.println("한번");
		}while(!PatternCheckUtil.patternCheck(ranPw,PatternCheckUtil.passwordPattern));
		return ranPw;
	}
}
