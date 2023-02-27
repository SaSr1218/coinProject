package team.model.coinlist;

import java.util.ArrayList;
import team.model.Dao;

public class Cdao extends Dao{
	// 싱글톤
	private static Cdao cdao = new Cdao();
	private Cdao() {}
	public Cdao getInstance() {return cdao;}
	
	int coinPrice = 1500;
	
	//코인리스트 가져와서 담을 ArrayList
	ArrayList<coinlistDto> coinlist = new ArrayList<>();
	
	// 코인 출력 메소드
	public ArrayList<coinlistDto> print_coin() {
		
		return coinlist;
	}
	// 코인 가격변동 메소드
	
	public void change_coin() {
		
		// 코인들의 개수만큼 반복
		for(int i=0;i<coinlist.size();i++) {
			
		}
		
	}
	

}
