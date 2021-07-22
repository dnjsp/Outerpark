package vo;

public class RoomVO {
	private int roomNumber;
	private String userId;
	private String roomName;
	private int maxCapacity;
	private int roomCount;
	private int bedCount;
	private int roomPrice;
	private String city;
	private String explanation;
<<<<<<< HEAD

=======
	
>>>>>>> 52a1a8e3191290d33b866d216650a9fc40a5cd2b
	public RoomVO(int roomNumber) {
		this.roomNumber = roomNumber;
	}
	
	public RoomVO(String city,int maxCapacity) {
		this.city = city;
		this.maxCapacity = maxCapacity;
	}
	
	public RoomVO(String userId, String roomName, int maxCapacity, int roomCount, int bedCount,
			int roomPrice, String city, String explanation) {
		this.userId = userId;
		this.roomName = roomName;
		this.maxCapacity = maxCapacity;
		this.roomCount = roomCount;
		this.bedCount = bedCount;
		this.roomPrice = roomPrice;
		this.city = city;
		this.explanation = explanation;
	}
<<<<<<< HEAD
	
	public int getRoomNumber() {
		return roomNumber;
	}
	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getRoomName() {
		return roomName;
	}
	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}
	public int getMaxCapacity() {
		return maxCapacity;
	}
	public void setMaxCapacity(int maxCapacity) {
		this.maxCapacity = maxCapacity;
	}
	public int getRoomCount() {
		return roomCount;
	}
	public void setRoomCount(int roomCount) {
		this.roomCount = roomCount;
	}
	public int getBedCount() {
		return bedCount;
	}
	public void setBedCount(int bedCount) {
		this.bedCount = bedCount;
	}
	public int getRoomPrice() {
		return roomPrice;
	}
	public void setRoomPrice(int roomPrice) {
		this.roomPrice = roomPrice;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getExplanation() {
		return explanation;
	}
	public void setExplanation(String explanation) {
		this.explanation = explanation;
	}
	
=======

	public int getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	public int getMaxCapacity() {
		return maxCapacity;
	}

	public void setMaxCapacity(int maxCapacity) {
		this.maxCapacity = maxCapacity;
	}

	public int getRoomCount() {
		return roomCount;
	}

	public void setRoomCount(int roomCount) {
		this.roomCount = roomCount;
	}

	public int getBedCount() {
		return bedCount;
	}

	public void setBedCount(int bedCount) {
		this.bedCount = bedCount;
	}

	public int getRoomPrice() {
		return roomPrice;
	}

	public void setRoomPrice(int roomPrice) {
		this.roomPrice = roomPrice;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getExplanation() {
		return explanation;
	}

	public void setExplanation(String explanation) {
		this.explanation = explanation;
	}

>>>>>>> 52a1a8e3191290d33b866d216650a9fc40a5cd2b
	@Override
	public String toString() {
		return "RoomVO [roomNumber=" + roomNumber + ", userId=" + userId + ", roomName=" + roomName + ", maxCapacity="
				+ maxCapacity + ", roomCount=" + roomCount + ", bedCount=" + bedCount + ", roomPrice=" + roomPrice
				+ ", city=" + city + ", explanation=" + explanation + "]";
	}
<<<<<<< HEAD

	
}
=======
}
>>>>>>> 52a1a8e3191290d33b866d216650a9fc40a5cd2b
