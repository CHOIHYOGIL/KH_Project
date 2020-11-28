package rsv.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import car.model.vo.Review;
import common.JDBCTemplate;
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
		
		PreparedStatement pstmt=null;
		int result=0;
		String query="insert into reservation values(?,?,to_char(sysdate,'yyyy-mm-dd'),RESERVATION_SEQ.nextval,?,?,?,?,1,?)";
		
		try {
			pstmt=conn.prepareStatement(query);
			pstmt.setInt(1,rsv.getCarNo());
			pstmt.setString(2, rsv.getUserId());
			pstmt.setString(3, rsv.getRsvStart());
			pstmt.setString(4, rsv.getRsvEnd());
			pstmt.setString(5, rsv.getRsvStime());
			pstmt.setString(6, rsv.getRsvEtime());
			pstmt.setString(7, rsv.getRsvPrice());
			result=pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
		
		
	}



	public int insertReview(Connection conn, String userId, int carNo, String revCon, int rate) {
		PreparedStatement pstmt=null;
		int result=0;
		String query="insert into review values(review_seq.nextval,?,?,?,?,to_char(sysdate,'yyyy-mm-dd'))";
		
		try {
			pstmt=conn.prepareStatement(query);
			pstmt.setInt(1,carNo);
			pstmt.setString(2, userId);
			pstmt.setString(3, revCon);
			pstmt.setInt(4, rate);
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
