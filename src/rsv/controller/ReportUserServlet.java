package rsv.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.service.UserService;
import member.model.vo.AdminPageData;
import member.model.vo.User;
import rsv.model.service.RsvService;
import rsv.model.vo.Report;
import rsv.model.vo.ReportPageData;

/**
 * Servlet implementation class ReportUserServlet
 */
@WebServlet(name = "ReportUser", urlPatterns = { "/reportUser" })
public class ReportUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReportUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	request.setCharacterEncoding("utf-8");
		
		//2. view에서 넘어온 데이터 저장
		int reqPage=Integer.parseInt(request.getParameter("reqPage"));
		System.out.println(reqPage);
		//3. 비즈니스 로직
		ArrayList<Report> list=new RsvService().selectReportMember();
		ReportPageData apd=new RsvService().selectList(reqPage);
		//4.결과처리
		
		RequestDispatcher rd=request.getRequestDispatcher("WEB-INF/views/user/reportUser.jsp");
		request.setAttribute("list", apd.getList());
		request.setAttribute("pageNavi", apd.getPageNavi());
		System.out.println(list);
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
