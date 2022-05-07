package domain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import dto.MusicDTO;



public class MusicDAO {
	//1. 연결관련 정보 저장용 변수
	String id = "root";
	String pw = "1234";
	String url ="jdbc:mysql://localhost:3306/musicstreaming"; 

	//2. DB연결관련 객체를 위한 참조변수
	Connection conn = null; 
	PreparedStatement pstmt = null; //SQL쿼리 전송용 객체
	ResultSet rs = null;

	
	public MusicDAO () {
	//3. 연결작업
	try {
		//DB드라이버 로드
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("Driver Loading Success!");
		conn=DriverManager.getConnection(url, id, pw);
		System.out.println("DB Connected..!");
	}
	 catch( Exception e) {
		e.printStackTrace(); 
		}
}
	public boolean Insert(MusicDTO dto) {
		try {
			pstmt=conn.prepareStatement("insert into music_tbl values(?,?,?,?)");
			pstmt.setInt(1, dto.getMusic_Code());
			pstmt.setString(2, dto.getMusic_Title());
			pstmt.setString(3, dto.getMusic_Genre());
			pstmt.setString(4, dto.getMusic_Release());
			int result = pstmt.executeUpdate();
			
			if(result!=0) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				pstmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return false;
	}
	
	//노래 조회

	public void selectAll(MusicDTO dto) {
		try {
			pstmt=conn.prepareStatement("select * from music_table");
		    
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				System.out.println(
						rs.getInt("Music_code")+"\t"+rs.getString("music_title")
						+"\t"+rs.getString("music_genre")+"\t\t"+rs.getString("music_release")
						);
		    
		    }
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//노래 수정
	
	public void Update(MusicDTO dto) {
		try {
			pstmt=conn.prepareStatement("update ");
		} catch (Exception e) {
			
		}
	}
	
	//노래 삭제
	public void delete(MusicDTO dto) {
		try {
			pstmt=conn.prepareStatement("update music_Tbl set Music_Title=?, Music_Genre=?, Music_Release where Music_code=?");
			pstmt.setString(1, dto.getMusic_Title());
			pstmt.setString(2, dto.getMusic_Genre());
			pstmt.setString(3, dto.getMusic_Release());
			int result = pstmt.executeUpdate();
			if(result!=0) {
				System.out.println("수정 성공");
			}else {
					System.out.println("수정 실패");
				}
			
		} catch (Exception e) {
		}

			
		}
		//삭제
		public void Delete() {}
		
	}
	







	

	
	
	
	
	



	




