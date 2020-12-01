package rsv.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.JDBCTemplate;
import member.model.service.UserService;
import member.model.vo.User;
import rsv.model.vo.Report;
import rsv.model.vo.Rsv;

public class RsvDao {

	public ArrayList<Rsv> selectRsvList(Connection conn, String userId, int start, int end) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Rsv> list = new ArrayList<Rsv>();

		String query = "select * from (select rownum as rnum,n.* from (select * from reservation where user_id=?)n) where rnum between ? and ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userId);
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			rset = pstmt.executeQuery();
			while (rset.next()) {

				Rsv r = new Rsv();
				r.setrNum(rset.getInt("rNum"));
				r.setUserId(rset.getString("user_id"));
				r.setCarNo(rset.getInt("car_no"));
				r.setRsvDate(rset.getString("rsv_date"));
				r.setRsvNo(rset.getInt("rsv_no"));
				r.setRsvStart(rset.getString("rsv_start"));
				r.setRsvEnd(rset.getString("rsv_end"));
				r.setRsvStime(rset.getString("rsv_stime"));
				r.setRsvEtime(rset.getString("rsv_etime"));
				r.setRsvStatus(rset.getInt("rsv_status"));
				r.setRsvPrice(rset.getString("rsv_price"));

				list.add(r);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}

