package controller;

public class PackController {
	private PackController(){}
	private static PackController instance;
	public static PackController getInstance(){
		if(instance == null){
			instance = new PackController();
		}
		return instance;
	}
	
	public void packMenu() {
		System.out.println();
	}
}
