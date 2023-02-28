package team.View;

import java.util.ArrayList;
import java.util.Scanner;

import team.controller.Mcontroller;
import team.controller.Scontroller;
import team.model.selling.Sdao;
import team.model.selling.sellingDto;

public class Selling {
	
	Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		
		Selling selling = new Selling();
		selling.profit_loss_print(4, 1);
		
		
	}
	
	
	
	public void temp() {
		
		while( true ) {
			System.out.println("코인목록");
			System.out.println();
			
			System.out.println("1. 매수 / 2. 매도");
			int ch = scanner.nextInt();
			
			if( ch == 1 ) { buy_coin(); }
			else if( ch == 2 ) { sell_coin(); }
		}
	}
	
	
	
	public void buy_coin() {
		System.out.println("매수할 코인을 선택해주세요.");
		int ch = scanner.nextInt();
		
		System.out.println("매수할 갯수를 선택해주세요.");
		int bAmount = scanner.nextInt();
		
		//boolean result = Scontroller.getInstance().buy_coin( Mcontroller.getInstance().getLoginSession(), bprice, bAmount );
	}
	
	public void sell_coin() {
		
		System.out.println("매도할 코인을 선택해주세요.");
		int bno = scanner.nextInt();
		
		System.out.println("매도할 갯수를 선턱해주세요.");
		int sAmount = scanner.nextInt();
		// 1. 유효성 검사
			// 1. 구매한 코인의 갯수보다 많으면 불가능
		int count = Scontroller.getInstance().coinCheck(bno);
		if( sAmount > count ) { System.out.println("구매수량을 초과하여 판매할 수 없습니다.");}
		
		
		//boolean result = Scontroller.getInstance().sell_coin(Mcontroller.getInstance().getLoginSession(), bno, sprice , sAmount);
	}
	
	
	public void profit_loss_print( int bNo , int mNo ) {
		
		ArrayList<sellingDto> report = Scontroller.getInstance().profit_and_loss(bNo, mNo);
		
		System.out.println("==============손익 리스트==============");
		System.out.println();
		System.out.println("수익률(%)\t\t손익액");
		for( sellingDto dto : report ) {
			System.out.println( dto.getProfit_rate()+ "%\t\t" + dto.getP_l_amount() );
		}
		
		
	}
	
	
}
