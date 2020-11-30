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
 * Servlet implementation class MakeRsvServlet
 */
@WebServlet(name = "MakeRsv", urlPatterns = { "/makeRsv" })
public class MakeRsvServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MakeRsvServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.setCharacterEncoding("utf-8");
		
		Rsv rsv=new Rsv();
	
		
		rsv.setRsvStart(request.getParameter("rsvStartDate"));
		rsv.setRsvEnd(request.getParameter("rsvEndDate"));
		rsv.setUserId(request.getParameter("userId"));
		rsv.setRsvPrice(request.getParameter("price"));

		rsv.setRsvStime(request.getParameter("rsvStartTime"));
		rsv.setRsvEtime(request.getParameter("rsvEndTime"));
		rsv.setCarNo(Integer.parseInt(request.getParameter("carNo")));
	
		
		
		System.out.println("carNo: ");
		System.out.println(request.getParameter("carNo"));
		System.out.println(request.getParameter("rsvStartDate"));
		System.out.println(request.getParameter("rsvEndDate"));
		System.out.println(request.getParameter("price"));
	
		System.out.println(request.getParameter("userId"));
	
	
		
	
	
		
		
		int result=new RsvService().insertCarRsv(rsv);
		RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
		request.setAttribute("loc","/carList?reqPage=1");
		if(result>0) {
			request.setAttribute("msg", "예약요청 성공!");
		}else {
			request.setAttribute("msg", "예약요청 실패");
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
