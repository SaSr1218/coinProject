package team.model.mypage;

public class mypageDto {
	private int aNo;		// 계좌 고유번호
	private int accName;	// 계좌 멤버이름	- mNo를 통해 mNo를 fk키로 쓰고 있는 acc 정보 중 accName을 가져오려함.
	private int aAccount;	// 계좌 번호		- mNo를 통해 mNo를 fk키로 쓰고 있는 acc 정보 중 Account를 가져오려함.
	private int aBalance;	// 계좌 잔고		- mNo를 통해 mNo를 fk키로 쓰고 있는 acc 정보 중 Balance를 가져오려함.
	private int mNo;		// 회원번호(fk)	
	
	public mypageDto() { }

	public mypageDto(int aNo, int accName, int aAccount, int aBalance, int mNo) {
		super();
		this.aNo = aNo;
		this.accName = accName;
		this.aAccount = aAccount;
		this.aBalance = aBalance;
		this.mNo = mNo;
	}

	public int getaNo() {
		return aNo;
	}

	public void setaNo(int aNo) {
		this.aNo = aNo;
	}

	public int getAccName() {
		return accName;
	}

	public void setAccName(int accName) {
		this.accName = accName;
	}

	public int getaAccount() {
		return aAccount;
	}

	public void setaAccount(int aAccount) {
		this.aAccount = aAccount;
	}

	public int getaBalance() {
		return aBalance;
	}

	public void setaBalance(int aBalance) {
		this.aBalance = aBalance;
	}

	public int getmNo() {
		return mNo;
	}

	public void setmNo(int mNo) {
		this.mNo = mNo;
	}

	@Override
	public String toString() {
		return "mypageDto [aNo=" + aNo + ", accName=" + accName + ", aAccount=" + aAccount + ", aBalance=" + aBalance
				+ ", mNo=" + mNo + "]";
	}	
	
}
