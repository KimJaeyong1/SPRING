package com.spring.shop.dto;

public class GalleryDto {
	private int gi_no;
	private String gi_title;
	private String gi_content;
	private String gi_writer;
	private String gi_insertdt;
	
	public GalleryDto() {
		// TODO Auto-generated constructor stub
	}

	public GalleryDto(int gi_no, String gi_title, String gi_content, String gi_writer, String gi_insertdt) {
		super();
		this.gi_no = gi_no;
		this.gi_title = gi_title;
		this.gi_content = gi_content;
		this.gi_writer = gi_writer;
		this.gi_insertdt = gi_insertdt;
	}

	public int getGi_no() {
		return gi_no;
	}

	public void setGi_no(int gi_no) {
		this.gi_no = gi_no;
	}

	public String getGi_title() {
		return gi_title;
	}

	public void setGi_title(String gi_title) {
		this.gi_title = gi_title;
	}

	public String getGi_content() {
		return gi_content;
	}

	public void setGi_content(String gi_content) {
		this.gi_content = gi_content;
	}

	public String getGi_writer() {
		return gi_writer;
	}

	public void setGi_writer(String gi_writer) {
		this.gi_writer = gi_writer;
	}

	public String getGi_insertdt() {
		return gi_insertdt;
	}

	public void setGi_insertdt(String gi_insertdt) {
		this.gi_insertdt = gi_insertdt;
	}
}
