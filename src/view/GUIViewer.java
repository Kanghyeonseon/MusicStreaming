package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import controller.FrontController;
import domain.DAO;
import domain.MusicDAO;
import dto.AuthDTO;
import dto.DTO;
import dto.MusicDTO;

public class GUIViewer extends JFrame implements ActionListener,KeyListener, MouseListener {
	
	//추가!!!
	
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
	JFrame signupmenu;
	JButton insert;
	JButton update;
	JButton delete;
	JButton select;
	JButton signup;
	JTextArea area;
	JScrollPane scroll;
	JButton bt1; JButton bt2; JButton bt3; JButton bt4; JButton bt5; //전체음악보기, 음악추가, 음악수정, 음악삭제, 종료
	JButton bt6;
	
	
	public JTextField area1; JTextField area2; JTextField area3; JTextField area4; JTextField area5; JTextField area6;
	//음악코드, 곡제목, 아티스트, 장르, 발매일, 키워드
	public static JTextArea area7;
	
	//레이블
	JLabel label1; JLabel label2; JLabel label3; 
	JLabel label4; JLabel label5; JLabel label6;
	
	
	//회원 메뉴 관련
	JFrame membermenu;
	JButton button1;
	JTextArea meberArea;
	JScrollPane memberScroll;

	private DTO dto;
 
	 
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
		
		id = new JTextField("아이디를 입력하세요");
		pw = new JPasswordField("비밀번호를 입력하세요"); 
		
		id.addMouseListener(this);
		pw.addMouseListener(this);
		
		
		
		id.setFocusTraversalKeysEnabled(false);
		
		login  = new JButton("로그인");
		exit   = new JButton("종료");
		signup = new JButton("회원가입");
		
		emp = new JLabel("직원");
		mem = new JLabel("멤버");
		
		employee = new JRadioButton("직원");
		member   = new JRadioButton("회원");
		
		
		radiogroup = new ButtonGroup();
		radiogroup.add(employee);
		radiogroup.add(member);
		
		
		id.setBounds(20,30,200,30);
		pw.setBounds(20,70,200,30);
		login.setBounds(230,30,80,70);
		exit.setBounds(320,30,80,70);
		
		employee.setBounds(20,130,20,20);
		emp.setBounds(50,130,40,20);
		member.setBounds(100,130,20,20);
		mem.setBounds(130,130,40,20);
		signup.setBounds(270,120,100,40);
		
		employee.setSelected(true);
		
		//리스너
		login.addActionListener(this);
		exit.addActionListener(this);
		signup.addActionListener(this);
		

		
		
		
		pan.add(id);
		pan.add(pw);
		pan.add(login);
		pan.add(exit);
		pan.add(emp);
		pan.add(mem);
		pan.add(employee);
		pan.add(member);
		pan.add(signup);
		
