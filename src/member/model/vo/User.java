package member.model.vo;

public class User {
	private int userNo;
	private String userId;
	private String userPw;
	private String userName;
	private String userAddr;
	private String userPhone;
	private String userEmail;
	private String userLicense;
	private int userGrade;
	private int userReport;
	private String userDate;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(int userNo, String userId, String userPw, String userName, String userAddr, String userPhone,
			String userEmail, String userLicense, int userGrade, int userReport, String userDate) {
		super();
		this.userNo = userNo;
		this.userId = userId;
		this.userPw = userPw;
		this.userName = userName;
		this.userAddr = userAddr;
		this.userPhone = userPhone;
		this.userEmail = userEmail;
		this.userLicense = userLicense;
		this.userGrade = userGrade;
		this.userReport = userReport;
		this.userDate = userDate;
	}
	public int getUserNo() {
		return userNo;
	}
	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPw() {
		return userPw;
	}
	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserAddr() {
		return userAddr;
	}
	public void setUserAddr(String userAddr) {
		this.userAddr = userAddr;
	}
	public String getUserPhone() {
		return userPhone;
	}
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserLicense() {
		return userLicense;
	}
	public void setUserLicense(String userLicense) {
		this.userLicense = userLicense;
	}
	public int getUserGrade() {
		return userGrade;
	}
	public void setUserGrade(int userGrade) {
		this.userGrade = userGrade;
	}
	public int getUserReport() {
		return userReport;
	}
	public void setUserReport(int userReport) {
		this.userReport = userReport;
	}
	public String getUserDate() {
		return userDate;
	}
	public void setUserDate(String userDate) {
		this.userDate = userDate;
	}
	
}
