package view;

import dao.OuterparkUserDAO;
import util.ScannerBuffer;
import vo.OuterparkUserVO;


public class LoginService {
	private LoginService(){}
	private static LoginService instance;
	public static LoginService getInstance(){
		if(instance == null){
			instance = new LoginService();
		}
		return instance;
	}
	
	private OuterparkUserDAO userDao = OuterparkUserDAO.getInstance();
	private ScannerBuffer scanner = ScannerBuffer.getInstance();
	
	public int main() {
		System.out.println("== 어서오세요. OuterPark입니다. ==");
		System.out.println("1.로그인 | 2.회원가입 | 3.아이디 찾기 | 4.정보 변경 | 5.사용자 삭제 | 6.프로그램 종료");
		System.out.print("번호를 입력해주세요> ");
		int input = scanner.nextInt();
		return input;
	}
	
	public int login() {
		System.out.print("아이디> ");
		String userId = scanner.next();
		System.out.print("비밀번호> ");
		String userPassword = scanner.next();
		
		if (userDao.loginUser(new OuterparkUserVO(userId, userPassword))) {
			System.out.println("로그인 성공");

			if (userDao.referenceType(new OuterparkUserVO(userId)).equals("host")) {
				return 7;
			} else {
				return 8;
			}
		} else {
			System.out.println("아이디 혹은 비밀번호를 잘못 입력하셨습니다.");
			return 10;
		}
	}

	public int signUp() {
		System.out.print("아이디> ");
		String userId = scanner.next();
		System.out.print("비밀번호> ");
		String userPassword = scanner.next();
		System.out.print("이름> ");
		String userName = scanner.next();
		System.out.print("닉네임> ");
		String userNickname = scanner.next();
		System.out.print("메일> ");
		String userMail = scanner.next();
		System.out.print("타입 (host: 1, customer: 2)> ");
		String userType = "";
		
		while (userType.isEmpty()) {
			int userTypei = scanner.nextInt();
			if (userTypei == 1) {
				userType = "host";
			} else if (userTypei == 2) {
				userType = "customer";
			} else {
				System.out.println("다시 입력하세요.");
				System.out.print("타입 (host: 1, customer: 2)> ");
			} 
		}
		
		if (userDao.insertUser(new OuterparkUserVO(userId, userPassword, userName, userNickname, userMail, userType)) == 1) {
			System.out.println("회원가입 성공");
		} else {
			System.out.println("회원가입 실패");
		}
		
		return 10;
	}

	public int idFound() {
		System.out.print("이름> ");
		String userName = scanner.next();
		System.out.print("메일> ");
		String userMail = scanner.next();
		System.out.print("닉네임> ");
		String userNickname = scanner.next();
		if (userDao.idfoundUser(new OuterparkUserVO(userName, userMail, userNickname)) == null) {
			System.out.println("아이디를 찾을 수 없습니다.");
		} else {
			System.out.print("아이디> ");
			System.out.println(userDao.idfoundUser(new OuterparkUserVO(userName, userMail, userNickname)));
		}
		return 10;
	}
	
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

