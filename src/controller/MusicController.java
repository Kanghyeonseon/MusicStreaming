package controller;

import dto.DTO;
import dto.MusicDTO;
import service.MusicService;

public class MusicController implements SubController {
	MusicService service = new MusicService();
	//집합관계는 이런식으로 객체를 만들어줘야한다. 	
	
	@Override
	public boolean execute(int num, DTO dto) {
		MusicDTO bdto = (MusicDTO) dto;// 다운캐스팅을 해주지않으면 받을 수 없다.
		//1.조회, 2.삽입, 3.수정, 4.삭제		
		if(num==1) {	
//			return service.Select(bdto);
		} else if(num==2) {
			return service.Insert(bdto);
		} else if(num==3) {		
		} else if(num==4) {			
		}		
		return false;
	}
}
