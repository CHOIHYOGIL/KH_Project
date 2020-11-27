package car.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import common.JDBCTemplate;
import car.model.dao.RentCarDao;
import car.model.vo.Car;
import car.model.vo.Review;

public class RentCarService {

	public ArrayList<Car> selectList() {
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<Car> list = new RentCarDao().selectList(conn);
		
		JDBCTemplate.close(conn);
		return list;
	}

	public Car selectOneCar(int carNo) {
		Connection conn = JDBCTemplate.getConnection();
		Car c = new RentCarDao().selectOneCar(conn,carNo);
		JDBCTemplate.close(conn);
		return c;
	}

	public ArrayList<Review> selectReview(int carNo) {
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<Review> list = new RentCarDao().selectReview(conn,carNo);
		JDBCTemplate.close(conn);
		return list;
	}

}
