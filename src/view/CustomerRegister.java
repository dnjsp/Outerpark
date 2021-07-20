package view;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import dao.*;
import vo.*;
import util.*;

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
	
	public void packMenu() {
		System.out.println("\n=============== PACKAGE ===============");
		
		String wantCity = "";
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
	      int maxPeople = scanner.nextInt();
	      Date now = new Date();
	      SimpleDateFormat date = new SimpleDateFormat("yyyyMMdd");
	      int dateNow = Integer.parseInt(date.format(now));
	      
	      int startDate = 0;
	      while(startDate<dateNow || startDate>21000000 ) {
	         System.out.print("* 이용 시작일 (ex.20210719) : ");
	         startDate = scanner.nextInt();
		}
		int endDate =0;
		while(endDate <= startDate) {
			System.out.print("* 이용 종료일 (ex.20210721) : ");
			endDate = scanner.nextInt();		
		}
		System.out.println("============ 확인창 =========");
		System.out.println("* 입력한 지역: " + wantCity);
		System.out.println("* 입력한 인원: " + maxPeople);
		System.out.println("* 입력한 날짜: " + startDate + " ~ " + endDate);
		customerChoice(wantCity, startDate, endDate, maxPeople);
	}
	

	public void customerChoice(String wantCity,int startDate, int endDate, int maxPeople) {// 차,방,투어 선택
		double saleRate;
		System.out.println("** 등록된 차량 목록 **");
		String carNumber = carChoice(wantCity,maxPeople);
		System.out.println("** 등록된 방 목록 **");
	    int roomNumber = roomChoice(wantCity,maxPeople);
	    System.out.println("** 등록된 투어 목록 **");
		int tourNumber = tourChoice(wantCity,maxPeople);
		int cnt = 0;
		if(carNumber.equals("0")) cnt++;
		if(roomNumber==0) cnt++;
		if(tourNumber==0) cnt++;
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
			int price = (endDate-startDate)*(int)((carPrice+roomPrice+tourPrice*maxPeople)*saleRate);
			
			PaymentDAO.getInstance().insertPayment(LoginService.loginId.getUserId(), packNumber,price);
			System.out.println("정상등록 되었습니다.\n\n\n");
		}else {
			System.out.println("등록 실패하였습니다.\n\n\n");
		}
	}
	
	public String carChoice(String wantCity, int maxPeople) {
		ArrayList<HashMap<String, Object>> list = CarDAO.getInstance().selectCar(new CarVO(wantCity,maxPeople));
		int size = list.size();
		System.out.println("번호\t차번호\t\t\t종류\t\t가격\t인승\t지역\t색상");
		for(int i=0; i<size;i++) {
			System.out.print(i+1+"\t");
			System.out.print(list.get(i).get("CAR_NUMBER")+"\t");
			System.out.printf("%16s\t",list.get(i).get("CAR_KIND"));
			System.out.print(list.get(i).get("CAR_PRICE")+"\t");
			System.out.print(list.get(i).get("CAR_SEATS")+"\t");
			System.out.print(list.get(i).get("CITY")+"\t");
			System.out.print(list.get(i).get("CAR_COLOR")+"\n");
		}
		System.out.println("* 원하는 차량의 번호를 입력해주세요: (미선택시 0을 입력해주세요)");
		int input = scanner.nextInt();
		String carNumber = "0";
		if(input != 0) carNumber = list.get(input-1).get("CAR_NUMBER")+"";
		return carNumber;
	}
	
	public int roomChoice(String wantCity, int maxPeople) {
		ArrayList<HashMap<String, Object>> list = RoomDAO.getInstance().selectRoom(new RoomVO(wantCity,maxPeople));
		int size = list.size();
		System.out.println("번호\t\t숙소이름\t\t최대인원\t방갯수\t침대갯수\t숙소가격\t지역\t숙소설명");
		for(int i=0; i<size;i++) {
			System.out.print(i+1+"\t");
			System.out.printf("%16s\t",list.get(i).get("ROOM_NAME"));
			System.out.print(list.get(i).get("MAX_CAPACITY")+"\t");
			System.out.print(list.get(i).get("ROOM_COUNT")+"\t");
			System.out.print(list.get(i).get("BED_COUNT")+"\t");
			System.out.print(list.get(i).get("ROOM_PRICE")+"\t");
			System.out.print(list.get(i).get("CITY")+"\t");
			System.out.print(list.get(i).get("EXPLANATION")+"\n");
		}
		System.out.println("* 원하는 방의 번호을 입력해주세요: (미선택시 0을 입력해주세요)");
		int input= scanner.nextInt();
		int roomNumber = 0;
		if(input != 0) roomNumber = Integer.parseInt(list.get(input-1).get("ROOM_NUMBER")+"");
		return roomNumber;
	}
	
	public int tourChoice(String wantCity, int maxPeople) {
		ArrayList<HashMap<String, Object>> list = TourDAO.getInstance().selectTour(new TourVO(wantCity));
		int size = list.size();
		System.out.println("번호\t\t투어이름\t\t투어시간\t투어가격\t지역\t투어설명");
		for(int i=0; i<size;i++) {
			System.out.print(i+1+"\t");
			System.out.printf("%16s\t",list.get(i).get("TOUR_NAME"));
			System.out.print(list.get(i).get("TOUR_TIME")+"\t");
			System.out.print(list.get(i).get("TOUR_PRICE")+"\t");
			System.out.print(list.get(i).get("CITY")+"\t");
			System.out.print(list.get(i).get("EXPLANATION")+"\n");
		}
		System.out.println("* 원하는 투어의 번호을 입력해주세요: (미선택시 0을 입력해주세요)");
		int input = scanner.nextInt();
		int tourNumber = 0;
		if(input != 0) tourNumber = Integer.parseInt(list.get(input-1).get("TOUR_NUMBER")+"");
		return tourNumber;
	}
}