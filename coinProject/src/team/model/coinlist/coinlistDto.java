package team.model.coinlist;

public class coinlistDto {

	private int cNo;
	private String cName;
	private int cPrice;
	private int cAmount;
	
	public coinlistDto(int cNo, String cName, int cPrice, int cAmount) {
		super();
		this.cNo = cNo;
		this.cName = cName;
		this.cPrice = cPrice;
		this.cAmount = cAmount;
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

	public int getcPrice() {
		return cPrice;
	}

	public void setcPrice(int cPrice) {
		this.cPrice = cPrice;
	}

	public int getcAmount() {
		return cAmount;
	}

	public void setcAmount(int cAmount) {
		this.cAmount = cAmount;
	}
	
	
	
	
	
	
	
}
