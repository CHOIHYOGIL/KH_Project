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
 * Servlet implementation class ChangeLevelServlet
 */
@WebServlet(name = "ChangeLevel", urlPatterns = { "/changeLevel" })
public class ChangeLevelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangeLevelServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		//1. 인코딩 
		request.setCharacterEncoding("utf-8");
		
		//2. view에서 보낸 값 저장
		int memberLevel=Integer.parseInt(request.getParameter("memberLevel"));
		int memberNo=Integer.parseInt(request.getParameter("memberNo"));
		System.out.println("changeLevel servlet 입장");
		System.out.println("memberLevel : "+memberLevel);
		System.out.println("memberNo : "+memberNo);
		//3. 비즈니스 로직
		int result= new UserService().changeLevel(memberLevel, memberNo);
		
		//4.결과처리
		 RequestDispatcher rd=request.getRequestDispatcher("WEB-INF/views/common/msg.jsp");
		 request.setAttribute("loc", "/adminPage?reqPage=1");
		 
		 if(result>0) {
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
