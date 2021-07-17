package vo;

public class TourVO {
	private int tourNumber;
	private String userId;
	private String tourName;
	private String tourTime;
	private int tourPrice;
	private String city;
	private String explanation;
	
	public TourVO(int tourNumber) {
		this.tourNumber = tourNumber;
	}
	
	public TourVO(int tourNumber, String userId, String tourName, String tourTime, int tourPrice, String city,
			String explanation) {
		this.tourNumber = tourNumber;
		this.userId = userId;
		this.tourName = tourName;
		this.tourTime = tourTime;
		this.tourPrice = tourPrice;
		this.city = city;
		this.explanation = explanation;
	}

	public int getTourNumber() {
		return tourNumber;
	}

	public void setTourNumber(int tourNumber) {
		this.tourNumber = tourNumber;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getTourName() {
		return tourName;
	}

	public void setTourName(String tourName) {
		this.tourName = tourName;
	}

	public String getTourTime() {
		return tourTime;
	}

	public void setTourTime(String tourTime) {
		this.tourTime = tourTime;
	}

	public int getTourPrice() {
		return tourPrice;
	}

	public void setTourPrice(int tourPrice) {
		this.tourPrice = tourPrice;
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
		return "TourVO [tourNumber=" + tourNumber + ", userId=" + userId + ", tourName=" + tourName + ", tourTime="
				+ tourTime + ", tourPrice=" + tourPrice + ", city=" + city + ", explanation=" + explanation + "]";
	}
}
