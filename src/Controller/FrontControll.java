package Controller;

import java.util.HashMap;
import java.util.Map;

import dto.DTO;

public class FrontControll {

	
	private Map<String, SubControll> map = new HashMap();
	
	public FrontControll() {
		Init(); //map에 Init에 지정된 대로 서브컨트롤러가 추가가 된다.
	}
	
	private void Init() {
		map.put("MUSIC", new MusicControll());
	}
	
	
	
	public boolean SubControllEX(String music, int num, DTO dto) {
		SubControll tmp;
		if(music.equals("MUSIC")) {
			tmp = map.get("MUSIC");
			return tmp.execute(num, dto);
		}
		return false;
	}
	
	
}
