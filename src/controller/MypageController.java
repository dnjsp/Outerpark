package controller;

import util.ScannerBuffer;
import util.View;
import view.Mypage;

public class MypageController {
	private MypageController() {}
	private static MypageController instance;
	public static MypageController getInstance(){
		if(instance == null){
			instance = new MypageController();
		}
		return instance;
	}
	
	private ScannerBuffer scanner = ScannerBuffer.getInstance();
	private Mypage mypage = Mypage.getInstance();
	
	public int mypage() {
		System.out.println("1.비밀번호 변경 2. 닉네임 변경 3.아이디 삭제 4.뒤로 가기");
		System.out.print("번호를 입력해주세요> ");
		int input = scanner.nextInt();
		while(true) {
			switch (input) {
				case 1: input = mypage.updatePassword(); break;
				case 2: input = mypage.updateNickname(); break;
				case 3: input = mypage.deleteUser(); break;
				case 4: input = View.HOSTMENU; break;
				default: 
					System.out.println("다시 입력해주세요.");
					return View.HOSTMENU;
			}
		}
	}
}
