package com.itwillbs.domain;

import java.sql.Date;

public class MemberVO {
	// VO(Value Object) => DTO의 동작과 동일하게 사용

	private String userid;
	private String userpw;
	private String username;
	private String useremail;
	private Date regdate;
	private Date updateDate;

	public MemberVO() {

	}

	public MemberVO(String userid, String userpw, String username, String useremail, Date regdate, Date updateDate) {
//		super(); // 상속관계의 부모객체 호출(부모 객체 생성)
		this.userid = userid;
		this.userpw = userpw;
		this.username = username;
		this.useremail = useremail;
		this.regdate = regdate;
		this.updateDate = updateDate;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getUserpw() {
		return userpw;
	}

	public void setUserpw(String userpw) {
		this.userpw = userpw;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUseremail() {
		return useremail;
	}

	public void setUseremail(String useremail) {
		this.useremail = useremail;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	@Override
	public String toString() {
		return "MemberVO [userid=" + userid + ", userpw=" + userpw + ", username=" + username + ", useremail="
				+ useremail + ", regdate=" + regdate + ", updateDate=" + updateDate + "]";
	}

}
