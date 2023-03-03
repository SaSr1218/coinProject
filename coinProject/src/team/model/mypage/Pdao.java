package team.model.mypage;

import java.util.ArrayList;

import team.model.Dao;
import team.model.member.DTO.AccountDto;

public class Pdao extends Dao{
	
	// 싱글톤
	private static Pdao pdao = new Pdao();
	private Pdao() { }
	public static Pdao getInstance() { return pdao; }
		
	// 1. 계좌 정보 확인( aName[이름] , aAcount[계좌번호] , aBalance[계좌잔고] , aAmount[코인 잔여개수]  )
	public ArrayList<mypageDto> checkAccount( int mNo  ) { // 인수 mNo , mNo -> 반환 : true[성공] / false[실패]
		
		ArrayList<mypageDto> list = new ArrayList<>();
		
		String sql = " select m.mNo , m.mName ,  ac.accountNo , ac.accBalance , b.bAmount  from member m , buy b ,  create_acc ac "
				+ " where ac.mNo = m.mNo and m.mNo = ?;";
		
		try {
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, mNo);
			
			rs = ps.executeQuery();
			if( rs.next() ) {
				mypageDto dto = new mypageDto( rs.getString(2) , rs.getString(3) , rs.getInt(4) , rs.getInt(5) ); 
				
				list.add(dto);
				return list;
			}
			
			
		}catch (Exception e) {System.out.println("DB 에러 : " + e ) ;}
		return null;
		
	}
	
	// 2. 계좌입금
	public boolean deposit( int aBalance , int mNo ) { 
		String sql = "insert into account ( aBalance , mNo ) values ( ? , ? )";
		try {
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, aBalance);
			ps.setInt(2, mNo);
			
			ps.executeUpdate();
			
			return true;
		}catch (Exception e) { System.out.println("DB 오류 : " + e);}
		return false;
	}
	
	// 3. 계좌출금
	public boolean withdraw( int aBalance , int mNo ) {	// outMoney를 쓸 예정..
		String sql = "update account set aBalance = ( aBalance - 매개변수 ) where mNo = ?"; 
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, aBalance);
			ps.setInt(2, mNo);
			
			ps.executeUpdate();
			
			return true;
			
		}catch (Exception e) { System.out.println("DB 오류 : " + e);}
		return false;
	}
	
}
	