package team.model.selling;

import java.util.ArrayList;

import team.model.Dao;

public class Sdao extends Dao {
	
	
	private static Sdao sdao = new Sdao();
	private Sdao() {}
	public static Sdao getInstance() {
		return sdao;
	}
	
	
	// 코인 목록 확인 - 김성봉
	public boolean coinListCheck( int cNo ) {
		
		String sql = "select * from coinlist where cNo = ? ";
		
		try {
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, cNo);
			
			rs = ps.executeQuery();
			
			if( rs.next() ) { return true; }
			
		}catch (Exception e) {
			System.out.println("DB 에러 : " + e );
		}
		
		
		
		return false;
	}
	
	
	// 코인 금액 가져오기 - 김성봉
	public int getCoinPrice( int cNo ) {
		
		String sql = "select * from coinlist where cno = ?";
		
		try {
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, cNo);
			
			rs = ps.executeQuery();
			
			if( rs.next() ) { return rs.getInt(3); }
			
		}catch (Exception e) {
			System.out.println("DB 에러 : " + e );
		}
		
		
		return 0;
	}
	
	// 매수 - 김성봉
	public boolean buy_coin( int mNo , int bPrice , int bAmount , int cNo ) {
		
		String sql = "insert into buy ( bprice , bAmount ,  mNo , cNo ) values ( ? , ? , ? , ? ) ;";
		
		
		try {
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, bPrice);
			ps.setInt(2, bAmount);
			ps.setInt(3, mNo);
			ps.setInt(4, cNo);
			
			ps.executeUpdate(); 
			
			return true;
		}catch (Exception e) {
			System.out.println("DB 에러 : " + e );
		}
		
		
		
		
		return false;
	}
	
	// 매도 - 김성봉
	public boolean sell_coin( int mNo , int bNo , int sPrice , int sAmount ) {
		
		String sql = "insert into sell ( sPrice , sAmount , bNo , cNo ) values ( ? , ? , ? , ? )";
		
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
	
	
	// 전체 보유 코인 확인 - 김성봉
	public ArrayList<sellingDto> own_coin_check( int bNo , int mNo ) {
		
		ArrayList<sellingDto> own_coinlist = new ArrayList<>(); 
		
		String sql = "select * from buy where bNo = ? and mNo = ?";
		
		try {
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, bNo);
			ps.setInt(2, mNo);
			
			rs = ps.executeQuery();
			
			while ( rs.next() ) {
				
				sellingDto dto = new sellingDto( rs.getInt(2), rs.getInt(3) );
				
				own_coinlist.add(dto);
			}
			
			return own_coinlist;
			
		}catch (Exception e) {
			System.out.println("DB 에러 : " + e );
		}
		
		
		return null;
	}
	
	// 보유코인갯수확인 - 김성봉
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
				sellingDto dto = new sellingDto(rs.getFloat(3), rs.getInt(4));
				
				report.add(dto);
			}
			
			
		}catch (Exception e) {
			System.out.println("DB 에러 : " + e );
		}
		return report;
		
	}
	
	
	
	
	
}
