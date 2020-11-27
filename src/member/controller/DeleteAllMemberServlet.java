package member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.service.UserService;

/**
 * Servlet implementation class DeleteAllMemberServlet
 */
@WebServlet(name = "DeleteAllMember", urlPatterns = { "/deleteAllMember" })
public class DeleteAllMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteAllMemberServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		String num=request.getParameter("num");
		System.out.println("deleteALL : "+num);
		
		boolean result=new UserService().deleteAllMember(num);

		 RequestDispatcher rd=request.getRequestDispatcher("WEB-INF/views/common/msg.jsp");
		 request.setAttribute("loc", "/adminPage");
		 
		 if(result) {
			 request.setAttribute("msg", "탈퇴성공");
		 }else {
			 request.setAttribute("msg", "탈퇴실패");
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
