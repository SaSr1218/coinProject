package team.model.mypage;

public class MypageDto {
	// 1. 필드
	private int aNo;		// 계좌고유번호 
	private int aBalance; 	// 로그인한 회원의 잔고
	private int aAmount;	// 잔여갯수
	private int mNo;		// 로그인한 회원번호
	private int cNo;		// 로그인한 회원의 코인번호
	
	// 2. 생성자
	public MypageDto () { }
	
	public MypageDto(int aNo, int aBalance, int aAmount, int mNo, int cNo) {
		super();
		this.aNo = aNo;
		this.aBalance = aBalance;
		this.aAmount = aAmount;
		this.mNo = mNo;
		this.cNo = cNo;
	}

	// 3. 메소드
	
	@Override
	public String toString() {
		return "MypageDto [aNo=" + aNo + ", aBalance=" + aBalance + ", aAmount=" + aAmount + ", mNo=" + mNo + ", cNo="
				+ cNo + "]";
	}

	public int getaNo() {
		return aNo;
	}

	public void setaNo(int aNo) {
		this.aNo = aNo;
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

	
	
}
