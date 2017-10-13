package com.technophillia.test.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/*
 * @author Karthik V Devaru
 * 
 * Bean Class Contains details of a member. 
 * Details can be further added based on requirements.
 * 
 */
@Entity
@Table(name="member_details")
public class MemberBean 
{

	//============START Variables =========================
	
	@Column(name="member_id")
	private String memberId;
	@Column(name="member_name")
	private String memberName;
	@Column(name="dob")
	private String memberDOB;
	@Column(name="address")
	private String memberAddress;
	@Column(name="contact_number")
	private String memberContactNumber;
	@Column(name="email")
	private String memberEmailId;

	//============ END Variables ===============================
	
	//=============== CONSTRUCTORS =============================
	public MemberBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MemberBean(String memberId, String memberName, String memberDOB, String memberAddress,
			String memberContactNumber, String memberEmailId) {
		super();
		this.memberId = memberId;
		this.memberName = memberName;
		this.memberDOB = memberDOB;
		this.memberAddress = memberAddress;
		this.memberContactNumber = memberContactNumber;
		this.memberEmailId = memberEmailId;
	}

	//===============END CONSTRUCTORS ============================
	
	//========= start Getters and Setters==========================
	
	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
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

	
	
	//========= END Getters and Setters==========================
	
	//======================= start hashcode equals and toString ===============================
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((memberAddress == null) ? 0 : memberAddress.hashCode());
		result = prime * result + ((memberContactNumber == null) ? 0 : memberContactNumber.hashCode());
		result = prime * result + ((memberDOB == null) ? 0 : memberDOB.hashCode());
		result = prime * result + ((memberEmailId == null) ? 0 : memberEmailId.hashCode());
		result = prime * result + ((memberId == null) ? 0 : memberId.hashCode());
		result = prime * result + ((memberName == null) ? 0 : memberName.hashCode());
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
		if (memberId == null) {
			if (other.memberId != null)
				return false;
		} else if (!memberId.equals(other.memberId))
			return false;
		if (memberName == null) {
			if (other.memberName != null)
				return false;
		} else if (!memberName.equals(other.memberName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "MemberBean [memberId=" + memberId + ", memberName=" + memberName + ", memberDOB=" + memberDOB
				+ ", memberAddress=" + memberAddress + ", memberContactNumber=" + memberContactNumber
				+ ", memberEmailId=" + memberEmailId + "]";
	}
	
	//======================= end hashcode equals and toString ===============================	
}
