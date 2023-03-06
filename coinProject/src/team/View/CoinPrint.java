package team.View;

import java.util.Scanner;

public class CoinPrint {
	
	private static CoinPrint print = new CoinPrint();
	public static CoinPrint getInstance() {return print;}
	
	private CoinPrint() {}
	
	Scanner sc = new Scanner(System.in);
	
	public void index() {
		Thread thread = Coinlist.getInstance();
        Coinlist.getInstance().setStop(true);
        thread.start();
        
        int cno = sc.nextInt();
        Selling.getInstance().index(cno);
	}

}
