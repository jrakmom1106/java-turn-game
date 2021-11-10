package javaFinalExam2class;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javaFinalExam2classSub.Monster;
import javaFinalExam2classSub.Users;

//인터페이스 클래스
public class GameInterface extends JFrame {

	//라벨,버튼,스위치 선언부
	
	public static JLabel lbl, lbl2, lbl3;
	
	
	static public String n;
	static public String username;
	
	
	//생성자
	
	BtnLis lis = new BtnLis();
	//static 선언 이유는 다른 클래스에서 생성자로 받기때문이다.
	static Monster s1 = new Monster("곰");
	static Monster s2 = new Monster("호랑이");
	static Users h1 = new Users(username);
	JButton btn3 = new JButton("생존자");
	JButton btn1 = new JButton(s1.name);
	JButton btn2 = new JButton(s2.name);
	JTextField name = new JTextField(10);
	
	//버튼listener 클래스
	class BtnLis implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			Object obj = e.getSource();
			if (obj == btn3) {
				
				String n = name.getText();
				
				lbl3.setText(n+"님 환영합니다");
				addname(n);
			}
		}
	}
	
	
	// 인터페이스의 생성자
	public GameInterface() {
		
		//지정부분
		setTitle("야생동물들에게 살아남기");
		setSize(500, 500);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //x 클릭시 전체종료 (메모리사용량 감소)
		getContentPane().setLayout(null); //배치관리자는 null
		
		//버튼 선언
		btn1.setBounds(60, 370 ,170, 40);
		btn2.setBounds(280, 370,170, 40);
		getContentPane().add(btn1);
		getContentPane().add(btn2);
		//3은 listener 지정
		btn3.addActionListener(lis);
		btn3.setBounds(182, 10, 122, 30);
		getContentPane().add(btn3);
		// text필드 선언
		name.setBounds(20,10,150,30);
		getContentPane().add(name);
		
		
		
		// 라벨 설정
		lbl = new JLabel();
		lbl.setBounds(105, 300, 274, 50);
		lbl.setText("게임을 시작합니다");
		lbl.setHorizontalAlignment(JLabel.CENTER); // 수평 가운데 정렬
		getContentPane().add(lbl);

		// 라벨2 설정
		lbl2 = new JLabel();
		lbl2.setBounds(105, 320, 274, 50);
		lbl2.setText("의 체력은 " + h1.hp + "입니다");
		lbl2.setHorizontalAlignment(JLabel.CENTER); // 수평 가운데 정렬
		getContentPane().add(lbl2);
		// 라벨3 설정
		lbl3 = new JLabel();
		lbl3.setBounds(343, 10, 122, 30);
		lbl3.setText("님 환영합니다.");
		getContentPane().add(lbl3);
		
		//이미지 라벨 생성
		JLabel imgLbl = new JLabel();
		ImageIcon bsImg = new ImageIcon("C:\\Users\\yn971106\\Pictures\\bear.jpg");
		imgLbl.setIcon(bsImg);
		imgLbl.setBounds(60, 70, 170, 250);
		imgLbl.setHorizontalAlignment(JLabel.CENTER);
		getContentPane().add(imgLbl);
		// [end]

		//이미지 라벨2 생성
		JLabel imgLbl2 = new JLabel();
		ImageIcon bsImg2 = new ImageIcon("C:\\Users\\yn971106\\Pictures\\tiger.jpg");
		imgLbl2.setIcon(bsImg2);
		imgLbl2.setBounds(280, 70,175, 260);
		imgLbl2.setHorizontalAlignment(JLabel.CENTER);
		getContentPane().add(imgLbl2);
		

		// 프레임이 보이도록 설정
		setVisible(true);
		
		// 공격의 listener 설정
		
		btn1.addActionListener(event -> {

			battle(s1);
		});

		btn2.addActionListener(event -> {

			battle(s2);
		});
	
	}
		// 유저네임을 받아 초기화시키는 메서드
		public String addname(String n) {
			return username = n;
			
		}
		//전투 메서드
	public static void battle(Monster s) {
		// 몬스터가 살아있을때까지 공격
		if (s.hp < 1) {
			//쓰려졌을때
			lbl.setText(s.name + "는 이미 쓰러져있다\n");

		} else {
			// 아니면 각각 해당된 수치만큼 공격을 주고받기
			h1.attack(s);
			s.attack(h1);

		}
		// 몬스터가 죽으면 게임클리어 팝업
		if (s1.hp < 1 && s2.hp < 1) {
			//팝업
			JOptionPane.showMessageDialog(lbl2, "야생동물을 해치웠다!");
			System.exit(0); //그리고 프로그램 종료
		}

		
	}


}



	