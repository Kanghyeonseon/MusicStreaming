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
	String url ="jdbc:mysql://localhost:3306/streamingdb"; 

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
		public void Select(MusicDTO dto) {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver"); //클래스이름이다.
				System.out.println("Driver Loading Success!");
				conn=DriverManager.getConnection(url, id, pw);
												//원하는DBMS위치, 
				System.out.println("DB Connected..!");
				
				pstmt=conn.prepareStatement("select * from music_tbl");
				
				//SQL실행
				rs = pstmt.executeQuery();
				//이건 int가 아니고 resultset의 형태로 리턴된다. 
				//그래서 rs객체에 resultset의 주소를에 담아준다.
				System.out.println("코드\t타이틀\t장르\t발매일\n");
				System.out.println("-----------------------------------------");
				while(rs.next()) {
					//한 열 이동하는것을 .next() 더이상 next가 되지않을 때 까지 
					
					System.out.printf("%d\t%s\t%s\t%s\n",rs.getInt("Music_code"), rs.getString("Music_title"), rs.getString("Music_Genre"), rs.getString("Music_Release"));
				}	
				
			} catch(Exception e) {
				e.printStackTrace();
			} finally {
				try { pstmt.close(); } catch (Exception e2) { e2.printStackTrace(); }
				try { conn.close(); } catch (Exception e1) { e1.printStackTrace(); }
			}
			
			
		
			
			
		}
		
		public boolean Insert(MusicDTO dto) {
				//전달이 잘 됐는지 boolean형으로 알려준다.
			try {
				pstmt = conn.prepareStatement("insert into music_tbl values(?,?,?,?)");
				pstmt.setInt(1, dto.getMusic_Code());
				pstmt.setString(2, dto.getMusic_Title());
				pstmt.setString(3, dto.getMusic_Genre());
				pstmt.setString(4, dto.getMusic_Release());
				int result = pstmt.executeUpdate();				
				if(result!=0) { return true; }
				
			} catch (Exception e) {
				e.printStackTrace();
			}  finally {
				try {pstmt.close(); }catch(Exception e) { e.printStackTrace(); }
			}			
			return false;
		}
		//도서정보 수정(num : 3)
		public void Update(MusicDTO dto) {
			try {
				//DB드라이버 로드
				Class.forName("com.mysql.cj.jdbc.Driver"); //클래스이름이다.
				System.out.println("Driver Loading Success!");
				//DB연결객체 생성
				conn=DriverManager.getConnection(url, id, pw);
												//원하는DBMS위치, 
				System.out.println("DB Connected..!");			
				
				//SQL전송객체
				pstmt = conn.prepareStatement("update music_Tbl set Music_Title=?, Music_Genre=?, Music_Release where Music_code=?");
												//조건절

				
				//SQL전송
				int result = pstmt.executeUpdate();
				if(result!=0) { System.out.println("수정 성공!"); }
				else { System.out.println("수정 실패!"); }
				
			} catch(Exception e) {
				e.printStackTrace();
				//만약에 오류가 발생하면 예외객체가만들어진다. 예외객체는 catch를 만들어줘야한다.
			} finally {
				//finally내부에 객체들을 해제하는 작업을 한다.
				//메모리공간에서 없애주는작업이다. 안 하면 계속 메모리공간에서 적재하고있다.
				//이것도 따로 try-catch만들어줘야한다.
				try { pstmt.close(); } catch(Exception e2) {e2.printStackTrace(); }
				try { conn.close(); } catch (Exception e1) { e1.printStackTrace(); }
			}
				
			
			
			
		}
		//도서정보 삭제(num : 4)
		public void Delete() {}
		
	}
	//연결객체 생성하는 작업까지만 한다. (finally이하 구문을 지워준다.)







	

	
	
	
	
	



	




