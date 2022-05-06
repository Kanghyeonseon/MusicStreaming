package dto;

public class MusicDTO {
	private int Music_Code;
	private String Music_Title;
	private String Music_Genre;
	private String Music_Release;	
	
	
	public MusicDTO(int music_Code, String music_Title, String music_Genre, String music_Release) {
		super();
		Music_Code = music_Code;
		Music_Title = music_Title;
		Music_Genre = music_Genre;
		Music_Release = music_Release;
	}
	public int getMusic_Code() {
		return Music_Code;
	}
	public void setMusic_Code(int music_Code) {
		Music_Code = music_Code;
	}
	public String getMusic_Title() {
		return Music_Title;
	}
	public void setMusic_Title(String music_Title) {
		Music_Title = music_Title;
	}
	public String getMusic_Genre() {
		return Music_Genre;
	}
	public void setMusic_Genre(String music_Genre) {
		Music_Genre = music_Genre;
	}
	public String getMusic_Release() {
		return Music_Release;
	}
	public void setMusic_Release(String music_Release) {
		Music_Release = music_Release;
	}
	@Override
	public String toString() {
		return "MusicDTO [Music_Code=" + Music_Code + ", Music_Title=" + Music_Title + ", Music_Genre=" + Music_Genre
				+ ", Music_Release=" + Music_Release + "]";
	}

	
	
	
	
	
	
	
	

	
	
}
