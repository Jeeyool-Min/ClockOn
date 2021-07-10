package com.clockOn.web.dao;

import java.util.List;
import java.util.Map;

import com.clockOn.web.entity.commute.Commute;

public interface CommuteDAO {
	// ��� �ο� ī��Ʈ
	public int goWorkCount();
	// ����� �ο� ī��Ʈ
	public int notWorkCount();
	// �ް� �ο� ī��Ʈ
	public int holidayCount();
	// ���� �ο� ī��Ʈ
	public int lateCount();
	// ��� ���
	public int hiSuccess(String emp_id);
	// �ڽ��� �ش� �� ��� ��� Ȯ��
	public int thisMonthWork(String emp_id);
	// �ڽ��� �ش� �� ���� ��� Ȯ��
	public int thisMonthLate(String emp_id);
	// �ڽ��� ����� ������ ��������
	public List<Commute> listRecord(Map<String, String> map);
	
}
