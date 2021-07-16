package view;

import dao.CarDAO;
import util.ScannerBuffer;
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
	
	public void carInformation() {
		System.out.println("1.렌트카 등록 2.렌트카 삭제 3.뒤로 가기");
		System.out.print("번호를 입력해주세요> ");
	}
	
	public void reCarInformation() {
		System.out.println("다시 입력해주세요.");
	}
	
	public int carInsert() {
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
		carDao.insertCar(new CarVO(carNumber, LoginService.loginId.getUserId(), carKind, carPrice, carSeats, city, carColor));
		System.out.println("등록 성공");
		return 10;
	}
	
	public int carDelete() {
		System.out.print("차 번호> ");
		String carNumber = scanner.next(); 
		// 비밀번호 입력
		if (carDao.deleteCar(new CarVO(carNumber)) == 1) {
			System.out.println("삭제되었습니다.");
		} else {
			System.out.println("존재하지 않는 차량입니다.");
		}
		return 10;
	}
}
