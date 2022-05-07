package dto;


//ID, PW를 담을 dto
public class AuthDTO extends DTO {
	private String id;
	private String pw;
	//생성

	public AuthDTO(String id, String pw) {
		super();
		this.id = id;
		this.pw = pw;
	}
	//Getter Setter

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	//toString()
	@Override
	public String toString() {
		return "AuthDTO [id=" + id + ", pw=" + pw + "]";
	}
	
	
	
	
}
