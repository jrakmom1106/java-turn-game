package javaFinalExam2classSub;
import javaFinalExam2class.GameInterface;

//유저 클래스
public class Users  {
	//상속하지 않은 메서드 중 유저의 name같은경우 다른 메서드에서 호출하지 않기 때문에 protected 선언 가능
	protected String name;
	public int hp = 100;
	// 유저이름 받아오기.
	public Users(String username) {
		name = username;
	}
	// 몬스터 공격 메서드
	public void attack(Monster s) {
		// 체력 30만큼 공격
		s.hp = s.hp - 30;
		// 만약 몬스터
		if (s.hp < 1) {
			GameInterface.lbl.setText(s.name + "(은) 는 쓰러졌다.!");
			//라벨이 2줄이라 죽은뒤에도 라벨이 남아있기때문에 지우는 용도로 ""추가
			GameInterface.lbl2.setText("");
			
			// 죽지 않았다면.
		} else {
			GameInterface.lbl.setText(" 유저 의 공격. " + s.name + "의 체력은 " + s.hp + " 남았다.");
		}

	}

}
