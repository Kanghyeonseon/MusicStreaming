package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import controller.FrontController;
import domain.DAO;
import domain.MusicDAO;
import dto.AuthDTO;
import dto.MusicDTO;

public class GUIViewer extends DAO implements ActionListener {
	
	//컨트롤러 추가
	FrontController controller =new FrontController();
	
	//로그인 창 관련 
	JFrame loginmenu; JTextField id; JTextField pw; JButton login;
	JButton exit; JRadioButton employee;
	JRadioButton member;
	JLabel emp;
	JLabel mem;
	ButtonGroup radiogroup;
	
	
	//직원 메뉴 관련 
	JFrame employeemenu;
	JButton insert;
	JButton update;
	JButton delete;
	JButton select;
	JTextArea area;
	JScrollPane scroll;
	JButton bt1; JButton bt2; JButton bt3; JButton bt4; JButton bt5; //전체음악보기, 음악추가, 음악수정, 음악삭제, 종료
	JTextArea area1; JTextArea area2; JTextArea area3; JTextArea area4; JTextArea area5; JTextArea area6;
	//음악코드, 곡제목, 아티스트, 장르, 발매일, 키워드
	JTextArea area7;
	
	//회원 메뉴 관련
	JFrame membermenu;
 
	 
	//생성자
	public GUIViewer()
	{
		super();
		Login();
		System.out.println("로그인 창 생성!");
	}
	
	
	//로그인 메뉴
	void Login() {
		loginmenu = new JFrame("로그인창");
		
		JPanel pan = new JPanel();
		pan.setLayout(null);
		
		id = new JTextField("ID");
		pw = new JTextField("PW");
		
		login = new JButton("로그인");
		exit = new JButton("종료");
		
		emp = new JLabel("직원");
		mem = new JLabel("멤버");
		
		employee = new JRadioButton("직원");
		member = new JRadioButton("회원");
		
		
		radiogroup= new ButtonGroup();
		radiogroup.add(employee);
		radiogroup.add(member);
		
		
		id.setBounds(20,10,200,30);
		pw.setBounds(20,50,200,30);
		login.setBounds(230,10,80,70);
		exit.setBounds(320,10,80,70);
		
		employee.setBounds(20,90,20,20);
		emp.setBounds(50,90,40,20);
		member.setBounds(100,90,20,20);
		mem.setBounds(130,90,40,20);
		
		employee.setSelected(true);
		
		//리스너
		login.addActionListener(this);
		exit.addActionListener(this);
		
		pan.add(id);
		pan.add(pw);
		pan.add(login);
		pan.add(exit);
		pan.add(emp);
		pan.add(mem);
		pan.add(employee);
		pan.add(member);
		
		loginmenu.add(pan);
		
		loginmenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		loginmenu.setBounds(100,100,430,170);
		loginmenu.setVisible(true);
	}
	
	//직원 메뉴
	void Employee() {
		employeemenu = new JFrame("직원메뉴");
		JPanel pan = new JPanel();
		pan.setLayout(null);
		
		
		//버튼들 추가
		bt1 = new JButton("전체음악검색"); bt1.setBounds(350, 20, 120,30); bt1.addActionListener(this);
		bt2 = new JButton("음악추가"); bt2.setBounds(350, 60, 120,30); bt2.addActionListener(this);
		bt3 = new JButton("음악수정"); bt3.setBounds(350, 100, 120,30); bt3.addActionListener(this);
		bt4 = new JButton("음악삭제"); bt4.setBounds(350, 140, 120,30); bt4.addActionListener(this);
		bt5 = new JButton("종료"); bt5.setBounds(350, 220, 120,30); bt5.addActionListener(this);		
		pan.add(bt1); pan.add(bt2); pan.add(bt3); pan.add(bt4); pan.add(bt5);
		
		//텍스트필드들 추가
		area1 = new JTextArea("코드"); area1.setBounds(20, 20, 300, 30); 
		area2 = new JTextArea(""); area2.setBounds(20, 60, 300, 30); 
		area3 = new JTextArea(""); area3.setBounds(20, 100, 300, 30); 
		area4 = new JTextArea(""); area4.setBounds(20, 140, 300, 30); 
		area5 = new JTextArea(""); area5.setBounds(20, 180, 300, 30); 
		area6 = new JTextArea(""); area6.setBounds(20, 220, 300, 30); 
		pan.add(area1); pan.add(area2); pan.add(area3); pan.add(area4); pan.add(area5); pan.add(area6);
		
		//스크롤추가!
		area7 = new JTextArea(""); 
		JScrollPane scroll = new JScrollPane(area7);
		scroll.setBounds(20, 270, 450, 170);
		pan.add(scroll);		
		
		employeemenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		employeemenu.setBounds(100,100,500,500);
		employeemenu.add(pan);
		employeemenu.setVisible(true);
	}
	
