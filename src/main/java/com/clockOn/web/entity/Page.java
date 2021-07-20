package com.clockOn.web.entity;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Page {
	private int page; //������������ȣ
	private int scalePerPage = 10; //�������� ������ �ڷ��� ���� (10���� ����)
	private int scalePerBlock = 5; //������ ������ �������� �ִ� ���� (5��)
	private int offset; //�ǳʶ� �ڷ��� ���� (1������ 0, 2������ 10��)
	private int lastNum; //������ ������ ��ȣ
	private double cntRows; //���� ��� �ڷ��� ����
	private int startNum; //���� �������� ���� ������ ��ȣ (1, 6, 11, 16, ...)
//	private int lastNum; //���� �������� ������ ������ ��ȣ (5, 10, 15, ...)
	
	
	//Controller���� Get��û ó�� �� ���� ���� ������ �۾�(������)
	public Page(int page, double cntRows) {
		this.page = page;
		this.offset =  0+(page-1)*scalePerPage;
		this.lastNum = (int) Math.ceil(cntRows/scalePerPage); 
		this.cntRows = cntRows;
		this.startNum = page-(page-1)%scalePerBlock; 
	}
	
}