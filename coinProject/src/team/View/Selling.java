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
		selling.index();

		
	}
	
	
	
	public void index() {
		
		while( true ) {
			
			System.out.println();
			
			System.out.println("1. 매수 / 2. 매도 / 3. 손익확인(임시)");
			int cNo = scanner.nextInt();
			
			if( cNo == 1 ) { buy_coin(); }
			else if( cNo == 2 ) { sell_coin(); }
			else if( cNo == 3 ) { profit_loss_print(); }
		}
	}
	
	
	
	// 코인 매수
	public void buy_coin() {
		
		System.out.println("매수할 코인번호를 입력하세요");
		int cNo = scanner.nextInt();
		// 유효성 검사 - 존재하는 코인인지 
		String result1 = Scontroller.getInstance().coinListCheck(cNo);
		
		if( result1 != null ) {
			
			int bPrice = Scontroller.getInstance().getCoinPrice(cNo);
			System.out.println( result1 + "을 선택하셨습니다.");
			System.out.println("매수할 갯수를 입력해주세요.");
			int bAmount = scanner.nextInt();
			
			/*
			boolean result2 = Scontroller.getInstance().buy_coin( 
					Mcontroller.getInstance().getLogSession(), bPrice, bAmount , cNo );
			*/
			
			// test code test code test code test code test code test code
			boolean result2 = Scontroller.getInstance().buy_coin(1, bPrice, bAmount, cNo);
			// test code test code test code test code test code test code
			
			if( result2 ) { System.out.println("매수가 완료되었습니다. 매수금액 : "+ BLUE + bPrice +"원"+ RESET );}
			else { System.out.println("매수에 실패했습니다.");}
			
		}else {
			System.out.println(RED + "존재하지 않는 코인입니다, 다시 확인해주세요" + RESET );
		}
		
	}
	
	
	// 매도
	public void sell_coin() {
		
		own_coin_check();
		
		System.out.println("매도할 코인을 선택해주세요.");
		int bNo = scanner.nextInt();
		int cNo = Scontroller.getInstance().findcNo(bNo);
		int sPrice = Scontroller.getInstance().getCoinPrice(cNo);
		
		System.out.println("매도할 갯수를 선턱해주세요.");
		int sAmount = scanner.nextInt();
		
		
		// 1. 유효성 검사
			// 1. 구매한 코인의 갯수보다 많으면 불가능
		int count = Scontroller.getInstance().coinCheck(bNo);
		if( sAmount > count ) { System.out.println( RED + "구매수량을 초과하여 판매할 수 없습니다." + RESET );}
		
		/*
		boolean result = Scontroller.getInstance().sell_coin( 
				Mcontroller.getInstance().getLogSession() , bNo, sPrice , sAmount , cNo);
		*/
		
		boolean result = Scontroller.getInstance().sell_coin(1, bNo, sPrice, sAmount, cNo);
		
		if( result ) { System.out.println("매도가 완료되었습니다.");}
		else { System.out.println("매도실패");}
	}
	
	
	// 손익 리스트
	public void profit_loss_print() {
		
		ArrayList<sellingDto> report = Scontroller.getInstance().profit_and_loss(1);
		
		System.out.println("============== 손익 리스트 ==============");
		System.out.println();
		System.out.println("코인명\t\t수익률(%)\t\t손익액\t\t거래일자");
		for( sellingDto dto : report ) {
			System.out.println( dto.getCname()+ "\t\t" + dto.getProfit_rate() + "%\t\t" +
					dto.getP_l_amount() + "\t\t" + dto.getsDate() );
		}
	}
	
	// 회원이 보유한 코인 확인
	public void own_coin_check() {
		
		ArrayList<sellingDto> own_coinlist = Scontroller.getInstance().own_coin_check(1);
		
		System.out.println("============== 내 지갑 ==============");
		System.out.println("거래번호\t\t소지갯수\t\t구매가격\t\t상품명");
		
		for( sellingDto dto : own_coinlist ) {
			System.out.println( dto.getbNo() +"\t\t"+ dto.getbAmount() + "\t\t" 
					+ dto.getbPrice() + "\t\t" + dto.getCname() );
		}
	}
	
		
}
