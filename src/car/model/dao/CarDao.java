package car.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import car.model.vo.Car;
import car.model.vo.Review;
import common.JDBCTemplate;

public class CarDao {

	///////////////////////////////////////////////////
	//
	//
	// 소현
	//
	//
	////////////////////////////////////////////////////

	public int totalCount(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int result = 0;
		String query = "select count(*) cnt from car";
		try {
			pstmt = conn.prepareStatement(query);
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

	public ArrayList<Car> selectCarList(Connection conn, int start, int end) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Car> list = new ArrayList<Car>();

		String query = "select * from (select rownum as rnum,n.* from (select * from car order by car_Sdate)n) where rnum between ? and ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rset = pstmt.executeQuery();
			while (rset.next()) {
				Car c = new Car();
				c.setCarNo(rset.getInt("car_no"));
				c.setUserId(rset.getString("user_Id"));
				c.setCarName(rset.getString("car_Name"));
				c.setCarType(rset.getString("car_type"));
				c.setCarYear(rset.getInt("car_year"));
				c.setCarLocation(rset.getString("car_Location"));
				c.setCarPrice(rset.getString("car_Price"));
				c.setCarSdate(rset.getString("car_Sdate"));
				c.setCarEdate(rset.getString("car_Edate"));
				c.setCarNopan(rset.getString("car_nopan"));
				c.setCarRate(rset.getDouble("car_rate"));
				list.add(c);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}

		return list;
	}

	public Car selectOneCar(Connection conn, String userId) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Car c = null;
		String query = "select * from car where USER_ID=?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userId);
			rset = pstmt.executeQuery();
			if (rset.next()) {
				c = new Car();
				c.setUserId(userId);
				c.setCarNo(rset.getInt("CAR_NO"));
				c.setCarName(rset.getString("CAR_NAME"));
				c.setCarType(rset.getString("CAR_TYPE"));
				c.setCarYear(rset.getInt("CAR_YEAR"));
				c.setCarLocation(rset.getString("CAR_LOCATION"));
				c.setCarPrice(rset.getString("CAR_PRICE"));
				c.setCarSdate(rset.getString("CAR_SDATE"));
				c.setCarEdate(rset.getString("CAR_EDATE"));
				c.setCarNopan(rset.getString("CAR_NOPAN"));
				c.setCarRate(rset.getDouble("CAR_RATE"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}

		return c;
	}

	////////////////////////////////////////////////////////////////////

	///////////////////////////////////////////////////
	//
	//
	// 가영
	//
	//
	////////////////////////////////////////////////////

	public ArrayList<Car> selectList(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Car> list = new ArrayList<Car>();
		String query = "select * from car order by car_no desc";

		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			while (rset.next()) {
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
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}

		return list;
	}

	public Car selectOneCar(Connection conn, int carNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Car c = new Car();
		String query = "select * from car where car_no =?";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, carNo);

			rset = pstmt.executeQuery();
			if (rset.next()) {
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
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return c;
	}

	public ArrayList<Review> selectReview(Connection conn, int carNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Review> list = new ArrayList<Review>();
		String query = "select * from review where car_no=? order by rev_no desc";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, carNo);

			rset = pstmt.executeQuery();
			while (rset.next()) {
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
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return list;
	}

	///////////////////////////////////////////////////////////

	///////////////////////////////////////////////////
	//
	//
	// 기현
	//
	//
	////////////////////////////////////////////////////

	public int insertCar(Connection conn, Car car) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query ="insert into car values(car_seq.nextval,'testID',?,?,?,?,?,?,?,?,?,0,?,?,?)";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, car.getCarName());
			pstmt.setString(2, car.getCarType());
			pstmt.setInt(3, car.getCarYear());
			pstmt.setString(4, car.getCarImage());
			pstmt.setString(5, car.getCarLocation());
			pstmt.setString(6, car.getCarPrice());
			pstmt.setString(7, car.getCarSdate());
			pstmt.setString(8, car.getCarEdate());
			pstmt.setString(9, car.getCarNopan());
			pstmt.setString(10, car.getCarImage2());
			pstmt.setString(11, car.getCarImage3());
			pstmt.setString(12, car.getCarImage4());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	////////////////////////////////////////////////////////////

}
