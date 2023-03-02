package team.model.mypage;

import team.model.Dao;
import team.model.member.DTO.AccountDto;

public class Pdao extends Dao{
	
	// 싱글톤
	private static Pdao pdao = new Pdao();
	private Pdao() { }
	public static Pdao getInstance() { return pdao; }
		
	// 1. 계좌 정보 확인( aName[이름] , aAcount[계좌번호] , aBalance[계좌잔고] , aAmount[코인 잔여개수]  )
	public boolean checkAccount( int mNo , int cNo ) { // 인수 mNo , mNo -> 반환 : true[성공] / false[실패]
	
		String sql = " select m.mNo , m.mName ,  ac.accountNo , ac.accBalance , b.bAmount  from member m , buy b ,  create_acc ac "
				+ " where  m.mNo = ?;";
		
		try {
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, mNo);
			
			rs = ps.executeQuery();
			if( rs.next() ) {
				mypageDto dto = new mypageDto( rs.getString(2) , rs.getString(3) , rs.getInt(4) , rs.getInt(5) ); 
			}
			return true;
		}catch (Exception e) {System.out.println("DB 에러 : " + e ) ;}
		return false;
	}
	
	// 2. 계좌입금
	public boolean deposit( int aBalance , int mNo ) { 
		String sql = "insert into account ( aBalance , mNo ) values ( ? , ? )";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, aBalance);
			ps.setInt(2, mNo);
			
		}catch (Exception e) { System.out.println("DB 오류 : " + e);}
		return false;
	}
	
	// 3. 계좌출금
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
	