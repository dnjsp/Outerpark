package controller;

import util.ScannerBuffer;
import view.*;

public class CustomerController {
	private CustomerController() {
	}

	private static CustomerController instance;

	public static CustomerController getInstance() {
		if (instance == null) {
			instance = new CustomerController();
		}
		return instance;
	}

	private ScannerBuffer scanner = ScannerBuffer.getInstance();
	private MypageController mypage = MypageController.getInstance();
	private CustomerRegister customerRegister = CustomerRegister.getinstance();
	
	public void customerMenu() {
		System.out.println("== Customer로 입장하였습니다. ==");
		while (true) {
			System.out.println("1.패키지 2.결제 3.마이페이지 4.로그아웃");
			System.out.print("번호를 입력해주세요> ");
			int input = scanner.nextInt();
			switch (input) {
				case 1: customerRegister.packManu(); break;
				case 2: customerRegister.customerChoice(); break;
				case 3: mypage.mypage(); break;
				case 4: LoginService.loginId = null; return;
				default: System.out.println("잘못 입력하셨습니다.");
			}
		}
	}
}