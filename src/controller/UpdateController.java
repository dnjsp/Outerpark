package controller;

import util.ScannerBuffer;
import view.LoginService;

public class UpdateController {
	private UpdateController() {}
	private static UpdateController instance;
	public static UpdateController getInstance(){
		if(instance == null){
			instance = new UpdateController();
		}
		return instance;
	}
	
	private ScannerBuffer scanner = ScannerBuffer.getInstance();
	private LoginService loginService = LoginService.getInstance();
	
	public int updateInformation() {
		loginService.updateInformation();
		int input = scanner.nextInt();
		switch (input) {
			case 1: loginService.updatePassword(); break;
			case 2: loginService.updateNickname(); break;
			default:
				loginService.reupdateInformation();
				input = scanner.nextInt();
				break;
		}
		return 1;
	}
	
}
