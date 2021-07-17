package vo;

public class PackVO {
	private int packNum;
	private int tourNumber;
	private int roomNumber;
	private String carNumber;
	private int saleRate;

	public PackVO(int packNum, int tourNumber, int roomNumber, String carNumber, int saleRate) {
		this.packNum = packNum;
		this.tourNumber = tourNumber;
		this.roomNumber = roomNumber;
		this.carNumber = carNumber;
		this.saleRate = saleRate;
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

	public int getSaleRate() {
		return saleRate;
	}

	public void setSaleRate(int saleRate) {
		this.saleRate = saleRate;
	}

	@Override
	public String toString() {
		return "PackVO [packNum=" + packNum + ", tourNumber=" + tourNumber + ", roomNumber=" + roomNumber
				+ ", carNumber=" + carNumber + ", saleRate=" + saleRate + "]";
	}

}
