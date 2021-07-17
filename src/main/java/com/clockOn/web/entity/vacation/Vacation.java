package com.clockOn.web.entity.vacation;

import java.sql.Date;

public class Vacation {
	private String holi_rid;
	private Date holi_start;
	private Date holi_end;
	private String holi_res;
	private String holi_state;	//int? ����:0 ����:1 ����:2
	private String holi_code;	//�ް� ����
	private String holi_evi;
	private String emp_id;
	
	/*�ް���û ���� insert*/
	public Vacation(Date holi_start, Date holi_end, String holi_res, String holi_code, String holi_evi, String emp_id) {
		this.holi_start = holi_start;
		this.holi_end = holi_end;
		this.holi_res = holi_res;
		this.holi_code = holi_code;
		this.holi_evi = holi_evi;
		this.emp_id = emp_id;
	}
}
