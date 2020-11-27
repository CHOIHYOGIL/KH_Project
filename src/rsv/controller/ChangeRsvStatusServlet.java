package rsv.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import rsv.model.service.RsvService;
import rsv.model.vo.Rsv;

/**
 * Servlet implementation class ChangeRsvStatusServlet
 */
@WebServlet(name = "ChangeRsvStatus", urlPatterns = { "/changeRsvStatus" })
public class ChangeRsvStatusServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ChangeRsvStatusServlet() {
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
		int status = Integer.parseInt(request.getParameter("status"));
		int rsvNo = Integer.parseInt(request.getParameter("rsvNo"));

		// 3.비지니스로직
		int result = new RsvService().updateRsvStatus(rsvNo, status); // 업데이트완료

		// 4.결과처리
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");

		if (result > 0) {
			Rsv rsv = new Rsv();
			rsv = new RsvService().selectOneRsv(rsvNo);

			if (status == 0) {
				request.setAttribute("msg", "예약을 취소합니다!"); // 빌리는 사람이 취소
				request.setAttribute("loc", "/myRsvList?reqPage=1&userId=" + rsv.getUserId());
				rd.forward(request, response);
			} else if (status == -1) {
				request.setAttribute("msg", "예약을 취소합니다!"); // 빌려주는 사람이 취소
				request.setAttribute("loc", "/myCarRsvList?reqPage=1&userId=" + rsv.getUserId());
				rd.forward(request, response);
			} else if (status == 20) {
				request.setAttribute("msg", "예약을 수락했습니다!");
				request.setAttribute("loc", "/myCarRsvList?reqPage=1&userId=" + rsv.getUserId());
				rd.forward(request, response);
			} else if (status == 21) {
				request.setAttribute("msg", "예약을 거절했습니다!");
				request.setAttribute("loc", "/myCarRsvList?reqPage=1&userId=" + rsv.getUserId());
				rd.forward(request, response);
			} else if (status == 22) {
				int payResult = new RsvService().insertPayment(rsvNo);
				if (payResult > 0) {
					request.setAttribute("msg", "결제가 완료되었습니다!");
					request.setAttribute("loc", "/myRsvList?reqPage=1&userId=" + rsv.getUserId());
					rd.forward(request, response);
				} else {
					request.setAttribute("msg", "오류발생! 관리자에게 문의하세요");
					request.setAttribute("loc", "/myRsvList?reqPage=1&userId=" + rsv.getUserId());
					rd.forward(request, response);

				}
			} else if (status == 3) {
				request.setAttribute("msg", "렌트를 시작합니다!");
				request.setAttribute("loc", "/myRsvList?reqPage=1&userId=" + rsv.getUserId());
				rd.forward(request, response);
			} else if (status == 4) {
				request.setAttribute("msg", "차주에게 반납확인을 요청합니다!");
				request.setAttribute("loc", "/myRsvList?reqPage=1&userId=" + rsv.getUserId());
				rd.forward(request, response);
			} else if (status == 5) {
				request.setAttribute("msg", "반납을 확인했습니다!");
				request.setAttribute("loc", "/myCarRsvList?reqPage=1&userId=" + rsv.getUserId());
				rd.forward(request, response);
			}

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
