package rsv.model.vo;

public class Report {
	private int report_No;
	private String report_Date;
	private String report_ER;
	private String report_EE;
	private String report_Comment;
	private int rsv_No;
	private int user_Report;
	
	public int getReport_No() {
		return report_No;
	}
	public void setReport_No(int report_No) {
		this.report_No = report_No;
	}
	public String getReport_Date() {
		return report_Date;
	}
	public void setReport_Date(String report_Date) {
		this.report_Date = report_Date;
	}
	public String getReport_ER() {
		return report_ER;
	}
	public void setReport_ER(String report_ER) {
		this.report_ER = report_ER;
	}
	public String getReport_EE() {
		return report_EE;
	}
	public void setReport_EE(String report_EE) {
		this.report_EE = report_EE;
	}
	public String getReport_Comment() {
		return report_Comment;
	}
	public void setReport_Comment(String report_Comment) {
		this.report_Comment = report_Comment;
	}
	public int getRsv_No() {
		return rsv_No;
	}
	public void setRsv_No(int rsv_No) {
		this.rsv_No = rsv_No;
	}
	public int getUser_Report() {
		return user_Report;
	}
	public void setUser_Report(int user_Report) {
		this.user_Report = user_Report;
	}
	public Report() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Report(int report_No, String report_Date, String report_ER, String report_EE, String report_Comment,
			int rsv_No, int user_Report) {
		super();
		this.report_No = report_No;
		this.report_Date = report_Date;
		this.report_ER = report_ER;
		this.report_EE = report_EE;
		this.report_Comment = report_Comment;
		this.rsv_No = rsv_No;
		this.user_Report = user_Report;
	}

	

}
