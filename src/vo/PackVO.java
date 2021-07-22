package vo;

public class PackVO {
	private int packNum;
	private int tourNumber;
	private int roomNumber;
	private String carNumber;
<<<<<<< HEAD
	private int startDate;
	private int endDate;
	private int people;
	
	public PackVO(int packNum, int tourNumber, int roomNumber, String carNumber, int startDate, int endDate,
=======
	private String startDate;
	private String endDate;
	private int people;
	
	public PackVO(int packNum, int tourNumber, int roomNumber, String carNumber, String startDate, String endDate,
>>>>>>> 52a1a8e3191290d33b866d216650a9fc40a5cd2b
			int people) {
		this.packNum = packNum;
		this.tourNumber = tourNumber;
		this.roomNumber = roomNumber;
		this.carNumber = carNumber;
		this.startDate = startDate;
		this.endDate = endDate;
		this.people = people;
	}
<<<<<<< HEAD
	
	public PackVO(int tourNumber, int roomNumber, String carNumber, int startDate, int endDate,
			int people) {
=======

	public PackVO(int tourNumber, int roomNumber, String carNumber, String startDate, String endDate,
			int people) {
		super();
>>>>>>> 52a1a8e3191290d33b866d216650a9fc40a5cd2b
		this.tourNumber = tourNumber;
		this.roomNumber = roomNumber;
		this.carNumber = carNumber;
		this.startDate = startDate;
		this.endDate = endDate;
		this.people = people;
	}
<<<<<<< HEAD

=======
	
>>>>>>> 52a1a8e3191290d33b866d216650a9fc40a5cd2b
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

<<<<<<< HEAD
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
=======
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
>>>>>>> 52a1a8e3191290d33b866d216650a9fc40a5cd2b
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
<<<<<<< HEAD
}
=======

}
>>>>>>> 52a1a8e3191290d33b866d216650a9fc40a5cd2b
