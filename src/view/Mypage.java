package view;

import dao.OuterparkUserDAO;
import util.ScannerBuffer;
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
	
	public void updateInformation() {
		System.out.println("1.비밀번호 변경 2. 닉네임 변경");
		System.out.print("번호를 입력해주세요> ");
	}
	
	public void reupdateInformation() {
		System.out.println("다시 입력해주세요.");
	}
	
	public int updatePassword() {
		System.out.print("아이디> ");
		String userId = scanner.next();
		System.out.print("비밀번호> ");
		String userPassword = scanner.next();
		System.out.print("변경할 비밀번호> ");
		String changePassword = scanner.next();
		
		if (userDao.updatePassword(new OuterparkUserVO(userId, userPassword),changePassword) == 1) {
			System.out.println("비밀번호를 변경하였습니다.");
		} else {
			System.out.println("비밀번호를 변경할 수 없습니다.");
		}
		
		return 10;
	}
	
	public int updateNickname() {
		System.out.print("아이디> ");
		String userId = scanner.next();
		System.out.print("비밀번호> ");
		String userPassword = scanner.next();
		System.out.print("변경할 닉네임> ");
		String userNickname = scanner.next();
		
		if (userDao.updateNickname(new OuterparkUserVO(userId, userPassword, userNickname)) == 1) {
			System.out.println("닉네임을 변경하였습니다.");
		} else {
			System.out.println("닉네임을 변경할 수 없습니다.");
		}
		return 10;
	}
	
	public int deleteUser() {
		System.out.print("삭제할 아이디를 입력하세요.> ");
		String userId = scanner.next();
		// 비밀번호도 입력받기
		if (userDao.deleteUser(new OuterparkUserVO(userId)) == 1) {
			System.out.println("아이디를 삭제했습니다.");
		} else {
			System.out.println("존재하지 않는 아이디입니다.");
		}
		return 10;		
	}
	
}
