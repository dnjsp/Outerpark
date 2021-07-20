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
	
	public void tourInsert() {
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
		if (tourDao.insertTour(new TourVO(LoginService.loginId.getUserId(), tourName, tourTime, tourPrice, city, explanation)) == 1) {
			System.out.println("등록 성공\n\n\n");
		} else {
			System.out.println("등록에 실패했습니다.\n\n\n");
		};
	}
	
	public void tourDelete() {
		System.out.print("관광명소 번호> ");
		int tourNumber = scanner.nextInt();
		if (tourDao.deleteTour(new TourVO(tourNumber)) == 1) {
			System.out.println("삭제되었습니다.\n\n\n");
		} else {
			System.out.println("존재하지 않거나 본인이 등록한 관광명소가 아닙니다.\n\n\n");
		}
	}
	
	public void tourSearch() {
		ArrayList<HashMap<String, Object>> list = tourDao.select(LoginService.loginId);
		int size = list.size();
		System.out.println("번호\t\t이름\t\t시간\t가격\t지역\t설명");
		for(int i=0; i<size;i++) {
			System.out.print(list.get(i).get("TOUR_NUMBER")+"\t");
			System.out.printf("%16s\t",list.get(i).get("TOUR_NAME"));
			System.out.print(list.get(i).get("TOUR_TIME")+"\t");
			System.out.print(list.get(i).get("TOUR_PRICE")+"\t");
			System.out.print(list.get(i).get("CITY")+"\t");
			System.out.print(list.get(i).get("EXPLANATION")+"\n");
		}
		System.out.println("\n\n\n");
	}
}
