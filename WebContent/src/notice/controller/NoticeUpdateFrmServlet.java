package notice.controller;

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
 * Servlet implementation class NoticeUpdateFrmServlet
 */
@WebServlet(name = "NoticeUpdateFrm", urlPatterns = { "/noticeUpdateFrm" })
public class NoticeUpdateFrmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public NoticeUpdateFrmServlet() {
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

		// 2.view�뿉�꽌 �꽆�뼱�삩 媛� ���옣
		int noticeNo = Integer.parseInt(request.getParameter("noticeNo"));

		// 3.鍮꾩��땲�뒪濡쒖쭅
		Notice n = new NoticeService().selectOneNotice(noticeNo);

		// 4.寃곌낵泥섎━
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/notice/noticeUpdateFrm.jsp");
		request.setAttribute("n", n);
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
