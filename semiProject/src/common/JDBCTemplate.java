package common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCTemplate {
	//데이터베이스 코드 중 중복부분 처리
	//1. Driver등록, Connection객체 생성	
	public static Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@1.220.236.74:15211:xe","selcar","1234");
			conn.setAutoCommit(false);//자동으로 커밋되는 설정을 해제
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	//2. Connection Close
	public static void close(Connection conn) {
		try {
			if(conn != null && !conn.isClosed()) {				
				conn.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void close(Statement stmt) {
		try {
			if(stmt != null && !stmt.isClosed()) {				
				stmt.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void close(ResultSet rset) {
		try {
			if(rset != null && !rset.isClosed()) {				
				rset.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
	//3. commit, rollback
	public static void commit(Connection conn) {
		try {
			if(conn != null && !conn.isClosed()) {				
				conn.commit();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void rollback(Connection conn) {
		try {
			if(conn != null && !conn.isClosed()) {				
				conn.rollback();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
}
