package dao;

import java.util.ArrayList;
import java.util.HashMap;

import util.JDBCUtil;
import view.LoginService;
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
		String query = String.format("INSERT INTO ROOM VALUES (%s,'%s','%s',%d ,%d, %d, %d, '%s','%s')"
				, "SEQ_ROOM.NEXTVAL", vo.getUserId(), vo.getRoomName(), vo.getMaxCapacity(), vo.getRoomCount(), vo.getBedCount(), vo.getRoomPrice(), vo.getCity(), vo.getExplanation());
		return jdbc.Update(query);
	}
	
	public int deleteRoom(RoomVO vo) {
		String query = String.format("DELETE FROM ROOM WHERE ROOM_NUMBER = '%s' AND USER_ID = '%s'", vo.getRoomNumber(),LoginService.loginId.getUserId());
		return jdbc.Update(query);
	}
	
	public ArrayList<HashMap<String, Object>> select(OuterparkUserVO vo) {
		String query = String.format("SELECT * FROM ROOM WHERE USER_ID = '%s'", vo.getUserId());
		return jdbc.selectList(query);
	}

	public ArrayList<HashMap<String, Object>> selectRoom (RoomVO vo) {
		String query = String.format("SELECT * FROM ROOM WHERE CITY = '%s' AND MAX_CAPACITY >= %d", vo.getCity(), vo.getMaxCapacity());
		return jdbc.selectList(query);
	}
	
	public int selectRoomPrice(int roomNumber) {
		String query = String.format("SELECT ROOM_PRICE FROM ROOM WHERE ROOM_NUMBER = %d", roomNumber);
		return jdbc.Selectint(query, "ROOM_PRICE");
	}
}
