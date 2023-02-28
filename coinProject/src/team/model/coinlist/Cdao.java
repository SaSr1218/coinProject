package team.model.coinlist;

import java.util.ArrayList;
import team.model.Dao;

public class Cdao extends Dao{
	// 싱글톤
	private static Cdao cdao = new Cdao();
	private Cdao() {}
	public static Cdao getInstance() {return cdao;}
	
	// 코인 출력 메소드
	public ArrayList<coinlistDto> print_coin() {
		ArrayList<coinlistDto> clist = new ArrayList<>();
		String sql = "select * from coinlist;";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				int result = change_coin(rs.getInt(3));
				coinlistDto dto = new coinlistDto(rs.getInt(1), rs.getString(2), result, rs.getInt(4),rs.getInt(5));
				clist.add(dto);
			}
			return clist;
		}catch (Exception e) {System.out.println(e);}
		return null;
	} // printcoin e
	
	// 코인 가격변동 메소드
	public int change_coin(int cprice) {
		int updown = (int)(Math.random()*2);
		int percent = (int)((Math.random()*3)+1);
		if(updown==1) {
			cprice = (cprice - (int)(cprice*(percent*0.01)));
		}else if(updown==0){
			cprice = (cprice + (int)(cprice*(percent*0.01)));
		}
		
		String sql = "update coinlist set cPrice = ? where cNo = ?;";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, cprice);
			ps.setInt(2, rs.getInt(1));
			ps.executeUpdate();	
		}catch (Exception e) {System.out.println(e);}
		
		return cprice;
	} // change_coin e
	

}
