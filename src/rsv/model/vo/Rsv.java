package rsv.model.vo;

public class Rsv {
	private int rNum;
	private int carNo;
	private String userId;
	private String rsvDate;
	private int rsvNo;
	private String rsvStart;
	private String rsvEnd;
	private int rsvStatus;
	private String rsvStime;
	private String rsvEtime;
	private String rsvPrice;

	public Rsv() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Rsv(int carNo, String userId, String rsvDate, int rsvNo, String rsvStart, String rsvEnd, String rsvStime,
			String rsvEtime, int rsvStatus, String rsvPrice) {
		super();
		this.carNo = carNo;
		this.userId = userId;
		this.rsvDate = rsvDate;
		this.rsvNo = rsvNo;
		this.rsvStart = rsvStart;
		this.rsvEnd = rsvEnd;
		this.rsvStime = rsvStime;
		this.rsvEtime = rsvEtime;
		this.rsvStatus = rsvStatus;
		this.rsvPrice = rsvPrice;
	}

	public int getrNum() {
		return rNum;
	}

	public void setrNum(int rNum) {
		this.rNum = rNum;
	}

	public int getCarNo() {
		return carNo;
	}

	public void setCarNo(int carNo) {
		this.carNo = carNo;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getRsvDate() {
		return rsvDate;
	}

	public void setRsvDate(String rsvDate) {
		this.rsvDate = rsvDate;
	}

	public int getRsvNo() {
		return rsvNo;
	}

	public void setRsvNo(int rsvNo) {
		this.rsvNo = rsvNo;
	}

	public String getRsvStart() {
		return rsvStart;
	}

	public void setRsvStart(String rsvStart) {
		this.rsvStart = rsvStart;
	}

	public String getRsvEnd() {
		return rsvEnd;
	}

	public void setRsvEnd(String rsvEnd) {
		this.rsvEnd = rsvEnd;
	}

	public String getRsvStime() {
		return rsvStime;
	}

	public void setRsvStime(String rsvStime) {
		this.rsvStime = rsvStime;
	}

	public String getRsvEtime() {
		return rsvEtime;
	}

	public void setRsvEtime(String rsvEtime) {
		this.rsvEtime = rsvEtime;
	}

	public int getRsvStatus() {
		return rsvStatus;
	}

	public void setRsvStatus(int rsvStatus) {
		this.rsvStatus = rsvStatus;
	}

	public String getRsvPrice() {
		return rsvPrice;
	}

	public void setRsvPrice(String rsvPrice) {
		this.rsvPrice = rsvPrice;
	}

}
