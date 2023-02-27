package team.model.member;

import java.sql.DriverManager;

import team.model.Dao;

public class Mdao extends Dao{

	// 싱글톤 적용
	private static Mdao mdao = new Mdao();
	private void Dao() {}
	public static Mdao getInstance() { return mdao; }
	
	// 메소드 영역
	// 1. 회원가입
	public boolean signUp( MemberDto mDto ) {
		
		String sql = "insert into member( mId, mPw, mPhone, mEmaile ) values( ?, ?, ?, ? )";
		
		try {
			ps = con.con.prepareStatement(sql);
			
			ps.setString(1, mDto.getmId());
			ps.setString(2, mDto.getmPw());
			ps.setString(3, mDto.getmPhone());
			ps.setString(4, mDto.getmEmail());
			ps.executeUpdate();
	
			return true;
		}
		catch( Exception e ) { System.out.println("예외 발생:" + e ); }

		return false;
	}
	// 2. 로그임
	public boolean login( String mid, String mpw ){
		return false;
	}
	
	// 3. 계좌 등록
	public boolean createAcc( AccountDto aDto ) {
		
		String sql = "insert into create_acc( accName, Account, Balance, mNo ) values( ?, ?, ?, ? )";
		
		try {
			ps = con.con.prepareStatement(sql);
			
			ps.setString(1, aDto.getAccName());
			ps.setString(2, aDto.getAccount());
			ps.setString(3, aDto.getBalance());
			ps.setString(4, aDto.getmNo());
			ps.executeUpdate();
	
			return true;
		}
		catch( Exception e ) { System.out.println("예외 발생:" + e ); }
		
		return false;
	}
	
	// 4. 코인 등록
	public boolean regiCoin( CoinDto cDto ) {
		
		String sql = "insert into coinlist( cName, cPrice, cAmount ) values( ?, ?, ? )";
		
		try {
			ps = con.con.prepareStatement(sql);
			
			ps.setString(1, cDto.getcName());
			ps.setString(2, cDto.getcPrice());
			ps.setString(3, cDto.getcAmount());
			ps.executeUpdate();
	
			return true;
		}
		catch( Exception e ) { System.out.println("예외 발생:" + e ); }
		
		return false;
	}
	
	// 5. 회원 탈퇴
	public boolean leave( String mid, String mpw ) {
		return false;
	}
}
