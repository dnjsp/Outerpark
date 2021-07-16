package view;

import dao.OuterparkUserDAO;
import util.ScannerBuffer;
import util.View;
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
	public static OuterparkUserVO loginId; 
	
	public int main() {
		System.out.println("== 어서오세요. OuterPark입니다. ==");
		System.out.println("1.로그인 | 2.회원가입 | 3.아이디 찾기 | 4.프로그램 종료");
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
			loginId = userDao.selectid(new OuterparkUserVO(userId));
			if (loginId.getUsertype().equals("host")) {
				return View.HOSTMENU;
			} else {
				return View.CUSTOMERMENU;
			}
		} else {
			System.out.println("아이디 혹은 비밀번호를 잘못 입력하셨습니다.");
			return View.HOME;
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
		
		return View.HOME;
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
		return View.HOME;
	}
	
}

