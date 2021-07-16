package controller;

import util.ScannerBuffer;
import util.View;

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
	private RoomController roomController = RoomController.getInstance();
	private CarController carController = CarController.getInstance();
	private TourController tourController = TourController.getInstance();
	private MypageController mypage = MypageController.getInstance();
	
	public int hostMenu() {
		System.out.println("== Host로 입장하였습니다. ==");
		System.out.println("1.방 2.렌트카 3.관광명소 4.마이페이지 5.로그아웃"); 
		System.out.print("번호를 입력해주세요> ");
		int input = scanner.nextInt();
		while(true) {
			switch (input) {
				case 1: input = roomController.roomInformation(); break;
				case 2: input = carController.carInformation(); break;
				case 3: input = tourController.tourInformation(); break;
				case 4: input = mypage.mypage(); break;
				case 5: return View.HOME;
				default: 
					System.out.println("잘못 입력하였습니다.");
					return View.HOSTMENU;
			}
		}
	}
}
