package team.model.mypage;

public class mypageDto {
	private int aNo;			// 계좌 고유번호
	private String mName;		// 계좌 멤버이름	- mNo를 통해 mNo를 fk키로 쓰고 있는 acc 정보 중 mName을 가져오려함.
	private String accountNo;	// 계좌 번호		- mNo를 통해 mNo를 fk키로 쓰고 있는 acc 정보 중 accountNo를 가져오려함.
	private int aBalance;		// 계좌 잔고		- mNo를 통해 mNo를 fk키로 쓰고 있는 acc 정보 중 accBalance를 가져오려함.
	private String accName;		// 계좌 은행
	private int mNo;			// 회원번호(fk)	
	private int cNo;			// 코인번호(fk)	
	
	public mypageDto() {}

	public mypageDto(int aNo, String mName, String accountNo, int aBalance, String accName, int mNo, int cNo) {
		super();
		this.aNo = aNo;
		this.mName = mName;
		this.accountNo = accountNo;
		this.aBalance = aBalance;
		this.accName = accName;
		this.mNo = mNo;
		this.cNo = cNo;
	}

	public mypageDto(String mName, String accName , String accountNo, int aBalance ) {
		super();
		this.mName = mName;
		this.accountNo = accountNo;
		this.aBalance = aBalance;
		this.accName = accName;
	}

	public int getaNo() {
		return aNo;
	}

	public void setaNo(int aNo) {
		this.aNo = aNo;
	}

	public String getmName() {
		return mName;
	}

	public void setmName(String mName) {
		this.mName = mName;
	}

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public int getaBalance() {
		return aBalance;
	}

	public void setaBalance(int aBalance) {
		this.aBalance = aBalance;
	}

	public String getAccName() {
		return accName;
	}

	public void setAccName(String accName) {
		this.accName = accName;
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
		return "mypageDto [aNo=" + aNo + ", mName=" + mName + ", accountNo=" + accountNo + ", aBalance=" + aBalance
				+ ", accName=" + accName + ", mNo=" + mNo + ", cNo=" + cNo + "]";
	}

	
	

	
}