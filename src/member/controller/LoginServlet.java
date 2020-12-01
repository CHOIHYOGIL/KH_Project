package member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import member.model.service.UserService;
import member.model.vo.User;

/**
 * Servlet implementation class loginServlet
 */
@WebServlet(name = "Login", urlPatterns = { "/login" })
public class LoginServlet extends HttpServlet {
   private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

   /**
    * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
    */
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      request.setCharacterEncoding("utf-8");
      User user = new User();
      user.setUserId(request.getParameter("userId"));
      user.setUserPw(request.getParameter("userPw"));
      
      User loginUser = new UserService().selectOneMember(user);
      
      RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
      if(loginUser != null) {
         HttpSession session = request.getSession();
         session.setAttribute("user", loginUser);
         request.setAttribute("msg", "로그인 성공");
         request.setAttribute("loc", "/");
      }else {
         request.setAttribute("msg", "아이디 또는 비밀번호를 확인하세요");
         request.setAttribute("loc", "/views/login.jsp");
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