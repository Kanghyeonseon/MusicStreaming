package domain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DAO {
	public String id = "root";
	public String pw = "1153";
	public String url ="jdbc:mysql://localhost:3306/musicstreaming"; 
	public Connection conn = null; 
	public PreparedStatement pstmt = null; //SQL쿼리 전송용 객체
	public ResultSet rs = null;
	protected DAO() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Loading Success!");
			conn=DriverManager.getConnection(url, id, pw);
			System.out.println("DB Connected..!");
		}
		 catch( Exception e) {
			e.printStackTrace(); 
		}
	}
}
