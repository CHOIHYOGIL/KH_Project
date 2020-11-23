package member.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.JDBCTemplate;
import member.model.vo.Member;

public class MemberDao {

	public Member selectOneMember(Connection conn, Member member) {
		
		PreparedStatement pstmt=null;
		ResultSet rset=null;
		Member loginMember=null;
		String query="select *from MEMBER where MEMBER_ID=? and MEMBER_PW=?";
		try {
			pstmt=conn.prepareStatement(query);
			pstmt.setString(1, member.getMemberId());
			pstmt.setString(2, member.getMemberPw());
			rset=pstmt.executeQuery();
			
			if(rset.next()) {
				loginMember=new Member();
			
				loginMember.setEmail(rset.getString("MEMBER_EMAIL"));
				loginMember.setEnrollDate(rset.getString("ENROLL_DATE"));
				loginMember.setLicense(rset.getString("MEMBER_LICENSE"));
				loginMember.setMemberId(rset.getString("MEMBER_ID"));
				loginMember.setMemberLevel(rset.getInt("MEMBER_GRADE"));
				loginMember.setMemberName(rset.getString("MEMBER_NAME"));
				loginMember.setMemberNo(rset.getInt("MEMBER_NO"));
				loginMember.setMemberPw(rset.getString("MEMBER_PW"));
				loginMember.setPhone(rset.getString("MEMBER_PHONE"));
				loginMember.setReport(rset.getInt("MEMBER_REPORT"));
				loginMember.setAddress(rset.getString("MEMBER_ADDR"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rset);
		}
		return loginMember;
	}

	public Member selectOneMember(Connection conn, String memberId) {
		
		PreparedStatement pstmt=null;
		ResultSet rset=null;
		Member member=null;
		String query="select *from member where MEMBER_ID=?";
		System.out.println("MYPATE DAO");
		try {
			pstmt=conn.prepareStatement(query);
			pstmt.setString(1, memberId);
			rset=pstmt.executeQuery();
			
			if(rset.next()) {
				member = new Member();
				member.setMemberNo(rset.getInt("MEMBER_NO"));
				member.setAddress(rset.getString("MEMBER_ADDR"));
				member.setEmail(rset.getString("MEMBER_EMAIL"));
				member.setEnrollDate(rset.getString("ENROLL_DATE"));
				member.setLicense(rset.getString("MEMBER_LICENSE"));
				member.setMemberId(rset.getString("MEMBER_ID"));
				member.setMemberName(rset.getString("MEMBER_NAME"));
				member.setMemberPw(rset.getString("MEMBER_PW"));
				member.setPhone(rset.getString("MEMBER_PHONE"));
				member.setReport(rset.getInt("MEMBER_REPORT"));
				member.setMemberLevel(rset.getInt("MEMBER_GRADE"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rset);
		}
		return member;
	}

	public ArrayList<Member> selectAllMember(Connection conn) {
		PreparedStatement pstmt=null;
		ResultSet rset=null;
		ArrayList<Member> allMember=new ArrayList<Member>();
		String query="select * from member";
		
		try {
			pstmt=conn.prepareStatement(query);
			rset=pstmt.executeQuery();
			
			while(rset.next()) {
				
				Member member=new Member();
				member.setMemberNo(rset.getInt("MEMBER_NO"));
				member.setAddress(rset.getString("MEMBER_ADDR"));
				member.setEmail(rset.getString("MEMBER_EMAIL"));
				member.setEnrollDate(rset.getString("ENROLL_DATE"));
				member.setLicense(rset.getString("MEMBER_LICENSE"));
				member.setMemberId(rset.getString("MEMBER_ID"));
				member.setMemberName(rset.getString("MEMBER_NAME"));
				member.setMemberPw(rset.getString("MEMBER_PW"));
				member.setPhone(rset.getString("MEMBER_PHONE"));
				member.setReport(rset.getInt("MEMBER_REPORT"));
				member.setMemberLevel(rset.getInt("MEMBER_GRADE"));
				allMember.add(member);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rset);
		}
		
		return allMember;
	}

	public ArrayList<Member> searchKeywordId(Connection conn, String keyword) {
		PreparedStatement pstmt=null;
		ResultSet rset=null;
		String query="select *from member where member_id like (?)";
		ArrayList<Member> list=new ArrayList<Member>();
		try {
			pstmt=conn.prepareStatement(query);
			pstmt.setString(1, '%'+keyword+'%');
			rset=pstmt.executeQuery();
			
			while(rset.next()) {

				Member member=new Member();
				member.setMemberNo(rset.getInt("MEMBER_NO"));
				member.setAddress(rset.getString("MEMBER_ADDR"));
				member.setEmail(rset.getString("MEMBER_EMAIL"));
				member.setEnrollDate(rset.getString("ENROLL_DATE"));
				member.setLicense(rset.getString("MEMBER_LICENSE"));
				member.setMemberId(rset.getString("MEMBER_ID"));
				member.setMemberName(rset.getString("MEMBER_NAME"));
				member.setMemberPw(rset.getString("MEMBER_PW"));
				member.setPhone(rset.getString("MEMBER_PHONE"));
				member.setReport(rset.getInt("MEMBER_REPORT"));
				member.setMemberLevel(rset.getInt("MEMBER_GRADE"));
				
				list.add(member);
					
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rset);
		}
		
		return list;
	}

	public ArrayList<Member> searchKeywordName(Connection conn, String keyword) {
		PreparedStatement pstmt=null;
		ResultSet rset=null;
		String query="select *from member where member_name like (?)";
		ArrayList<Member> list=new ArrayList<Member>();
		try {
			pstmt=conn.prepareStatement(query);
			pstmt.setString(1, '%'+keyword+'%');
			rset=pstmt.executeQuery();
			
			while(rset.next()) {

				Member member=new Member();
				member.setMemberNo(rset.getInt("MEMBER_NO"));
				member.setAddress(rset.getString("MEMBER_ADDR"));
				member.setEmail(rset.getString("MEMBER_EMAIL"));
				member.setEnrollDate(rset.getString("ENROLL_DATE"));
				member.setLicense(rset.getString("MEMBER_LICENSE"));
				member.setMemberId(rset.getString("MEMBER_ID"));
				member.setMemberName(rset.getString("MEMBER_NAME"));
				member.setMemberPw(rset.getString("MEMBER_PW"));
				member.setPhone(rset.getString("MEMBER_PHONE"));
				member.setReport(rset.getInt("MEMBER_REPORT"));
				member.setMemberLevel(rset.getInt("MEMBER_GRADE"));
				
				list.add(member);
					
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rset);
		}
		
		return list;
	}

	public int changeLevel(Connection conn, int memberLevel, int memberNo) {
		PreparedStatement pstmt=null;
		int result=0;
		
		String query="update member set MEMBER_GRADE=? where MEMBER_NO=?";
		try {
			pstmt=conn.prepareStatement(query);
			pstmt.setInt(1,memberLevel);
			pstmt.setInt(2, memberNo);
			
			result=pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	

}
