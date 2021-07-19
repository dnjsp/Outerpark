package dao;

import java.util.ArrayList;
import java.util.HashMap;

import util.JDBCUtil;
import view.LoginService;
import vo.CarVO;
import vo.OuterparkUserVO;

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
		String query = String.format("DELETE FROM CAR WHERE CAR_NUMBER = '%s' AND USER_ID = '%s'", vo.getCarNumber(),LoginService.loginId.getUserId());
		return jdbc.Update(query);
	}
	
	public ArrayList<HashMap<String, Object>> select(OuterparkUserVO vo) {
		String query = String.format("SELECT * FROM CAR WHERE USER_ID = '%s'", vo.getUserId());
		return jdbc.selectList(query);
	}
}
