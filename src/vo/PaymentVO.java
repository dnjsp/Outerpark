package vo;

public class PaymentVO {
	private int cartNo;
	private String userId;
	private int packNum;
	private String startDate;
	private String endDate;
	private int people;
	private String payDate;
	private String refund;
	
	public PaymentVO(int cartNo, String userId, int packNum, String startDate, String endDate, int people, String payDate,
			String refund) {
		this.cartNo = cartNo;
		this.userId = userId;
		this.packNum = packNum;
		this.startDate = startDate;
		this.endDate = endDate;
		this.people = people;
		this.payDate = payDate;
		this.refund = refund;
	}

	public int getCartNo() {
		return cartNo;
	}

	public void setCartNo(int cartNo) {
		this.cartNo = cartNo;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getPackNum() {
		return packNum;
	}

	public void setPackNum(int packNum) {
		this.packNum = packNum;
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

	public int getPeople() {
		return people;
	}

	public void setPeople(int people) {
		this.people = people;
	}

	public String getPayDate() {
		return payDate;
	}

	public void setPayDate(String payDate) {
		this.payDate = payDate;
	}

	public String getRefund() {
		return refund;
	}

	public void setRefund(String refund) {
		this.refund = refund;
	}

	@Override
	public String toString() {
		return "Payment [cartNo=" + cartNo + ", userId=" + userId + ", packNum=" + packNum + ", startDate=" + startDate
				+ ", endDate=" + endDate + ", people=" + people + ", payDate=" + payDate + ", refund=" + refund + "]";
	}
}
