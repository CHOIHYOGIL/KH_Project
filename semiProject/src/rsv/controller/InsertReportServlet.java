package rsv.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import rsv.model.service.RsvService;

/**
 * Servlet implementation class InsertReportServlet
 */
@WebServlet(name = "InsertReport", urlPatterns = { "/insertReport" })
public class InsertReportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public InsertReportServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		String who = request.getParameter("who");
		int rsvNo = Integer.parseInt(request.getParameter("rsvNo"));
		String reporter = request.getParameter("reporter");
		String reportee = request.getParameter("reportee");
		String repCon = request.getParameter("reportContent");

		int insert = RsvService.insertReport(rsvNo, reporter, reportee, repCon);
		int report = RsvService.updateReport(reportee);

		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
		if (insert * report > 0) {
			request.setAttribute("msg", "신고 완료!");
			if (who.equals("car")) {
				request.setAttribute("loc", "/changeRsvStatus?status=70&rsvNo=" + rsvNo);
			} else {
				request.setAttribute("loc", "/changeRsvStatus?status=71&rsvNo=" + rsvNo);
			}
		} else {
			request.setAttribute("msg", "신고 실패");
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
