package team.model.selling;

public class sellingDto {
	
	// 1. 필드
	private float profit_rate;
	private int p_l_amount;
	private int bPrice;
	private int bAmount;
	
	
	// 2. 생성자
	public sellingDto() {}

	public sellingDto(float profit_rate, int p_l_amount) {
		this.profit_rate = profit_rate;
		this.p_l_amount = p_l_amount;
	}
	public sellingDto(int bPrice, int bAmount) {
		this.bPrice = bPrice;
		this.bAmount = bAmount;
	}
	
	
	
	// 3. 메소드
	public float getProfit_rate() {
		return profit_rate;
	}

	public void setProfit_rate(float profit_rate) {
		this.profit_rate = profit_rate;
	}

	public int getP_l_amount() {
		return p_l_amount;
	}

	public void setP_l_amount(int p_l_amount) {
		this.p_l_amount = p_l_amount;
	}

	public int getbPrice() {
		return bPrice;
	}

	public void setbPrice(int bPrice) {
		this.bPrice = bPrice;
	}

	public int getbAmount() {
		return bAmount;
	}

	public void setbAmount(int bAmount) {
		this.bAmount = bAmount;
	}
	
	
	
	
}
