package notice.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import common.JDBCTemplate;
import notice.model.dao.NoticeDao;
import notice.model.vo.Notice;
import notice.model.vo.NoticePageData;

public class NoticeService {

	public NoticePageData selectList(int reqPage) {



		Connection conn = JDBCTemplate.getConnection();
		NoticeDao dao = new NoticeDao();
		int totalCount = dao.totalCount(conn); 
		int numPerPage = 10; 
		int totalPage = totalCount % numPerPage == 0 ? (totalCount / numPerPage) : (totalCount / numPerPage) + 1;

		int start = (reqPage - 1) * numPerPage + 1; // �빐�떦 �럹�씠吏� 寃뚯떆臾쇱쓽 �떆�옉 踰덊샇
		int end = reqPage * numPerPage; // �빐�떦 �럹�씠吏� 寃뚯떆臾쇱쓽 �걹 踰덊샇
		// System.out.println("�떆�옉踰덊샇 : " + start + " / �걹踰덊샇 : " + end);
		ArrayList<Notice> list = dao.selectList(conn, start, end);

		// �럹�씠吏� �꽕鍮꾧쾶�씠�뀡
		int pageNaviSize = 5; // �럹�씠吏� �꽕鍮꾧쾶�씠�뀡 湲몄씠 吏��젙
		String pageNavi = ""; // �럹�씠吏� �꽕鍮� �깭洹� �옉�꽦�슜

		// �럹�씠吏��꽕鍮� �떆�옉踰덊샇 援ы븯湲�
		// reqPage:1~5 ->1, reqPage:6~10 ->6, reqPage:11~15 ->11
		int pageNo = ((reqPage - 1) / pageNaviSize) * pageNaviSize + 1;

		// �씠�쟾 踰꾪듉 : �럹�씠吏� �떆�옉踰덊샇媛� 1�씠 �븘�땶 寃쎌슦�뿉留� �씠�쟾踰꾪듉 �깮�꽦
		if (pageNo != 1) {
			pageNavi += "<a class='btn' href='/noticeList?reqPage=" + (pageNo - 1) + "'>�씠�쟾</a>";
		}

		// �럹�씠吏� �꽕鍮� �닽�옄
		// 52媛�->totalPage=6媛쒗럹�씠吏�
		// reqPage=1, pageNo=1
		for (int i = 0; i < pageNaviSize; i++) {
			if (reqPage == pageNo) {// �럹�씠吏��꽕鍮꾧� �쁽�옱 �슂泥��럹�씠吏��씤 寃쎌슦(a�깭洹멸� �븘�슂�뾾�쓬)
				pageNavi += "<span class='selectPage'>" + pageNo + "</span>";
			} else {
				pageNavi += "<a class='btn' href='/noticeList?reqPage=" + pageNo + "'>" + pageNo + "</a>";
			}
			pageNo++;
			if (pageNo > totalPage) {
				break;
			}

		}

		// �떎�쓬 踰꾪듉
		if (pageNo <= totalPage) {
			pageNavi += "<a class='btn' href='/noticeList?reqPage=" + pageNo + "'>�떎�쓬</a>";
		}

		JDBCTemplate.close(conn);

		// �븯�굹�쓽 �뜲�씠�꽣 ���엯�쓣 �뿬�윭媛� ���옣 -> 諛곗뿴
		// �뿬�윭 �뜲�씠�꽣 ���엯�쓣 �뿬�윭媛� ���옣 -> 媛앹껜 -> NoticePageData 媛앹껜 �깮�꽦

		NoticePageData npd = new NoticePageData(list, pageNavi);

		return npd;
	}

	public int insertNotice(Notice n) {
		Connection conn = JDBCTemplate.getConnection();
		int result = new NoticeDao().insertNotice(conn, n);
		if (result > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

	public Notice selectOneNotice(int noticeNo) {
		Connection conn = JDBCTemplate.getConnection();
		Notice n = new NoticeDao().selectOneNotice(conn, noticeNo);
		JDBCTemplate.close(conn);
		return n;
	}

	public static int deleteOneNotice(int noticeNo) {
		Connection conn = JDBCTemplate.getConnection();
		int result = new NoticeDao().deleteOneNotice(conn, noticeNo);
		if (result > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

	public int updateNotice(Notice n) {
		Connection conn = JDBCTemplate.getConnection();
		int result = new NoticeDao().updateNotice(conn, n);
		if (result > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}



	public Notice selectNoticeView(int noticeNo) {
		Connection conn = JDBCTemplate.getConnection();
		Notice n = new NoticeDao().selectOneNotice(conn, noticeNo);
		JDBCTemplate.close(conn);
		return n;
	}


}
