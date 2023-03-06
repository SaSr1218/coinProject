package team.View;

public class CoinPrint {
	
	private static CoinPrint print = new CoinPrint();
	public static CoinPrint getInstance() {return print;}
	
	private CoinPrint() {}
	
	public void index() {
		Thread thread = Coinlist.getInstance();
        Coinlist.getInstance().setStop(true);
        thread.start();
        
        Selling.getInstance().index();
	}

}
