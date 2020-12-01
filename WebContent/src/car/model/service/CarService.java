package car.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import car.model.dao.CarDao;
import car.model.vo.Car;
import car.model.vo.CarPageData;
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

	public CarPageData selectList(int reqPage) {
		Connection conn = JDBCTemplate.getConnection();
		CarDao dao = new CarDao();
		int totalCount = dao.totalCount(conn); // 총 게시물 구하는 dao
		System.out.println("totalCount : "+totalCount);
		int numPerPage = 10; // 한페이지당 보여지는 게시물 수
		int totalPage = totalCount % numPerPage == 0 ? (totalCount / numPerPage) : (totalCount / numPerPage) + 1;

		// int totalPage = 0;
		// if (totalCount % numPerPage == 0) {
		// totalPage = totalCount / numPerPage;
		// } else {
		// totalPage = totalCount / numPerPage + 1;
		// }

		// System.out.println("totalCount : " + totalCount);

		// reqPage=1 -> start:1, end:10
		// reqPage=2 -> start:11, end:20
		// reqPage=3 -> start:21, end:30
		int start = (reqPage - 1) * numPerPage + 1; // 해당 페이지 게시물의 시작 번호
		int end = reqPage * numPerPage; // 해당 페이지 게시물의 끝 번호
		// System.out.println("시작번호 : " + start + " / 끝번호 : " + end);
		ArrayList<Car> list = dao.selectCarList(conn, start, end);

		// 페이지 네비게이션
		int pageNaviSize = 5; // 페이지 네비게이션 길이 지정
		String pageNavi = ""; // 페이지 네비 태그 작성용

		// 페이지네비 시작번호 구하기
		// reqPage:1~5 ->1, reqPage:6~10 ->6, reqPage:11~15 ->11
		int pageNo = ((reqPage - 1) / pageNaviSize) * pageNaviSize + 1;

		// 이전 버튼 : 페이지 시작번호가 1이 아닌 경우에만 이전버튼 생성
		if (pageNo != 1) {
			pageNavi += "<a class='btn' href='/carList?reqPage=" + (pageNo - 1) + "'>이전</a>";
		}

		// 페이지 네비 숫자
		// 52개->totalPage=6개페이지
		// reqPage=1, pageNo=1
		for (int i = 0; i < pageNaviSize; i++) {
			if (reqPage == pageNo) {// 페이지네비가 현재 요청페이지인 경우(a태그가 필요없음)
				pageNavi += "<span class='selectPage'>" + pageNo + "</span>";
			} else {
				pageNavi += "<a class='btn' href='/carList?reqPage=" + pageNo + "'>" + pageNo + "</a>";
			}
			pageNo++;
			if (pageNo > totalPage) {
				break;
			}

		}

		// 다음 버튼
		if (pageNo <= totalPage) {
			pageNavi += "<a class='btn' href='/carList?reqPage=" + pageNo + "'>다음</a>";
		}

		JDBCTemplate.close(conn);

		// 하나의 데이터 타입을 여러개 저장 -> 배열
		// 여러 데이터 타입을 여러개 저장 -> 객체 -> NoticePageData 객체 생성

		CarPageData cpd = new CarPageData(list, pageNavi);

		return cpd;
	}

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
		ArrayList<Car> list = new CarDao().selectList(conn);

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
