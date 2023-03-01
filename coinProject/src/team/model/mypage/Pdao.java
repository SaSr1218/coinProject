package team.model.mypage;

import team.model.Dao;

public class Pdao extends Dao{
	
	// 싱글톤
	private static Pdao pdao = new Pdao();
	private Pdao() { }
	public static Pdao getInstance() { return pdao; }
		
	// 1. 계좌 정보 확인( accName[계좌멤버이름] , Account[계좌번호] , balance[계좌잔고] )
	public boolean checkAccount( int mNo ) {
	
		String sql = " select m.mNo , ac.accName , ac.Account , ac.Balance from member m , create_acc ac "
				+ " where ac.accNo = m.mNo and m.mNo = ?";
		
		try {
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, mNo);
			
			rs = ps.executeQuery();
			
			
		}catch (Exception e) {System.out.println("DB 에러 : " + e ) ;}
		return true;
	}
	
	// 계좌입금
	public boolean deposit( int aBalance , int mNo ) {
		String sql = "insert into account ( aBalance , mNo ) values ( ? , ? )";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, aBalance);
			ps.setInt(2, mNo);
			
		}catch (Exception e) { System.out.println("DB 오류 : " + e);}
		return false;
	}
	
	// 계좌출금
	public boolean withdraw( int aBalance , int mNo ) {
		String sql = "insert into account ( aBalance , mNo ) values ( ? , ? )";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, aBalance);
			ps.setInt(2, mNo);
			
		}catch (Exception e) { System.out.println("DB 오류 : " + e);}
		return false;
	}
	
}
	