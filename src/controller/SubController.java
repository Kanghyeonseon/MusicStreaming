package controller;

import dto.DTO;
import view.GUIViewer;

public interface SubController {
	boolean execute(int num, DTO dto,GUIViewer viewer); 
	//BookDTO자리에 DTO를 넣어주는 작업을했다. 업캐스팅. 상위클래스인 DTO 
	
	
	
}
