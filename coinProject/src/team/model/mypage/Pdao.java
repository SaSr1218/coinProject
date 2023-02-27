package team.model.mypage;

public class Pdao {
	
	// 싱글톤
	private static Pdao pdao = new Pdao();
	public Pdao() { }
	public static Pdao getInstance() { return pdao; }
	
}
