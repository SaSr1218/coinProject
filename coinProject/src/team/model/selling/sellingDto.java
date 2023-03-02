package team.model.selling;

public class sellingDto {
	
	// 1. 필드
	private float profit_rate;
	private int p_l_amount;
	private int bNo;
	private int bPrice;
	private int bAmount;
	private int cNo;
	private String cName;
	private String sDate;
	
	// 2. 생성자
	public sellingDto() {}

	public sellingDto(float profit_rate, int p_l_amount) {
		this.profit_rate = profit_rate;
		this.p_l_amount = p_l_amount;
	}
	public sellingDto(int bNo , int bPrice, int bAmount , String cName) {
		this.bNo = bNo;
		this.bPrice = bPrice;
		this.bAmount = bAmount;
		this.cName = cName; 
	}
	
	public sellingDto( int cNo , String cName ) {
		this.cNo = cNo;
		this.cName = cName;
	}
	
	public sellingDto( String cName , String sDate , float profit_rate, int p_l_amount) {
		this.cName = cName;
		this.sDate = sDate;
		this.profit_rate = profit_rate;
		this.p_l_amount = p_l_amount;
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

	public int getbNo() {
		return bNo;
	}

	public void setbNo(int bNo) {
		this.bNo = bNo;
	}

	public String getCname() {
		return cName;
	}

	public void setCname(String cName) {
		this.cName = cName;
	}

	public int getcNo() {
		return cNo;
	}

	public void setcNo(int cNo) {
		this.cNo = cNo;
	}

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	public String getsDate() {
		return sDate;
	}

	public void setsDate(String sDate) {
		this.sDate = sDate;
	}
	
	
	
	
	
	
}
