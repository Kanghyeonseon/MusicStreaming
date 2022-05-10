package domain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DAO {
	public String id = "STREAMING";
	public String pw = "1234";
	public String url ="jdbc:oracle:thin:@localhost:1521:XE"; 
	public Connection conn = null; 
	public PreparedStatement pstmt = null; //SQL쿼리 전송용 객체
	public ResultSet rs = null;
	protected DAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Driver Loading Success!");
			conn=DriverManager.getConnection(url, id, pw);
			System.out.println("DB Connected..!");
		}
		 catch( Exception e) {
			e.printStackTrace(); 
		}
	}
}
