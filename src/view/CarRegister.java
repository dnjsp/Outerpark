package view;

import java.util.ArrayList;
import java.util.HashMap;

import dao.CarDAO;
import dao.OuterparkUserDAO;
import util.ScannerBuffer;
import util.View;
import vo.CarVO;

public class CarRegister {
	private CarRegister() {}
	private static CarRegister instance;
	public static CarRegister getInstance(){
		if(instance == null){
			instance = new CarRegister();
		}
		return instance;
	}
	
	private CarDAO carDao = CarDAO.getInstance();
	private ScannerBuffer scanner = ScannerBuffer.getInstance();
	
	public void carInsert() {
		System.out.print("차 번호> ");
		String carNumber = scanner.next();
		System.out.print("차 종류> ");
		String carKind = scanner.next();
		System.out.print("가격> ");
		int carPrice = scanner.nextInt();
		System.out.print("인승> ");
		int carSeats = scanner.nextInt();
		System.out.print("지역> ");
		String city = scanner.next();
		System.out.print("차 색상> ");
		String carColor = scanner.next();
		if (carDao.insertCar(new CarVO(carNumber, LoginService.loginId.getUserId(), carKind, carPrice, carSeats, city, carColor)) == 1) {
			System.out.println("등록 성공");
		} else {
			System.out.println("등록에 실패했습니다.");
		}
	}
	
	public void carDelete() {
		System.out.print("차 번호> ");
		String carNumber = scanner.next();
		if (carDao.deleteCar(new CarVO(carNumber)) == 1) {
			System.out.println("삭제되었습니다.");
		} else {
			System.out.println("존재하지 않는 차량입니다.");
		}
	}
	
	public void carSearch() {
		ArrayList<HashMap<String, Object>> list = carDao.select(LoginService.loginId);
		int size = list.size();
		String[] key = {"CAR_NUMBER","CAR_KIND","CAR_PRICE","CAR_SEATS","CITY","CAR_COLOR"};
		System.out.println("번호\t종류\t가격\t인승\t지역\t색상");
		for(int i=0; i<size;i++) {
			for(int j=0; j<key.length; j++) {
				System.out.print(list.get(i).get(key[j])+"\t");
			}
			System.out.println();
		}
	}
}
