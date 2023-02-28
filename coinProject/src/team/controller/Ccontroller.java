package team.controller;

import java.util.ArrayList;

import team.model.coinlist.Cdao;
import team.model.coinlist.coinlistDto;

public class Ccontroller {
	//1. 싱글톤
	private static Ccontroller ccontroller = new Ccontroller();
	private Ccontroller() {}
	public static Ccontroller getInstance() {return ccontroller;}
	
	public ArrayList<coinlistDto> print_coin() {
		return Cdao.getInstance().print_coin();
	}
	
		
}
