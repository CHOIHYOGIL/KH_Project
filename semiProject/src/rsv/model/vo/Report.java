package rsv.model.vo;

public class Report {
	private int reportNo;
	private String reportDate;
	private String reportER;
	private String reportEE;
	private String reportComment;
	private int rsvNo;

	public Report() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Report(int reportNo, String reportDate, String reportER, String reportEE, String reportComment, int rsvNo) {
		super();
		this.reportNo = reportNo;
		this.reportDate = reportDate;
		this.reportER = reportER;
		this.reportEE = reportEE;
		this.reportComment = reportComment;
		this.rsvNo = rsvNo;
	}

	public int getReportNo() {
		return reportNo;
	}

	public String getReportDate() {
		return reportDate;
	}

	public String getReportER() {
		return reportER;
	}

	public String getReportEE() {
		return reportEE;
	}

	public String getReportComment() {
		return reportComment;
	}

	public int getRsvNo() {
		return rsvNo;
	}

	public void setReportNo(int reportNo) {
		this.reportNo = reportNo;
	}

	public void setReportDate(String reportDate) {
		this.reportDate = reportDate;
	}

	public void setReportER(String reportER) {
		this.reportER = reportER;
	}

	public void setReportEE(String reportEE) {
		this.reportEE = reportEE;
	}

	public void setReportComment(String reportComment) {
		this.reportComment = reportComment;
	}

	public void setRsvNo(int rsvNo) {
		this.rsvNo = rsvNo;
	}

}
