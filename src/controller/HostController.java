package controller;

import util.*;
import view.LoginService;

public class HostController {
	private HostController() {}
	private static HostController instance;
	public static HostController getInstance(){
		if(instance == null){
			instance = new HostController();
		}
		return instance;
	}
	
	private ScannerBuffer scanner = ScannerBuffer.getInstance(); 
	
	public void hostMenu() {
		System.out.println("========= Host로 입장하였습니다. =========");
		while(true) {
			System.out.println("1.방 2.렌트카 3.관광명소 4.마이페이지 5.로그아웃"); 
			System.out.print("번호를 입력해주세요> ");
			int input = scanner.nextInt();
			switch (input) {
				case 1: RoomController.getInstance().roomInformation(); break;
				case 2: CarController.getInstance().carInformation(); break;
				case 3: TourController.getInstance().tourInformation(); break;
				case 4: MypageController.getInstance().mypage(); break;
				case 5: LoginService.loginId= null; return;
				default: System.out.println("잘못 입력하였습니다.");
			}
		}
	}
}
