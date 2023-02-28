package team.model.member.DAO;

import java.sql.DriverManager;

import team.model.Dao;
import team.model.member.DTO.AccountDto;
import team.model.member.DTO.CoinDto;
import team.model.member.DTO.MemberDto;

public class Mdao extends Dao{

	// 싱글톤 적용
	private static Mdao mdao = new Mdao();
	private Mdao() {}
	public static Mdao getInstance() { return mdao; }
	
	// 메소드 영역
	// 1-1. 회원가입 (아이디 중복 체크)
	public int idCheck( String mId ) {
		String sql = "select * from member where mId = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, mId);
			rs = ps.executeQuery();
			if( rs.next() ) { return 2; }
			else { return 1; }
		} catch(Exception e) { System.out.println("예외발생: " + e);}
		return 3;
	}
	
	// 1-2. 회원가입 처리
	public int signUp( MemberDto mDto ) {
		
		String sql = "insert into member( mId, mPw, mName, mPhone, mEmail ) values( ?,?,?,?, ? )";
		
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, mDto.getmId());
			ps.setString(2, mDto.getmPw());
			ps.setString(3, mDto.getmName());
			ps.setString(4, mDto.getmPhone());
			ps.setString(5, mDto.getmEmail());
			ps.executeUpdate();
			return 1;
		}catch( Exception e ) { System.out.println("예외 발생:" + e ); }
		return 3;
	}
	
	// 2. 로그임
	public int login( String mId, String mPw ){
		
		String sql = "select * from member where mId = ? and mPw = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, mId);
			ps.setString(2, mPw);
			rs = ps.executeQuery();
			if( rs.next() ) { return rs.getInt(1); }
			else { return 0; }
		} catch (Exception e) {System.out.println(e);}
		return 0;
	}
	
	// 3. 계좌 등록
	public boolean createAcc( AccountDto aDto ) {
		
		String sql = "insert into create_acc( accName, Account, Balance, mNo ) values( ?, ?, ?, ? )";
		
		try {
			ps = con.prepareStatement(sql);
			
			ps.setString(1, aDto.getAccName());
			ps.setString(2, aDto.getAccount());
			ps.setInt(3, aDto.getBalance());
			ps.setInt(4, aDto.getmNo());
			ps.executeUpdate();
	
			return true;
		}
		catch( Exception e ) { System.out.println("예외 발생:" + e ); }
		
		return false;
	}
	
	// 4-1. 코인 이름 중복 체크
	public int coincheck( String cName ) {
		String sql = "select * from coinlist where cName = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, cName);
			rs = ps.executeQuery();
			if( rs.next() ) { return 2; }
			else { return 1; }
		} catch(Exception e) { System.out.println("예외발생: " + e);}
		return 3;
	}
	
	
	// 4. 코인 등록
	public boolean regiCoin( CoinDto cDto ) {
		
		String sql = "insert into coinlist( cName, cPrice, cAmount, cFirstprice ) values( ?, ?, ?, ? )";
		
		try {
			ps = con.prepareStatement(sql);
			
			ps.setString(1, cDto.getcName());
			ps.setInt(2, cDto.getcPrice());
			ps.setInt(3, cDto.getcAmount());
			ps.setInt(4, cDto.getcFirstprice());
			ps.executeUpdate();
	
			return true;
		}
		catch( Exception e ) { System.out.println("예외 발생:" + e ); }
		
		return false;
	}
	
	// 5. 회원 탈퇴
	public boolean leave( String mpw ) {
		return false;
	}
}
