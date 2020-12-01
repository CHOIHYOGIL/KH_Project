package rsv.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.service.UserService;
import rsv.model.service.RsvService;

/**
 * Servlet implementation class ReportAllDecisionServlet
 */
@WebServlet(name = "ReportAllDecision", urlPatterns = { "/reportAllDecision" })
public class ReportAllDecisionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReportAllDecisionServlet() {
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
		String id=request.getParameter("userId");
		int result=0;
		int result1=0;
		int result3=0;
		//3. 비즈니스 로직
		
		System.out.println(num);
		System.out.println(id);
		if(id.equals("false")) {
			result=new RsvService().deleteReportRecord(num);
		}else {
			  result1=new RsvService().reportAllDecision(num, id);
			  result3=new RsvService().deleteReportRecord(num);
		}
		
		 
		 //4. 결과처리
		 
		 RequestDispatcher rd=request.getRequestDispatcher("WEB-INF/views/common/msg.jsp");
		 request.setAttribute("loc", "/reportUser?reqPage=1");
		 
		 if(result1>0 && result3>0 ) {
			 request.setAttribute("msg", "신고반영 성공");
		 }else {
			 request.setAttribute("msg", "신고반영 실패");
		 }
		 
		 if(result>0) {
			 request.setAttribute("msg", "신고철회 성공");
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
