package team.View;

import java.util.Scanner;

import team.controller.Mcontroller;
import team.model.coinlist.Cdao;
import team.model.member.DTO.AccountDto;
import team.model.member.DTO.Accountextends.AccountBitsum;
import team.model.member.DTO.Accountextends.AccountCoinone;
import team.model.member.DTO.Accountextends.AccountUpbit;
import team.model.member.DTO.CoinDto;

public class Member {
	
	// 스캨너
	private Scanner scanner = new Scanner(System.in);
	
	// 싱글톤 적용
	private static Member member = new Member();
	private Member() {}
	public static Member getInstance() { return member; }
	
	// 메소드 영역
	// 0. 인덱스
	public void index() {
		while(true) {
			System.out.println("-------------------EZ 코인 거래소-------------------");
			System.out.print("[메뉴] 1.회원가임 2.로그인 3.아이디찾기 4.비밀번호찾기");
			try{
			int choice = scanner.nextInt();
			
			if( choice == 1 ) { signUp(); }
			else if( choice == 2) { login(); }
			else if( choice == 3 ) { searchID(); }
			else if( choice == 4 ) { searchPW(); }
			else { System.out.println("[알림] 번호를 다시 입력해주세요."); }
			}
			catch(Exception e){ System.out.println("예외발생: " + e);}
		}
	}
	
