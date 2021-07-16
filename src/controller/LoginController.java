package controller;

import util.View;
import view.LoginService;

public class LoginController {
	public static void main(String[] args) {
		new LoginController().start();
	}
	
	private LoginService loginservice = LoginService.getInstance();
	private HostController host = HostController.getInstance();
	
	public void start() {
		int view = View.HOME;
		
		while (true) {
			switch (view) {
				case View.HOME: view = loginservice.main(); break;
				case View.LOGIN: view = loginservice.login(); break;
				case View.JOIN:	view = loginservice.signUp(); break;
				case View.FINDID: view = loginservice.idFound(); break;
				case View.EXIT: System.exit(0);
				case View.HOSTMENU: view = host.hostMenu(); break;
				// case View.CUSTOMERMENU: view = c
				default:
					System.out.println("다시 입력해주세요.");
					view = View.HOME;
					break;
			}	
		}
	}
}
