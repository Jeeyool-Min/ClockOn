package com.clockOn.web.entity;

import lombok.Getter;

@Getter
public class Criteria {
    
	/* ���� ������ */
    private int pageNum;
    
    /* �� ������ �� ������ �Խù� ���� */
    private int amount;
    
    /* ��ŵ �� �Խù��� �� ( (pageNum-1) * amount )*/
    private int skip;
    
    /* �⺻ ������ -> �⺾ ���� : pageNum = 1, amount = 10 */
    public Criteria() {
        this(1,10);
        this.skip = 0;
    }
    
    /* ������ => ���ϴ� pageNum, ���ϴ� amount */
    public Criteria(int pageNum, int amount) {
        this.pageNum = pageNum;
        this.amount = amount;
        this.skip = (pageNum-1)*amount;
    }
    
    
    public void setPageNum(int pageNum) {
    	this.skip = (pageNum-1) * this.amount;
		this.pageNum = pageNum;
	}
    
    public void setAmount(int amount) {
    	this.skip = (this.pageNum-1) * amount;
		this.amount = amount;
	}
    
    public void setSkip(int skip) {
		this.skip = skip;
	}
     
    
}


