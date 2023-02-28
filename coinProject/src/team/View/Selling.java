package team.View;

import java.util.Scanner;

import team.model.selling.Sdao;

public class Selling {
	
	Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		
		
	}
	
	
	
	public void temp() {
		
		while( true ) {
			System.out.println("코인목록");
			System.out.println();
			
			System.out.println("1. 매수 / 2. 매도");
			int ch = scanner.nextInt();
			
			if( ch == 1 ) { buy_coin(); }
			else if( ch == 2 ) { sell_coin(); }
		}
	}
	
	
	
	public void buy_coin() {
		System.out.println("매수할 코인을 선택해주세요.");
		int ch = scanner.nextInt();
		
		System.out.println("매수할 갯수를 선택해주세요.");
		int bAmount = scanner.nextInt();
		
		boolean result = false;
	}
	
	public void sell_coin() {
		System.out.println("매도할 코인을 선택해주세요.");
		int ch = scanner.nextInt();
		
		System.out.println("매도할 갯수를 선턱해주세요.");
		int sAmount = scanner.nextInt();
		
		boolean result = false; 
	}
	
	
	
}
