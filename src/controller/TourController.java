package controller;

import util.ScannerBuffer;
import view.TourRegister;

public class TourController {
	private TourController() {}
	private static TourController instance;
	public static TourController getInstance(){
		if(instance == null){
			instance = new TourController();
		}
		return instance;
	}
	
	private ScannerBuffer scanner = ScannerBuffer.getInstance();
	private TourRegister tourRegister = TourRegister.getInstance();
	
	public int tourInformation() {
		tourRegister.tourInformation();
		int input = scanner.nextInt();
		switch (input) {
		case 1: tourRegister.tourInsert(); break;
		case 2: tourRegister.tourDelete(); break;
		case 3: return 10;
		default:
			tourRegister.tourInformation();
			input = scanner.nextInt();
			break;
		}
		return 1;
	}
}
