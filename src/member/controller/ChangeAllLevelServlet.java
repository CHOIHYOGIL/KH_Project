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
 * Servlet implementation class ChangeAllLevelServlet
 */
@WebServlet(name = "ChangeAllLevel", urlPatterns = { "/changeAllLevel" })
public class ChangeAllLevelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangeAllLevelServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//1. 인코딩
		request.setCharacterEncoding("utf-8");
		
		//2.view에서 보낸 값 저장
		String num= request.getParameter("num");
		String level=request.getParameter("level");
		
		//3. 비즈니스 로직
		 boolean result=new UserService().changeAllLevel(num, level);
		 
		 //4. 결과처리
		 
		 RequestDispatcher rd=request.getRequestDispatcher("WEB-INF/views/common/msg.jsp");
		 request.setAttribute("loc", "/adminPage");
		 
		 if(result) {
			 request.setAttribute("msg", "변경성공");
		 }else {
			 request.setAttribute("msg", "변경실패");
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
