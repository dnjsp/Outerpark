package vo;

public class RoomVO {
	private int roomNumber;
	private String userId;
	private String roomName;
	private int maxCapacitt;
	private int roomCount;
	private int bedCount;
	private int roomPrice;
	private String city;
	private String explanation;

	public RoomVO(String userId, String roomName, int maxCapacitt, int roomCount, int bedCount,
			int roomPrice, String city, String explanation) {
		this.userId = userId;
		this.roomName = roomName;
		this.maxCapacitt = maxCapacitt;
		this.roomCount = roomCount;
		this.bedCount = bedCount;
		this.roomPrice = roomPrice;
		this.city = city;
		this.explanation = explanation;
	}
	
	public RoomVO(int roomNumber) {
		this.roomNumber = roomNumber;
	}
	
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

	public int getMaxCapacitt() {
		return maxCapacitt;
	}

	public void setMaxCapacitt(int maxCapacitt) {
		this.maxCapacitt = maxCapacitt;
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

	@Override
	public String toString() {
		return "RoomVO [roomNumber=" + roomNumber + ", userId=" + userId + ", roomName=" + roomName + ", maxCapacitt="
				+ maxCapacitt + ", roomCount=" + roomCount + ", bedCount=" + bedCount + ", roomPrice=" + roomPrice
				+ ", city=" + city + ", explanation=" + explanation + "]";
	}
}