		return list;
	}

	public ArrayList<Rsv> selectCarRsvList(Connection conn, String userId, int start, int end) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Rsv> list = new ArrayList<Rsv>();

		String query = "select * from (select rownum as rnum,n.* from (select * from reservation where car_no=(select car_no from car where user_id=?))n) where rnum between ? and ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userId);
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			rset = pstmt.executeQuery();
			while (rset.next()) {

				Rsv r = new Rsv();
				r.setrNum(rset.getInt("rNum"));
				r.setUserId(rset.getString("user_id"));
				r.setRsvDate(rset.getString("rsv_date"));
				r.setRsvNo(rset.getInt("rsv_no"));
				r.setRsvStart(rset.getString("rsv_start"));
				r.setRsvEnd(rset.getString("rsv_end"));
				r.setRsvStime(rset.getString("rsv_stime"));
				r.setRsvEtime(rset.getString("rsv_etime"));
				r.setRsvStatus(rset.getInt("rsv_status"));
				r.setRsvPrice(rset.getString("rsv_price"));
				r.setCarNo(rset.getInt("car_no"));

				list.add(r);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}

		return list;
	}

	public int rsvTotalCount(Connection conn, String userId) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int result = 0;
		String query = "select count(*) cnt from reservation where user_id=?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userId);
			rset = pstmt.executeQuery();
			if (rset.next()) {
				result = rset.getInt("cnt");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int carRsvTotalCount(Connection conn, String userId) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int result = 0;
		String query = "select count(*) cnt from reservation where car_no=(select car_no from car where user_id=?)";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userId);
			rset = pstmt.executeQuery();
			if (rset.next()) {
				result = rset.getInt("cnt");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int updateRsvStatus(Connection conn, int rsvNo, int status) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "update reservation set rsv_status=? where rsv_no=?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, status);
			pstmt.setInt(2, rsvNo);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public Rsv selectOneRsv(Connection conn, int rsvNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Rsv r = null;
		String query = "select * from reservation where rsv_no=?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, rsvNo);
			rset = pstmt.executeQuery();
			if (rset.next()) {
				r = new Rsv();
				r.setUserId(rset.getString("user_id"));
				r.setRsvDate(rset.getString("rsv_date"));
				r.setRsvNo(rset.getInt("rsv_no"));
				r.setRsvStart(rset.getString("rsv_start"));
				r.setRsvEnd(rset.getString("rsv_end"));
				r.setRsvStime(rset.getString("rsv_stime"));
				r.setRsvEtime(rset.getString("rsv_etime"));
				r.setRsvStatus(rset.getInt("rsv_status"));
				r.setRsvPrice(rset.getString("rsv_price"));
				r.setCarNo(rset.getInt("car_no"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return r;
	}

	public int insertPayment(Connection conn, int rsvNo, String price) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "insert into pay values(pay_seq.nextval,?,to_char(sysdate,'yyyy-mm-dd'),?)";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, price);
			pstmt.setInt(2, rsvNo);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int insertCarRsv(Connection conn, Rsv rsv) {

		PreparedStatement pstmt = null;
		int result = 0;
		String query = "insert into reservation values(?,?,to_char(sysdate,'yyyy-mm-dd'),RESERVATION_SEQ.nextval,?,?,?,?,1,?)";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, rsv.getCarNo());
			pstmt.setString(2, rsv.getUserId());
			pstmt.setString(3, rsv.getRsvStart());
			pstmt.setString(4, rsv.getRsvEnd());
			pstmt.setString(5, rsv.getRsvStime());
			pstmt.setString(6, rsv.getRsvEtime());
			pstmt.setString(7, rsv.getRsvPrice());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;

	}

	public int insertReview(Connection conn, String userId, int carNo, String revCon, int rate, int rsvNo) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "insert into review values(review_seq.nextval,?,?,?,?,to_char(sysdate,'yyyy-mm-dd'),?)";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, carNo);
			pstmt.setString(2, userId);
			pstmt.setString(3, revCon);
			pstmt.setInt(4, rate);
			pstmt.setInt(5, rsvNo);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int insertReport(Connection conn, int rsvNo, String reporter, String reportee, String repCon) {
		PreparedStatement pstmt = null;
		int result = 0;
		int i = 1;
		String query = "insert into report values(report_seq.nextval,to_char(sysdate,'yyyy-mm-dd'),?,?,?,?)";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, reporter);
			pstmt.setString(2, reportee);
			pstmt.setString(3, repCon);
			pstmt.setInt(4, rsvNo);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}


	public int deleteReportRecord(Connection conn, int reportNo) {
		 PreparedStatement pstmt=null;
	      int result=0;
	      
	   
	      String query="delete from report where REPORT_NO=?";
	      try {
	         pstmt=conn.prepareStatement(query);
	         pstmt.setInt(1,reportNo);
	      
	         
	         result=pstmt.executeUpdate();
	         
	      } catch (SQLException e) {
	         // TODO Auto-generated catch block
	         e.printStackTrace();
	      }finally {
	         JDBCTemplate.close(pstmt);
	      }
	      return result;

	}

	public int reportAllDecision(Connection conn, String userId, int reportNo) {
		PreparedStatement pstmt=null;
	      int result=0;
	      
	      String query="update member set user_report=user_report+1 where USER_ID=?";
	      try {
	         pstmt=conn.prepareStatement(query);
	         pstmt.setString(1,userId);
	      
	         
	         result=pstmt.executeUpdate();
	         
	      } catch (SQLException e) {
	         // TODO Auto-generated catch block
	         e.printStackTrace();
	      }finally {
	         JDBCTemplate.close(pstmt);
	      }
	      return result;

	}

	public int deleteReportUser(Connection conn, int no) {
		PreparedStatement pstmt=null;
		int result=0;
		String query="delete from report where REPORT_NO=?";
		try {
			pstmt=conn.prepareStatement(query);
			pstmt.setInt(1,no);
		;
			result=pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public ArrayList<Report> selectAllMember(Connection conn) {
		PreparedStatement pstmt=null;
		ResultSet rset=null;
		ArrayList<Report> allMember=new ArrayList<Report>();
		String query="select * from report";
		
		try {
			pstmt=conn.prepareStatement(query);
			rset=pstmt.executeQuery();
			
			while(rset.next()) {
				
				Report report=new Report();
			
				report.setReport_Comment(rset.getString("REPORT_COMMENT"));
				report.setReport_Date(rset.getString("REPORT_DATE"));
				report.setReport_EE(rset.getString("REPORT_EE"));
				report.setReport_ER(rset.getString("REPORT_ER"));
				report.setReport_No(rset.getInt("REPORT_NO"));
				report.setRsv_No(rset.getInt("RSV_NO"));
		
				allMember.add(report);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rset);
		}
		
		return allMember;
	}

	public int totalCount(Connection conn) {
		 PreparedStatement pstmt = null;
	      ResultSet rset = null;
	      int result = 0;
	      String query = "select count(*) cnt from report";
	      try {
	         pstmt = conn.prepareStatement(query);
	         rset = pstmt.executeQuery();
	         if(rset.next()) {
	            result = rset.getInt("cnt");
	         }
	      } catch (SQLException e) {
	         // TODO Auto-generated catch block
	         e.printStackTrace();
	      } finally {
	         JDBCTemplate.close(rset);
	         JDBCTemplate.close(pstmt);
	      }      
	      return result;
	
	}

	public ArrayList<Report> selectList(Connection conn, int start, int end) {
		 PreparedStatement pstmt = null;
	      ResultSet rset = null;
	      String query = "select * from ( select rownum as unum, n.* from (select * from report order by 1 desc)n ) where unum between ? and ?";
	      ArrayList<Report> list = new ArrayList<Report>();
	      
	      try {
	         pstmt = conn.prepareStatement(query);
	         pstmt.setInt(1, start);
	         pstmt.setInt(2, end);
	         rset = pstmt.executeQuery();
	         while(rset.next()) {

					Report r=new Report();
					r.setReport_Comment(rset.getString("REPORT_COMMENT"));
					r.setReport_Date(rset.getString("REPORT_DATE"));
					r.setReport_EE(rset.getString("REPORT_EE"));
					r.setReport_ER(rset.getString("REPORT_ER"));
					r.setReport_No(rset.getInt("REPORT_NO"));
					r.setRsv_No(rset.getInt("RSV_NO"));
			
					list.add(r);          
	         }
	      } catch (SQLException e) {
	         // TODO Auto-generated catch block
	         e.printStackTrace();
	      }finally {
	         JDBCTemplate.close(rset);
	         JDBCTemplate.close(pstmt);
	      }      
	      
	      return list;
	}

	public int addUserReport(Connection conn, String id) {
		PreparedStatement pstmt=null;
		int result=0;
		String query="update member set user_report=user_report+1 where USER_ID=?";
		try {
			pstmt=conn.prepareStatement(query);
			pstmt.setString	(1,id);
		;
			result=pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

}
