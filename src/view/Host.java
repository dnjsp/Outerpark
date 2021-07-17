package view;

public class Host {
	private Host() {}
	private static Host instance;
	public static Host getInstance(){
		if(instance == null){
			instance = new Host();
		}
		return instance;
	}
	
	public void host() {
		System.out.println("== Host로 입장하였습니다. ==");
		System.out.println("1.방 2.렌트카 3.관광명소 4.로그아웃"); 
		System.out.print("번호를 입력해주세요> ");	
	}
	
	public void reHost() {
		System.out.println("다시 입력해주세요.");
		System.out.println("1.방 2. 렌트카 3. 관광명소 4.로그아웃 "); 
		System.out.print("번호를 입력해주세요> ");
	}
}
