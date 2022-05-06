
package main;

import domain.MusicDAO;
import dto.MusicDTO;

public class Main {
	public static void main(String[] args) {
		//1. BookDAO- BookDTO 테스트

		MusicDTO dto = new MusicDTO(4,"오만상분다","댄스","20201112");
		MusicDAO dao = new MusicDAO();
		dao.Insert(dto); //성공여부 확인
		dao.Select(dto);
		dao.Update(dto);
		
		

		
		
	}
}