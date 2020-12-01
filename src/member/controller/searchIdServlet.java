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
 * Servlet implementation class searchIdServlet
 */
@WebServlet(name = "searchId", urlPatterns = { "/searchId" })
public class searchIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public searchIdServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		User user = new User();
		user.setUserName(request.getParameter("userName"));
		user.setUserPhone(request.getParameter("userPhone"));
		
		User userId = new UserService().searchUser(user);
		RequestDispatcher rd = request.getRequestDispatcher("/views/resultSearchId.jsp");
		if(userId != null) {
			request.setAttribute("result", true);
		}else {
			request.setAttribute("result", false);
		}
		request.setAttribute("userId", userId);
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
