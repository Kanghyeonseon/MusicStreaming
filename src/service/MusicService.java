package service;

import java.sql.ResultSet;
import java.sql.SQLException;

import domain.MusicDAO;
import dto.MusicDTO;
import view.GUIViewer;

public class MusicService {
	//멤버
	MusicDAO dao = new MusicDAO();
	
	public boolean Insert(MusicDTO dto) {
		return dao.Insert(dto);
		//전달받은 dto를 dao로 넘기고 반환되는 값을 Controller로 true/false로 연결
		
	}
	
	public boolean Update(MusicDTO dto) {
		return dao.Update(dto);
	}
	
	public boolean Delete(MusicDTO dto) {
		return dao.Delete(dto);
	}
	

	public boolean Select(MusicDTO dto) {
		return dao.Select(dto);
		
	}
	
}
