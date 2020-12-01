package rsv.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import rsv.model.service.RsvService;

/**
 * Servlet implementation class ReportDecisionServlet
 */
@WebServlet(name = "ReportDecision", urlPatterns = { "/reportDecision" })
public class ReportDecisionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReportDecisionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.setCharacterEncoding("utf-8");
		String id=request.getParameter("userId");
		int no=Integer.parseInt(request.getParameter("num"));
		System.out.println(id);
		int result=0;
		int result1=0;
		int result3=0;
		RequestDispatcher rd=request.getRequestDispatcher("WEB-INF/views/common/msg.jsp");
		if(id.equals("false")) {
			result=new RsvService().deleteReportUser(no);
			
		}else {
			result1=new RsvService().addUserReport(id);
			result3=new RsvService().deleteReportUser(no);
		}
		
		 
		 if(result>0) {
			 request.setAttribute("msg", "신고철회 성공");
			 request.setAttribute("loc", "/reportUser?reqPage=1");
		 }else {
			 request.setAttribute("msg", "신고철회 실패");
			 request.setAttribute("loc", "/reportUser?reqPage=1");
		 }
		 
		 if(result1>0 && result3>0) {
			 request.setAttribute("msg", "신고반영 성공");
			 request.setAttribute("loc", "/reportUser?reqPage=1");
		 }else {
			 request.setAttribute("msg", "신고반영실패");
			 request.setAttribute("loc", "/reportUser?reqPage=1");
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
