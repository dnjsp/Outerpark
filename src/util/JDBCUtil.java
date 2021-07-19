package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.HashMap;

public class JDBCUtil {
	private static JDBCUtil instance = new JDBCUtil();
	public static JDBCUtil getInstance() {
		return instance;
	}

	private JDBCUtil() {}
	
	Connection conn;
	PreparedStatement pstm;
	ResultSet rs;
	ResultSetMetaData metaData;
	
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
		
	public void DBclose(Connection conn, PreparedStatement pstm){
		try {  
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
			int excute = pstm.executeUpdate();
			this.DBclose(conn, pstm);
			return excute;
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
	
	public ArrayList<HashMap<String, Object>> selectList(String query) {
		ArrayList<HashMap<String, Object>> list = new ArrayList<>();
		try {
			conn = this.getConnection();
			pstm = conn.prepareStatement(query);
			rs = pstm.executeQuery();
			metaData = rs.getMetaData();
			int sizeColumn = metaData.getColumnCount();
			
			while(rs.next()) {
				HashMap<String, Object> hash = new HashMap<String,Object>(sizeColumn);
				for(int i=1;i<=sizeColumn;++i) {
					hash.put(metaData.getColumnName(i),rs.getObject(i));
				}
				list.add(hash);
			}
		}catch(Exception e) {
			return null;
		}
		this.DBclose(conn, pstm, rs);
		return list;
	}
	
}