	// 1. 회원가입
	public void signUp() throws Exception {
		System.out.println("-------------------회원가입 페이지-------------------");
		System.out.print("아이디(5자리 이상): ");		String mId = scanner.next();
		System.out.print("비밀번호: ");		String mPw = scanner.next();
		System.out.print("비밀번호 확인: ");	String mPwC = scanner.next();
		System.out.print("이름: ");		String mName = scanner.next();
		System.out.print("연락처(하이픈 생략): ");		String mPhone = scanner.next();
		System.out.print("이메일: ");		String mEmail = scanner.next();
		
		boolean checkId = true;
		boolean checkPw = true;
		boolean checkName = true;
		boolean checkPhone = true;
		boolean checkEmail = true;
		
		if( mId.length() < 5 ) { System.out.println("[알림] 아이디 5자리 이상 입력!"); checkId = false; }
		if( !mPw.equals(mPwC) ) { System.out.println("[알림] 비밀번호 불일치!"); checkPw = false; }
		if( mName.length() < 2) { System.out.println("[알림] 이름 확인!"); checkName = false; }
		if( mPhone.length() != 11 ) { System.out.println("[알림] 번호 확인!"); checkPhone = false; }
		if( !(mEmail.contains("@")) ) { System.out.println("[알림] 잘못된 양식!(@입력)"); checkEmail = false; }
		
		
		else if( checkId && checkPw && checkName && checkPhone &&  checkEmail ) { 
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

		if( result ) {
			System.out.println("[알림] 로그인 성공");
			if( Mcontroller.getInstance().adminCoin() ) { loginIndex( mId ); }
			else { loginIndex(); }
		}
		else { System.out.println("[알림] 로그인 실패"); }
	}
	
	// 2-1. 로그인 후 메뉴 출력 (일반 회원)
	public void loginIndex() throws Exception{
		while(true) {
			System.out.print("[메뉴] 1.계좌생성, 2.코인확인, 3.계좌확인, 4.로그아웃 5.회원탈퇴");
			int choice = scanner.nextInt();
			
			if( choice == 1 ) { createAcc(); }
			else if( choice == 2 ) { Selling.getInstance().index(); } 
			else if( choice == 3 ) { } 
			else if( choice == 4 ) { 
				Mcontroller.getInstance().setLogSession(0);
				System.out.println("[알림] 정상적으로 로그아웃되었습니다.");
				break;
			} 
			else if( choice == 5 ) {  if(leave()) { break; }; } 
		}
	}
	
	// 2-1. 로그인 후 메뉴 출력 (관리자) - 오버로딩 적용
	public void loginIndex(String admin) throws Exception{
		while(true) {
			System.out.print("[메뉴] 1.계좌생성, 2.코인확인, 3.계좌확인, 4.로그아웃 5.회원탈퇴 6.코인등록[관리자용]");
			int choice = scanner.nextInt();
			
			if( choice == 1 ) { createAcc(); }
			else if( choice == 2 ) { } 
			else if( choice == 3 ) { } 
			else if( choice == 4 ) { 
				Mcontroller.getInstance().setLogSession(0);
				System.out.println("[알림] 정상적으로 로그아웃되었습니다.");
				break;
			} 
			else if( choice == 5 ) { if(leave()) { break; } } 
			else if( choice == 6 ) { regiCoin(); }
		}
	}

	// 3. 아이디 찾기
	public void searchID()throws Exception{
		System.out.println("-------------------아이디 찾기-------------------");
		System.out.print("[선택] 1.핸드폰으로 아이디찾기 2.이메일로 아이디찾기");
		int choice = scanner.nextInt();
		
		if( choice == 1) {
			System.out.print("번호 입력: ");	String mPhone = scanner.next();
			
			if( Mcontroller.getInstance().searchID(mPhone) == null ) {
				System.out.println("[알림] 번호를 다시 확인해주세요.");
			}
			else {
				System.out.println("아이디: " + Mcontroller.getInstance().searchID(mPhone));
			}	
		}
		
		else if( choice == 2) {
			System.out.print("이름 입력: ");	String mName = scanner.next();
			System.out.print("이메일 입력: ");	String mEmail = scanner.next();
			
			if( Mcontroller.getInstance().searchID(mName, mEmail) == null ) {
				System.out.println("[알림] 입력하신 정보를 다시 확인해주세요.");
			}
			else {
				System.out.println("아이디: " + Mcontroller.getInstance().searchID(mName, mEmail));
			}
		}
	}
	
	// 4. 비밀번호 찾기
	public void searchPW() throws Exception{
		System.out.println("-------------------비밀번호 찾기-------------------");
		System.out.print("아이디 입력: ");	String mId = scanner.next();
		System.out.print("번호 입력: ");	String mPhone = scanner.next();
		
		if( Mcontroller.getInstance().searchPW(mId, mPhone) == null ) {
			System.out.println("[알림] 입력하신 정보를 다시 확인해주세요.");
		}
		else {
			System.out.println("비밀번호: " + Mcontroller.getInstance().searchPW(mId, mPhone));
		}
	}
	
	// 5. 계좌생성 (상속 활용)
	public void createAcc() throws Exception {
		
		AccountDto acc = new AccountDto();
		
		boolean result = true;
		
		System.out.println("-------------------계좌생성 페이지-------------------");
		System.out.print("[계좌선택] 1.업비트 2.빗썸 3.코인원");		int choice = scanner.nextInt();
		
		if( choice == 1 ) {
			acc = new AccountUpbit();
			String accName = "업비트";		String accountNo = acc.createAccount();
			System.out.println("[생성 계좌 정보] 계좌은행:"  + accName + " 계좌번호:" + accountNo );
			result = Mcontroller.getInstance().createAcc(accName,accountNo,0);
			
			if( result ) { acc.complete(); }
		}
		else if( choice == 2 ) {
			acc = new AccountBitsum();
			String accName = "빗썸";		String accountNo = acc.createAccount();
			System.out.println("[생성 계좌 정보] 계좌은행:"  + accName + " 계좌번호:" + accountNo );
			result = Mcontroller.getInstance().createAcc(accName,accountNo,0);
			if( result ) { acc.complete(); }
		}
		else if( choice == 3 ) {
			acc = new AccountCoinone();
			String accName = "코인원";		String accountNo = acc.createAccount();
			System.out.println("[생성 계좌 정보] 계좌은행:"  + accName + " 계좌번호:" + accountNo );
			result = Mcontroller.getInstance().createAcc(accName,accountNo,0);
			if( result ) { acc.complete(); }
		}
	}
		
	// 6. 코인등록
	public void regiCoin() throws Exception {
		System.out.println("-------------------관리자용 페이지[코인 등록]-------------------");
		System.out.print("코인명: ");		String cName = scanner.next();
		System.out.print("발행량: ");		int cAmount = scanner.nextInt();
		System.out.print("발행가격: ");		int cPrice = scanner.nextInt();
		System.out.print("초기가격: ");		int cFirstprice = scanner.nextInt();
		
		if( Mcontroller.getInstance().regiCoin(cName, cAmount, cPrice, cFirstprice) == 1 ) {
			System.out.println("[알림]" + cName + "정상 발행 완료");
		}
		else { System.out.println("[알림] 이미 발행된 코인입니다." ); }
	}
	
	// 7. 회원탈퇴
	public boolean leave() throws Exception {
		System.out.println("-------------------회원탈퇴 페이지-------------------");
		System.out.print("비밀번호: ");		String mpw = scanner.next();
		
		if( Mcontroller.getInstance().leave(mpw) ) { System.out.println("[알림] 회원 탈퇴 정상 완료"); return true;}
		else { System.out.println("[알림] 비밀번호가 다릅니다."); return false; }
	}
}
