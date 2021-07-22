package vo;

public class CarVO {
	private String carNumber;
	private String userId;
	private String carKind;
	private int carPrice;
	private int carSeats;
	private String city;
	private String carColor;

	public CarVO(String carNumber) {
		this.carNumber = carNumber;
	}
	
	public CarVO(String city,int carSeats) {
		this.city = city;
		this.carSeats = carSeats;
	}
	
	public CarVO(String carNumber, String userId, String carKind, int carPrice, int carSeats, String city,
			String carColor) {
		this.carNumber = carNumber;
		this.userId = userId;
		this.carKind = carKind;
		this.carPrice = carPrice;
		this.carSeats = carSeats;
		this.city = city;
		this.carColor = carColor;
	}

	public String getCarNumber() {
		return carNumber;
	}

	public void setCarNumber(String carNumber) {
		this.carNumber = carNumber;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getCarKind() {
		return carKind;
	}

	public void setCarKind(String carKind) {
		this.carKind = carKind;
	}

	public int getCarPrice() {
		return carPrice;
	}

	public void setCarPrice(int carPrice) {
		this.carPrice = carPrice;
	}

	public int getCarSeats() {
		return carSeats;
	}

	public void setCarSeats(int carSeats) {
		this.carSeats = carSeats;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCarColor() {
		return carColor;
	}

	public void setCarColor(String carColor) {
		this.carColor = carColor;
	}

	@Override
	public String toString() {
		return "CarVO [carNumber=" + carNumber + ", userId=" + userId + ", carKind=" + carKind + ", carPrice="
				+ carPrice + ", carSeats=" + carSeats + ", city=" + city + ", carColor=" + carColor + "]";
	}
<<<<<<< HEAD
}
=======
}
>>>>>>> 52a1a8e3191290d33b866d216650a9fc40a5cd2b
