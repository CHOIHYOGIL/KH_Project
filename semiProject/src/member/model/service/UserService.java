package member.model.service;

import java.sql.Connection;

import common.JDBCTemplate;
import member.model.dao.UserDao;
import member.model.vo.User;

public class UserService {

	public User selectOneUser(String userId) {
		Connection conn = JDBCTemplate.getConnection();
		User result = new UserDao().selectOneUser(conn,userId);
		JDBCTemplate.close(conn);
		return result;
	}

	public int insertUser(User user) {
		Connection conn = JDBCTemplate.getConnection();
		int result = new UserDao().insertUser(conn,user);
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

	public User loginUser(String userId,String userPw) {
		Connection conn = JDBCTemplate.getConnection();
		User u = new UserDao().loginUser(conn,userId,userPw);
		JDBCTemplate.close(conn);
		return u;
	}

}
