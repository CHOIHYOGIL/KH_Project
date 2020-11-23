package member.model.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.StringTokenizer;

import common.JDBCTemplate;
import member.model.dao.MemberDao;
import member.model.vo.Member;

public class MemberService {

	public Member selectOneMember(Member member) {
		
		Connection conn=JDBCTemplate.getConnection();
		Member loginMember=new MemberDao().selectOneMember(conn,member);
		JDBCTemplate.close(conn);
		return loginMember;
		
	}

	public Member selectOneMember(String memberId) {
		
		Connection conn=JDBCTemplate.getConnection();
		Member result=new MemberDao().selectOneMember(conn, memberId);
		JDBCTemplate.close(conn);
		return result;
	}

	public ArrayList<Member> selectAllMember() {
		Connection conn=JDBCTemplate.getConnection();
		ArrayList<Member> allMember=new MemberDao().selectAllMember(conn);
		JDBCTemplate.close(conn);
		return allMember;
	}

	public ArrayList<Member> searchKeyword(String type, String keyword) {
		Connection conn=JDBCTemplate.getConnection();
		ArrayList<Member> list=null;
		
		if(type.equals("memberId")) {
			
			list=new MemberDao().searchKeywordId(conn,keyword);
		}else if(type.equals("memberName")) {
			list=new MemberDao().searchKeywordName(conn,keyword);
		}
		
		JDBCTemplate.close(conn);
		return list;
	}

	public int changeLevel(int memberLevel, int memberNo) {
		Connection conn=JDBCTemplate.getConnection();
		int result=new MemberDao().changeLevel(conn,memberLevel, memberNo);
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
			int result1=new MemberDao().changeLevel(conn, memberLevel, memberNo);
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

	

}
