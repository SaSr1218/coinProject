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
	DecimalFormat df = new DecimalFormat("###,###");
	
	private static Selling sell = new Selling();
	private Selling () { }
	public static Selling getInstance() { return sell; }
	
	
	
	public void index( int cNo ) {
		
		while( true ) {
			
			sellingDto dto = Scontroller.getInstance().getCoinInfo(cNo, Mcontroller.getInstance().getLogSession() );
			
			System.out.println();
			System.out.println("=== 코인 상세보기 === ");
			System.out.println("코인명 : " + dto.getCname() );
			System.out.println("현재가 : " + df.format( dto.getCmprice() ) );
			System.out.println("최근거래가 : " + df.format( dto.getRecent_trade() ) );
			System.out.println("보유단가 : " + df.format( dto.getPcsumprice() ) );
			System.out.println("보유수량 : " + df.format( dto.getPcamount() ) );
			System.out.print("손익(%) : " + dto.getRate() + "%\t\t" );
			System.out.println("손익(원) : " + df.format( dto.getProceeds() ) + "원" );
			System.out.println();
			System.out.println("1. 매수하기 / 2. 매도하기 3. 뒤로가기");
			int ch = scanner.nextInt();
			
			if( ch == 1 ) { buy_coin( cNo ); }
			else if( ch == 2 ) { sell_coin(); }
			else if ( ch == 3 ) { break; }
			
		}
		
	}
	
	
	
	// 코인 매수
	public void buy_coin( int cNo ) {
		
		System.out.print("매수할 갯수를 입력해주세요 : ");
		int ctvolume = scanner.nextInt();
		
		
		
		System.out.println("코인명, 현재단가 : ");
		System.out.println( ctvolume + "개 매수가 완료되었습니다.");
		
	}
	
	public void sell_coin() {
		
	}
	
	
		
}
