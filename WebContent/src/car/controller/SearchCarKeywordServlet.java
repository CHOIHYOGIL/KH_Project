package car.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import car.model.service.CarService;
import car.model.vo.Car;
import car.model.vo.CarPageData;

/**
 * Servlet implementation class SearchCarKeywordServlet
 */
@WebServlet(name = "SearchCarKeyword", urlPatterns = { "/searchCarKeyword" })
public class SearchCarKeywordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchCarKeywordServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		System.out.println("searchCarListServlet 입장");
		String zone=request.getParameter("zone");
		String carType=request.getParameter("car-type");
		String addr=request.getParameter("addr");
		String Sdate=request.getParameter("date-range1");
		String Edate=request.getParameter("date-range2");
		String carName=request.getParameter("carName");
String location;
		if(addr.equals("")) {
			location=zone;
		}else {
			 location=zone+' '+addr;
		}

		
		System.out.println("location : "+location);
		System.out.println("carName:"+carName);
		System.out.println("zone :"+zone);
		System.out.println("carType : "+carType);
		System.out.println("addr : "+addr);
		System.out.println("Sdate : "+Sdate);
		System.out.println("Edate: "+Edate);
		
		System.out.println(zone+' '+addr);
		ArrayList<Car> list=new CarService().searchKeyword(location,carType,carName,Sdate,Edate);
		
		System.out.println("carkeyword list: "+list);

		if(list.size()==0) {
			RequestDispatcher rd=request.getRequestDispatcher("WEB-INF/views/common/msg.jsp");
			request.setAttribute("msg", "검색결과 없습니다.");
			request.setAttribute("loc", "/carList?reqPage=1");
			
			System.out.println("dao완성");
			rd.forward(request, response);
		}else {
			RequestDispatcher rd=request.getRequestDispatcher("WEB-INF/views/car/carList.jsp");
			request.setAttribute("list", list);
		
		
			System.out.println("dao완성");
			rd.forward(request, response);
			
		}
	

	

		
		

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
