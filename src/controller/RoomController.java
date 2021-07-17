package controller;

import util.ScannerBuffer;
import view.RoomRegister;

public class RoomController {
	private RoomController() {}
	private static RoomController instance;
	public static RoomController getInstance(){
		if(instance == null){
			instance = new RoomController();
		}
		return instance;
	}
	
	private ScannerBuffer scanner = ScannerBuffer.getInstance();
	private RoomRegister roomRegister = RoomRegister.getInstance();
	
	public int roomInformation() {
		roomRegister.roomInformation();
		int input = scanner.nextInt();
		switch (input) {
		case 1: roomRegister.roomInsert(); break;
		case 2: roomRegister.roomDelete(); break;
		case 3: return 10;
		default:
			roomRegister.roomInformation();
			input = scanner.nextInt();
			break;
		}
		return 1;
	}
}