		loginmenu.add(pan);
		
		
		loginmenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		loginmenu.setBounds(500,500,450,200);
		loginmenu.setVisible(true);
	}
	
	
	//회원가입
	JTextField idtext;
	JTextField pwtext;
	JLabel idlabel;
	JLabel pwlabel;
	JPanel panel;
	JButton btn1;
	
	
	
	void SignUp() {
		
		
		signupmenu = new JFrame("회원가입");
		panel = new JPanel();
		
		
		idlabel = new JLabel("ID");
	    pwlabel = new JLabel("PW");
		
	    idtext = new JTextField(13);
	    pwtext = new JTextField(13);
	   
	   btn1 = new JButton("회원가입");
	   btn1.setAlignmentX(Component.CENTER_ALIGNMENT);
	 
	   
	   idtext.setBounds(20,30,200,30);
//	   idlabel.setBounds(20,30,200,30);
//	   pwlabel.setBounds(70,30,200,30);
	   pwtext.setBounds(20,120,200,30);
	   btn1.setBounds(270,120,100,40);
	   
	   btn1.addActionListener(this);
	   
	   panel.add(idlabel);
	   panel.add(pwlabel);
	   panel.add(idtext);
	   panel.add(pwtext);
	   panel.add(btn1);
	   
		signupmenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		signupmenu.setBounds(100,100,500,500);
		signupmenu.add(panel);
		signupmenu.setVisible(true);

	}
	 //직원 메뉴
	void Employee() {
		employeemenu = new JFrame("직원메뉴");
		JPanel pan = new JPanel();
		pan.setLayout(null);
		
		
		//버튼들 추가
		bt1 = new JButton("전체음악검색"); bt1.setBounds(380, 20, 120,30); bt1.addActionListener(this);
		bt2 = new JButton("음악추가"); bt2.setBounds(380, 66, 120,30); bt2.addActionListener(this);
		bt3 = new JButton("음악수정"); bt3.setBounds(380, 111, 120,30); bt3.addActionListener(this);
		bt4 = new JButton("음악삭제"); bt4.setBounds(380, 156, 120,30); bt4.addActionListener(this);
		bt5 = new JButton("종료"); bt5.setBounds(380, 246, 120,30); bt5.addActionListener(this);		
		bt6 = new JButton("초기화"); bt6.setBounds(380, 201,120,30); bt6.addActionListener(this);
		pan.add(bt1); pan.add(bt2); pan.add(bt3); pan.add(bt4); pan.add(bt5); pan.add(bt6);
		
		//텍스트필드들 추가
		area1 = new JTextField(); area1.setBounds(20, 20, 330, 30); 
		area2 = new JTextField(); area2.setBounds(20, 66, 330, 30); 
		area3 = new JTextField(); area3.setBounds(20, 111, 330, 30); 
		area4 = new JTextField(); area4.setBounds(20, 156, 330, 30); 
		area5 = new JTextField(); area5.setBounds(20, 201, 330, 30); 
		area6 = new JTextField(); area6.setBounds(20, 246, 330, 30); 
		
		//레이블 추가
		label1 = new JLabel("Code"); label1.setBounds(20, 5, 30, 15);
		label2 = new JLabel("Title"); label2.setBounds(20, 52, 50, 15);
		label3 = new JLabel("Artist"); label3.setBounds(20, 97, 50, 15);
		label4 = new JLabel("Gerne"); label4.setBounds(20, 142, 50, 15);
		label5 = new JLabel("Release"); label5.setBounds(20, 187, 50, 15);
		label6 = new JLabel("Keyword"); label6.setBounds(20, 232, 50, 15);
		
		
		pan.add(label1); 	pan.add(area1); 
		pan.add(label2); 	pan.add(area2); 
		pan.add(label3);	pan.add(area3); 
		pan.add(label4);	pan.add(area4); 
		pan.add(label5);	pan.add(area5); 
		pan.add(label6);	pan.add(area6); 
		
		
		//스크롤추가!
		area7 = new JTextArea("");  
		JScrollPane scroll = new JScrollPane(area7);
		scroll.setBounds(20, 290, 480, 170);
		pan.add(scroll);		
		
		employeemenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		employeemenu.setBounds(100,100,535,510);
		employeemenu.add(pan);
		employeemenu.setVisible(true);
	}
	
	
	//회원 메뉴 
	void Member() {
		membermenu = new JFrame("회원메뉴");		
				
		JPanel pan = new JPanel();
		pan.setLayout(null);
		
		button1 = new JButton("전체음악검색"); button1.setBounds(350, 20, 120,30);
				
		pan.add(button1);
		
		meberArea = new JTextArea(""); 
		JScrollPane scroll = new JScrollPane(meberArea);
		scroll.setBounds(17, 270, 480, 170);
		pan.add(scroll);
		
		
		membermenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		membermenu.setBounds(100,100,530,500);
		membermenu.add(pan);	
		membermenu.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
           
           
           if(e.getSource()==button1) {
        	meberArea.setText("");
   			MusicDTO dto = null;
   			boolean r2 = controller.SubControllerEX("MUSIC", 1,dto);
   			
   		 }
            //회원가입
		    if(e.getSource()==signup) {
		    	System.out.println("Sign Up");
		    	SignUp();
		    }
		
		    if(e.getSource()==btn1) {
		    	    AuthDTO dto = new AuthDTO(idtext.getText(),pwtext.getText());
		    		boolean r = controller.SubControllerEX("AUTH", 3, dto);
		    		if(r) {
		    			JOptionPane.showMessageDialog(null, "로그인 성공");
		    			Login();
		    		}else{
		    			JOptionPane.showMessageDialog(null, "로그인 실패");
		    		}
		    	}
		
 		
			if(e.getSource() == login ) {
			System.out.println("LOGIN");
			
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
			area7.setText("");
			System.out.println("전체보기 누름!");
			MusicDTO dto = null;
			boolean r2 = controller.SubControllerEX("MUSIC", 1,dto);
			
		 }
		 if(e.getSource()==bt2) {
			MusicDTO dto = new MusicDTO(area1.getText(),area2.getText(),area3.getText()
					,area4.getText(),area5.getText(),area6.getText());
			boolean r2 = controller.SubControllerEX("MUSIC", 2, dto);
			if(r2) {
				System.out.println("INSERT성공!");
			}
		 }
		 if(e.getSource()==bt3) {
			 MusicDTO dto = new MusicDTO(area1.getText(),area2.getText(),area3.getText()
						,area4.getText(),area5.getText(),area6.getText());
				boolean r2 = controller.SubControllerEX("MUSIC", 3, dto);
				if(r2) {
					System.out.println("UPDATE 성공!");
				}
		 }
		 if(e.getSource()==bt4) {
			 System.out.println("삭제버튼 누름!");
			 MusicDTO dto = new MusicDTO(area1.getText());
			boolean r2 = controller.SubControllerEX("MUSIC", 4, dto);
				if(r2) {
					System.out.println("DELETE 성공!");
				}
		 }
		 if(e.getSource()==bt5) {
			 System.exit(-1);
		 }
		 if(e.getSource()==bt6) {
			 area1.setText("");
			 area2.setText("");
			 area3.setText("");
			 area4.setText("");
			 area5.setText("");
			 area6.setText("");
			 area7.setText("");
		 }
		 
		 
	}


	@Override
	public void keyTyped(KeyEvent e) {
		
	}


	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode()==KeyEvent.VK_TAB&&e.getSource()==id) {
			pw.requestFocus();
		}
		
		if(e.getKeyCode()==KeyEvent.VK_TAB&&e.getSource()==pw) {
			id.requestFocus();
		}
	}


	@Override
	public void keyReleased(KeyEvent e) {
		
	}


	@Override
	public void mouseClicked(MouseEvent e) {
		 if(e.getSource()==id) {
			 
         	id.setText("");
         }
		 if(e.getSource()==pw) {
			 pw.setText("");
			 
		 }
		 
		 
		     
		
	}


	@Override
	public void mousePressed(MouseEvent e) {
		
	}


	@Override
	public void mouseReleased(MouseEvent e) {
		
	}


	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}