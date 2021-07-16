package SWING;

import java.util.ArrayList;
import java.util.HashMap;

import dao.OuterparkUserDAO;


public class OuterparkApplication {
	public static void main(String[] args) {
		
	
		
//	OuterparkUserDAO userdao = OuterparkUserDAO.getInstance();
//	OuterparkUserVO uservo = new OuterparkUserVO("dnjsp","dnjsp", "조원혜", "원혜", "dnjsp@naver.com", "host");
//	userdao.insertUser(uservo);
//	
//	CarDAO cardao = CarDAO.getInstance();
//	CarVO carVO = new CarVO("000가0000", "master", "없음", 0, 0, "없음", "없음");
//	cardao.Carinsert("master", carVO);
//	
//	TourDAO tourdao = TourDAO.getInstance();
//	TourVO tourVO = new TourVO(0, "master", "없음", "없음", 0, "없음", "없음");
//	tourdao.Tourinsert("master", tourVO);
	
	OuterparkUserDAO userdao = OuterparkUserDAO.getInstance();
	ArrayList<HashMap<String, Object>> list = userdao.select();
		int size = list.size();
	    String[] key = {"USER_ID","USER_NAME","USER_NICKNAME","USER_MAIL","USER_TYPE"};
	    System.out.println("아이디\t이름\t닉네임\t");
	    for(int i=0; i<size;i++) {
	    	for(int j=0; j<key.length; j++) {
	    		System.out.print(list.get(i).get(key[j])+"\t");
	    	}
	        System.out.println();
	      }
	}
}

