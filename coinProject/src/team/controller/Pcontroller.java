package team.controller;

import java.util.ArrayList;

import team.model.mypage.Pdao;
import team.model.mypage.mypageDto;

public class Pcontroller {

	// 싱글톤
	private static Pcontroller pcon = new Pcontroller();
	public Pcontroller() { }
	public static Pcontroller getInstance() { return pcon; }
	
	// 로그인 섹션 값 : Mcontroller.getInstance().getLogSession()
	
	// 1. 계좌정보 출력
	public ArrayList<mypageDto> checkAccount( int mNo  ) {
		return Pdao.getInstance().checkAccount(mNo);
	}
	
	// 2. 계좌입금
	public boolean deposit(  int mNo , int aBalance  ) {
		return Pdao.getInstance().deposit( mNo, aBalance  );
	}
	
	
	// 3. 계좌출금
	public boolean withdraw( int mNo , int aBalance ) {
		return Pdao.getInstance().withdraw ( mNo, aBalance );
	}
	
	
	
}
