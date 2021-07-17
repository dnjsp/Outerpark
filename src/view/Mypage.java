package view;

import dao.OuterparkUserDAO;
import util.PatternCheckUtil;
import util.SHA256Util;
import util.ScannerBuffer;
import util.View;
import vo.OuterparkUserVO;

public class Mypage {
	private Mypage() {}
	private static Mypage instance;
	public static Mypage getInstance(){
		if(instance == null){
			instance = new Mypage();
		}
		return instance;
	}
	
	private ScannerBuffer scanner = ScannerBuffer.getInstance();
	private OuterparkUserDAO userDao = OuterparkUserDAO.getInstance();
	private SHA256Util sha = SHA256Util.getInstance();
	private PatternCheckUtil pattern = PatternCheckUtil.getInstance();
		
	public void updatePassword() {
		String changePassword = "";
		while(!pattern.patternCheck(changePassword, pattern.passwordPattern)) {
			System.out.println("비밀번호는 문자,숫자,특수문자가 포함된 8자 이상이어야 합니다.");
			System.out.print("변경할 비밀번호를 입력하세요.> ");
			changePassword = scanner.next();			
		}
		changePassword = sha.encrypt(changePassword);
		
		if (userDao.updateUser(LoginService.loginId,"USER_PASSWORD",changePassword)==1) {
			System.out.println("비밀번호를 변경하였습니다.");
		} else {
			System.out.println("비밀번호를 변경할 수 없습니다.");
		}
	}
	
	public void updateNickname() {
		System.out.print("변경할 닉네임을 입력하세요.> ");
		String userNickname = scanner.next();
		
		if (userDao.updateUser(LoginService.loginId,"USER_NICKNAME",userNickname)==1) {
			System.out.println("닉네임을 변경하였습니다.");
		} else {
			System.out.println("닉네임을 변경할 수 없습니다.");
		}
	}
	
	public void deleteUser() {
		System.out.print("비밀번호를 입력하세요.> ");
		String userPassword = scanner.next();
		userPassword = sha.encrypt(userPassword);
		if (userDao.deleteUser(new OuterparkUserVO(LoginService.loginId.getUserId(),userPassword)) == 1) {
			System.out.println("아이디를 삭제했습니다.");
		} else {
			System.out.println("존재하지 않는 아이디입니다."); // 에러남
		}
	}
}