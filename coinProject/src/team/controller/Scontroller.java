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
	
	
	public boolean buy_coin( int mNo , int bPrice , int bAmount ) {
		return Sdao.getInstance().buy_coin(mNo, bPrice, bAmount);
	}
	
	
	public boolean sell_coin( int mNo , int bNo , int sPrice , int sAmount ) {
		return Sdao.getInstance().sell_coin(mNo, bNo, sPrice, sAmount);
	}
	
	public int coinCheck( int bNo ) {
		return Sdao.getInstance().coinCheck(bNo);
	}
	
	public ArrayList<sellingDto> profit_and_loss( int bNo , int mNo ){
		return Sdao.getInstance().profit_and_loss(bNo, mNo);
	}
	
}
