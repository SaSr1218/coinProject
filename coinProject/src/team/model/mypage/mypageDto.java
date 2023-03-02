package team.model.mypage;

public class mypageDto {
	private int aNo;		// 계좌 고유번호
	private String aName;	// 계좌 멤버이름	- mNo를 통해 mNo를 fk키로 쓰고 있는 acc 정보 중 mName을 가져오려함.
	private String aAcount;	// 계좌 번호		- mNo를 통해 mNo를 fk키로 쓰고 있는 acc 정보 중 accountNo를 가져오려함.
	private int aBalance;	// 계좌 잔고		- mNo를 통해 mNo를 fk키로 쓰고 있는 acc 정보 중 accBalance를 가져오려함.
	private int aAmount;	// 코인 잔여개수	- cNo를 통해 cNo를 fk키로 쓰고 있는 buy , sell에서 bAmount - sAmoun 값을 가져오려함.
	private int mNo;		// 회원번호(fk)	
	private int cNo;		// 코인번호(fk)	
	
	public mypageDto(String aName, String aAcount, int aBalance, int aAmoun ) { }

	public int getaNo() {
		return aNo;
	}

	public void setaNo(int aNo) {
		this.aNo = aNo;
	}

	public String getaName() {
		return aName;
	}

	public void setaName(String aName) {
		this.aName = aName;
	}

	public String getaAcount() {
		return aAcount;
	}

	public void setaAcount(String aAcount) {
		this.aAcount = aAcount;
	}

	public int getaBalance() {
		return aBalance;
	}

	public void setaBalance(int aBalance) {
		this.aBalance = aBalance;
	}

	public int getaAmount() {
		return aAmount;
	}

	public void setaAmount(int aAmount) {
		this.aAmount = aAmount;
	}

	public int getmNo() {
		return mNo;
	}

	public void setmNo(int mNo) {
		this.mNo = mNo;
	}

	public int getcNo() {
		return cNo;
	}

	public void setcNo(int cNo) {
		this.cNo = cNo;
	}

	@Override
	public String toString() {
		return "mypageDto [aNo=" + aNo + ", aName=" + aName + ", aAcount=" + aAcount + ", aBalance=" + aBalance
				+ ", aAmount=" + aAmount + ", mNo=" + mNo + ", cNo=" + cNo + "]";
	}

	
	
	
}
