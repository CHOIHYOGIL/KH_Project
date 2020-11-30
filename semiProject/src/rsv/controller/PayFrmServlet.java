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
import member.model.service.UserService;
import member.model.vo.User;
import rsv.model.service.RsvService;
import rsv.model.vo.Rsv;

/**
 * Servlet implementation class PayFrmServlet
 */
@WebServlet(name = "PayFrm", urlPatterns = { "/payFrm" })
public class PayFrmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PayFrmServlet() {
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
		String userId=request.getParameter("userId");

		// 3.비지니스로직
		Rsv rsv = new RsvService().selectOneRsv(rsvNo);
		User user=new UserService().selectOneMember(userId);
		int carNo=rsv.getCarNo();
		Car car=new CarService().selectOneCar(carNo);

		// 4.결과처리
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/rsv/payFrm.jsp");
		request.setAttribute("rsv", rsv);
		request.setAttribute("user", user);
		request.setAttribute("car",car);
		rd.forward(request, response);
		System.out.println(carNo);

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
