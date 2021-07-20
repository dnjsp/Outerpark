package view;

import java.util.ArrayList;
import java.util.HashMap;

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
			System.out.println("등록 성공\n\n\n");
		} else {
			System.out.println("등록에 실패했습니다.\n\n\n");
		}
	}
	
	public void carDelete() {
		System.out.print("차 번호> ");
		String carNumber = scanner.next(); 
		if (carDao.deleteCar(new CarVO(carNumber)) == 1) {
			System.out.println("삭제되었습니다.\n\n\n");
		} else {
			System.out.println("존재하지 않거나 본인이 등록한 차가 아닙니다.\n\n\n");
		}
	}
	
	public void carSearch() {
		ArrayList<HashMap<String, Object>> list = carDao.select(LoginService.loginId);
		int size = list.size();
		System.out.println("번호\t\t종류\t\t가격\t인승\t지역\t색상");
		for(int i=0; i<size;i++) {
			System.out.print(list.get(i).get("CAR_NUMBER")+"\t");
			System.out.printf("%s\t",list.get(i).get("CAR_KIND"));
			System.out.print(list.get(i).get("CAR_PRICE")+"\t");
			System.out.print(list.get(i).get("CAR_SEATS")+"\t");
			System.out.print(list.get(i).get("CITY")+"\t");
			System.out.print(list.get(i).get("CAR_COLOR")+"\n");
		}
		System.out.println("\n\n\n");
	}
}
