package com.clockOn.web.dao;

import java.util.List;

import com.clockOn.web.entity.correction.Correction;

public interface CorrectionDAO {

	//���� - ����ٱ�� ������û
	public int corrReq(List<Correction> list);

	public List<Correction> corrList(String emp_id);

}
