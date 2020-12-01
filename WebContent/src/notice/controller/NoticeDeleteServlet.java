package notice.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import notice.model.service.NoticeService;
import notice.model.vo.Notice;

/**
 * Servlet implementation class NoticeDeleteServlet
 */
@WebServlet(name = "NoticeDelete", urlPatterns = { "/noticeDelete" })
public class NoticeDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public NoticeDeleteServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1.�씤肄붾뵫
		request.setCharacterEncoding("utf-8");
		// 2.view�뿉�꽌 蹂대궦 �뜲�씠�꽣 ���옣
		int noticeNo = Integer.parseInt(request.getParameter("noticeNo"));
		// 3.鍮꾩��땲�뒪濡쒖쭅
		Notice n = new NoticeService().selectOneNotice(noticeNo);
		int result = NoticeService.deleteOneNotice(noticeNo);
		// 5.寃곌낵泥섎━
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
		if (result > 0) {
			request.setAttribute("msg", "�궘�젣 �셿猷�");
			request.setAttribute("loc", "/noticeList?reqPage=1");
		} else {
			request.setAttribute("msg", "怨듭��궗�빆 �궘�젣 �떎�뙣");
			request.setAttribute("loc", "noticeView?noticeNo=" + noticeNo);
		}
		rd.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
