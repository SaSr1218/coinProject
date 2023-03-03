package team.model.selling;

import java.util.ArrayList;

import team.model.Dao;

public class Sdao extends Dao {
	
	
	private static Sdao sdao = new Sdao();
	private Sdao() {}
	public static Sdao getInstance() {
		return sdao;
	}
	
	
	public sellingDto getCoinInfo( int cNo , int mNo ) {
		
		String sql = "select c.cname , p.cmprice , (select ctprice from cointradelist where cno = ? and sellstate is not null order by ctdate desc limit 1) as recent_trade, "
					+ "pn.pcSumPrice , pn.pcAmount , (select ((p.cmprice - pn.pcsumprice)/pn.pcsumprice)*100 from coinmarketp p , personal_coinlist pn where p.cno = pn.cno and pn.cno = ?), "
					+ "(select pn.pcsumprice * ((p.cmprice - pn.pcsumprice)/pn.pcsumprice) * pn.pcamount from coinmarketp p , personal_coinlist pn where p.cno = pn.cno and pn.cno = ?)"
					+ " from coinlist c , coinmarketp p , personal_coinlist pn"
					+ " where c.cno = p.cno and p.cno = pn.cno and pn.cno = ? and pn.mno = ?";
		
		try {
			
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, cNo);
			ps.setInt(2, cNo);
			ps.setInt(3, cNo);
			ps.setInt(4, cNo);
			ps.setInt(5, mNo);
			
			rs = ps.executeQuery();
			
			if ( rs.next() ) {
				sellingDto dto = new sellingDto(
						rs.getString(1), rs.getInt(2) , rs.getInt(3),
						rs.getInt(4), rs.getInt(5), rs.getDouble(6), rs.getInt(7)
				);
				return dto ;
			}else {
				
				sql = "select c.cname , p.cmprice , (select ctprice from cointradelist where cno = ? and sellstate is not null order by ctdate desc limit 1) "
					+ " from coinlist c , coinmarketp p"
					+ " where c.cno = p.cno and c.cno = ?";
				
				ps = con.prepareStatement(sql);
				
				ps.setInt(1, cNo);
				ps.setInt(2, cNo);
				
				rs = ps.executeQuery();
				
				if( rs.next() ) {
					sellingDto dto = new sellingDto(
							rs.getString(1), rs.getInt(2), rs.getInt(3),
							0, 0, 0, 0
					);
					
					return dto ;
				}
				
				
			}
			
			
			
		}catch (Exception e) {
			System.out.println("DB 에러 : " + e );
		}
		
		
		return null;
	}
	
	
	
	public boolean buy_coin( int ctprice , int ctvolume , String buystate , int cno , int mno ) {
		
		String sql = "insert into cointradelist ( ctprice , ctvolume , buystate , cno , mno ) "
					+ " values ( ? , ? , ? , ? , ? )";
		
		try {
			
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, ctprice);
			ps.setInt(2, ctvolume);
			ps.setString(3, buystate);
			ps.setInt(4, cno);
			ps.setInt(5, mno);
			
			ps.executeUpdate();
			
			
		}catch (Exception e) {
			System.out.println("DB 에러 : " + e );
		}
		
		return false; 
	}
	
	
	
	
	
	
	
	
	
	
	
}
