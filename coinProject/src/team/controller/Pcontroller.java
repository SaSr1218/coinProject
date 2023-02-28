package team.controller;

public class Pcontroller {

	// 싱글톤
	private static Pcontroller con = new Pcontroller();
	public Pcontroller() { }
	public static Pcontroller getInstance() { return con; }
	
	
}
