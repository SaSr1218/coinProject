package team.View;

import java.util.ArrayList;

import team.controller.Ccontroller;
import team.model.coinlist.coinlistDto;

public class Coinlist {
	
	//싱글톤
	private static Coinlist coinlist = new Coinlist();
	private Coinlist() {}
	public static Coinlist getInstance() {return coinlist;}
	
	
	public void print_coin() {
		while(true) {
			try {Thread.sleep(5000); } //해당 메소드 작업시간 추가
			catch (Exception e) {}
			ArrayList<coinlistDto> result = Ccontroller.getInstance().print_coin();
			System.out.println("---------------------코인리스트----------------------");
			System.out.println("번호\t코인이름\t가격\t기초대비");
			for(int i=0;i<result.size();i++) {
				System.out.printf("%d\t%s\t%d\t%.2f\n",
						result.get(i).getcNo(),result.get(i).getcName(),result.get(i).getcPrice(),
						((double)result.get(i).getcPrice()/(double)result.get(i).getcFirstPrice())*100
						);
			}
		}
		
	}// print_coin e
} // class e