package controller;

import dto.AuthDTO;
import dto.DTO;
import service.AuthService;

public class AuthController implements SubController{
	AuthService service = new AuthService(); //집합 포함관계를 봐야한다.
	@Override
	public boolean execute(int num, DTO dto) {
		AuthDTO adto  = (AuthDTO) dto; //다운캐스팅
		
		if(num==1) {   	  //멤버로그인
			return service.MemberLogin(adto);
		}
		else if(num==2) { //직원로그인
			return service.EmployeeLogin(adto);
		}		
		
		return false;
	}

}
