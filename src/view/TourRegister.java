package view;

import java.util.ArrayList;
import java.util.HashMap;

import dao.TourDAO;
import util.ScannerBuffer;
import vo.TourVO;

public class TourRegister {
	private TourRegister() {}
	private static TourRegister instance;
	public static TourRegister getInstance(){
		if(instance == null){
			instance = new TourRegister();
		}
		return instance;
	}
	
	private TourDAO tourDao = TourDAO.getInstance();
	private ScannerBuffer scanner = ScannerBuffer.getInstance();
	
	public void tourInformation() {
		System.out.println("1.관광명소 등록 2.관광명소 삭제 3.뒤로 가기");
		System.out.print("번호를 입력해주세요> ");
	}
	
	public void reTourInformation() {
		System.out.println("다시 입력해주세요.");
	}
	
	public void tourInsert() {
		System.out.print("관광명소 번호> ");
		int tourNumber = scanner.nextInt();
		System.out.print("Host 아이디> ");
		String userId = scanner.next();
		System.out.print("관광명소 이름> ");
		String tourName = scanner.next();
		System.out.print("관광명소 시간> ");
		String tourTime = scanner.next();
		System.out.print("가격> ");
		int tourPrice = scanner.nextInt();
		System.out.print("지역> ");
		String city = scanner.next();
		System.out.print("설명> ");
		String explanation = scanner.next();
		tourDao.insertTour(new TourVO(tourNumber, userId, tourName, tourTime, tourPrice, city, explanation));
		System.out.println("등록 성공");
	}
	
	public void tourDelete() {
		System.out.print("관광명소 번호> ");
		int tourNumber = scanner.nextInt(); 
		// 비밀번호 입력
		if (tourDao.deleteTour(new TourVO(tourNumber)) == 1) {
			System.out.println("삭제되었습니다.");
		} else {
			System.out.println("존재하지 않는 관광명소입니다.");
		}
	}
	
	public void tourSearch() {
		ArrayList<HashMap<String, Object>> list = tourDao.select(LoginService.loginId);
		int size = list.size();
		String[] key = {"TOUR_NUMBER","TOUR_NAME","TOUR_TIME","TOUR_PRICE","CITY","EXPLANATION"};
		System.out.println("번호\t이름\t시간\t가격\t지역\t설명");
		for(int i=0; i<size;i++) {
			for(int j=0; j<key.length; j++) {
				System.out.print(list.get(i).get(key[j])+"\t");
			}
			System.out.println();
		}
	}
}
