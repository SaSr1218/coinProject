package team.controller;

import java.util.ArrayList;

import team.model.selling.Sdao;
import team.model.selling.sellingDto;

public class Scontroller {
	
	private static Scontroller sc = new Scontroller();
	private Scontroller() {}
	public static Scontroller getInstance() {
		return sc;
	}
	
	
	public sellingDto getCoinInfo( int cNo , int mNo) {
		return Sdao.getInstance().getCoinInfo(cNo, mNo);
	}
	
	public boolean buy_coin( int ctprice , int ctvolume , int cno , int mno ) {
		return Sdao.getInstance().buy_coin(ctprice, ctvolume, cno, mno);
	}
	
	public boolean sell_coin( int ctprice , int ctvolume , int cno , int mno ) {
		return Sdao.getInstance().sell_coin(ctprice, ctvolume, cno, mno);
	}
	
}
