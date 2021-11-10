package javaFinalExam2classSub;
import javaFinalExam2class.GameInterface;
import javax.swing.JOptionPane;

//몬스터 클래스
public class Monster {

	
	public String name;
	public int hp = 80;

	// 생성자 및 이름 초기화 interface에서 받아온 이름을 name에 지정
	public Monster(String n) {

		name = n;

	}

	// 공격
	public void attack(Users h) {
		//몬스터가 유저를 공격
		if (hp > 0) {
			//유저가 살아있다면 10을 깎는다.
			h.hp = h.hp - 10;
			//만약 유저가 죽었다면
			if (h.hp < 1) {
				JOptionPane.showMessageDialog(null, "야생동물에게 당했다...");
				System.exit(0);
			}
			//출력문.
			GameInterface.lbl2.setText(name + "의 공격. " + "유저 의 체력은 " + h.hp + " 남았다.");
		}

	}

}
