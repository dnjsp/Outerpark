package vo;

public class PaymentVO {
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
