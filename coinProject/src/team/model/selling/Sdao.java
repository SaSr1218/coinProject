package team.model.selling;

import team.model.Dao;

public class Sdao extends Dao {
	
	
	private static Sdao sdao = new Sdao();
	private Sdao() {}
	public static Sdao getInstance() {
		return sdao;
	}
	
	
	
	
	
	
	// 매수 - 김성봉
	public boolean buy_coin( int mNo , int bPrice , int bAmount ) {
		
		String sql = "insert into buy ( bprice , bAmount ,  mNo ) values ( 1 , 2 , 1) ;";
		
		try {
			ps = con.prepareStatement(sql);
			
			ps.executeUpdate(); 
			
			return true;
		}catch (Exception e) {
			System.out.println("DB 에러 : " + e );
		}
		
		
		
		
		return false;
	}
	
	// 매도 - 김성봉
	public boolean sell_coin( int mNo , int bNo , int sPrice , int sAmount ) {
		return false;
	}
	
	
	// 손익확인 - 김성봉
	public void profit_and_loss( int mNo ) {
		
	}
	
}