	//회원 메뉴 
	void Member() {
		membermenu = new JFrame("회원메뉴");		
		
		membermenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		membermenu.setBounds(100,100,500,500);
		membermenu.setVisible(true);
	}
	
	MusicDAO dao = new MusicDAO();
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		 if(e.getSource() == login ) {
			System.out.println("로그인 버튼 누름!");
			
			//로그인 처리 하기(컨트롤러)
			//로그인 성공시 
			//-Login창 숨김
			//-Employee창 띄움
			//로그인 실패시 다이얼로그 띄움
			if(employee.isSelected())
			{
				AuthDTO dto = new AuthDTO(id.getText(),pw.getText());
				boolean r = controller.SubControllerEX("AUTH", 2, dto);
				if(r)
				{	
					loginmenu.setVisible(false); //로그인인증이성공했으면 창을 보여줄 필요가없다.
					Employee();
				}else
				{
					JOptionPane.showMessageDialog(null, "로그인 실패");
				}
				
			}else if(member.isSelected())
			{
				AuthDTO dto = new AuthDTO(id.getText(),pw.getText());
				boolean r = controller.SubControllerEX("AUTH", 1, dto);
				if(r)
				{	
					loginmenu.setVisible(false);
					Member();
				}else
				{
					JOptionPane.showMessageDialog(null, "로그인 실패");
				}				
				
			}			 
		 }
		 if(e.getSource() == exit) {
			 System.out.println("종료 버튼 누름!");
			 System.exit(-1);
		 }
		 
		 //전체보기를 누르면?
		 if(e.getSource() ==bt1) {
			 System.out.println("전체보기 누름!");
			 
			 try {
					pstmt = conn.prepareStatement("select * from music_tbl");
					rs = pstmt.executeQuery(); //select로 물어보면 result set으로 받아진다.
					String code=null; String title=null; String artist=null; String genre=null; String release=null; String keyword=null;
					//행이 하나라서 while을 없애도 되는데 이떄까지 이렇게 했기때문에 헷갈리지말라고 이렇게 해준다.
					System.out.println("코드\t제목\t가수\t");
					while(rs.next()) {
						code=rs.getString("music_code"); 
						title=rs.getString("music_title"); 
						artist=rs.getString("music_artist");
						genre=rs.getString("music_genre");
						release=rs.getString("music_release"); 
						keyword=rs.getString("music_keyword");
						area7.append(code+"\t"+title+"\t"+artist+"\t"+genre+"\t"+release+"\t"+keyword+"\n");
					}
				} catch(Exception e1) { e1.printStackTrace(); 
				} finally {
					try { rs.close(); } catch(Exception e1) { e1.printStackTrace(); }
					try { pstmt.close(); } catch(Exception e2) { e2.printStackTrace(); }
				}
		 }
		 if(e.getSource()==bt2) {
			MusicDTO dto = new MusicDTO(area1.getText(),area2.getText(),area3.getText()
					,area4.getText(),area5.getText(),area6.getText());
			boolean r2 = controller.SubControllerEX("MUSIC", 2, dto);
			if(r2) {
				System.out.println("INSERT성공!");
			}
		 }
		 
		 
	}
}