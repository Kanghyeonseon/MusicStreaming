package domain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import dto.MusicDTO;



public class MusicDAO extends DAO {
	public boolean Select(MusicDTO dto) {
		try {
			pstmt=conn.prepareStatement("select * from music_tbl");
			
			//SQL실행
			rs = pstmt.executeQuery();
			System.out.println("코드\t타이틀\t장르\t발매일\n");
			System.out.println("-----------------------------------------");
			while(rs.next()) {
				//한 열 이동하는것을 .next() 더이상 next가 되지않을 때 까지 
				
				System.out.printf("%d\t%s\t%s\t%s\n",rs.getInt("Music_code"), rs.getString("Music_title"), rs.getString("Music_Genre"), rs.getString("Music_Release"));
			}
			int result = pstmt.executeUpdate();
			if (result!=0) {return true;}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {pstmt.close(); }catch(Exception e) { e.printStackTrace(); }
		}			
		return false;
	}
		
		public boolean Insert(MusicDTO dto) {
				//전달이 잘 됐는지 boolean형으로 알려준다.
			try {
				pstmt = conn.prepareStatement("insert into music_tbl values(?,?,?,?,?,?)");
				pstmt.setString(1, dto.getMusic_Code());
				pstmt.setString(2, dto.getMusic_Title());
				pstmt.setString(3, dto.getMusic_Artist());
				pstmt.setString(4, dto.getMusic_Genre());
				pstmt.setString(5, dto.getMusic_Release());
				pstmt.setString(6, dto.getMusic_Keyword());
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
		public boolean Update(MusicDTO dto) {
			try {
			pstmt = conn.prepareStatement("update music_tbl set music_title=?, music_artist=?, music_genre=?, music_release=?, music_keyword=? where music_code=?");
			//조건절
			pstmt.setString(6, dto.getMusic_Code());
			pstmt.setString(1, dto.getMusic_Title());
			pstmt.setString(2, dto.getMusic_Artist());
			pstmt.setString(3, dto.getMusic_Genre());
			pstmt.setString(4, dto.getMusic_Release());
			pstmt.setString(5, dto.getMusic_Keyword());
			
			//SQL전송
			int result = pstmt.executeUpdate();
			if(result!=0) { System.out.println("수정 성공!"); return true;}
			else { System.out.println("수정 실패!"); }
			
			} catch(Exception e) {
			e.printStackTrace();
			} finally {
				try { pstmt.close(); } catch(Exception e) {e.printStackTrace(); }
				try { conn.close(); } catch (Exception e) { e.printStackTrace(); }
			}
			
			return false;
			
		}
		public boolean Delete(MusicDTO dto) {
			try {
				pstmt=conn.prepareStatement("delete from music_tbl where music_code=?");
				pstmt.setString(1,  dto.getMusic_Code());		
				int result = pstmt.executeUpdate();
				if(result!=0) { System.out.println("삭제 성공!"); return true;}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try { pstmt.close(); } catch(Exception e) {e.printStackTrace(); }
				try { conn.close(); } catch (Exception e) { e.printStackTrace(); }
			}
			

			return false;
		}
		
	}
	//연결객체 생성하는 작업까지만 한다. (finally이하 구문을 지워준다.)







	

	
	
	
	
	



	




