package online.technophillia.test.vo;

/*
 * @author Karthik V Devaru
 * 
 * Bean Class Contains details of a member. 
 * Details can be further added based on requirements.
 * 
 */
public class MemberBean 
{

	private String memberId;
	
	private String memberFirstName;
	
	private String memberMiddleName;
	
	private String memberLastName;
	
	private String memberDOB;
	
	private String memberAddress;
	
	private String memberContactNumber;
	
	private String memberEmailId;

	public MemberBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public MemberBean(String memberId, String memberFirstName, String memberMiddleName, String memberLastName,
			String memberDOB, String memberAddress, String memberContactNumber, String memberEmailId) {
		super();
		this.memberId = memberId;
		this.memberFirstName = memberFirstName;
		this.memberMiddleName = memberMiddleName;
		this.memberLastName = memberLastName;
		this.memberDOB = memberDOB;
		this.memberAddress = memberAddress;
		this.memberContactNumber = memberContactNumber;
		this.memberEmailId = memberEmailId;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getMemberFirstName() {
		return memberFirstName;
	}

	public void setMemberFirstName(String memberFirstName) {
		this.memberFirstName = memberFirstName;
	}

	public String getMemberMiddleName() {
		return memberMiddleName;
	}

	public void setMemberMiddleName(String memberMiddleName) {
		this.memberMiddleName = memberMiddleName;
	}

	public String getMemberLastName() {
		return memberLastName;
	}

	public void setMemberLastName(String memberLastName) {
		this.memberLastName = memberLastName;
	}

	public String getMemberDOB() {
		return memberDOB;
	}

	public void setMemberDOB(String memberDOB) {
		this.memberDOB = memberDOB;
	}

	public String getMemberAddress() {
		return memberAddress;
	}

	public void setMemberAddress(String memberAddress) {
		this.memberAddress = memberAddress;
	}

	public String getMemberContactNumber() {
		return memberContactNumber;
	}

	public void setMemberContactNumber(String memberContactNumber) {
		this.memberContactNumber = memberContactNumber;
	}

	public String getMemberEmailId() {
		return memberEmailId;
	}

	public void setMemberEmailId(String memberEmailId) {
		this.memberEmailId = memberEmailId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((memberAddress == null) ? 0 : memberAddress.hashCode());
		result = prime * result + ((memberContactNumber == null) ? 0 : memberContactNumber.hashCode());
		result = prime * result + ((memberDOB == null) ? 0 : memberDOB.hashCode());
		result = prime * result + ((memberEmailId == null) ? 0 : memberEmailId.hashCode());
		result = prime * result + ((memberFirstName == null) ? 0 : memberFirstName.hashCode());
		result = prime * result + ((memberId == null) ? 0 : memberId.hashCode());
		result = prime * result + ((memberLastName == null) ? 0 : memberLastName.hashCode());
		result = prime * result + ((memberMiddleName == null) ? 0 : memberMiddleName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MemberBean other = (MemberBean) obj;
		if (memberAddress == null) {
			if (other.memberAddress != null)
				return false;
		} else if (!memberAddress.equals(other.memberAddress))
			return false;
		if (memberContactNumber == null) {
			if (other.memberContactNumber != null)
				return false;
		} else if (!memberContactNumber.equals(other.memberContactNumber))
			return false;
		if (memberDOB == null) {
			if (other.memberDOB != null)
				return false;
		} else if (!memberDOB.equals(other.memberDOB))
			return false;
		if (memberEmailId == null) {
			if (other.memberEmailId != null)
				return false;
		} else if (!memberEmailId.equals(other.memberEmailId))
			return false;
		if (memberFirstName == null) {
			if (other.memberFirstName != null)
				return false;
		} else if (!memberFirstName.equals(other.memberFirstName))
			return false;
		if (memberId == null) {
			if (other.memberId != null)
				return false;
		} else if (!memberId.equals(other.memberId))
			return false;
		if (memberLastName == null) {
			if (other.memberLastName != null)
				return false;
		} else if (!memberLastName.equals(other.memberLastName))
			return false;
		if (memberMiddleName == null) {
			if (other.memberMiddleName != null)
				return false;
		} else if (!memberMiddleName.equals(other.memberMiddleName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "MemberDao [memberId=" + memberId + ", memberFirstName=" + memberFirstName + ", memberMiddleName="
				+ memberMiddleName + ", memberLastName=" + memberLastName + ", memberDOB=" + memberDOB
				+ ", memberAddress=" + memberAddress + ", memberContactNumber=" + memberContactNumber
				+ ", memberEmailId=" + memberEmailId + "]";
	}
	
	
		
}
