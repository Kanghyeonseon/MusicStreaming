package dto;

public class MusicDTO extends DTO {
	private String Music_Code;
	private String Music_Title;
	private String Music_Artist;
	private String Music_Genre;
	private String Music_Release;	
	private String Music_Keyword;
	
//	public MusicDTO() {}
	public MusicDTO(String music_Code, String music_Title, String music_Artist, String music_Genre,
			String music_Release, String music_Keyword) {
		super();
		Music_Code = music_Code;
		Music_Title = music_Title;
		Music_Artist = music_Artist;
		Music_Genre = music_Genre;
		Music_Release = music_Release;
		Music_Keyword = music_Keyword;
	}
	
	public MusicDTO(String text) {
		// TODO Auto-generated constructor stub
	}

	public String getMusic_Code() {
		return Music_Code;
	}
	public void setMusic_Code(String music_Code) {
		Music_Code = music_Code;
	}
	public String getMusic_Title() {
		return Music_Title;
	}
	public void setMusic_Title(String music_Title) {
		Music_Title = music_Title;
	}
	public String getMusic_Artist() {
		return Music_Artist;
	}
	public void setMusic_Artist(String music_Artist) {
		Music_Artist = music_Artist;
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
	public String getMusic_Keyword() {
		return Music_Keyword;
	}
	public void setMusic_Keyword(String music_Keyword) {
		Music_Keyword = music_Keyword;
	}
	
	@Override
	public String toString() {
		return "MusicDTO [Music_Code=" + Music_Code + ", Music_Title=" + Music_Title + ", Music_Artist=" + Music_Artist
				+ ", Music_Genre=" + Music_Genre + ", Music_Release=" + Music_Release + ", Music_Keyword="
				+ Music_Keyword + "]";
	}
	
	
}

	
	
	
	
	
	
	
	

	
	

