package vo;

public class PaymentVO {
<<<<<<< HEAD
	private int cartNumber;
	private String userId;
	private int packNumber;
	private String payDate;
	private String refund;
	
	public PaymentVO(int cartNumber, String userId, int packNum, String payDate, String refund) {
		super();
		this.cartNumber = cartNumber;
		this.userId = userId;
		this.packNumber = packNum;
		this.payDate = payDate;
		this.refund = refund;
	}
	
	public PaymentVO(String userId, int packNum, String payDate, String refund) {
		super();
		this.userId = userId;
		this.packNumber = packNum;
		this.payDate = payDate;
		this.refund = refund;
	}
	
	public int getCartNo() {
		return cartNumber;
	}
	public void setCartNo(int cartNo) {
		this.cartNumber = cartNo;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public int getPackNum() {
		return packNumber;
	}
	public void setPackNum(int packNum) {
		this.packNumber = packNum;
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
		return "PaymentVO [cartNumber=" + cartNumber + ", userId=" + userId + ", packNumber=" + packNumber + ", payDate=" + payDate
				+ ", refund=" + refund + "]";
	}
}
=======
	private int cartNo;
	private String userId;
	private int packNum;
	private String payDate;
	private String state;
	private int price;

	public PaymentVO(int cartNo, String userId, int packNum, String payDate, String state, int price) {
		this.cartNo = cartNo;
		this.userId = userId;
		this.packNum = packNum;
		this.payDate = payDate;
		this.state = state;
		this.price = price;
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

	public String getPayDate() {
		return payDate;
	}

	public void setPayDate(String payDate) {
		this.payDate = payDate;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "PaymentVO [cartNo=" + cartNo + ", userId=" + userId + ", packNum=" + packNum + ", payDate=" + payDate
				+ ", state=" + state + ", price=" + price + "]";
	}
}
>>>>>>> 52a1a8e3191290d33b866d216650a9fc40a5cd2b
