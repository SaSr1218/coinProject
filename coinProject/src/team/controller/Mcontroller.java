package team.controller;

public class Mcontroller {
	
	private static Mcontroller mController = new Mcontroller();
	private Mcontroller() { }
	public static Mcontroller getInstance() { return mController; }
	
	// 1. 계좌정보 호출(계좌번호, 계좌잔고) [ 인수 : MemberDto dto[mNo] / 반환 : 성공, 실패 ]
	public boolean checkAccount( int mNo ) {
		
		return true;
	}
	
	// 2. 계좌 입금
	
	
	// 3. 계좌 출금
	
	
	
}
