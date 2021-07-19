package view;

import java.util.ArrayList;
import java.util.HashMap;

import dao.*;
import util.ScannerBuffer;
import vo.*;

public class CustomerRegister {
	
	private CustomerRegister() {}
	private static CustomerRegister instance;
	public static CustomerRegister getinstance() {
	if (instance == null) {
		instance = new CustomerRegister();
	}	
		return instance;
	}
		
	private ScannerBuffer scanner = ScannerBuffer.getInstance();
	private String wantCity = "";
	private int maxPeople;
	private String carNumber;
	private int roomNumber;
	private int tourNumber;
	private String startDate;
	private String endDate;
	private int cnt;
	
	public void packManu() {
		System.out.println("== PACKAGE ==");
		
		while(wantCity.isEmpty()) {
			System.out.println("1.서울|2.대전|3.목포|4.인천|5.광주|6.울산|7.부산");// 안적어도 넘어감
			System.out.print("* 원하는 지역의 번호를 입력하세요: ");
			int wantCityInt = scanner.nextInt();
			switch (wantCityInt) {
				case 1: wantCity = "서울"; break;
				case 2: wantCity = "대전"; break;
				case 3: wantCity = "목포"; break;
				case 4: wantCity = "인천"; break;
				case 5: wantCity = "광주"; break;
				case 6: wantCity = "울산"; break;
				case 7: wantCity = "부산"; break;
				default: System.out.println("잘못 입력하였습니다."); break;
			}
		}
		
		System.out.print("* 이용 인원: ");
		maxPeople = scanner.nextInt();
		System.out.println("* 이용 시작일: (ex.20210719)");
		startDate = scanner.next();
		System.out.println("* 이용 종료일: (ex.20210719)");
		endDate = scanner.next();
		System.out.println("== 확인창 ==");
		System.out.println("* 입력한 지역: " + wantCity);
		System.out.println("* 입력한 인원: " + maxPeople);
		System.out.println("* 입력한 날짜: " + startDate + " ~ " + endDate);
		customerChoice();
	}
	

	public void customerChoice() {// 차,방,투어 선택
		double saleRate;
		System.out.println("** 등록된 차량 목록 **");
		carChoice();
		System.out.println("** 등록된 방 목록 **");
	    roomChoice();
	    System.out.println("** 등록된 투어 목록 **");
		tourChoice();
		switch (cnt) {
			case 0: saleRate = 0.8; break;
			case 1: saleRate = 0.9; break;
			case 2: saleRate = 1; break;
			case 3: System.out.println("입력된 정보가 없습니다."); return;
			default: System.out.println("에러"); return;
			}
		if(PackDAO.getInstance().insertPack(new PackVO(tourNumber,roomNumber,carNumber,startDate,endDate,maxPeople))==1) {
			int packNumber = PackDAO.getInstance().getPackNumber();
			int carPrice = CarDAO.getInstance().selectCarPrice(carNumber);
			int roomPrice = RoomDAO.getInstance().selectRoomPrice(roomNumber);
			int tourPrice = TourDAO.getInstance().selectTourPrice(tourNumber);
			int price = (Integer.parseInt(endDate)-Integer.parseInt(startDate))*(int)((carPrice+roomPrice+tourPrice)*saleRate);
			
			PaymentDAO.getInstance().insertPayment(LoginService.loginId.getUserId(), packNumber,price);
			System.out.println("정상등록 되었습니다.");
		} else {
			System.out.println("등록 실패하였습니다.");
		}
		

	}
	
	public void carChoice() {
		ArrayList<HashMap<String, Object>> list = CarDAO.getInstance().selectCar(new CarVO(wantCity,maxPeople));
		int size = list.size();
		String[] key = { "CAR_NUMBER", "CAR_KIND", "CAR_PRICE", "CAR_SEATS", "CITY", "CAR_COLOR" };
		System.out.println("번호\t종류\t가격\t인승\t지역\t색상");
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < key.length; j++) {
				System.out.print(list.get(i).get(key[j]) + "\t");
			}
			System.out.println();
			
		}
		System.out.println("* 원하는 차량의 번호를 입력해주세요: (미선택시 0을 입력해주세요)");
		carNumber = scanner.next();
		if(carNumber.equals("0")) cnt++;
		
	}
	
	public void roomChoice() {
		ArrayList<HashMap<String, Object>> list = RoomDAO.getInstance().selectRoom(new RoomVO(wantCity,maxPeople));
		int size = list.size();
		String[] key = { "ROOM_NUMBER","ROOM_NAME","ROOM_COUNT", "BED_COUNT","ROOM_PRICE","CITY", "EXPLANATION" };
		System.out.println("방번호\t숙소이름\t방갯수\t침대갯수\t숙소가격\t지역\t숙소설명");
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < key.length; j++) {
				System.out.print(list.get(i).get(key[j]) + "\t");
			}
			System.out.println();
		}
		System.out.println("* 원하는 방의 번호을 입력해주세요: (미선택시 0을 입력해주세요)");
		roomNumber= scanner.nextInt();
		if(roomNumber==0) cnt++;
		
	}
	
	public void tourChoice() {
		ArrayList<HashMap<String, Object>> list = TourDAO.getInstance().selectTour(new TourVO(wantCity));
		int size = list.size();
		String[] key = { "TOUR_NUMBER","TOUR_NAME", "TOUR_TIME", "TOUR_PRICE", "CITY", "EXPLANATION" };
		System.out.println("투어번호\t투어이름\t투어시간\t투어가격\t지역\t투어설명");
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < key.length; j++) {
				System.out.print(list.get(i).get(key[j]) + "\t");
			}
			System.out.println();
		}
		System.out.println("* 원하는 투어의 번호을 입력해주세요: (미선택시 0을 입력해주세요)");
		tourNumber = scanner.nextInt();
		if(tourNumber==0) cnt++;
	}
	
}