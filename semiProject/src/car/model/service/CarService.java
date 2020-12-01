package car.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import car.model.dao.CarDao;
import car.model.vo.Car;
import car.model.vo.Review;
import common.JDBCTemplate;

public class CarService {

	///////////////////////////////////////////////////
	//
	//
	// 소현
	//
	//
	////////////////////////////////////////////////////

	

	public Car selectCarDetailView(String userId) {
		Connection conn = JDBCTemplate.getConnection();
		Car c = new CarDao().selectOneCar(conn, userId);
		JDBCTemplate.close(conn);
		return c;
	}

	//////////////////////////////////////////////////////////////////////////////////////////////

	///////////////////////////////////////////////////
	//
	//
	// 가영
	//
	//
	////////////////////////////////////////////////////

	public ArrayList<Car> selectList() {
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<Car> list = new CarDao().selectCarList(conn);
		JDBCTemplate.close(conn);
		return list;
	}

	public Car selectOneCar(int carNo) {
		Connection conn = JDBCTemplate.getConnection();
		Car c = new CarDao().selectOneCar(conn, carNo);
		JDBCTemplate.close(conn);
		return c;
	}

	public ArrayList<Review> selectReview(int carNo) {
		Connection conn = JDBCTemplate.getConnection();
		System.out.println("service carNo: "+carNo);
		ArrayList<Review> list = new CarDao().selectReview(conn, carNo);
		JDBCTemplate.close(conn);
		return list;
	}

	/////////////////////////////////////////////////////////////////////////

	///////////////////////////////////////////////////
	//
	//
	// 기현
	//
	//
	////////////////////////////////////////////////////

	public int insertCar(Car car) {
		Connection conn = JDBCTemplate.getConnection();
		int result = new CarDao().insertCar(conn, car);
		if (result > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

	public ArrayList<Car> searchKeyword(String location, String carType,  String carName,String Sdate, String Edate) {
		
		Connection conn=JDBCTemplate.getConnection();
		ArrayList<Car> list=null;
		
		list=new CarDao().searchKeyword(conn,location,carType,carName,Sdate,Edate);
		
		JDBCTemplate.close(conn);
		return list;
	}

	////////////////////////////////////////////////////////////

}
