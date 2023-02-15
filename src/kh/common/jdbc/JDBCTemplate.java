package kh.common.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class JDBCTemplate {	
	public static Connection getConnection() {
		Connection conn = null;
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","KH","KH");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			if(conn != null && !conn.isClosed()) {
				System.out.println("연결 성공");
			} else {
				System.out.println("연결 실패");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return conn;
	}
	
	public static void close(Connection conn) {
		try {
			if(conn != null && !conn.isClosed()){
				conn.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void close(Statement stmt) {
		try {
			if(stmt != null && !stmt.isClosed()){
				stmt.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
	
	public static void close(ResultSet rs) {
		try {
			if(rs != null && !rs.isClosed()){
				rs.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}	
	
	public static void rollback(Connection conn) {
		try {
			if(conn != null && !conn.isClosed()){
				conn.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
}
