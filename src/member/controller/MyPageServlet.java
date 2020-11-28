package member.controller;

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

/**
 * Servlet implementation class MyPageServlet
 */
@WebServlet(name = "MyPage", urlPatterns = { "/mypage" })
public class MyPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MyPageServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 1. 인코딩
		request.setCharacterEncoding("utf-8");

		// 2. view 에서 넘어온 데이터 저장
		String memberId = request.getParameter("userId");
		System.out.println("memberId : " + memberId);
		// 3. 비즈니스 로직
		System.out.println("mypage SERVLET 입장");
		User member = new UserService().selectOneMember(memberId);
		// 소현 추가
		Car car = new CarService().selectCarDetailView(memberId);
		// 4. 결과처리
		System.out.println(member.getUserGrade());
		if (member.getUserGrade() == 0) {
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/user/mypage.jsp");
			request.setAttribute("member", member);
			rd.forward(request, response);
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/user/mypage1.jsp");
			request.setAttribute("member", member);
			// 소현:마이페이지에 회원의 차 정보도 넘겨줌
			if (car != null) {
				request.setAttribute("car", car);
				System.out.println("차정보있음");
			}else {
				System.out.println("차정보없음");
			}
			rd.forward(request, response);
		}

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
