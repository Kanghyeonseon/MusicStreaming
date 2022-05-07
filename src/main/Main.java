
package main;

import Controller.FrontControll;
import View.view;
import domain.MusicDAO;
import dto.MusicDTO;

public class Main {
	public static void main(String[] args) {
		//1. BookDAO- BookDTO 테스트

//		FrontControll controll = new FrontControll();
//		
//     	MusicDTO dto = new MusicDTO(5050,"하지마","자바","2022-05-06");
////		controll.SubControllEX("MUSIC",1 , dto);
//		controll.SubControllEX("MUSIC",2 , dto);
//		
//		controll.SubControllEX("MUSIC", 3, dto);
        
		
		view v = new view();
		
		v.MusicMenu();
	}
}