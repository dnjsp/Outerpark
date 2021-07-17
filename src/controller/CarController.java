package controller;

import util.ScannerBuffer;
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
		carRegister.carInformation();
		int input = scanner.nextInt();
		switch (input) {
		case 1: carRegister.carInsert(); break;
		case 2: carRegister.carDelete(); break;
		case 3: return 10;
		default:
			carRegister.carInformation();
			input = scanner.nextInt();
			break;
		}
		return 1;
	}
}
