package member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.model.service.MemberService;
import member.model.vo.Member;

/**
 * Servlet implementation class LoginServlet
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
		
		//1. 인코딩
		request.setCharacterEncoding("utf-8");
		
		Member member=new Member();
		member.setMemberId(request.getParameter("memberId"));
		member.setMemberPw(request.getParameter("memberPw"));
		
		
		Member loginMember=new MemberService().selectOneMember(member);
		RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
		if(loginMember != null) {
			System.out.println(loginMember);
			System.out.println(loginMember.getMemberLevel());
			if(loginMember.getMemberLevel()==2) {
				request.setAttribute("msg", "준회원은 로그인 권한이 없습니다. 관리자에게 문의하세요");
			}else {
				System.out.println("hihi");
				HttpSession session=request.getSession();
				session.setAttribute("member", loginMember);
				request.setAttribute("msg", "로그인 성공");
			}
			request.setAttribute("loc", "/");
			
		}else {
			//로그인 실패
			request.setAttribute("msg", "아이디 또는 비밀번호를 확인하세요");
			request.setAttribute("loc", "/views/member/login.jsp");
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
