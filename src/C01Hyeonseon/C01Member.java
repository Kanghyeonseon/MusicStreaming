package C01Hyeonseon;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class C01Member {
	public int ID;
	public String Name;
	public int Age;
	public int Like_Music_Code;
	int Money;
	int Expiration_Date;
	String today = null;
	Date date = new Date();
	SimpleDateFormat d = new SimpleDateFormat("yyyy-MM-dd");
	Calendar cal = Calendar.getInstance();
	cal.setTime(date);
	
	C03Membership membership = new C03Membership();
	
	
	
	int Payment(C03Membership mem, Date date) {
		Expiration_Date= 

		
		cal.add(Calendar.MONTH, 1);

		
		
		today = d.format(cal.getTime());			
		
		System.out.println(today);
		
		return Money-=mem.Membership_Price;
		//Payment를 하면 Member에서 Money가 깎인다
	}
	
	//Membership_period만큼 회원멤버십만료기간이 증가
	//멤버십날짜가 오늘 날짜보다 크면 "멤버십이 만료되었습니다"창이 뜬다. 재생불가능
	
	
	
	
}
