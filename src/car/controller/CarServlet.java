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
				//2.view에서 넘어온값 
				//acr사진정보
				//파일업로드 준비
				//2-1) 파일업로드 경로 설치
				String root = getServletContext().getRealPath("/"); //webContent폴터까지 경로
				String saveDirectory = root+"upload/carphoto";
				//2-2) 파일 최대크기 지정(cos라이브러리 무료버전의 경우 최대 10MB까지 가능)
				int maxSize = 10*1024*1024; //10메가 바이트
				//request -> MulitpartRequest 객체로 변환하면서 파일이 업로드
				MultipartRequest mRequest = new MultipartRequest(request, saveDirectory,maxSize,"UTF-8",new DefaultFileRenamePolicy());
				//car정보
				Car car = new Car();
				car.setCarName(mRequest.getParameter("carName"));
				car.setCarType(mRequest.getParameter("carType"));
				car.setCarYear(Integer.parseInt(mRequest.getParameter("carYear")));
				car.setCarLocation(mRequest.getParameter("roadAddr")+" "+mRequest.getParameter("detailAddr"));
				car.setCarPrice(mRequest.getParameter("carPrice"));
				car.setCarSdate(mRequest.getParameter("carSdate"));
				car.setCarEdate(mRequest.getParameter("carEdate"));
				car.setCarNopan(mRequest.getParameter("carNoPan"));
				car.setCarImage(mRequest.getFilesystemName("filename1"));
				car.setCarImage2(mRequest.getFilesystemName("filename2"));
				car.setCarImage3(mRequest.getFilesystemName("filename3"));
				car.setCarImage4(mRequest.getFilesystemName("filename4"));
				//3.비지니스로직
				int result = new CarService().insertCar(car);
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
				if(result>0) {
					request.setAttribute("msg", "등록이 완료되었습니다.");
				}else {
					request.setAttribute("msg", "등록이 실패되었습니다.");
				}
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
