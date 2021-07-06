package com.clockOn.web.service.vacation;

import java.util.List;

import com.clockOn.web.entity.vacation.Annday;
import com.clockOn.web.entity.vacation.Vacation;
import com.clockOn.web.entity.vacation.VacationInfo;

public interface LeaveService {
	/*���� �ѿ���, �������� ���*/
	Annday getVacinfo(String emp_id);

	int reqVac(Vacation vacation);

	List<Vacation> listVacReq(String emp_id);

	List<VacationInfo> listAllVacReq();

	int cancelVacReq(String id);

	List<VacationInfo> listWaitReq();

	int cntReq();
	
	int cntwReq();

	int reject(String holi_rid);

	int cancel(String holi_rid);

	int confirm(String holi_rid, String emp_id, String holi_code, String[] offs, String holi_period);
		
}
