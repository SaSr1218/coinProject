package team.controller;

import team.model.mypage.Pdao;

public class Pcontroller {

	// 싱글톤
	private static Pcontroller pcon = new Pcontroller();
	public Pcontroller() { }
	public static Pcontroller getInstance() { return pcon; }
	
	// 0. 로그인 섹션 값
	private int loginSession = 0;
	public int getLoginSession() { return loginSession; }
	public void setLoginSession (int loginSession) { this.loginSession = loginSession; }
	
	// 1. 계좌정보 출력
	public boolean checkAccount( int mNo ) {
		return Pdao.getInstance().checkAccount( mNo );
	}
	
	// 2. 계좌입금
	public boolean deposit( int aBalance , int mNo ) {
		return Pdao.getInstance().deposit(aBalance, mNo);
	}
	
	
	// 3. 계좌출금
	public boolean withdraw( int aBalance , int mNo ) {
		return Pdao.getInstance().withdraw ( aBalance, mNo );
	}
	
	
	
}
