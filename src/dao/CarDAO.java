package dao; 

import util.JDBCUtil;
import vo.CarVO;

public class CarDAO {
	private static CarDAO instance = new CarDAO(); 
	public static CarDAO getInstance() {
		return instance;
	}
	
	private CarDAO() {}
	
	JDBCUtil jdbc = JDBCUtil.getInstance();
	 
	public int insertCar(CarVO vo) {
		String query = String.format("INSERT INTO CAR VALUES ('%s','%s','%s',%d,%d,'%s','%s')"
				, vo.getCarNumber(), vo.getUserId(), vo.getCarKind(), vo.getCarPrice(), vo.getCarSeats(), vo.getCity(), vo.getCarColor());
		return jdbc.Update(query);
	}
	
	public int deleteCar(CarVO vo) {
		String query = String.format("DELETE FROM CAR WHERE CAR_NUMBER = '%s'", vo.getCarNumber());
		return jdbc.Update(query);
	}

}
