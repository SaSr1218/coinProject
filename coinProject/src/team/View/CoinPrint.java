package team.View;

import java.util.Scanner;

public class CoinPrint {
   
   private static CoinPrint print = new CoinPrint();
   public static CoinPrint getInstance() {return print;}
   
   private CoinPrint() {}
   
   Scanner sc = new Scanner(System.in);
   
   public void index(){
	   Coinlist.getInstance().setStop(true);
	   int cno = sc.nextInt();
	   if(cno==0) {
		   Coinlist.getInstance().setStop(false);
		   return;
	   }else {
		   Coinlist.getInstance().setStop(false);
		   Selling.getInstance().index(cno);
	   }
   }

}