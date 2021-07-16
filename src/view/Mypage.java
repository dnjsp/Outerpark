package view;

import dao.OuterparkUserDAO;
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
		
	public int updatePassword() {
		System.out.print("현재 비밀번호를 입력하세요.> ");
		String userPassword = scanner.next();
		System.out.print("변경할 비밀번호를 입력하세요.> ");
		String changePassword = scanner.next();
		
		if (userDao.updatePassword(new OuterparkUserVO(LoginService.loginId.getUserId(), userPassword),changePassword) == 1) {
			System.out.println("비밀번호를 변경하였습니다.");
		} else {
			System.out.println("비밀번호를 변경할 수 없습니다.");
		}
		return View.HOSTMENU; // 비밀번호 변경하고 호스트메뉴가 아닌 메인메뉴로 이동함
	}
	
	public int updateNickname() {
		System.out.print("변경할 닉네임을 입력하세요.> ");
		String userNickname = scanner.next();
		
		if (userDao.updateNickname(new OuterparkUserVO(LoginService.loginId.getUserId(), 
				LoginService.loginId.getUserPassword(), userNickname)) == 1) {
			System.out.println("닉네임을 변경하였습니다.");
		} else {
			System.out.println("닉네임을 변경할 수 없습니다."); // 닉네임 변경이 안 됨..
		}
		return View.HOSTMENU; 
	}
	
	public int deleteUser() {
		System.out.print("비밀번호를 입력하세요.> ");
		String userPassword = scanner.next();
		if (userDao.deleteUser(new OuterparkUserVO(LoginService.loginId.getUserId(),userPassword)) == 1) {
			System.out.println("아이디를 삭제했습니다.");
		} else {
			System.out.println("존재하지 않는 아이디입니다.");
		}
		return View.HOSTMENU;	// 에러남...
	}
	
}
