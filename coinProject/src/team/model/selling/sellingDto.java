package team.model.selling;

public class sellingDto {
	
	private int profit_rate;
	private int p_l_amount;
	
	public sellingDto() {}

	public sellingDto(int profit_rate, int p_l_amount) {
		this.profit_rate = profit_rate;
		this.p_l_amount = p_l_amount;
	}

	public int getProfit_rate() {
		return profit_rate;
	}

	public void setProfit_rate(int profit_rate) {
		this.profit_rate = profit_rate;
	}

	public int getP_l_amount() {
		return p_l_amount;
	}

	public void setP_l_amount(int p_l_amount) {
		this.p_l_amount = p_l_amount;
	}
	
	
}
