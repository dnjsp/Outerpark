package controller;

import util.ScannerBuffer;
import util.View;
import view.CarRegister;

public class CarController {
	private CarController() {}
	private static CarController instance;
	public static CarController getInstance(){
		if(instance == null){
			instance = new CarController();
		}
		return instance;
	}
	
	private ScannerBuffer scanner = ScannerBuffer.getInstance();
	private CarRegister carRegister = CarRegister.getInstance();
	
	public int carInformation() {
		System.out.println("1.렌트카 등록 2.렌트카 삭제 3.목록 조회 4.뒤로 가기");
		System.out.print("번호를 입력해주세요> ");
		int input = scanner.nextInt();
		switch (input) {
		case 1: carRegister.carInsert(); break;
		case 2: carRegister.carDelete(); break;
		case 3: carRegister.carSearch(); break;
		case 4: return View.HOSTMENU;
		default:
			System.out.println("잘못 입력하였습니다.");
			return 2;
		}
		return 2;
	}
}
