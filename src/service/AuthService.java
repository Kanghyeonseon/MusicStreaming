package service;

import domain.AuthDAO;
import dto.AuthDTO;

public class AuthService {
	AuthDAO dao = new AuthDAO();
	
	//회원로그인
	public boolean MemberLogin(AuthDTO dto) {
		return dao.MemberLogin(dto);
	}
	
	
	//직원로그인
	public boolean EmployeeLogin(AuthDTO dto) {
		return dao.EmployeeLogin(dto);
	}
	//회원가입
	public boolean SignUp(AuthDTO dto) {
		return dao.SignUp(dto);
	}
}
