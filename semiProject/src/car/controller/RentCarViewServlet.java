package car.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import car.model.service.RentCarService;
import car.model.vo.Car;
import car.model.vo.Review;

/**
 * Servlet implementation class CarViewServlet
 */
@WebServlet(name = "RentCarView", urlPatterns = { "/rentCarView" })
public class RentCarViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RentCarViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		int carNo = Integer.parseInt(request.getParameter("carNo"));
		
		Car car =  new RentCarService().selectOneCar(carNo);
		ArrayList<Review> list = new RentCarService().selectReview(carNo);
		
		request.setAttribute("car", car);
		request.setAttribute("rlist", list);
		request.getRequestDispatcher("/WEB-INF/views/car/carView.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
