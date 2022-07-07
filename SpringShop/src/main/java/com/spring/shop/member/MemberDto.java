package com.spring.shop.member;

public class MemberDto {
	private String mi_id;
	private String mi_pw;
	private String mi_name;
	private String mi_mobile;
	private String mi_email;
	private int mi_postcode;
	private String mi_roadaddress;
	private String mi_detailaddress;
	private String mi_createdat;
	
	public MemberDto() {
		// TODO Auto-generated constructor stub
	}
	
	public MemberDto(String mi_id, String mi_pw, String mi_name, String mi_mobile, String mi_email, int mi_postcode,
			String mi_roadaddress, String mi_detailaddress, String mi_createdat) {
		super();
		this.mi_id = mi_id;
		this.mi_pw = mi_pw;
		this.mi_name = mi_name;
		this.mi_mobile = mi_mobile;
		this.mi_email = mi_email;
		this.mi_postcode = mi_postcode;
		this.mi_roadaddress = mi_roadaddress;
		this.mi_detailaddress = mi_detailaddress;
		this.mi_createdat = mi_createdat;
	}
	
	public String getMi_id() {
		return mi_id;
	}
	public void setMi_id(String mi_id) {
		this.mi_id = mi_id;
	}
	public String getMi_pw() {
		return mi_pw;
	}
	public void setMi_pw(String mi_pw) {
		this.mi_pw = mi_pw;
	}
	public String getMi_name() {
		return mi_name;
	}
	public void setMi_name(String mi_name) {
		this.mi_name = mi_name;
	}
	public String getMi_mobile() {
		return mi_mobile;
	}
	public void setMi_mobile(String mi_mobile) {
		this.mi_mobile = mi_mobile;
	}
	public String getMi_email() {
		return mi_email;
	}
	public void setMi_email(String mi_email) {
		this.mi_email = mi_email;
	}
	public int getMi_postcode() {
		return mi_postcode;
	}
	public void setMi_postcode(int mi_postcode) {
		this.mi_postcode = mi_postcode;
	}
	public String getMi_roadaddress() {
		return mi_roadaddress;
	}
	public void setMi_roadaddress(String mi_roadaddress) {
		this.mi_roadaddress = mi_roadaddress;
	}
	public String getMi_detailaddress() {
		return mi_detailaddress;
	}
	public void setMi_detailaddress(String mi_detailaddress) {
		this.mi_detailaddress = mi_detailaddress;
	}
	public String getMi_createdat() {
		return mi_createdat;
	}
	public void setMi_createdat(String mi_createdat) {
		this.mi_createdat = mi_createdat;
	}
}
