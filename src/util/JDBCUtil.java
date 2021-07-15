package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JDBCUtil {
	private static JDBCUtil instance = new JDBCUtil();
	public static JDBCUtil getInstance() {
		return instance;
	}

	private JDBCUtil() {}
	
	Connection conn;
	PreparedStatement pstm;
	ResultSet rs;
	
	public Connection getConnection()
	{
		Connection conn = null;
		try {
			String user = "YYJ95"; 
			String pw = "java";
			String url = "jdbc:oracle:thin:@192.168.46.30:1521:xe";
			Class.forName("oracle.jdbc.driver.OracleDriver");        
			conn = DriverManager.getConnection(url, user, pw);          
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;     
	}
	
	public void DBclose(Connection conn, PreparedStatement pstm, ResultSet rs){
		try {
			if ( rs != null )  rs.close();   
			if ( pstm != null )pstm.close();  
			if ( conn != null )conn.close(); 			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
		
	public int Update(String query) {
		try {
			conn = this.getConnection();
			pstm = conn.prepareStatement(query);
			return pstm.executeUpdate();		
		}catch(Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	public boolean SelectBoolean(String query) {
		try {
			conn = this.getConnection();
			pstm = conn.prepareStatement(query);
			rs = pstm.executeQuery();	
			return rs.next();
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public String SelectString(String query,String col) {
		try {
			conn = this.getConnection();
			pstm = conn.prepareStatement(query);
			rs = pstm.executeQuery();
			rs.next();
			return rs.getString(col);
		}catch(Exception e) {
			return null;
		}
	}
}
