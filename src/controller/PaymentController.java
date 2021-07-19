package controller;

public class PaymentController {
	private PaymentController(){}
	private static PaymentController instance;
	public static PaymentController getInstance(){
		if(instance == null){
			instance = new PaymentController();
		}
		return instance;
	}
	
	public void paymentMenu() {
		System.out.println();
	}
}
