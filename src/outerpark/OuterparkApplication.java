package outerpark;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import outerparkuser.*;
import util.JDBCUtil;

public class OuterparkApplication {
	public static void main(String[] args) {
		OuterparkUserDAO userdao = OuterparkUserDAO.getInstance();
		//OuterparkUserVO uservo = new OuterparkUserVO("master","master", "master", "master", "show5116@naver.com", "host");
		
		
		ArrayList<HashMap<String, Object>> list = userdao.select();
		System.out.println(list.size());
		String[] key = {"USER_ID","USER_PASSWORD","USER_NAME","USER_NICKNAME","USER_MAIL","USER_TYPE"};
		for (int i = 0; i < list.size(); i++) {
			for (int j = 0; j < key.length; j++) {
				System.out.print(list.get(i).get(key[j]) + "\t\t");
			}
			System.out.println();
		}
		//userdao.insertUser(uservo);
	}
}

