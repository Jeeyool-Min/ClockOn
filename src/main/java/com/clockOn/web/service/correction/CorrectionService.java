package com.clockOn.web.service.correction;

import java.util.List;

import com.clockOn.web.entity.correction.Correction;

public interface CorrectionService {

	//���� - ����ٱ�� ������û
	public int corrReq(List<Correction> list);
	
	//���� - ���� ����Ʈ
	public List<Correction> corrList(String emp_id);
	
	//������ - �� ���� ����� ��� ���� ����Ʈ ���(�������� ��û)
	public List<Correction> corrListAll();

}
