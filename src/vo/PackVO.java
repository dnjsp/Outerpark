package vo;

public class PackVO {
	private int packNum;
	private int tourNumber;
	private int roomNumber;
	private String carNumber;
	private String startDate;
	private String endDate;
	private String people;
	
	public PackVO(int packNum, int tourNumber, int roomNumber, String carNumber, String startDate, String endDate,
			String people) {
		super();
		this.packNum = packNum;
		this.tourNumber = tourNumber;
		this.roomNumber = roomNumber;
		this.carNumber = carNumber;
		this.startDate = startDate;
		this.endDate = endDate;
		this.people = people;
	}
	
	public PackVO(int tourNumber, int roomNumber, String carNumber, String startDate, String endDate,
			String people) {
		super();
		this.tourNumber = tourNumber;
		this.roomNumber = roomNumber;
		this.carNumber = carNumber;
		this.startDate = startDate;
		this.endDate = endDate;
		this.people = people;
	}
	
	public int getPackNum() {
		return packNum;
	}
	public void setPackNum(int packNum) {
		this.packNum = packNum;
	}
	public int getTourNumber() {
		return tourNumber;
	}
	public void setTourNumber(int tourNumber) {
		this.tourNumber = tourNumber;
	}
	public int getRoomNumber() {
		return roomNumber;
	}
	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}
	public String getCarNumber() {
		return carNumber;
	}
	public void setCarNumber(String carNumber) {
		this.carNumber = carNumber;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getPeople() {
		return people;
	}
	public void setPeople(String people) {
		this.people = people;
	}
	
	@Override
	public String toString() {
		return "PackVO [packNum=" + packNum + ", tourNumber=" + tourNumber + ", roomNumber=" + roomNumber
				+ ", carNumber=" + carNumber + ", startDate=" + startDate + ", endDate=" + endDate + ", people="
				+ people + "]";
	}

}
