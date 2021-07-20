package vo;

public class PackVO {
	private int packNum;
	private int tourNumber;
	private int roomNumber;
	private String carNumber;
	private int startDate;
	private int endDate;
	private int people;
	
	public PackVO(int packNum, int tourNumber, int roomNumber, String carNumber, int startDate, int endDate,
			int people) {
		this.packNum = packNum;
		this.tourNumber = tourNumber;
		this.roomNumber = roomNumber;
		this.carNumber = carNumber;
		this.startDate = startDate;
		this.endDate = endDate;
		this.people = people;
	}
	
	public PackVO(int tourNumber, int roomNumber, String carNumber, int startDate, int endDate,
			int people) {
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

	public int getStartDate() {
		return startDate;
	}

	public void setStartDate(int startDate) {
		this.startDate = startDate;
	}

	public int getEndDate() {
		return endDate;
	}

	public void setEndDate(int endDate) {
		this.endDate = endDate;
	}

	public int getPeople() {
		return people;
	}

	public void setPeople(int people) {
		this.people = people;
	}

	@Override
	public String toString() {
		return "PackVO [packNum=" + packNum + ", tourNumber=" + tourNumber + ", roomNumber=" + roomNumber
				+ ", carNumber=" + carNumber + ", startDate=" + startDate + ", endDate=" + endDate + ", people="
				+ people + "]";
	}
}
