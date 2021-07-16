package controller;

import util.ScannerBuffer;
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
		mypage.updateInformation();
		int input = scanner.nextInt();
		while(true) {
			switch (input) {
				case 10: mypage.updateInformation(); 
				case 1: input = mypage.updatePassword(); break;
				case 2: input = mypage.updateNickname(); break;
				default: 
					mypage.reupdateInformation();
					input = scanner.nextInt();
					break;
			}
		}
	}
}
