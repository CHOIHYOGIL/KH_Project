package rsv.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import rsv.model.service.RsvService;
import rsv.model.vo.Rsv;
import rsv.model.vo.RsvPageData;

/**
 * Servlet implementation class MyRsvListServlet
 */
@WebServlet(name = "MyRsvList", urlPatterns = { "/myRsvList" })
public class MyRsvListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MyRsvListServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1.인코딩
		request.setCharacterEncoding("utf-8");

		// 2.view값 저장
		String userId = request.getParameter("userId");
		int reqPage = Integer.parseInt(request.getParameter("reqPage"));

		// 3.비지니스로직
		RsvPageData rpd = new RsvService().selectRsvList(reqPage, userId);

		// 4.결과처리
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/rsv/myRsvList.jsp");
		request.setAttribute("list", rpd.getList());
		request.setAttribute("pageNavi", rpd.getPageNavi());
		request.setAttribute("userId", userId);
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
