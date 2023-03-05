package team.View;

import java.util.ArrayList;

import team.controller.Ccontroller;
import team.model.coinlist.coinlistDto;

public class Coinlist extends Thread {
	
	//싱글톤
	private static Coinlist coinlist = new Coinlist();
	private Coinlist() {}
	public static Coinlist getInstance() {return coinlist;}
	
	boolean stop = false;
	
	public boolean isStop() {
		return stop;
	}
	public void setStop(boolean stop) {
		this.stop = stop;
	}
	
	@Override
	public void run() {
		while(true) {
			if(stop) {
				ArrayList<coinlistDto> result = Ccontroller.getInstance().print_coin();
				System.out.println("---------------------코인리스트----------------------");
				System.out.println("번호\t코인이름\t가격\t기초대비");
				for(int i=0;i<result.size();i++) {
					System.out.printf("%d\t%s\t%d\t%.2f\n",
					result.get(i).getcNo(),result.get(i).getcName(),result.get(i).getcPrice(),
					((double)result.get(i).getcPrice()/(double)result.get(i).getcFirstPrice())*100-100
					);
				}
				System.out.println("1. 매수 / 2. 매도 / 3. 손익확인(임시)");
				try {Thread.sleep(5000); }	// 5초에 한번씩 업데이트
				catch (Exception e) {}
			}	
			else {
				Thread.yield();
			}
			
		} // while e
	} // run e
	
	public void profit_print() {
		while(true) {
			System.out.println("---------------------손익 페이지----------------------");
			ArrayList<coinlistDto> result = Ccontroller.getInstance().profit_print();
			System.out.println("NO\t코인명\t보유단가\t보유수량\t현재가\t손익");
		} // while e
	} // profit e
	
} // class e
