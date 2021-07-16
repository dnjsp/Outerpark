package controller;

import util.ScannerBuffer;
import view.Host;

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
	private Host host = Host.getInstance();
	
	public int hostMenu() {
		host.host();
		int input = scanner.nextInt();
		while(true) {
			switch (input) {
				case 10: host.host(); 
				case 1: input = roomController.roomInformation(); break;
				case 2: input = carController.carInformation(); break;
				case 3: input = tourController.tourInformation(); break;
				case 4: return 10;
				default: 
					host.reHost();
					input = scanner.nextInt();
					break;
			}
		}
	}
}
