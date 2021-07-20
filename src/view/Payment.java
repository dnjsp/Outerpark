package view;

import java.util.ArrayList;
import java.util.HashMap;

import dao.*;
import util.ScannerBuffer;

public class Payment {
	private Payment() {}
	private static Payment instance;
	public static Payment getInstance(){
		if(instance == null){
			instance = new Payment();
		}
		return instance;
	}
	
	private PaymentDAO paydao = PaymentDAO.getInstance();
	private ScannerBuffer scanner = ScannerBuffer.getInstance();
	
	public void paymentHistory() {
		ArrayList<HashMap<String, Object>> list = paydao.selectPayment(LoginService.loginId.getUserId());
		int size = list.size();
		System.out.println("번호\t가격\t상태\t수정날짜");
		for(int i=0; i<size;i++) {
			System.out.print(i+1+"\t");
			System.out.print(list.get(i).get("PRICE")+"\t");
			System.out.print(list.get(i).get("STATE")+"\t");
			System.out.print(list.get(i).get("PAY_DATE")+"\n");
		}
		System.out.println("뒤로 가시려면 0을,");
		System.out.println("결제 내역을 수정하거나, 자세히 보려면 결제 번호를 입력해 주세요.");
		int input = scanner.nextInt();
		if(input==0) return;
		String cartNumber = list.get(input-1).get("CART_NUMBER") + "";
		String state = list.get(input-1).get("STATE")+"";
		paymentDetails(cartNumber);
		paymentStatement(cartNumber,state);
	}
	
	public void paymentDetails(String cartNumber) {
		ArrayList<HashMap<String, Object>> listRoom = RoomDAO.getInstance().roomDetail(cartNumber);
		ArrayList<HashMap<String, Object>> listCar = CarDAO.getInstance().carDetail(cartNumber);
		ArrayList<HashMap<String, Object>> listTour = TourDAO.getInstance().tourDetail(cartNumber);
		ArrayList<HashMap<String, Object>> listCart = PaymentDAO.getInstance().selectDetail(cartNumber);
		System.out.printf("* 방정보 *\n 방 이름 : %s   방 개수 : %s개    침대 개수 : %s개    방 인원 : %s명\n 방 설명 : %s\n"
				,listRoom.get(0).get("ROOM_NAME"),listRoom.get(0).get("ROOM_COUNT")
				,listRoom.get(0).get("BED_COUNT"),listRoom.get(0).get("MAX_CAPACITY"),listRoom.get(0).get("EXPLANATION"));
		System.out.printf("* 차정보 *\n 차 종류 : %s   차 좌석 : %s인승\n",
				listCar.get(0).get("CAR_KIND"),listCar.get(0).get("CAR_SEATS"));
		System.out.printf("* 투어정보 *\n 투어 이름 : %s    투어 시간 : %s시간 \n 투어 설명 : %s\n"
				,listTour.get(0).get("TOUR_NAME"),listTour.get(0).get("TOUR_TIME"),listTour.get(0).get("EXPLANATION"));
		System.out.printf("* 지역 : %s    선택인원 : %s명   가격 : %s원   날짜 : %s ~ %s\n"
				,listCart.get(0).get("CITY"),listCart.get(0).get("PEOPLE"),listCart.get(0).get("PRICE")
				,listCart.get(0).get("START_DATE"),listCart.get(0).get("END_DATE"));
	}
	
	public void paymentStatement(String cartNumber, String state) {
		if(state.equals("결제대기")) {
			while(true) {
				System.out.print("결제 하시겠습니까? (1:yes 2:no)");
				switch (scanner.nextInt()) {
					case 1: 
						PaymentDAO.getInstance().updateState("결제완료", cartNumber);
						System.out.println("결제가 완료되었습니다.");
						return;
					case 2: return;
					default: break;
				}
			}
		}else if(state.equals("결제완료")) {
			while(true) {
				System.out.print("환불 하시겠습니까? (1:yes 2:no)");
				switch (scanner.nextInt()) {
					case 1: 
						PaymentDAO.getInstance().updateState("환불", cartNumber);
						System.out.println("환불이 완료되었습니다.");
						return;
					case 2: return;
					default: break;
				}
			}
		}
	}
}
