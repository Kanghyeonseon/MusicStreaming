package View;

import java.util.Scanner;

import Controller.FrontControll;
import Controller.MusicControll;
import Service.MusicService;
import domain.MusicDAO;
import dto.MusicDTO;

public class view {
     int num;
     Scanner input = new Scanner(System.in);
     
     FrontControll controll = new FrontControll();
     
     public void LoginMenu() {
    	 while(true) {
    		 System.out.println("------------LOGIN------------");
    		 System.out.println("1 관리자로그인");
    		 System.out.println("2 회원로그인");
    		 System.out.println("3 종료");
    		 System.out.println("------------LOGIN------------");
    		 System.out.print("번호");
    		 num = input.nextInt();
    		 switch (num) {
			case 1:
				MusicMenu();
				break;
			case 2:
				break;
				
			case 3:
				System.out.println("프로그램을 종료합니다");
				System.exit(-1);
				break;
			default:
				System.out.println("잘못입력하셨습니다...");
			}
    	 }
     }
     
     public void MusicMenu() {
    	 System.out.println("------------MUSIC------------");
    	 System.out.println("1 노래등록");
    	 System.out.println("2 등록된노래조회");
    	 System.out.println("3 노래검색");
    	 System.out.println("4 노래수정");
    	 System.out.println("3 노래삭제");
    	 System.out.println("------------MUSIC------------");
    	 System.out.println("번호 : ");
    	 num=input.nextInt();
    	 switch (num) {
		case 1: //노래등록
			System.out.println("노래코드 | 노래제목 | 노래장르  | 출시년월일");
			int Code = input.nextInt();
			String Title = input.next();
			String Genre = input.next();
			String Release = input.next();
			MusicDTO dto = new MusicDTO(Code,Title,Genre,Release);
			
			boolean result = controll.SubControllEX("MUSIC", 1 , dto);
			
			if(result)
				System.out.println("등록 완료");
			else
			    System.out.println("등록 실패");
			break;
		case 2: //등록된 노래 조회

            
            
            
			
			
            break;
		case 3: //노래 검색
			
            break;
		case 4: //노래 수정    
		default:
			break;
		}
     }
    

}
