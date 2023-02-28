package team.View;

import java.util.ArrayList;
import java.util.Scanner;

import team.controller.Mcontroller;
import team.controller.Scontroller;
import team.model.selling.Sdao;
import team.model.selling.sellingDto;

public class Selling implements Color {
	
	Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {

		Selling selling = new Selling();
		selling.temp();

		
	}
	
	
	
	public void temp() {
		
		while( true ) {
			System.out.println("코인목록");
			System.out.println();
			
			System.out.println("1. 매수 / 2. 매도 / 3. 손익확인(임시)");
			int ch = scanner.nextInt();
			
			if( ch == 1 ) { buy_coin(); }
			else if( ch == 2 ) { sell_coin(); }
			else if( ch == 3 ) { profit_loss_print( 4 , 1); }
		}
	}
	
	
	
	
	public void buy_coin() {
		System.out.println("매수할 코인을 선택해주세요.");
		int cNo = scanner.nextInt();
		
		int bPrice = Scontroller.getInstance().getCoinPrice(cNo);
		
		boolean result1 = Scontroller.getInstance().coinListCheck(cNo);
		
		if( result1 ) {
			System.out.println("매수할 갯수를 선택해주세요.");
			int bAmount = scanner.nextInt();
			
			
			
			boolean result2 = Scontroller.getInstance().buy_coin( 
					Mcontroller.getInstance().getLogSession(), bPrice, bAmount , cNo );
			
			if( result2 ) { System.out.println("매수가 완료되었습니다. 매수금액 : "+ BLUE + bPrice +"원"+ RESET );}
			else { System.out.println("매수에 실패했습니다.");}
		}else {
			System.out.println(RED + "존재하지 않는 코인입니다, 다시 확인해주세요" + RESET );
		}
		
	}
	
	
	
	public void sell_coin() {
		
		
		
		System.out.println("매도할 코인을 선택해주세요.");
		int bNo = scanner.nextInt();
		
		int sPrice = Scontroller.getInstance().getCoinPrice(bNo);
		
		System.out.println("매도할 갯수를 선턱해주세요.");
		int sAmount = scanner.nextInt();
		
		
		// 1. 유효성 검사
			// 1. 구매한 코인의 갯수보다 많으면 불가능
		int count = Scontroller.getInstance().coinCheck(bNo);
		if( sAmount > count ) { System.out.println( RED + "구매수량을 초과하여 판매할 수 없습니다." + RESET );}
		
		
		boolean result = Scontroller.getInstance().sell_coin( 
				Mcontroller.getInstance().getLogSession() , bNo, sPrice , sAmount);
	}
	
	
	public void profit_loss_print( int bNo , int mNo ) {
		
		ArrayList<sellingDto> report = Scontroller.getInstance().profit_and_loss(bNo, mNo);
		
		System.out.println("============== 손익 리스트 ==============");
		System.out.println();
		System.out.println("수익률(%)\t\t손익액");
		for( sellingDto dto : report ) {
			System.out.println( dto.getProfit_rate()+ "%\t\t" + dto.getP_l_amount() );
		}
		
		
	}
	
		
}
