package com.clockOn.web.service.vacation;

import com.clockOn.web.entity.vacation.Annday;

public interface LeaveService {
   /*���� �ѿ���, �������� ���*/
   Annday getVacinfo(String emp_id);
}