package rsv.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import common.JDBCTemplate;

import rsv.model.dao.RsvDao;
import rsv.model.vo.Rsv;
import rsv.model.vo.RsvPageData;

public class RsvService {

	public RsvPageData selectRsvList(int reqPage, String userId) {
		Connection conn = JDBCTemplate.getConnection();
		RsvDao dao = new RsvDao();
		int totalCount = dao.rsvTotalCount(conn, userId); // 총 게시물 구하는 dao
		int numPerPage = 10; // 한페이지당 보여지는 게시물 수
		int totalPage = totalCount % numPerPage == 0 ? (totalCount / numPerPage) : (totalCount / numPerPage) + 1;

		// int totalPage = 0;dd
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
		ArrayList<Rsv> list = dao.selectRsvList(conn, userId, start, end);

		// 페이지 네비게이션
		int pageNaviSize = 5; // 페이지 네비게이션 길이 지정
		String pageNavi = ""; // 페이지 네비 태그 작성용

		// 페이지네비 시작번호 구하기
		// reqPage:1~5 ->1, reqPage:6~10 ->6, reqPage:11~15 ->11
		int pageNo = ((reqPage - 1) / pageNaviSize) * pageNaviSize + 1;

		// 이전 버튼 : 페이지 시작번호가 1이 아닌 경우에만 이전버튼 생성
		if (pageNo != 1) {
			pageNavi += "<a class='btn' href='/myRsvList?reqPage=" + (pageNo - 1) + "'>이전</a>";
		}

		// 페이지 네비 숫자
		// 52개->totalPage=6개페이지
		// reqPage=1, pageNo=1
		for (int i = 0; i < pageNaviSize; i++) {
			if (reqPage == pageNo) {// 페이지네비가 현재 요청페이지인 경우(a태그가 필요없음)
				pageNavi += "<span class='selectPage'>" + pageNo + "</span>";
			} else {
				pageNavi += "<a class='btn' href='/myRsvList?reqPage=" + pageNo + "'>" + pageNo + "</a>";
			}
			pageNo++;
			if (pageNo > totalPage) {
				break;
			}

		}

		// 다음 버튼
		if (pageNo <= totalPage) {
			pageNavi += "<a class='btn' href='/myRsvList?reqPage=" + pageNo + "'>다음</a>";
		}

		JDBCTemplate.close(conn);

		// 하나의 데이터 타입을 여러개 저장 -> 배열
		// 여러 데이터 타입을 여러개 저장 -> 객체 -> NoticePageData 객체 생성

		RsvPageData rpd = new RsvPageData(list, pageNavi);

		return rpd;
	}

	public RsvPageData selectCarRsvList(int reqPage, String userId) {
		Connection conn = JDBCTemplate.getConnection();
		RsvDao dao = new RsvDao();
		int totalCount = dao.carRsvTotalCount(conn, userId);
		int numPerPage = 10;
		int totalPage = totalCount % numPerPage == 0 ? (totalCount / numPerPage) : (totalCount / numPerPage) + 1;

		int start = (reqPage - 1) * numPerPage + 1;
		int end = reqPage * numPerPage;
		ArrayList<Rsv> list = dao.selectCarRsvList(conn, userId, start, end);

		int pageNaviSize = 5;
		String pageNavi = "";

		int pageNo = ((reqPage - 1) / pageNaviSize) * pageNaviSize + 1;

		if (pageNo != 1) {
			pageNavi += "<a class='btn' href='/myCarRsvList?reqPage=" + (pageNo - 1) + "'>이전</a>";
		}

		for (int i = 0; i < pageNaviSize; i++) {
			if (reqPage == pageNo) {
				pageNavi += "<span class='selectPage'>" + pageNo + "</span>";
			} else {
				pageNavi += "<a class='btn' href='/myCarRsvList?reqPage=" + pageNo + "'>" + pageNo + "</a>";
			}
			pageNo++;
			if (pageNo > totalPage) {
				break;
			}

		}

		if (pageNo <= totalPage) {
			pageNavi += "<a class='btn' href='/myCarRsvList?reqPage=" + pageNo + "'>다음</a>";
		}

		JDBCTemplate.close(conn);

		RsvPageData rpd = new RsvPageData(list, pageNavi);

		return rpd;
	}

	public int updateRsvStatus(int rsvNo, int status) {
		Connection conn = JDBCTemplate.getConnection();
		int result = new RsvDao().updateRsvStatus(conn, rsvNo, status);
		if (result > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

	public Rsv selectOneRsv(int rsvNo) {
		Connection conn = JDBCTemplate.getConnection();
		Rsv rsv = new RsvDao().selectOneRsv(conn, rsvNo);
		JDBCTemplate.close(conn);
		return rsv;
	}

	public int insertPayment(int rsvNo) {
		Connection conn = JDBCTemplate.getConnection();
		Rsv rsv = new RsvDao().selectOneRsv(conn, rsvNo);
		String price = rsv.getRsvPrice();
		int result = new RsvDao().insertPayment(conn, rsvNo, price);
		if (result > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

	public int insertCarRsv(Rsv rsv) {
		Connection conn=JDBCTemplate.getConnection();
		int result=new RsvDao().insertCarRsv(conn,rsv);
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
		
	}

}
