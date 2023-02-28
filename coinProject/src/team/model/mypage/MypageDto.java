package team.model.mypage;

public class MypageDto {
	// 1. 필드
	private int accNo;		// 계좌 고유번호
	private int Account;	// 코인 잔여개수
	private int Balance;	// 잔고금액
	private int mNo;		// 멤버 고유번호
	private int cNo;		// 코인 고유번호
	
	// 2. 생성자
	public MypageDto() { }

	public MypageDto(int mNo, int cNo, int accNo, int account, int balance) {
		this.mNo = mNo;
		this.cNo = cNo;
		this.accNo = accNo;
		this.Account = account;
		this.Balance = balance;
	}
	
	// 3. 메소드
	
	@Override
	public String toString() {
		return "MypageDto [mNo=" + mNo + ", cNo=" + cNo + ", accNo=" + accNo + ", Account=" + Account + ", Balance="
				+ Balance + "]";
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

	public int getAccNo() {
		return accNo;
	}

	public void setAccNo(int accNo) {
		this.accNo = accNo;
	}

	public int getAccount() {
		return Account;
	}

	public void setAccount(int account) {
		this.Account = account;
	}

	public int getBalance() {
		return Balance;
	}

	public void setBalance(int balance) {
		this.Balance = balance;
	}
	
	
	
}
