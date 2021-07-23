package com.clockOn.web.entity.commute;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Commute {
	private String work_rid;
	private String work_day;
	private String work_in;
	private String work_out;
	private String work_late;
	private String holi_code;
	private String work_comm;
	private String emp_id;
	
	
	public Commute(String work_rid, String work_day, String work_in, String work_out, String work_late, String holi_code,
			String work_comm) {
		this.work_rid = work_rid;
		this.work_day = work_day;
		this.work_in = work_in;
		this.work_out = work_out;
		this.work_late = work_late;
		this.holi_code = holi_code;
		this.work_comm = work_comm;
	}
	
	public Commute(String work_rid, String work_day, String work_in, String work_out, String work_late, String holi_code,
				String work_comm, String emp_id) {
		this.work_rid = work_rid;
		this.work_day = work_day;
		this.work_in = work_in;
		this.work_out = work_out;
		this.work_late = work_late;
		this.holi_code = holi_code;
		this.work_comm = work_comm;
		this.emp_id = emp_id;
	}
}

/*
 * Commute Ŭ������ ����ϴ� ���
 * 1. ��� ���� �� : Insert
 * x ��� ���� �� : Update --> work_rid, emp_id
 * 2. ��������� ����� ������ �ҷ��� �� 
 * 3. ������ : ������ ������ ����Ʈ�� �ҷ��� �� (Ķ������, �����) 
 * */