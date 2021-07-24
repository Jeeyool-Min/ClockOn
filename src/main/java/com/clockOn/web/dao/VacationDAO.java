package com.clockOn.web.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.clockOn.web.entity.commute.WorkOff;
import com.clockOn.web.entity.vacation.Annday;
import com.clockOn.web.entity.vacation.Vacation;
import com.clockOn.web.entity.vacation.VacationInfo;

public interface VacationDAO {

	public Annday getVacInfo(String emp_id);

	public int reqVac(Vacation vacation);

	public List<Vacation> listVacReq(@Param("emp_id") String emp_id, @Param("offset") int offset, @Param("limit") int limit);

	public int cancelVacReq(String holi_rid);

	/*������*/
	public List<VacationInfo> listAllVacReq();
	
	public List<VacationInfo> listWaitReq();

	public int cntReq();
	
	public int cntwReq();
	/*���� ó�� 1-�ް����̺� ����*/
	public int confirm(String holi_rid);
	//2- work_atti ���̺� �ް� ���� ����
	public int processVac(List<WorkOff> off);
	//3- ��������
	
	public int subAnnday(Map<String, Object> map);

	public int reject(String holi_rid);
	
	public int cancel(String holi_rid);

	public int cntwoff(String emp_id);

	public List<HashMap<String, Object>> comingVac(String emp_id);

	public List<HashMap<String, String>> waitingVac(String emp_id);

	public int cntMyReq(String emp_id);
}
