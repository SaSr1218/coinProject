package team.model.selling;

import java.util.ArrayList;

import team.model.Dao;

public class Sdao extends Dao {
	
	
	private static Sdao sdao = new Sdao();
	private Sdao() {}
	public static Sdao getInstance() {
		return sdao;
	}
	
	// 코인 정보 가져오기 - 코인 상세보기페이지 , 개인 포트폴리오에 사용할 코인정보 객체화 
	public sellingDto getCoinInfo( int cNo , int mNo ) {
		
		String sql = "select c.cname , p.cmprice , p.cmremaining , (select ctprice from cointradelist where cno = ? and sellstate is not null order by ctdate desc limit 1) as recent_trade, "
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
						rs.getInt(4), rs.getInt(5) , rs.getInt(6) , rs.getDouble(7), rs.getInt(8)
				);
				return dto ;
			}else {
				
				sql = "select c.cname , p.cmprice , p.cmremaining , (select ctprice from cointradelist where cno = ? and sellstate is not null order by ctdate desc limit 1) "
					+ " from coinlist c , coinmarketp p"
					+ " where c.cno = p.cno and c.cno = ?";
				
				ps = con.prepareStatement(sql);
				
				ps.setInt(1, cNo);
				ps.setInt(2, cNo);
				
				rs = ps.executeQuery();
				
				if( rs.next() ) {
					sellingDto dto = new sellingDto(
							rs.getString(1), rs.getInt(2), rs.getInt(3), rs.getInt(4),
							0, 0, 0, 0
					);
					return dto ;
				}
			}
		}catch (Exception e) {
			System.out.println("정보셀렉트 에러 : " + e );
		}
		return null;
	}

	
	// 거래테이블에 내역 인서트
	public boolean buy_coin( int ctprice , int ctvolume , int cno , int mno ) {
		
		String sql = "insert into cointradelist ( ctprice , ctvolume , buystate , cno , mno ) values ( ? , ? , ? , ? , ? )";
		
		try {
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, ctprice);
			ps.setInt(2, ctvolume);
			ps.setString(3, "B");
			ps.setInt(4, cno);
			ps.setInt(5, mno);
			
			ps.executeUpdate();
			
			CMRemainingUpdate( ctvolume , cno );
			personal_portfolio( mno , ctvolume , ctprice , cno );
			CMPriceUpdate( cno );
			
			return true ;
		
		}catch (Exception e) {
			System.out.println("매수 에러 : " + e );
		}
		
		return false;
	}
	
	
	// 매수된 코인 갯수만큼 해당 코인의 잔여수량 업데이트
	public void CMRemainingUpdate( int ctvolume , int cno ) {
		
		String sql = "update coinmarketp p , cointradelist t set p.cmremaining = ( p.cmremaining - ? ) where p.cno = ?";
		
		try {
			
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, ctvolume);
			ps.setInt(2, cno);
			
			ps.executeUpdate();
			
		}catch (Exception e) {
			System.out.println("잔여수량업데이트 에러 : " + e );
		}
	}
	
	
	// 개인 거래현황 인서트 및 업데이트
	public void personal_portfolio( int mno , int ctvolume , int ctprice , int cno ) {
		
		String sql = "insert into personal_coinlist ( pcno , pcAmount , pcsumprice , cno , mno ) values (  ? , ? , ? , ? , ? )"
				+ " on duplicate key update pcamount = (select sum(ctvolume) from cointradelist where sellstate is null), "
				+ " pcsumprice = (select sum(ctprice * ctvolume) from cointradelist where mno = ? and cno = ? and sellstate is null )/pcamount ;";
		
		try {
			
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, mno);
			ps.setInt(2, ctvolume);
			ps.setInt(3, ctprice);
			ps.setInt(4, cno);
			ps.setInt(5, mno);
			ps.setInt(6, mno);
			ps.setInt(7, cno);
			
			ps.executeUpdate();
			
		}catch (Exception e) {
			System.out.println("개인코인리스트 에러 : " + e );
		}
	}
	
	
	// 평단가 업데이트
	public void CMPriceUpdate( int cno ) {
		
		String sql = "update coinmarketp p,"
					+ " (select ((p.ciprice*p.cmremaining) + "
					+ " (select (select ctprice from cointradelist where cno = ? and sellstate is not null order by ctdate desc limit 1) * "
					+ " (select ((select sum(ctvolume) from cointradelist where cno = ? and sellstate is null) - (select sum(ctvolume) from cointradelist where cno = ? and sellstate is not null)) "
					+ " from (select sum(ctvolume) from cointradelist where cno = ? and sellstate is null) buycoin , (select sum(ctvolume) from cointradelist where cno = ? and sellstate is not null) sellcoin) "
					+ " from dual)) / c.cAmount as result from coinmarketp p , coinlist c where p.cno = c.cno and p.cno = ? ) r "
					+ " set p.cmprice = r.result where p.cno = ? ;";
		
		try {
			
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, cno);
			ps.setInt(2, cno);
			ps.setInt(3, cno);
			ps.setInt(4, cno);
			ps.setInt(5, cno);
			ps.setInt(6, cno);
			ps.setInt(7, cno);
			
			ps.executeUpdate();
			
		}catch (Exception e) {
			System.out.println("평단가업데이트 에러 : " + e );
		}
		
	}
		
	public boolean sell_coin( int ctprice , int ctvolume , int cno , int mno ) {
		
		String sql = "insert into cointradelist ( ctprice , ctvolume , sellstate , cno , mno ) values ( ? , ? , ? , ? , ? )";
		
		try {
			
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, ctprice);
			ps.setInt(2, ctvolume);
			ps.setString(3, "S");
			ps.setInt(4, cno);
			ps.setInt(5, mno);
			
			ps.executeUpdate();
			
			CMRemainingUpdate( ctvolume , cno );
			personal_portfolio( mno , ctvolume , ctprice , cno );
			CMPriceUpdate( cno );
			
			return true;
			
		}catch (Exception e) {
			System.out.println("매도 에러 : " + e );
		}
		return false;
	}
	
	
	// ----------------------------------------------------------------------------------------
	
	// 개인 보유 코인 전체 가져오기
	public ArrayList<sellingDto> get_personalInfo( int mNo ) {
		
		ArrayList<sellingDto> list = new ArrayList<>();
		
		String sql = "select c.cname , pn.pcsumprice , pn.pcamount , p.cmprice , ((p.cmprice - pn.pcsumprice)/pn.pcsumprice)*100"
				+ " from coinmarketp p , personal_coinlist pn , coinlist c "
				+ " where p.cno = pn.cno and c.cno = p.cno and pn.mno = 3";
	
		try {
			
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, mNo);
			
			rs = ps.executeQuery();
			
			while( rs.next() ) {
				
				sellingDto dto = new sellingDto(
					rs.getString(1), rs.getInt(2) , rs.getInt(3) , 
					rs.getInt(4) , rs.getInt(5), rs.getDouble(6)
				);
				
				list.add(dto);
			}
			return list;
			
		}catch (Exception e) {
			System.out.println("개인포트폴리오 : " + e );
		}
		
		return null;
	}
	
	
	public void copy() {
		
		String sql = "insert into coinmarketp ( ciprice , cmprice , cmremaining , cno ) values ("
				+ " (select cprice from coinlist order by cNo desc limit 1),"
				+ " (select cprice from coinlist order by cNo desc limit 1),"
				+ " (select camount from coinlist order by cNo desc limit 1),"
				+ " (select cno from coinlist order by cno desc limit 1));";
		
		try {
			ps = con.prepareStatement(sql);
			
			ps.executeUpdate();
			
		}catch (Exception e) {
			System.out.println("카피에러 : " + e);
		}
		
	}
	
	
	
}
 