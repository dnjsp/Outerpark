package vo;

public class PaymentVO {
	private int cartNo;
	private String userId;
	private int packNum;
	private String payDate;
	private String refund;
	
	public PaymentVO(int cartNo, String userId, int packNum, String payDate, String refund) {
		super();
		this.cartNo = cartNo;
		this.userId = userId;
		this.packNum = packNum;
		this.payDate = payDate;
		this.refund = refund;
	}
	
	public PaymentVO(String userId, int packNum, String payDate, String refund) {
		super();
		this.userId = userId;
		this.packNum = packNum;
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
		return "PaymentVO [cartNo=" + cartNo + ", userId=" + userId + ", packNum=" + packNum + ", payDate=" + payDate
				+ ", refund=" + refund + "]";
	}
}
