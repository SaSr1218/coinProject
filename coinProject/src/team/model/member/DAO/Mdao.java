package team.model.member.DAO;

import java.sql.DriverManager;

import team.controller.Mcontroller;
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
	
	// 3-1. 아이디 찾기(핸드폰) (오버로딩)
	public String searchID( String mPhone ) {
		
		String sql = "select * from member where mPhone =?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, mPhone);
			rs = ps.executeQuery();
			if( rs.next()) { return rs.getString(2); }
		}catch (Exception e) {System.out.println(e);}
		return null;
	}
	
	// 3-2. 아이디 찾기(이름, 이메일)
	public String searchID( String mName, String mEmail ) {

		String sql = "select * from member where mName = ? and mEmail =?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, mName);
			ps.setString(2, mEmail);
			rs = ps.executeQuery();
			if( rs.next()) { return rs.getString(2); }
		}catch (Exception e) {System.out.println(e);}
		return null;
	}
	
	// 4. 비밀번호 찾기
	public String searchPW( String mId, String mPhone ) {
		String sql = "select * from member where mId = ? and mPhone =?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, mId);
			ps.setString(2, mPhone);
			rs = ps.executeQuery();
			if( rs.next()) { return rs.getString(3); }
		}catch (Exception e) {System.out.println(e);}
		return null;
	}
	
	// 5. 계좌 생성
	public boolean createAcc( AccountDto aDto ) {
		
		String sql = "insert into create_acc( accName, accountNo, accBalance, mNo ) values( ?, ?, ?, ? )";
		
		try {
			ps = con.prepareStatement(sql);
			
			ps.setString(1, aDto.getAccName());
			ps.setString(2, aDto.getAccountNo());
			ps.setInt(3, aDto.getAccBalance());
			ps.setInt(4, aDto.getmNo());
			ps.executeUpdate();
	
			return true;
		}
		catch( Exception e ) { System.out.println("예외 발생:" + e ); }
		
		return false;
	}
	
	// 6-1. 코인 등록 권한 확인
	public boolean adminCoin( int mNo ) {
		String sql = "select * from member where mNo = ?";
		
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, mNo);
			rs = ps.executeQuery();
			if( rs.next() ) { 
				if(rs.getString(2).equals("admin")) { return true; }
			}
			else { return false; }
		} catch(Exception e) { System.out.println("예외발생: " + e);}
		return false;
	}

	// 6-2. 코인 중복 체크
	public int coinCheck( String cName ) {
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
	
	// 6-3. 코인 등록 처리
	public int regiCoin( CoinDto cDto ) {
		
		String sql = "insert into coinlist( cName, cPrice, cAmount, cFirstprice ) values( ?, ?, ?, ? )";
		
		try {
			ps = con.prepareStatement(sql);
			
			ps.setString(1, cDto.getcName());
			ps.setInt(2, cDto.getcPrice());
			ps.setInt(3, cDto.getcAmount());
			ps.setInt(4, cDto.getcFirstprice());
			ps.executeUpdate();
	
			return 1;
		} catch( Exception e ) { System.out.println("예외 발생:" + e ); }
		
		return 2;
	}

	
	// 7. 회원 탈퇴
	public boolean leave( int mNo, String mPw ) {
		
		String sql = "select * from member where mNo = ?";
		
		try {
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, mNo);
			rs = ps.executeQuery();
			if( rs.next() ) {
				if(rs.getString(3).equals(mPw)) {
					String dsql = "delete from member where mNo = ? and mPw = ?";
					ps = con.prepareStatement(dsql);
					
					ps.setInt(1, mNo);
					ps.setString(2, mPw);
					ps.executeUpdate();
					return true;
				}
			}	
		} catch( Exception e ) { System.out.println("예외 발생:" + e ); }
		return false;
	}
}
