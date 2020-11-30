package car.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;


import car.model.service.CarService;
import car.model.vo.Car;

/**
 * Servlet implementation class CarServlet
 */
@WebServlet(name = "Car", urlPatterns = { "/car" })
public class CarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CarServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.인코딩
		request.setCharacterEncoding("utf-8");
		System.out.println("넘어옴");
		
		
		Car car = new Car();

	
		//2-1) 파일업로드 경로 설치
		String root = getServletContext().getRealPath("/"); //webContent폴터까지 경로
		String saveDirectory = root+"upload/carphoto";
		//2-2) 파일 최대크기 지정(cos라이브러리 무료버전의 경우 최대 10MB까지 가능)
		int maxSize = 10*1024*1024; //10메가 바이트
		//request -> MulitpartRequest 객체로 변환하면서 파일이 업로드
		MultipartRequest mRequest = new MultipartRequest(request, saveDirectory,maxSize,"UTF-8",new DefaultFileRenamePolicy());
		car.setCarNopan(mRequest.getParameter("carNopan"));
		car.setCarYear(Integer.parseInt(mRequest.getParameter("carYear")));
		car.setCarType(mRequest.getParameter("carType"));
		car.setCarName(mRequest.getParameter("CarName"));
		car.setCarSdate(mRequest.getParameter("carSdate"));
		car.setCarEdate(mRequest.getParameter("carEdate"));
		car.setCarPrice(mRequest.getParameter("carPrice"));
		car.setCarImage(mRequest.getParameter("filename1"));
		car.setCarImage2(mRequest.getParameter("filename2"));
		car.setCarImage3(mRequest.getParameter("filename3"));
		car.setCarImage4(mRequest.getParameter("filename4"));
		System.out.println(mRequest.getParameter("carNopan"));
		System.out.println(Integer.parseInt(mRequest.getParameter("carYear")));
		System.out.println(mRequest.getParameter("carType"));
		System.out.println(mRequest.getParameter("roadAddr"));
		System.out.println(mRequest.getParameter("detailAddr"));
		//3.비지니스로직
		//int result = new CarService().insertCar(car);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
		request.setAttribute("loc", "/");
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
