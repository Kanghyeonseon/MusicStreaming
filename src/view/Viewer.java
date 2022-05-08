package view;

import java.util.Scanner;

import dto.AuthDTO;

import controller.FrontController;
import dto.MusicDTO;

public class Viewer {
	
	int num;
	Scanner sc = new Scanner(System.in);
	
	//컨트롤러객체를 추가
	FrontController controller = new FrontController();
	
	//메인메뉴
	public void LoginMenu() {		
		while(true) {
		System.out.println("----------로그인----------");
		System.out.println("1. 회원로그인");
		System.out.println("2. 관리자로그인");
		System.out.println("3. 종료");
		System.out.println("----------로그인----------");
		System.out.print("번호 >>");
		num = sc.nextInt();		
		switch(num) {
			case 1 : //직원로그인				
				System.out.print("ID | PW 입력 >>");
				String tmpid = sc.next();
				String tmppw = sc.next();
				AuthDTO dto = new AuthDTO(tmpid,tmppw);
				boolean r1 = controller.SubControllerEX("AUTH", 1, dto);
				if(r1) {
					System.out.println("로그인 성공!");
				} else {
					System.out.println("로그인 실패!");
				}
				break;
			case 2 : 
				System.out.print("ID | PW 입력 >>");
				tmpid = sc.next();
				tmppw = sc.next();
				dto = new AuthDTO(tmpid,tmppw);
				boolean r2 = controller.SubControllerEX("AUTH", 2, dto);
				if(r2) {
					MusicMenu();
				} else {
					System.out.println("로그인 실패!");
				}
				break;
			case 3 : //종료
				break;
			default : 
				System.out.println("잘못 입력하셨습니다.");
				
		} //switch끝
		} //while 끝
		
	}
	
	//도서메뉴
	public void MusicMenu() {
		while(true) {
			System.out.println("----------MAIN----------");
			System.out.println("1. Select"); 
			System.out.println("2. Insert"); 
			System.out.println("3. Update"); 
			System.out.println("4. Delete"); 
			System.out.println("5. Previous");
			System.out.println("----------MAIN----------");
			System.out.print("번호 >>");

			switch(num) {
				case 1 : 
					System.out.println("음악 조회!");					
					break;
				case 2 :
					System.out.println("음악코드|타이틀|장르|발매일");
					int Music_Code = sc.nextInt();
					String Music_Title = sc.next();
					String Music_Genre=sc.next();
					String Music_Releaser=sc.next();
		//			MusicDTO dto = new MusicDTO(Music_Code, Music_Title,Music_Genre,Music_Releaser);
			//		boolean result = controller.SubControllerEX("MUSIC", 2, dto);
				//	if(result) System.out.println("INSERT 성공");
					//else System.out.println("INSERT 실패!");
					break;
				case 3 : 
					System.out.println("수정요청!");
					break;
				case 4 : 
					System.out.println("삭제요청!");
					break;
				case 5 : 
					return; //Main메뉴로 리턴					
				default : //잘못입력 
					System.out.println("번호를 잘못입력하셨습니다.");
					break;
			}
			
			
			
		}
	}
	
	
	//인증(로그인)메뉴
	
	
	//직원메뉴
	
	
	//회원메뉴
}
