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
	
	
	public boolean coinListCheck( int cNo ) {
		return Sdao.getInstance().coinListCheck(cNo);
	}
	
	public int getCoinPrice( int cNo ) {
		return Sdao.getInstance().getCoinPrice(cNo);
	}
	
	public boolean buy_coin( int mNo , int bPrice , int bAmount , int cNo ) {
		return Sdao.getInstance().buy_coin(mNo, bPrice, bAmount, cNo);
	}
	
	
	public boolean sell_coin( int mNo , int bNo , int sPrice , int sAmount) {
		return Sdao.getInstance().sell_coin(mNo, bNo, sPrice, sAmount );
	}
	
	public int coinCheck( int bNo ) {
		return Sdao.getInstance().coinCheck(bNo);
	}
	
	public ArrayList<sellingDto> profit_and_loss( int bNo , int mNo ){
		return Sdao.getInstance().profit_and_loss(bNo, mNo);
	}
	
	public ArrayList<sellingDto> own_coin_check( int bNo , int mNo ){
		return Sdao.getInstance().own_coin_check(bNo, mNo);
	}
	
	
	
}
