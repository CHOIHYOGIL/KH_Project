package rsv.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import car.model.service.CarService;
import car.model.vo.Car;
import rsv.model.service.RsvService;
import rsv.model.vo.Rsv;

/**
 * Servlet implementation class ReportUserFrmServlet
 */
@WebServlet(name = "ReportFrm", urlPatterns = { "/reportFrm" })
public class ReportFrmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ReportFrmServlet() {
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
		int rsvNo = Integer.parseInt(request.getParameter("rsvNo"));
		String reporter = request.getParameter("userId");

		// 3.비지니스로직

		Rsv rsv = new RsvService().selectOneRsv(rsvNo);
		int carNo = rsv.getCarNo();
		Car car = new CarService().selectOneCar(carNo);

		// 4.결과처리
		RequestDispatcher rd = null;
		if (reporter.equals(car.getUserId())) { // 신고하는사람: 차주인
			rd = request.getRequestDispatcher("/WEB-INF/views/rsv/reportUserFrm.jsp");
		} else { // 신고하는사람:차 빌렸던사람
			rd = request.getRequestDispatcher("/WEB-INF/views/rsv/reportCarFrm.jsp");
		}
		request.setAttribute("userId", reporter);
		request.setAttribute("rsv", rsv);
		request.setAttribute("car", car);
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
