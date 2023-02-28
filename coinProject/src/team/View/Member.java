package team.View;

import java.util.Scanner;

import team.controller.Mcontroller;
import team.model.member.DTO.CoinDto;

public class Member {
	
	// 스캨너
	private Scanner scanner = new Scanner(System.in);
	
	// 싱글톤 적용
	private static Member member = new Member();
	private void Member() {}
	public static Member getInstance() { return member; }
	
	// 메소드 영역
	// 인덱스
	public void index() {
		while(true) {
			System.out.println("-------------------EZ 코인 거래소-------------------");
			System.out.print("[메뉴] 1.회원가임 2.로그인 3.아이디찾기 4.비밀번호찾기");
			try{
			int choice = scanner.nextInt();
			
			if( choice == 1 ) {
				signUp();
			}
			else if( choice == 2) {
				login();
			}
			else if( choice == 3 ) { }
			else if( choice == 4 ) { }
			else { System.out.println("[알림] 번호를 다시 입력해주세요."); }
			}
			catch(Exception e){ System.out.println("예외발생: " + e);}
		}
	}
	
	// 1. 회원가입
	public void signUp() throws Exception {
		System.out.println("-------------------회원가입 페이지-------------------");
		System.out.print("아이디: ");		String mId = scanner.next();
		System.out.print("비밀번호: ");		String mPw = scanner.next();
		System.out.print("비밀번호 확인: ");	String mPwC = scanner.next();
		System.out.print("이름: ");		String mName = scanner.next();
		System.out.print("연락처: ");		String mPhone = scanner.next();
		System.out.print("이메일: ");		String mEmail = scanner.next();

		if( !mPw.equals(mPwC) ) { System.out.println("[알림] 비밀번호 불일치"); }
		else if( mPw.equals(mPwC) ) { 
			int result = Mcontroller.getInstance().signUp(mId, mPw, mName, mPhone, mEmail);
			if(  result == 1 ) { System.out.println("[알림] 회원가입 완료!"); }
			else if( result == 2 ) { System.out.println("[알림] 아이디 중복입니다."); }
			else if( result == 3 ) { System.out.println("[알림] 시스템 오류 관리자 문의!"); }
		}
	}
	
	// 2. 로그인
	public void login() throws Exception {
		System.out.println("-------------------로그인 페이지-------------------");
		System.out.print("아이디: ");		String mId = scanner.next();
		System.out.print("비밀번호: ");		String mpw = scanner.next();
		
		boolean result = Mcontroller.getInstance().login(mId, mpw);
		
		System.out.println( result );
		
		if( result ) {
			System.out.println("[알림] 로그인 성공");
			System.out.println("[메뉴] 1.계좌생성, 2.코인확인, 3.계좌확인, 4.로그아웃 5.회원탈퇴 6.코인등록[관리자용]");
			int choice = scanner.nextInt();
			
			if( choice == 1 ) { createAcc(); }
			else if( choice == 2 ) { } 
			else if( choice == 3 ) { } 
			else if( choice == 4 ) {  } 
			else if( choice == 5 ) { leave(); } 
			else if( choice == 6 ) { regiCoin(); }
		}
		else { System.out.println("[알림] 로그인 실패"); }
	}
	
	// 3. 계좌생성
	public void createAcc() throws Exception {
		System.out.println("-------------------계좌생성 페이지-------------------");
		System.out.print("이름: ");		String accName = scanner.next();
		System.out.print("계좌번호: ");		String Account = scanner.next();
		System.out.print("계좌잔고: ");		int balance = scanner.nextInt();
		
		boolean result = Mcontroller.getInstance().createAcc(accName,Account,balance);
		
	}
	
	// 4. 코인등록
	public void regiCoin() throws Exception {
		System.out.println("-------------------관리자용 페이지[코인 등록]-------------------");
		System.out.println("코인명: ");	String cName = scanner.next();
		System.out.println("발행량: ");	int cAmount = scanner.nextInt();
		System.out.println("발행가격: ");	int cPrice = scanner.nextInt();
		System.out.println("초기가격: ");	int cFirstprice = scanner.nextInt();
		
		CoinDto dto = new CoinDto( 0, cName, cAmount, cPrice, cFirstprice );
		if(Mcontroller.getInstance().regiCoin(dto)) {
			System.out.println("[알림] 정상적으로 발행되었습니다.");
		}
	}
	
	// 5. 회원탈퇴
	public void leave() throws Exception {
		System.out.println("-------------------회원탈퇴 페이지-------------------");
		System.out.print("비밀번호: ");		String mpw = scanner.next();
	}
}
