package member.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.JDBCTemplate;
import member.model.vo.User;


public class UserDao {

   public User selectOneMember(Connection conn, User user) {
      
      PreparedStatement pstmt=null;
      ResultSet rset=null;
      User loginMember=null;
      String query="select *from MEMBER where  USER_ID=? and  USER_PW=?";
      try {
         pstmt=conn.prepareStatement(query);
         pstmt.setString(1, user.getUserId());
         pstmt.setString(2, user.getUserPw());
         rset=pstmt.executeQuery();
         
         if(rset.next()) {
            loginMember=new User();
         
            loginMember.setUserEmail(rset.getString("USER_EMAIL"));
            loginMember.setUserDate(rset.getString("ENROLL_DATE"));
            loginMember.setUserLicense(rset.getString("USER_LICENSE"));
            loginMember.setUserId(rset.getString("USER_ID"));
            loginMember.setUserGrade(rset.getInt("USER_GRADE"));
            loginMember.setUserName(rset.getString("USER_NAME"));
            loginMember.setUserNo(rset.getInt("USER_NO"));
            loginMember.setUserPw(rset.getString("USER_PW"));
            loginMember.setUserPhone(rset.getString("USER_PHONE"));
            loginMember.setUserReport(rset.getInt("USER_REPORT"));
            loginMember.setUserAddr(rset.getString("USER_ADDR"));
            loginMember.setUserReport(rset.getInt("USER_REPORT"));
            
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

   public User selectOneMember(Connection conn, String memberId) {
      
      PreparedStatement pstmt=null;
      ResultSet rset=null;
      User member=null;
      String query="select *from member where  USER_ID=?";
      System.out.println("MYPATE DAO");
      System.out.println("memberId:" +memberId);
      try {
      
         pstmt=conn.prepareStatement(query);
         pstmt.setString(1, memberId);
         rset=pstmt.executeQuery();
         
         if(rset.next()) {
            member = new User();
            member.setUserNo(rset.getInt("USER_NO"));
            member.setUserAddr(rset.getString("USER_ADDR"));
            member.setUserEmail(rset.getString("USER_EMAIL"));
            member.setUserDate(rset.getString("ENROLL_DATE"));
            member.setUserLicense(rset.getString("USER_LICENSE"));
            member.setUserId(rset.getString("USER_ID"));
            member.setUserName(rset.getString("USER_NAME"));
            member.setUserPw(rset.getString("USER_PW"));
            member.setUserPhone(rset.getString("USER_PHONE"));
            member.setUserReport(rset.getInt("USER_REPORT"));
            member.setUserGrade(rset.getInt("USER_GRADE"));
      
            
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

   public ArrayList<User> selectAllMember(Connection conn) {
      PreparedStatement pstmt=null;
      ResultSet rset=null;
      ArrayList<User> allMember=new ArrayList<User>();
      String query="select * from member";
      
      try {
         pstmt=conn.prepareStatement(query);
         rset=pstmt.executeQuery();
         
         while(rset.next()) {
            
            User member=new User();
            member.setUserNo(rset.getInt("USER_NO"));
            member.setUserAddr(rset.getString("USER_ADDR"));
            member.setUserEmail(rset.getString("USER_EMAIL"));
            member.setUserDate(rset.getString("ENROLL_DATE"));
            member.setUserLicense(rset.getString("USER_LICENSE"));
            member.setUserId(rset.getString("USER_ID"));
            member.setUserName(rset.getString("USER_NAME"));
            member.setUserPw(rset.getString("USER_PW"));
            member.setUserPhone(rset.getString("USER_PHONE"));
            member.setUserReport(rset.getInt("USER_REPORT"));
            member.setUserGrade(rset.getInt("USER_GRADE"));
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

   public ArrayList<User> searchKeywordId(Connection conn, String keyword) {
      PreparedStatement pstmt=null;
      ResultSet rset=null;
      String query="select *from member where USER_ID like (?)";
      ArrayList<User> list=new ArrayList<User>();
      try {
         pstmt=conn.prepareStatement(query);
         pstmt.setString(1, '%'+keyword+'%');
         rset=pstmt.executeQuery();
         
         while(rset.next()) {

            User member=new User();
            member.setUserNo(rset.getInt("USER_NO"));
            member.setUserAddr(rset.getString("USER_ADDR"));
            member.setUserEmail(rset.getString("USER_EMAIL"));
            member.setUserDate(rset.getString("ENROLL_DATE"));
            member.setUserLicense(rset.getString("USER_LICENSE"));
            member.setUserId(rset.getString("USER_ID"));
            member.setUserName(rset.getString("USER_NAME"));
            member.setUserPw(rset.getString("USER_PW"));
            member.setUserPhone(rset.getString("USER_PHONE"));
            member.setUserReport(rset.getInt("USER_REPORT"));
            member.setUserGrade(rset.getInt("USER_GRADE"));
            
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

   public ArrayList<User> searchKeywordName(Connection conn, String keyword) {
      PreparedStatement pstmt=null;
      ResultSet rset=null;
      String query="select *from member where USER_NAME like (?)";
      ArrayList<User> list=new ArrayList<User>();
      try {
         pstmt=conn.prepareStatement(query);
         pstmt.setString(1, '%'+keyword+'%');
         rset=pstmt.executeQuery();
         
         while(rset.next()) {

            User member=new User();
            member.setUserNo(rset.getInt("USER_NO"));
            member.setUserAddr(rset.getString("USER_ADDR"));
            member.setUserEmail(rset.getString("USER_EMAIL"));
            member.setUserDate(rset.getString("ENROLL_DATE"));
            member.setUserLicense(rset.getString("USER_LICENSE"));
            member.setUserId(rset.getString("USER_ID"));
            member.setUserName(rset.getString("USER_NAME"));
            member.setUserPw(rset.getString("USER_PW"));
            member.setUserPhone(rset.getString("USER_PHONE"));
            member.setUserReport(rset.getInt("USER_REPORT"));
            member.setUserGrade(rset.getInt("USER_GRADE"));
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
      
      String query="update member set USER_GRADE=? where USER_NO=?";
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

   public ArrayList<User> searchKeywordLicense(Connection conn, String keyword) {
      PreparedStatement pstmt=null;
      System.out.println("license Dao 입장");
      ResultSet rset=null;
      String query="select *from member where USER_LICENSE like (?)";
      ArrayList<User> list=new ArrayList<User>();
      try {
         pstmt=conn.prepareStatement(query);
         pstmt.setString(1,'%'+keyword+'%');
         rset=pstmt.executeQuery();
         
         while(rset.next()) {

            User member=new User();
            member.setUserNo(rset.getInt("USER_NO"));
            member.setUserAddr(rset.getString("USER_ADDR"));
            member.setUserEmail(rset.getString("USER_EMAIL"));
            member.setUserDate(rset.getString("ENROLL_DATE"));
            member.setUserLicense(rset.getString("USER_LICENSE"));
            member.setUserId(rset.getString("USER_ID"));
            member.setUserName(rset.getString("USER_NAME"));
            member.setUserPw(rset.getString("USER_PW"));
            member.setUserPhone(rset.getString("USER_PHONE"));
            member.setUserReport(rset.getInt("USER_REPORT"));
            member.setUserGrade(rset.getInt("USER_GRADE"));
            
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

   public int deleteAllMember(Connection conn, int memberNo) {
      PreparedStatement pstmt=null;
      int result=0;
      String query="delete from member where USER_NO=?";
      
      try {
         pstmt=conn.prepareStatement(query);
         pstmt.setInt(1, memberNo);
         result=pstmt.executeUpdate();
      } catch (SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }finally {
         JDBCTemplate.close(pstmt);
      }
      return result;
   }

   public int updateMember(Connection conn, String memberId,String phone, String memberPw, String addr, String email, String license) {
      
      PreparedStatement pstmt=null;
      
      int result=0;
      String query="update member set USER_PHONE=?, USER_ADDR=?, USER_EMAIL=?,  USER_LICENSE=?,  USER_PW=? where  USER_ID=?";
      
      try {
         pstmt=conn.prepareStatement(query);
         pstmt.setString(1, phone);
         pstmt.setString(2, addr);
         pstmt.setString(3,email);
         pstmt.setString(4, license);
         pstmt.setString(5, memberPw);
         pstmt.setString(6, memberId);
         result=pstmt.executeUpdate();
      } catch (SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }finally{
         JDBCTemplate.close(pstmt);
      }
      return result;
   }

   public int totalCount(Connection conn) {
        PreparedStatement pstmt = null;
         ResultSet rset = null;
         int result = 0;
         String query = "select count(*) cnt from member";
         try {
            pstmt = conn.prepareStatement(query);
            rset = pstmt.executeQuery();
            if(rset.next()) {
               result = rset.getInt("cnt");
            }
         } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
         } finally {
            JDBCTemplate.close(rset);
            JDBCTemplate.close(pstmt);
         }      
         return result;
   }

   public ArrayList<User> selectList(Connection conn, int start, int end) {
       PreparedStatement pstmt = null;
         ResultSet rset = null;
         String query = "select * from ( select rownum as unum, n.* from (select * from member order by 1 desc)n ) where unum between ? and ?";
         ArrayList<User> list = new ArrayList<User>();
         
         try {
            pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, start);
            pstmt.setInt(2, end);
            rset = pstmt.executeQuery();
            while(rset.next()) {

               User member=new User();
               member.setUserNo(rset.getInt("USER_NO"));
               member.setUserAddr(rset.getString("USER_ADDR"));
               member.setUserEmail(rset.getString("USER_EMAIL"));
               member.setUserDate(rset.getString("ENROLL_DATE"));
               member.setUserLicense(rset.getString("USER_LICENSE"));
               member.setUserId(rset.getString("USER_ID"));
               member.setUserName(rset.getString("USER_NAME"));
               member.setUserPw(rset.getString("USER_PW"));
               member.setUserPhone(rset.getString("USER_PHONE"));
               member.setUserReport(rset.getInt("USER_REPORT"));
               member.setUserGrade(rset.getInt("USER_GRADE"));
               list.add(member);          
            }
         } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
         }finally {
            JDBCTemplate.close(rset);
            JDBCTemplate.close(pstmt);
         }      
         
         return list;
   }

public User searchUser(Connection conn, User user) {
	 PreparedStatement pstmt = null;
     ResultSet rset = null;
     User userId = null;
     String query = "select * from member where user_name=? and user_phone=?";
     try {
        pstmt = conn.prepareStatement(query);
        pstmt.setString(1, user.getUserName());
        pstmt.setString(2, user.getUserPhone());
        rset = pstmt.executeQuery();
        if(rset.next()) {
           userId = new User();
           userId.setUserAddr(rset.getString("user_addr"));
           userId.setUserDate(rset.getString("enroll_date"));
           userId.setUserEmail(rset.getString("user_email"));
           userId.setUserGrade(rset.getInt("user_grade"));
           userId.setUserId(rset.getString("user_id"));
           userId.setUserLicense(rset.getString("user_license"));
           userId.setUserName(rset.getString("user_name"));
           userId.setUserNo(rset.getInt("user_no"));
           userId.setUserPhone(rset.getString("user_phone"));
           userId.setUserPw(rset.getString("user_pw"));
           userId.setUserReport(rset.getInt("user_report"));
        }
     } catch (SQLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
     } finally {
        JDBCTemplate.close(pstmt);
        JDBCTemplate.close(rset);
     }
     return userId;

}

public User searchPw(Connection conn, User user) {
	 PreparedStatement pstmt = null;
     ResultSet rset = null;
     User userPw = null;
     String query = "select * from member where user_id=? and user_name=? and user_phone=?";
     try {
        pstmt = conn.prepareStatement(query);
        pstmt.setString(1, user.getUserId());
        pstmt.setString(2, user.getUserName());
        pstmt.setString(3, user.getUserPhone());
        rset = pstmt.executeQuery();
        if(rset.next()) {
           userPw = new User();
           userPw.setUserAddr(rset.getString("user_addr"));
           userPw.setUserDate(rset.getString("enroll_date"));
           userPw.setUserEmail(rset.getString("user_email"));
           userPw.setUserGrade(rset.getInt("user_grade"));
           userPw.setUserId(rset.getString("user_id"));
           userPw.setUserLicense(rset.getString("user_license"));
           userPw.setUserName(rset.getString("user_name"));
           userPw.setUserNo(rset.getInt("user_no"));
           userPw.setUserPhone(rset.getString("user_phone"));
           userPw.setUserPw(rset.getString("user_pw"));
           userPw.setUserReport(rset.getInt("user_report"));
        }
        
     } catch (SQLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
     } finally {
        JDBCTemplate.close(pstmt);
        JDBCTemplate.close(rset);
     }
     return userPw;

}

public int insertUser(Connection conn, User user) {
	 PreparedStatement pstmt = null;
     int result = 0;
     String query = "INSERT INTO MEMBER VALUES(MEMBER_SEQ.NEXTVAL,?,?,?,?,?,?,?,1,to_char(sysdate,'yyyy-mm-dd'),0)";
     try {
        pstmt = conn.prepareStatement(query);
        pstmt.setString(1, user.getUserId());
        pstmt.setString(2, user.getUserPw());
        pstmt.setString(3, user.getUserName());
        pstmt.setString(4, user.getUserAddr());
        pstmt.setString(5, user.getUserEmail());
        pstmt.setString(6, user.getUserPhone());
        pstmt.setString(7, user.getUserLicense());
        result = pstmt.executeUpdate();
     } catch (SQLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
     } finally {
        JDBCTemplate.close(pstmt);
     }
     return result;

}


   

}