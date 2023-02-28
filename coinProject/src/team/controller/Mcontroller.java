package team.controller;

import team.model.member.DAO.Mdao;
import team.model.member.DTO.AccountDto;
import team.model.member.DTO.CoinDto;
import team.model.member.DTO.MemberDto;

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
	

	private int logSession = 0;
	
	// 메소드 영역
	// 1. 회원가입
	public int signUp( String mId, String mPw, String mName, String mPhone, String mEmail ) {
		
		int result = Mdao.getInstance().idCheck(mId);
		
		// 기능1: 유효성 검사 (1: 아이디 중복 x , 2: 아이디 중복 o, 3: 회원가입 미처리)
		if( result == 2) { return 2; }
		else if( result == 3){ return 3; }
		MemberDto mDto = new MemberDto(0, mId, mPw, mName, mPhone, mEmail);
		return Mdao.getInstance().signUp(mDto);
	}
	
	// 2. 로그인
	public boolean login( String mId, String mPw ) {
		int result = Mdao.getInstance().login(mId,mPw);
		if( result == 0 ) { return false; }
		else { logSession = result; return true;  }
	}
	
	// 3. 아이디 찾기
	public String searchID( String mPhone ) {
		return Mdao.getInstance().searchID(mPhone);
	}
	
	public String searchID( String mName, String mEmail ) {
		return Mdao.getInstance().searchID(mName, mEmail);
	}
	
	// 4. 비밀번호 찾기
	public String searchPW( String mId, String mPhone ) {
		return Mdao.getInstance().searchPW(mId, mPhone);
	}
	
	
	// 5. 계좌 등록
	public boolean createAcc( String accName, String accountNo, int accBalance ) {
		AccountDto aDto = new AccountDto( 0, accName, accountNo, accBalance, logSession );
		return Mdao.getInstance().createAcc(aDto);
	}
	
	// 6. 코인 등록
	public int regiCoin(String cName, int cAmount, int cPrice, int cFirstprice) {
		
		int result = Mdao.getInstance().coinCheck(cName);
		
		if( result == 2 ) { return 2; }
		else if( result == 3 ) { return 3;}
		CoinDto cDto = new CoinDto(0, cName, cPrice, cAmount, cFirstprice);
		return Mdao.getInstance().regiCoin(cDto);
	}
	
	// 7. 회원 탈퇴
	public boolean leave( String mpw ) {
		return Mdao.getInstance().leave(mpw);
	}
	
	public int getLogSession() {
		return logSession;
	}
	
	public void setLogSession(int logSession) {
		this.logSession = logSession;
	}
	

}
