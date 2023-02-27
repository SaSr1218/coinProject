package team.View;

import java.util.Scanner;

public class Mypage {

	// 싱글톤
	private static Mypage mypage = new Mypage();
	public Mypage() { }
	public static Mypage getInstance() { return mypage; }
	
	// 필드
	Scanner scanner = new Scanner(System.in);
	
	// 1. 계좌메인화면
	public void mypage() {
		while(true) {
			
			try {
			System.out.println("1. 계좌확인 2. 입금 3. 출금"); int ach = scanner.nextInt();
			if ( ach == 1 ) { checkAccount(); }
			else if ( ach == 2 ) { deposit(); }
			else if ( ach == 3 ) { withdarw(); }
			} catch (Exception e) {
				// TODO: handle exception
			}
		
	
		
		} // while end
	} // mypage end 
	
	// 1.1 계좌확인
	public void checkAccount() {
		
	}
	
	// 1.2 계좌입금
	public void deposit() {
		
	}
	
	// 1.3 계좌출금
	public void withdarw() {
		
	}
	
	
}