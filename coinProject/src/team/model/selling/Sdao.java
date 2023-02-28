package team.model.selling;

import java.util.ArrayList;

import team.model.Dao;

public class Sdao extends Dao {
	
	
	private static Sdao sdao = new Sdao();
	private Sdao() {}
	public static Sdao getInstance() {
		return sdao;
	}
	
	
	// 매수 - 김성봉
	public boolean buy_coin( int mNo , int bPrice , int bAmount ) {
		
		String sql = "insert into buy ( bprice , bAmount ,  mNo ) values ( ? , ? , ? ) ;";
		
		try {
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, mNo);
			ps.setInt(2, bPrice);
			ps.setInt(3, bAmount);
			
			ps.executeUpdate(); 
			
			return true;
		}catch (Exception e) {
			System.out.println("DB 에러 : " + e );
		}
		
		
		
		
		return false;
	}
	
	// 매도 - 김성봉
	public boolean sell_coin( int mNo , int bNo , int sPrice , int sAmount ) {
		
		String sql = "insert into sell ( sPrice , sAmount , bNo ) values ( ? , ? , ?)";
		
		try {
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, sPrice);
			ps.setInt(2, sAmount);
			ps.setInt(3, bNo);
			
			ps.executeUpdate();
			
			return true;
			
		}catch( Exception e) {
			System.out.println("DB 에러 : " + e );
		}
		
		return false;
	}
	
	
	// 보유코인 확인 - 김성봉
	public int coinCheck( int bNo ) {
		
		String sql = "select * from buy where bNo = ?";
		
		try {
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, bNo);
			
			rs = ps.executeQuery();
			
			if( rs.next() ) { return rs.getInt(3); } 
			
		}catch (Exception e) {
			System.out.println("DB 에러 : " + e );
		}
		
		return 0;
	}
	
	
	// 손익확인 - 김성봉
	public ArrayList<sellingDto> profit_and_loss( int bNo , int mNo ) {
		
		ArrayList<sellingDto> report = new ArrayList<>();
		
		String sql = "select b.bPrice , s.sPrice , (s.sPrice - b.bPrice)/b.bPrice*100, (s.sAmount * s.sPrice) - (s.sAmount * b.bPrice) "
					+ " from buy b, sell s "
					+ " where b.bNo = s.bNo and s.bno = ? and mNo = ?;";
		
		try {
			
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, bNo);
			ps.setInt(2, mNo);
			
			rs = ps.executeQuery();
			
			while( rs.next() ) {
				sellingDto dto = new sellingDto(rs.getInt(3), rs.getInt(4));
				
				report.add(dto);
			}
			
			
		}catch (Exception e) {
			System.out.println("DB 에러 : " + e );
		}
		return report;
		
	}
	
	
	
}
