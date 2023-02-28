package team.controller;

import team.model.selling.Sdao;

public class Scontroller {
	
	private Scontroller sc = new Scontroller();
	private Scontroller() {}
	public Scontroller getInstance() {
		return sc;
	}
	
	
	public boolean buy_coin( int mNo , int bPrice , int bAmount ) {
		return Sdao.getInstance().buy_coin(mNo, bPrice, bAmount);
	}
	
	
	public boolean sell_coin( int mNo , int bNo , int sPrice , int sAmount ) {
		return Sdao.getInstance().sell_coin(mNo, bNo, sPrice, sAmount);
	}
	
}
