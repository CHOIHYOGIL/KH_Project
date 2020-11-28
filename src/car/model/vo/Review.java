package car.model.vo;

/**
 * @author jayou
 *
 */
public class Review {
	private int revNo;
	private int carNo;
	private String revWriter;
	private String revContent;
	private int revRate;
	private String revEnrollDate;
	
	public Review() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Review(int revNo, int carNo, String revWriter, String revContent, int revRate, String revEnrollDate) {
		super();
		this.revNo = revNo;
		this.carNo = carNo;
		this.revWriter = revWriter;
		this.revContent = revContent;
		this.revRate = revRate;
		this.revEnrollDate = revEnrollDate;
	}
	public int getRevNo() {
		return revNo;
	}
	public void setRevNo(int revNo) {
		this.revNo = revNo;
	}
	public int getCarNo() {
		return carNo;
	}
	public void setCarNo(int carNo) {
		this.carNo = carNo;
	}
	public String getRevWriter() {
		return revWriter;
	}
	public void setRevWriter(String revWriter) {
		this.revWriter = revWriter;
	}
	public String getRevContent() {
		return revContent;
	}
	public void setRevContent(String revContent) {
		this.revContent = revContent;
	}
	public int getRevRate() {
		return revRate;
	}
	public void setRevRate(int revRate) {
		this.revRate = revRate;
	}
	public String getRevEnrollDate() {
		return revEnrollDate;
	}
	public void setRevEnrollDate(String revEnrollDate) {
		this.revEnrollDate = revEnrollDate;
	}
	
	
}
