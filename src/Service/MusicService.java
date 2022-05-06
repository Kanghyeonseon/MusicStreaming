package Service;

import domain.MusicDAO;
import dto.MusicDTO;

public class MusicService {
      
	
	MusicDAO dao = new MusicDAO();
	
	//조회
	public void Select(MusicDTO dto) {
		dao.Select(dto);
	}
	
	//추가
	
	public boolean Insert(MusicDTO dto) {
		return dao.Insert(dto);
		
	}
	
	
}
