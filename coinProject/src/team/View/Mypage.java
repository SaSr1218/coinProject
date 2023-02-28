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
	public void checkAccount() { // if 
		System.out.println("연동된 계좌번호는 : " ); 
		System.out.println("출금 가능 금액은 : ");
	}
	
	// 1.2 계좌입금
	public void deposit() {
		System.out.println("입금할 금액을 입력해주세요."); int inMoney = scanner.nextInt();
	}
	
	// 1.3 계좌출금
	public void withdarw() { // if 출금 금액이 계좌금액보다 크다면 실패하고 "계좌에 있는 금액 이하를 입력해주세요."
		System.out.println("출금할 금액을 입력해주세요."); int outMoney = scanner.nextInt();

	}
	
	
}