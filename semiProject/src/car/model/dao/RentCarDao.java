package car.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import car.model.vo.Car;
import car.model.vo.Review;
import common.JDBCTemplate;

public class RentCarDao {

	public ArrayList<Car> selectList(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Car> list = new ArrayList<Car>();
		String query = "select * from car where to_date(car_edate) > sysdate order by car_no desc";
		
		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Car c = new Car();
				c.setCarEdate(rset.getString("car_edate"));
				c.setCarImage(rset.getString("car_image"));
				c.setCarImage2(rset.getString("car_image2"));
				c.setCarImage3(rset.getString("car_image3"));
				c.setCarImage4(rset.getString("car_image4"));
				c.setCarLocation(rset.getString("car_location"));
				c.setCarName(rset.getString("car_name"));
				c.setCarNo(rset.getInt("car_no"));
				c.setCarPrice(rset.getString("car_price"));
				c.setCarRate(rset.getDouble("car_rate"));
				c.setCarSdate(rset.getString("car_sdate"));
				c.setCarType(rset.getString("car_type"));
				c.setCarYear(rset.getInt("car_year"));
				c.setUserId(rset.getString("user_id"));
				c.setCarNopan(rset.getString("car_nopan"));
				list.add(c);
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

	public Car selectOneCar(Connection conn, int carNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Car c = new Car();
		String query="select * from car where car_no =?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, carNo);
			
			rset = pstmt.executeQuery();
			if(rset.next()) {
				c = new Car();
				c.setCarEdate(rset.getString("car_edate"));
				c.setCarImage(rset.getString("car_image"));
				c.setCarImage2(rset.getString("car_image2"));
				c.setCarImage3(rset.getString("car_image3"));
				c.setCarImage4(rset.getString("car_image4"));
				c.setCarLocation(rset.getString("car_location"));
				c.setCarName(rset.getString("car_name"));
				c.setCarNo(rset.getInt("car_no"));
				c.setCarPrice(rset.getString("car_price"));
				c.setCarRate(rset.getDouble("car_rate"));
				c.setCarSdate(rset.getString("car_sdate"));
				c.setCarType(rset.getString("car_type"));
				c.setCarYear(rset.getInt("car_year"));
				c.setUserId(rset.getString("user_id"));
				c.setCarNopan(rset.getString("car_nopan"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return c;
	}

	public ArrayList<Review> selectReview(Connection conn, int carNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Review> list = new ArrayList<Review>();
		String query="select * from review where car_no=? order by rev_no desc";
		
		try {
			pstmt =conn.prepareStatement(query);
			pstmt.setInt(1, carNo);
			
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Review r = new Review();
				r.setCarNo(rset.getInt("car_no"));
				r.setRevContent(rset.getString("rev_content"));
				r.setRevNo(rset.getInt("rev_no"));
				r.setRevRate(rset.getInt("rev_rate"));
				r.setRevWriter(rset.getString("rev_writer"));
				r.setRevEnrollDate(rset.getString("enroll_date"));
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

}
