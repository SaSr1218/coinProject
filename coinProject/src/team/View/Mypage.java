package team.View;

import java.util.Scanner;

import team.controller.Pcontroller;
import team.model.member.DTO.AccountDto;

public class Mypage {

	// 싱글톤
	private static Mypage mypage = new Mypage();
	public Mypage() { }
	public static Mypage getInstance() { return mypage; }
	
	// 필드
	Scanner scanner = new Scanner(System.in);
	
	// 1. 계좌메인화면
	public void mypage(){
		while(true) {
			try {
			System.out.println("1. 계좌확인 2. 입금 3. 출금"); int ach = scanner.nextInt();
			if ( ach == 1 ) { checkAccount(1 ,1 ); } // 계좌확인[계좌번호, 계좌잔고]
			else if ( ach == 2 ) { deposit( 1000 , 1); } // 계좌입금
			else if ( ach == 3 ) { withdarw( 1000 , 1); } // 계좌출금
			} catch (Exception e) {System.out.println("DB 에러 이유 : " + e);}
		
	
		
		} // while end
	} // mypage end 
	
	// 1.1 계좌확인
	public void checkAccount( int mNo , int cNo ) { 
		System.out.println("계좌명 \t 계좌번호 \t \t 계좌잔고 \t 코인잔여개수");
		
		boolean result = Pcontroller.getInstance().checkAccount( mNo , cNo );
		if ( result ) { System.out.println("[계좌정보]"); }
		else { System.out.println("연동된 계좌가 없습니다."); }
		
	}
	
	// 1.2 계좌입금
	public void deposit( int aBalance , int mNo ) {
		System.out.println("입금할 금액을 입력해주세요."); int inMoney = scanner.nextInt();
		boolean result = Pcontroller.getInstance().deposit(aBalance, mNo);
		if ( result ) { System.out.println("계좌입금 완료되었습니다.");}
		else { System.out.println("계좌입금 실패하였습니다.");}
	}
	
	// 1.3 계좌출금
	public void withdarw( int aBalance , int mNo ) { // if 출금 금액이 계좌금액보다 크다면 실패하고 "계좌에 있는 금액 이하를 입력해주세요."
		System.out.println("출금할 금액을 입력해주세요."); int outMoney = scanner.nextInt();
		boolean result = Pcontroller.getInstance().withdraw(aBalance, mNo);
		if ( result ) { System.out.println("계좌출금 완료되었습니다.");}
		else { System.out.println("계좌출금 실패하였습니다.");}
	}
	
	
}