package member.model.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.StringTokenizer;

import common.JDBCTemplate;
import member.model.vo.AdminPageData;
import member.model.dao.UserDao;
import member.model.vo.User;


public class UserService {

	public User selectOneMember(User member) {
		
		Connection conn=JDBCTemplate.getConnection();
		System.out.println(member.getUserId());
		System.out.println(member.getUserPw());
		User loginMember=new UserDao().selectOneMember(conn,member);
		JDBCTemplate.close(conn);
		return loginMember;
		
	}

	public User selectOneMember(String memberId) {
		
		Connection conn=JDBCTemplate.getConnection();
		User result=new UserDao().selectOneMember(conn, memberId);
		JDBCTemplate.close(conn);
		System.out.println("mypage Service 끝");
		return result;
	}

	public ArrayList<User> selectAllMember() {
		Connection conn=JDBCTemplate.getConnection();
		ArrayList<User> allMember=new UserDao().selectAllMember(conn);
		JDBCTemplate.close(conn);
		return allMember;
	}

	public ArrayList<User> searchKeyword(String type, String keyword) {
		Connection conn=JDBCTemplate.getConnection();
		ArrayList<User> list=null;
		
		if(type.equals("memberId")) {
			
			list=new UserDao().searchKeywordId(conn,keyword);
		}else if(type.equals("memberName")) {
			list=new UserDao().searchKeywordName(conn,keyword);
		}else if(type.equals("license")) {
			System.out.println("hihiihhi");
			list=new UserDao().searchKeywordLicense(conn,keyword);
		}
		
		JDBCTemplate.close(conn);
		return list;
	}

	public int changeLevel(int memberLevel, int memberNo) {
		Connection conn=JDBCTemplate.getConnection();
		int result=new UserDao().changeLevel(conn,memberLevel, memberNo);
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

	public boolean changeAllLevel(String num, String level) {
		//num = "42/43/44"  level="1/2/3";
		Connection conn=JDBCTemplate.getConnection();
		StringTokenizer sT1= new StringTokenizer(num, "/");
		StringTokenizer sT2= new StringTokenizer(level, "/");
		boolean result=true;
		
		while(sT1.hasMoreTokens()) {
			int memberLevel=Integer.parseInt(sT2.nextToken());
			int memberNo = Integer.parseInt(sT1.nextToken());
			int result1=new UserDao().changeLevel(conn, memberLevel, memberNo);
			if(result1==0) {
				result=false;
				break;
			}
		}
		if(result) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

	public boolean deleteAllMember(String num) {
		Connection conn=JDBCTemplate.getConnection();
		StringTokenizer sT1= new StringTokenizer(num, "/");
		
		boolean result=true;
		
		while(sT1.hasMoreTokens()) {
			
			int memberNo=Integer.parseInt(sT1.nextToken());
			int result1=new UserDao().deleteAllMember(conn,memberNo);
			if(result1==0) {
				result=false;
				break;
			}
		}
		if(result) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

	public int updateMember(String memberId,String phone, String memberPw, String addr, String email, String license) {
		
		Connection conn=JDBCTemplate.getConnection();
		
		int result=new UserDao().updateMember(conn,memberId,phone, memberPw,addr,email,license);
		
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

	public AdminPageData selectList(int reqPage) {
	
		Connection conn=JDBCTemplate.getConnection();
		UserDao dao=new UserDao();
		
		int totalCount=dao.totalCount(conn);
		
		int numPerPage=10;
		
		int totalPage=0;
		
		if(totalCount % numPerPage==0) {
			totalPage=totalCount/numPerPage;
		}else {
			totalPage=totalCount/numPerPage+1;
		}
		
		int start = (reqPage-1) * numPerPage+1;
		int end=reqPage*numPerPage;
		
		ArrayList<User> list=dao.selectList(conn,start,end);
		
		int pageNaviSize=10;
		String pageNavi="";
		
		int pageNo=reqPage-2;
		 if(reqPage < 4) {
	         pageNo = 1;
	      }
	      if(reqPage > 5) {
	    	  System.out.println("reaPage:"+reqPage);
	         pageNo = reqPage-2 ;
	      }
	      //이전버튼
	      if(pageNo!=1) {
	         pageNavi +=  "<a class='btn' href='/adminPage?reqPage="+(pageNo-1)+"'>이전</a>";
	         
	      }
	      //네비 숫자
	      for(int i=0;i<pageNaviSize;i++) {
	         if(reqPage == pageNo) {
	            pageNavi += "<span class='btn btn-danger'>"+pageNo+"</span>";
	         }else {
	            pageNavi += "<a class='btn' href='/adminPage?reqPage="+pageNo+"'>"+pageNo+"</a>";            
	         }
	         pageNo++;
	         if(pageNo>totalPage) {
	            break;
	         }
	      }
	      //다음버튼
	      if(pageNo <= totalPage) {
	         pageNavi += "<a class='btn' href='/adminPage?reqPage="+pageNo+"'>다음</a>";
	      }
	      AdminPageData bpd = new AdminPageData(list,pageNavi);
	      JDBCTemplate.close(conn);
	      return bpd;
		
	}

	

	

}
