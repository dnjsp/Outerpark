package controller;

import view.LoginService;

public class LoginController {
	public static void main(String[] args) {
		new LoginController().start();
	}
	
	private LoginService loginservice = LoginService.getInstance();
	private HostController host = HostController.getInstance();
	private UpdateController update = UpdateController.getInstance();
	
	public void start() {
		int view = 10;
		
		while (true) {
			switch (view) {
				case 10: view = loginservice.main(); break;
				case 1: view = loginservice.login(); break;
				case 2:	view = loginservice.signUp(); break;
				case 3: view = loginservice.idFound(); break;
				case 4: view = update.updateInformation(); break;
				case 5: view = loginservice.deleteUser(); break;
				case 6: System.exit(0);
				case 7: view = host.hostMenu(); break;
				// case 8: view = c
				default:
					System.out.println("다시 입력해주세요.");
					view = 10;
					break;
			}	
		}
	}
}
