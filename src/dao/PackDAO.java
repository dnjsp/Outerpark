package dao;

import java.util.ArrayList;
import java.util.HashMap;

import util.JDBCUtil;
import vo.CarVO;
import vo.RoomVO;
import vo.TourVO;

public class PackDAO {
	private static PackDAO instance = new PackDAO();
	public static PackDAO getInstance() {
		return instance;
	}
	
	private PackDAO() {}
	
	JDBCUtil jdbc = JDBCUtil.getInstance();
	
	public ArrayList<HashMap<String, Object>> selectRoom (RoomVO vo) {
		String query = String.format("SELECT * FROM ROOM WHERE CITY = '%s' AND MAX_CAPACITY >= %d", vo.getCity(), vo.getMaxCapacity());
		return jdbc.selectList(query);
	}
	
	public ArrayList<HashMap<String, Object>> selectCar (CarVO vo) {
		String query = String.format("SELECT * FROM CAR WHERE CITY = '%s' AND CAR_SEATS >= %d", vo.getCity(), vo.getCarSeats());
		return jdbc.selectList(query);
	}

	public ArrayList<HashMap<String, Object>> selectTour (TourVO vo) {
		String query = String.format("SELECT * FROM TOUR WHERE CITY = '%s'", vo.getCity());
		return jdbc.selectList(query);
	}
}
