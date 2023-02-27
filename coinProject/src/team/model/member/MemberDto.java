package team.model.member;

public class MemberDto {

	// 필드 영역
	private int mNo;
	private String mId;
	private String mPw;
	private String mPhone;
	private String mEmail;
	
	// 생성자 영역
	public MemberDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public MemberDto(int mNo, String mId, String mPw, String mPhone, String mEmail) {
		super();
		this.mNo = mNo;
		this.mId = mId;
		this.mPw = mPw;
		this.mPhone = mPhone;
		this.mEmail = mEmail;
	}
	
	// 메소드 영역
	@Override
	public String toString() {
		return "MemberDto [mNo=" + mNo + ", mId=" + mId + ", mPw=" + mPw + ", mPhone=" + mPhone + ", mEmail=" + mEmail
				+ "]";
	}

	public int getmNo() {
		return mNo;
	}

	public void setmNo(int mNo) {
		this.mNo = mNo;
	}

	public String getmId() {
		return mId;
	}

	public void setmId(String mId) {
		this.mId = mId;
	}

	public String getmPw() {
		return mPw;
	}

	public void setmPw(String mPw) {
		this.mPw = mPw;
	}

	public String getmPhone() {
		return mPhone;
	}

	public void setmPhone(String mPhone) {
		this.mPhone = mPhone;
	}

	public String getmEmail() {
		return mEmail;
	}

	public void setmEmail(String mEmail) {
		this.mEmail = mEmail;
	}
}
