package dao;

import java.util.ArrayList;
import java.util.HashMap;

import util.JDBCUtil;
import vo.OuterparkUserVO;
import vo.RoomVO;

public class RoomDAO {
	private static RoomDAO instance = new RoomDAO(); 
	public static RoomDAO getInstance() {
		return instance;
	}
	
	JDBCUtil jdbc = JDBCUtil.getInstance();
	
	private RoomDAO() {}
	
	public int insertRoom(RoomVO vo) {
		String query = String.format("INSERT INTO ROOM VALUES (%d,'%s','%s',%d ,%d, %d, %d, '%s','%s')"
				, vo.getRoomNumber(), vo.getUserId(), vo.getRoomName(), vo.getMaxCapacitt(), vo.getRoomCount(), vo.getBedCount(), vo.getRoomPrice(), vo.getCity(), vo.getExplanation());
		return jdbc.Update(query);
	}
	
	public int deleteRoom(RoomVO vo) {
		String query = String.format("DELETE FROM ROOM WHERE ROOM_NUMBER = %d", vo.getRoomNumber());
		return jdbc.Update(query);
	}
	
	public ArrayList<HashMap<String, Object>> select(OuterparkUserVO vo) {
		String query = String.format("SELECT * FROM ROOM WHERE USER_ID = '%s'", vo.getUserId());
		return jdbc.selectList(query);
	}

}
