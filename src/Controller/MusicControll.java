package Controller;

import Service.MusicService;
import dto.DTO;
import dto.MusicDTO;

public class MusicControll implements SubControll {
    MusicService service = new MusicService();
	
	
	@Override
	public boolean execute(int num, DTO dto) {
		//1 등록 2 조회 3 수정 4 삭제
		MusicDTO mdto = (MusicDTO) dto;
		
		
		if(num==1) {
			service.Insert(mdto);
		}else if(num==2){
			service.Select(mdto);
		}else if(num==3) {
			service.Delete(mdto);
		}
		
		
		
		return false;
	}

	
	
	
}
