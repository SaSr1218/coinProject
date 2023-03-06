package team.model.mypage;

import java.util.ArrayList;

import team.controller.Mcontroller;
import team.controller.Pcontroller;
import team.model.Dao;

public class Pdao extends Dao{
	
	// 싱글톤
	private static Pdao pdao = new Pdao();
	private Pdao() { }
	public static Pdao getInstance() { return pdao; }
		
	// 1. 계좌 정보 확인( aName[이름] , aAcount[계좌번호] , aBalance[계좌잔고] , aAmount[코인 잔여개수]  )
	public ArrayList<mypageDto> checkAccount( int mNo  ) { // 인수 mNo , mNo -> 반환 : true[성공] / false[실패]
		
		ArrayList<mypageDto> list = new ArrayList<>();
		
		String sql1 = "insert into account ( mNo , aBalance ) values ( ? , 0 )";
		
		String sql2 = " select m.mName , ac.accName , ac.accountNo , a.aBalance  from member m , create_acc ac , account a "
				+ " where m.mNo and ac.mNo = a.mNo and m.mNo = ?";
		
		try {
			ps = con.prepareStatement(sql1);
			
			ps.setInt(1, mNo);
			ps.executeUpdate();
			
			
			ps = con.prepareStatement(sql2);
			
			ps.setInt(1, mNo);
			
			rs = ps.executeQuery();
			if( rs.next() ) {
				mypageDto dto = new mypageDto( rs.getString(1) , rs.getString(2) , rs.getString(3) , rs.getInt(4) ); 
				
				list.add(dto);
				return list;
			}
			
			
		}catch (Exception e) {System.out.println("DB 에러 : " + e ) ;}
		return list;
	}
	
	// 2. 계좌입금
	public boolean deposit( int mNo , int aBalance , int adeposit ) { 
		String sql1 = "insert into account ( mNo , adeposit ) values ( ? , ? )";
		String sql2 = "update account set aBalance = (aBalance + ?/2 ) where mNo = ?";
		
		try {
			ps = con.prepareStatement(sql1);
			
			ps.setInt(1, mNo);
			ps.setInt(2, adeposit);
			
			ps = con.prepareStatement(sql2);
			
			ps.setInt(1, adeposit);
			ps.setInt(2, mNo);
			
			ps.executeUpdate();
			
			return true;
		}catch (Exception e) { System.out.println("DB 오류 : " + e);}
		return false;
	}
	
	// 2.1 입금계좌 찾기
	public int getaBalance( int mNo ) {
		String sql = "select * from account aBalance where mNo = ?";
		
		try {
			
			ps = con.prepareStatement(sql);
			ps.setInt(1, mNo);
			rs = ps.executeQuery();
			if ( rs.next() ) { return rs.getInt(4); }
		}catch (Exception e) {System.out.println(e);}
		return 0;
	}
	
	// 2.2 입금금액 찾기
	public int getAdeposit (int mNo) {
		String sql = "select * from account adeposit where mNo = ?";
		
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, mNo);
			rs = ps.executeQuery();
			if ( rs.next() ) { return rs.getInt(6); }
		}catch (Exception e) {System.out.println(e);}
		return 0;
	}
	
	// 3. 계좌출금
	public boolean withdraw( int mNo , int aBalance , int withdraw  ) {
		String sql1 = "insert into account ( mNo , withdraw ) values ( ? , ? )"; 
		String sql2 = "update account set aBalance = (aBalance - ?) where mNo =?";
		
		try {			
			if( Pcontroller.getInstance().getaBalance(Mcontroller.getInstance().getLogSession()) - withdraw < 0 ) {
			return false;
		} 
			ps = con.prepareStatement(sql1);
			
			ps.setInt(1, mNo);
			ps.setInt(2, withdraw);
			
			ps = con.prepareStatement(sql2);
			
			ps.setInt(1, withdraw);
			ps.setInt(2, mNo);
			
			ps.executeUpdate();

			return true;
		}catch (Exception e) { System.out.println("DB 오류 : " + e);}
		return false;
	}
	

	
}