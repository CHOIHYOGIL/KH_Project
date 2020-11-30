package notice.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import notice.model.service.NoticeService;
import notice.model.vo.Notice;

/**
 * Servlet implementation class InsertNoticeServlet
 */
@WebServlet(name = "InsertNotice", urlPatterns = { "/insertNotice" })
public class InsertNoticeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public InsertNoticeServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 1.�씤肄붾뵫
		request.setCharacterEncoding("utf-8");

		// 2.view�뿉�꽌 �꽆寃⑥� 媛� ���옣
		String noticeTitle = request.getParameter("noticeTitle");
		String noticeContent = request.getParameter("noticeContent");
		Notice n = new Notice();
		n.setNoticeTitle(request.getParameter("noticeTitle"));
		n.setNoticeContent(request.getParameter("noticeContent"));

		// 3.鍮꾩��땲�뒪濡쒖쭅
		int result = new NoticeService().insertNotice(n);

		// 4.寃곌낵泥섎━
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
		if (result > 0) {
			request.setAttribute("msg", "怨듭��궗�빆 �벑濡� �꽦怨�");
		} else {
			request.setAttribute("msg", "怨듭��궗�빆 �벑濡� �떎�뙣");
		}
		request.setAttribute("loc", "/noticeList?reqPage=1");
		rd.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
