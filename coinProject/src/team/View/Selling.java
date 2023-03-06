package team.View;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

import team.controller.Mcontroller;
import team.controller.Scontroller;
import team.model.coinlist.Cdao;
import team.model.selling.Sdao;
import team.model.selling.sellingDto;

public class Selling implements Color {
	
	Scanner scanner = new Scanner(System.in);
	DecimalFormat df = new DecimalFormat("#,###");
	
	private static Selling sell = new Selling();
	private Selling () { }
	public static Selling getInstance() { return sell; }
	
	
	
	public void index( int cNo ) {
		
		while( true ) {
			
			sellingDto dto = Scontroller.getInstance().getCoinInfo(cNo, Mcontroller.getInstance().getLogSession() );
			
			System.out.println();
			System.out.println("=== 코인 상세보기 ===");
			System.out.println("코인명 : " + dto.getCname() );
			System.out.println("현재가 : " + df.format( dto.getCmprice() ) );
			System.out.println("최근거래가 : " + df.format( dto.getRecent_trade() ) );
			System.out.println("=================");
			System.out.println("보유단가 : " + GREEN + df.format( dto.getPcsumprice() ) + RESET + " 원" );
			System.out.println("보유수량 : " + GREEN + df.format( dto.getPcamount() ) + RESET + " 개" );
			if( dto.getRate() < 0 ) { System.out.print("손익(%) : " + BLUE + dto.getRate() + RESET + " %\t\t" ); }
			else { System.out.print("손익(%) : " + RED +dto.getRate() + RESET + "%\t\t" ); }
			if( dto.getProceeds() < 0 ) { System.out.println("손익(원) : " + BLUE + df.format( dto.getProceeds() ) + RESET + "원" ); }
			else { System.out.println("손익(원) : " + RED + df.format( dto.getProceeds() ) + RESET + " 원" ); }
			
			System.out.println();
			System.out.println("1. 매수하기 / 2. 매도하기 / 3. 뒤로가기");
			int ch = scanner.nextInt();
			
			if( ch == 1 ) { buy_coin( cNo ); }
			else if( ch == 2 ) { sell_coin( cNo ); }
			else if ( ch == 3 ) { break; }
			
		}
		
	}
	
	// 코인 매수
	public void buy_coin( int cNo ) {
		
		sellingDto dto = Scontroller.getInstance().getCoinInfo(cNo, Mcontroller.getInstance().getLogSession() );
		
		System.out.println("[" + dto.getCname() + "] / " + 
							"[가격 : " + dto.getCmprice() +
							"[ 잔여코인수량 : " + dto.getCmremaining() + "]");
		System.out.print("매수할 갯수를 입력해주세요 : ");
		int ctvolume = scanner.nextInt();
		
		boolean result = Scontroller.getInstance().buy_coin(
				dto.getCmprice() , ctvolume, cNo, Mcontroller.getInstance().getLogSession() );
		
		if( result ) { System.out.println("매수가 완료되었습니다. 매수가격 : " + df.format(dto.getCmprice() ) );}
		System.out.println(RED + "잔여 수량 이상 구매할 수 없습니다" + RESET );
		
		System.out.println( ctvolume + "개 매수가 완료되었습니다.");
		
	}
	
	public void sell_coin( int cNo ) {
		
		sellingDto dto = Scontroller.getInstance().getCoinInfo(cNo, Mcontroller.getInstance().getLogSession() );
		
		System.out.println("[" + dto.getCname() + "] / " + "[ 보유코인수량 : " + dto.getPcamount() + "]");
		System.out.print("매도할 갯수를 입력해주세요 : ");
		int ctvolume = scanner.nextInt();
		
		boolean result = Scontroller.getInstance().sell_coin(
				dto.getCmprice() , ctvolume, cNo, Mcontroller.getInstance().getLogSession());
		
		if( result ) { System.out.println("매도가 완료되었습니다. 매도가격 : " + df.format(dto.getCmprice() ) );}
		
	}
	
	
	
	
	// ------------------------------------------------------------------------------------------
	
	// 개인 손익 확인
	public void my_portfolio() {
		
		System.out.println("=== 포트폴리오 ===");
		System.out.printf("");
		
	}
	
	
		
}
