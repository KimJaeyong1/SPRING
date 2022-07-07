package com.spring.shop.dto;

public class BoardDto {
	private int bi_no;
	private String bi_title;
	private String bi_content;
	private String bi_writer;
	private String bi_insertdt;
	private int bi_hit;
	private int bi_status;
	
	public BoardDto() {
		// TODO Auto-generated constructor stub
	}

	public BoardDto(int bi_no, String bi_title, String bi_content, String bi_writer, String bi_insertdt, int bi_hit,
			int bi_status, String board_type, int board_id, int file_num, String file_name, String saved_file_name,
			int file_size, String upload_dt, String insert_dt) {
		super();
		this.bi_no = bi_no;
		this.bi_title = bi_title;
		this.bi_content = bi_content;
		this.bi_writer = bi_writer;
		this.bi_insertdt = bi_insertdt;
		this.bi_hit = bi_hit;
		this.bi_status = bi_status;
	}

	public int getBi_no() {
		return bi_no;
	}

	public void setBi_no(int bi_no) {
		this.bi_no = bi_no;
	}

	public String getBi_title() {
		return bi_title;
	}

	public void setBi_title(String bi_title) {
		this.bi_title = bi_title;
	}

	public String getBi_content() {
		return bi_content;
	}

	public void setBi_content(String bi_content) {
		this.bi_content = bi_content;
	}

	public String getBi_writer() {
		return bi_writer;
	}

	public void setBi_writer(String bi_writer) {
		this.bi_writer = bi_writer;
	}

	public String getBi_insertdt() {
		return bi_insertdt;
	}

	public void setBi_insertdt(String bi_insertdt) {
		this.bi_insertdt = bi_insertdt;
	}

	public int getBi_hit() {
		return bi_hit;
	}

	public void setBi_hit(int bi_hit) {
		this.bi_hit = bi_hit;
	}

	public int getBi_status() {
		return bi_status;
	}

	public void setBi_status(int bi_status) {
		this.bi_status = bi_status;
	}
}
