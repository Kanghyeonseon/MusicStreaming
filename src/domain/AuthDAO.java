package domain;

import dto.AuthDTO;

public class AuthDAO extends DAO{
	public AuthDAO() {};
	
	//회원로그인 1번
	public boolean MemberLogin(AuthDTO dto) {
		try {
			pstmt = conn.prepareStatement("select id, pw from member_tbl where id=?");
			pstmt.setString(1, dto.getId()); //첫 번째 물음표읙 값이다.
			rs = pstmt.executeQuery(); //select로 물어보면 result set으로 받아진다.
			String tid=null,tpw=null;
			//행이 하나라서 while을 없애도 되는데 이떄까지 이렇게 했기때문에 헷갈리지말라고 이렇게 해준다.
			while(rs.next()) {
				tid=rs.getString("id");
				tpw=rs.getString("pw");
			}
			
			//id, pw검증과정
			if(tid!=null && tpw!=null) {
				if(tid.equals(dto.getId())&&tpw.equals(dto.getPw())) {
					return true;
				}
			}
			
			
			
		} catch(Exception e) { e.printStackTrace(); 
		} finally {
			try { rs.close(); } catch(Exception e) { e.printStackTrace(); }
			try { pstmt.close(); } catch(Exception e) { e.printStackTrace(); }
		}
		
		
		return false;
	}
	
	
	//직원로그인 2번
	public boolean EmployeeLogin(AuthDTO dto) {
		try {
			pstmt = conn.prepareStatement("select id, pw from employee_tbl where id=?");
			pstmt.setString(1, dto.getId()); //첫 번째 물음표읙 값이다.
			rs = pstmt.executeQuery(); //select로 물어보면 result set으로 받아진다.
			String tid=null,tpw=null;
			//행이 하나라서 while을 없애도 되는데 이떄까지 이렇게 했기때문에 헷갈리지말라고 이렇게 해준다.
			while(rs.next()) {
				tid=rs.getString("id");
				tpw=rs.getString("pw");
			}			
			//id, pw검증과정
			if(tid!=null && tpw!=null) {
				if(tid.equals(dto.getId())&&tpw.equals(dto.getPw())) {
					return true;
				}
			}
		} catch(Exception e) { e.printStackTrace(); 
		} finally {
			try { rs.close(); } catch(Exception e) { e.printStackTrace(); }
			try { pstmt.close(); } catch(Exception e) { e.printStackTrace(); }
		}
		
		
		return false;
	}
	//회원가입
	public boolean SignUp(AuthDTO dto) {
		try {
			pstmt = conn.prepareStatement("insert into member_tbl values(?,?)");
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getPw());
			
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
}
