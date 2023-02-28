package team.model.member.DTO;

public class CoinDto {
	
	// 필드 영역
	private int cNo;
	private String cName;
	private int cAmount;
	private int cPrice;
	private int cFirstprice;
	
	// 생성자 영역
	public CoinDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CoinDto(int cNo, String cName, int cPrice, int cAmount, int cFirstprice) {
		super();
		this.cNo = cNo;
		this.cName = cName;
		this.cAmount = cAmount;
		this.cPrice = cPrice;
		this.cFirstprice = cFirstprice;
	}
	
	// 메소드 영역
	@Override
	public String toString() {
		return "CoinDto [cNo=" + cNo + ", cName=" + cName + ", cPrice=" + cPrice + ", cAmount=" + cAmount
				+ ", cFirstprice=" + cFirstprice + "]";
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
	public int getcFirstprice() {
		return cFirstprice;
	}
	public void setcFirstprice(int cFirstprice) {
		this.cFirstprice = cFirstprice;
	}

	
}
