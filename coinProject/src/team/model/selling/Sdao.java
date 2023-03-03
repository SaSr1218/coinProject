package team.model.selling;

import java.util.ArrayList;

import team.model.Dao;

public class Sdao extends Dao {
	
	
	private static Sdao sdao = new Sdao();
	private Sdao() {}
	public static Sdao getInstance() {
		return sdao;
	}
	
	
	
	public 
	
	
	
	
	
	
	
	
	
	
	// ================================================================================
	
	
	// 코인 목록 가져오기
	public String coinListCheck( int cNo ) {
		
		ArrayList<sellingDto> coinList = new ArrayList<>();
		
		String sql = "select * from coinlist where cNo = ? ";
		
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, cNo);
			rs = ps.executeQuery();
		
			if( rs.next() ) { return rs.getString(2); }
			
		}catch (Exception e) {
			System.out.println("DB 에러 : " + e );
		}
		return null;
	}
	
	// buy bNo 로 코인 cNo 찾기
	public int findcNo( int bNo ) {
		
		String sql = "select cNo from buy where bno = ? ";
		
		try {
			
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, bNo);
			
			rs = ps.executeQuery();
			
			if( rs.next() ) { return rs.getInt(1); }
			
		}catch (Exception e) {
			System.out.println("DB 에러 : " + e );
		}
		
		return 0;
	}
	
	
	// 코인 금액 가져오기
	public int getCoinPrice( int cNo ) {
		
		String sql = "select * from coinlist where cNo = ?";
		
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
	
	// 매수
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
	
	// 매도
	public boolean sell_coin( int mNo , int bNo , int sPrice , int sAmount , int cNo) {
		
		String sql1 = "update buy set bAmount = (bAmount - ?) where bNo = ? and mNo = ?";
		String sql2 = "insert into sell ( sPrice , sAmount , bNo , cNo ) values ( ? , ? , ? , ? )";
		
		try {
			ps = con.prepareStatement(sql1);
			
			ps.setInt(1, sAmount);
			ps.setInt(2, bNo);
			ps.setInt(3, mNo);
			
			ps.executeUpdate();
			
			ps = con.prepareStatement(sql2);
			
			ps.setInt(1, sPrice);
			ps.setInt(2, sAmount);
			ps.setInt(3, bNo);
			ps.setInt(4, cNo);
			
			ps.executeUpdate();
			
			return true;
			
		}catch( Exception e) {
			System.out.println("DB 에러 : " + e );
		}
		
		return false;
	}
	
	
	// 로그인한 회원이 보유한 전체코인 가져오기
	public ArrayList<sellingDto> own_coin_check( int mNo ) {
		
		ArrayList<sellingDto> own_coinlist = new ArrayList<>(); 
		
		String sql = "select b.bno , b.bprice , b.bamount , c.cname"
					+ " from  buy b , member m , coinlist c"
					+ " where b.mno = m.mno and b.cno = c.cno and m.mno = ?"; 
		
		try {
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, mNo);
			
			rs = ps.executeQuery();
			
			while ( rs.next() ) {
				
				sellingDto dto = new sellingDto( rs.getInt(1) , rs.getInt(2), rs.getInt(3) , rs.getString(4) );
				
				own_coinlist.add(dto);
			}
			
			return own_coinlist;
			
		}catch (Exception e) {
			System.out.println("DB 에러 : " + e );
		}
		
		
		return null;
	}
	
	// 보유코인갯수확인
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
	
	
	// 손익확인
	public ArrayList<sellingDto> profit_and_loss( int mNo ) {
		
		ArrayList<sellingDto> report = new ArrayList<>();
		
		String sql = "select c.cname , s.sDate , b.bPrice , s.sPrice , (s.sPrice - b.bPrice)/b.bPrice*100, (s.sAmount * s.sPrice) - (s.sAmount * b.bPrice)"
					+ " from buy b, sell s , coinlist c"
					+ " where b.bNo = s.bNo and s.cNo = c.cNo and mNo = ?";
		
		try {
			
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, mNo);
			
			rs = ps.executeQuery();
			
			while( rs.next() ) {
				sellingDto dto = new sellingDto( rs.getString(1) , rs.getString(2) , rs.getFloat(5) , rs.getInt(6));
				
				report.add(dto);
			}
			
		}catch (Exception e) {
			System.out.println("DB 에러 : " + e );
		}
		return report;
		
	}
}
