package member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.service.UserService;
import member.model.vo.User;

/**
 * Servlet implementation class joinServlet
 */
@WebServlet(name = "join", urlPatterns = { "/join" })
public class joinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public joinServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		User user = new User();
		user.setUserId(request.getParameter("userId"));
		user.setUserPw(request.getParameter("userPw"));
		user.setUserName(request.getParameter("userName"));
		user.setUserPhone(request.getParameter("userPhone"));
		user.setUserAddr(request.getParameter("userAddr")+" "+(request.getParameter("userAddr2"))+" "+(request.getParameter("userAddr3"))+" "+(request.getParameter("userAddr4")));
		user.setUserLicense(request.getParameter("userLicense"));
		user.setUserEmail(request.getParameter("userEmail"));
		int result = new UserService().insertUser(user);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
		request.setAttribute("loc", "/");
		if(result>0) {
			request.setAttribute("msg", "회원가입 성공");
		}else {
			request.setAttribute("msg", "회원가입 실패");
		}
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
