package car.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import car.model.service.CarService;
import car.model.vo.CarPageData;

/**
 * Servlet implementation class CarListServlet
 */
@WebServlet(name = "CarList", urlPatterns = { "/carList" })
public class CarListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CarListServlet() {
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

		// 2.view媛� ���옣
		
	
	
		int reqPage = Integer.parseInt(request.getParameter("reqPage")); // 1�럹�씠吏� �슂泥�
		System.out.println(reqPage);
		// 3.鍮꾩��땲�뒪濡쒖쭅
		CarPageData cpd = new CarService().selectList(reqPage);
		
		
		// 4.寃곌낵泥섎━
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/car/carList.jsp");
		System.out.println("list:"+cpd.getList());
		System.out.println("pageNavi:"+cpd.getPageNavi());
		request.setAttribute("list", cpd.getList());
		request.setAttribute("pageNavi", cpd.getPageNavi());
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
