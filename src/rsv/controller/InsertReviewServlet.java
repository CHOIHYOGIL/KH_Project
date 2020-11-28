package rsv.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import car.model.vo.Review;
import rsv.model.service.RsvService;

/**
 * Servlet implementation class InsertReviewServlet
 */
@WebServlet(name = "InsertReview", urlPatterns = { "/insertReview" })
public class InsertReviewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public InsertReviewServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");

//		int rsvNo = Integer.parseInt(request.getParameter("rsvNo"));
	
		String userId = request.getParameter("userId");
		int carNo = Integer.parseInt(request.getParameter("carNo"));
		String revCon = request.getParameter("reviewContent");
		int rate = Integer.parseInt(request.getParameter("rate"));
		int rsvNo=Integer.parseInt(request.getParameter("rsvNo"));

		System.out.println(userId);
		System.out.println(carNo);
		System.out.println(revCon);
		System.out.println(rate);
		System.out.println(rsvNo);
		
		int result = RsvService.insertReview(userId,carNo,revCon,rate,rsvNo);

		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
		/*request.setAttribute("loc", "/myRsvList?userId=" + userId + "&reqPage=1");*/
		if (result > 0) {
			request.setAttribute("msg", "후기 등록 성공!");
			request.setAttribute("loc", "/changeRsvStatus?status=6&rsvNo="+rsvNo);
		} else {
			request.setAttribute("msg", "후기 등록 실패");
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
