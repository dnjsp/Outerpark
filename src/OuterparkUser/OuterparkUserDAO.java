package OuterparkUser;

import util.JDBCUtil;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class OuterparkUserDAO {
	private static OuterparkUserDAO instance = new OuterparkUserDAO();
	public static OuterparkUserDAO getInstance() {
		return instance;
	}

	private OuterparkUserDAO() {}
	
	JDBCUtil jdbc = JDBCUtil.getInstance();
	
	public int insertUser(OuterparkUserVO vo) {
		String query = String.format("INSERT INTO OUTERPARK_USER VALUES ('%s','%s','%s','%s','%s','%s')"
				,vo.getUserId(),vo.getUserPassword(),vo.getUserName(),vo.getUserNickname(),vo.getUserMail(),vo.getUsertype());
		return jdbc.Update(query);
	}
}
