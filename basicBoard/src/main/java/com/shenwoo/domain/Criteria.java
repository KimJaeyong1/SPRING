package com.shenwoo.domain;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Criteria {

    // 현재 페이지
    private int pageNum;
    
    // 한 페이지 당 보여질 게시물 갯수
    private int amount;
    
    // 스킵 할 게시물 수 ( (pageNum - 1) * amount )
    private int skip;
    
    // 검색 키워드
    private String keyword;
    
    // 검색 타입
    private String type;
    
    // 검색 타입 배열
    private String[] typeArr;
    
    // 기본 생성자 -> 기본 세팅 : pageNum = 1, amount = 10
    public Criteria() {
        this(1,10);
    }
    
    // 생성자 => 원하는 pageNum, 원하는 amount
    public Criteria(int pageNum, int amount) {
        this.pageNum = pageNum;
        this.amount = amount;
    }

    // type변수에 데이터가 들어왔을 때 자동으로 배열 형식으로 변환하여 typeArr변수에 저장될 수 있도록 setter 매서드 직접 생성
    public void setType(String type) {
    	this.type = type;
    	this.typeArr = type.split("");
    }
    
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public void setSkip(int skip) {
		this.skip = skip;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}


	public void setTypeArr(String[] typeArr) {
		this.typeArr = typeArr;
	}
}
