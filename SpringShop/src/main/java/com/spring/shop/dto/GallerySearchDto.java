package com.spring.shop.dto;

public class GallerySearchDto {
	private String searchType;
	private String keyword;
	private int curPage;
	private int pagePerCnt;
	private int totalCnt;
	private float limit;
	private float offset;
	
	public GallerySearchDto() {
		// TODO Auto-generated constructor stub
	}
	
	public GallerySearchDto(String searchType, String keyword, int curPage, int pagePerCnt, int totalCnt, float limit,
			float offset) {
		super();
		this.searchType = searchType;
		this.keyword = keyword;
		this.curPage = curPage;
		this.pagePerCnt = pagePerCnt;
		this.totalCnt = totalCnt;
		this.limit = limit;
		this.offset = offset;
	}

	public String getSearchType() {
		return searchType;
	}

	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public int getCurPage() {
		return curPage;
	}

	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}

	public int getPagePerCnt() {
		return pagePerCnt;
	}

	public void setPagePerCnt(int pagePerCnt) {
		this.pagePerCnt = pagePerCnt;
	}

	public int getTotalCnt() {
		return totalCnt;
	}

	public void setTotalCnt(int totalCnt) {
		this.totalCnt = totalCnt;
	}

	public float getLimit() {
		return limit;
	}

	public void setLimit(float limit) {
		this.limit = limit;
	}

	public float getOffset() {
		return offset;
	}

	public void setOffset(float offset) {
		this.offset = offset;
	}
}
