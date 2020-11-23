package member.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.service.MemberService;
import member.model.vo.Member;

/**
 * Servlet implementation class SearchKeywordServlet
 */
@WebServlet(name = "SearchKeyword", urlPatterns = { "/searchKeyword" })
public class SearchKeywordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchKeywordServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//1. 인코딩 시작
		request.setCharacterEncoding("utf-8");
		
		//2. view에서 넘어온 값 저장
		String keyword=request.getParameter("keyword");
		String type=request.getParameter("type");
		
		System.out.print("type : "+type);
		//3. 비즈니스 로직
		ArrayList<Member> list=new MemberService().searchKeyword(type,keyword);
		
		RequestDispatcher rd=request.getRequestDispatcher("WEB-INF/views/member/adminPage.jsp");
		request.setAttribute("list", list);
		request.setAttribute("type", type);
		request.setAttribute("key", keyword);
		
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
