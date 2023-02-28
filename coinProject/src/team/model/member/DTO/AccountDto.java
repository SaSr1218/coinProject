package team.model.member.DTO;

public class AccountDto {
	
	// 필드 영역
	private int accNo;
	private String accName;
	private String Account;
	private int balance;
	private int mNo;
	
	// 생성자 영역
	public AccountDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public AccountDto(int accNo, String accName, String account, int balance, int mNo) {
		super();
		this.accNo = accNo;
		this.accName = accName;
		Account = account;
		this.balance = balance;
		this.mNo = mNo;
	}
	
	// 메소드 영역
	@Override
	public String toString() {
		return "AccountDto [accNo=" + accNo + ", accName=" + accName + ", Account=" + Account + ", balance=" + balance
				+ ", mNo=" + mNo + "]";
	}

	public int getAccNo() {
		return accNo;
	}

	public void setAccNo(int accNo) {
		this.accNo = accNo;
	}

	public String getAccName() {
		return accName;
	}

	public void setAccName(String accName) {
		this.accName = accName;
	}

	public String getAccount() {
		return Account;
	}

	public void setAccount(String account) {
		Account = account;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public int getmNo() {
		return mNo;
	}

	public void setmNo(int mNo) {
		this.mNo = mNo;
	}
}
