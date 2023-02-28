package team.model.mypage;

public class Pdao {
	
	// 싱글톤
	private static Pdao pdao = new Pdao();
	public Pdao() { }
	public static Pdao getInstance() { return pdao; }
	
	// 1. 로그인 성공 후 메뉴에서 계좌누를시 [ 반환 : 로그인 성공한 회원번호의 account 반환 ] 
	public boolean checkAccount ( int aBalance , int aAmout ) {
		
	String sql = "select * from member m , coinlist c , account a where a.aNo = m.mNo and a.aNo = c.cNo;";
	
			return true;
	}

	
	
}
	