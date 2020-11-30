package pay.model.vo;

public class Pay {
	private int payNo;
	private String payAmount;
	private String payDate;
	private int rsvNo;

	public Pay() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Pay(int payNo, String payAmount, String payDate, int rsvNo) {
		super();
		this.payNo = payNo;
		this.payAmount = payAmount;
		this.payDate = payDate;
		this.rsvNo = rsvNo;
	}

	public int getPayNo() {
		return payNo;
	}

	public void setPayNo(int payNo) {
		this.payNo = payNo;
	}

	public String getPayAmount() {
		return payAmount;
	}

	public void setPayAmount(String payAmount) {
		this.payAmount = payAmount;
	}

	public String getPayDate() {
		return payDate;
	}

	public void setPayDate(String payDate) {
		this.payDate = payDate;
	}

	public int getRsvNo() {
		return rsvNo;
	}

	public void setRsvNo(int rsvNo) {
		this.rsvNo = rsvNo;
	}

}
