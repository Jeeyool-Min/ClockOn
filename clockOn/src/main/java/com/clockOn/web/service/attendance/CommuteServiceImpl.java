package com.clockOn.web.service.attendance;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clockOn.web.dao.CommuteDAO;
import com.clockOn.web.dao.MemberDAO;
import com.clockOn.web.entity.Page;
import com.clockOn.web.entity.commute.Commute;
import com.clockOn.web.entity.commute.CommuteDetail;

@Service
public class CommuteServiceImpl implements CommuteService {

	@Autowired
	private CommuteDAO commuteDAO;

	@Autowired
	private MemberDAO memberDAO;

	@Override
	public String work_day(String emp_id) {
		return commuteDAO.work_day(emp_id);
	}

	@Override
	public int hiSuccess(String emp_id) {

		return commuteDAO.hiSuccess(emp_id);
	}

	@Override
	public List<Commute> listRecord(Map<String, String> map) {
		return commuteDAO.listRecord(map);
	}

	@Override
	public List<CommuteDetail> allByList(List<Map<String, String>> mapList, Page page) {
		return commuteDAO.allByList(mapList, page);
	}

	@Override
	public List<CommuteDetail> myList(Map<String, String> map) {
		return commuteDAO.myList(map);
	}

	@Override
	public int byeSuccess(String emp_id) {
		return commuteDAO.byeSuccess(emp_id);
	}
	
	@Override
	public int cntRows(List<Map<String, String>> mapList) {
		return commuteDAO.cntRows(mapList);
	}

	/* ������ */

	@Override
	public int goWorkCount() {
		return commuteDAO.goWorkCount();
	}

	@Override
	public int notWorkCount() {
		return commuteDAO.notWorkCount();
	}

	@Override
	public int holidayCount() {
		return commuteDAO.holidayCount();
	}

	@Override
	public int lateCount() {
		return commuteDAO.lateCount();
	}

	@Override
	public int thisMonthWork(String emp_id) {

		return commuteDAO.thisMonthWork(emp_id);
	}

	@Override
	public int thisMonthLate(String emp_id) {
		return commuteDAO.thisMonthLate(emp_id);
	}

	@Override
	public int thisMonthAbsent(String emp_id) {
		Calendar cal = Calendar.getInstance();
		int absent = 0;
		int today = cal.get(Calendar.DATE); // ����
		int cntWknd = getCntWknd(today); // ���ñ��� �ָ� ��
		int cntWork = commuteDAO.cntWdays(emp_id); // ���� �ٹ��ϼ�
		absent = today - (cntWknd + commuteDAO.thisMonthHoli(emp_id) + cntWork);
		System.out.println(today);
		System.out.println(cntWknd);
		System.out.println(cntWork);
		return absent;
	}

	@Override
	public int thisMonthHoli(String emp_id) {
		return commuteDAO.thisMonthHoli(emp_id);
	}

	@Override
	public int thisMonthTime(String emp_id) {
		return commuteDAO.thisMonthTime(emp_id);
	}

	@Override
	public int thisYearWork(String emp_id) {
		return commuteDAO.thisYearWork(emp_id);
	}

	@Override
	public int thisYearLate(String emp_id) {
		return commuteDAO.thisYearLate(emp_id);
	}

	@Override
	public int thisYearTime(String emp_id) {
		return commuteDAO.thisYearTime(emp_id);
	}

	@Override
	public int thisYearAbsent(String emp_id) {
		Calendar cal = Calendar.getInstance();
		int absent = 0;

		int today = cal.get(Calendar.DATE); // ����
		int cntWknd = getCntWkndYear(today); // ���ñ��� �ָ� ��
		int cntWork = commuteDAO.cntYdays(emp_id); // ���� �ٹ��ϼ�
		absent = cal.get(Calendar.DAY_OF_YEAR) - (cntWknd + commuteDAO.thisYearHoli(emp_id) + cntWork);

		return absent;
	}

	@Override
	public int thisYearHoli(String emp_id) {
		return commuteDAO.thisYearHoli(emp_id);
	}

	// �̹� �� �ָ� �� ���ϱ�
	public int getCntWknd(int today) {
		Calendar cal = Calendar.getInstance();

		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH);

		System.out.println(month);
		int cntWknd = 0;
		/* cal.getActualMaximum(Calendar.DAY_OF_MONTH); */

		// cntWknd ���ϱ� (1~7 : ��~��)
		for (int i = 1; i <= today; i++) {
			cal.set(year, month, i);
			int m = cal.get(Calendar.DAY_OF_WEEK);
			if (m == 1 || m == 7) {
				cntWknd++;
			}
			System.out.println(i);
			System.out.println(cntWknd);
		}

		return cntWknd;
	}

	// �̹� �⵵ �ָ� �� ���ϱ�
	public int getCntWkndYear(int today) {
		Calendar cal = Calendar.getInstance();

		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH);
		int cntWknd = 0;
		/* cal.getActualMaximum(Calendar.DAY_OF_MONTH); */

		// cntWknd ���ϱ� (1~7 : ��~��)
		for (int j = 0; j <= month; j++) {
			cal.set(year, j, 1);
			for (int i = 1; i <= cal.getActualMaximum(Calendar.DAY_OF_MONTH); i++) {
				cal.set(year, j, i);
				int m = cal.get(Calendar.DAY_OF_WEEK);
				if (m == 1 || m == 7) {
					cntWknd++;
				}
				if (j == month && i == today)
					break;
			}
		}

		return cntWknd;
	}

	@Override
	public List<HashMap<String, Object>> allMemberCommute() {
		// public List<Attendance> allMemberCommute() {
		List<HashMap<String, Object>> listById = commuteDAO.allMemberCommute();
		Calendar cal = Calendar.getInstance();
		// �ڹ�-����Ŭ�������� �̹����� ������ �������� �ڵ带 ���� ¥�ð�,
		int today = cal.get(Calendar.DATE);
		int cntWknd = getCntWknd(today);

		// ����� ���� ���� �ٹ��ϼ� ���ϱ�
		List<Integer> list = commuteDAO.cntWork();
		// today - cntWknd - �ް��ϼ� - �ٹ��ϼ�(�ָ��ٹ�X)
		for (int i = 0; i < listById.size(); i++) {
			long h = 0;
			if (listById.get(i).get("holiday") != null)
				h = (long) listById.get(i).get("holiday");
			int w = 0;
			if (list.get(i) != null)
				w = list.get(i);
			long absent = today - (cntWknd + h + w);
			HashMap<String, Object> newmap = listById.get(i);
			newmap.put("absent", absent);
			listById.set(i, newmap);
			// listById.set(i, listById.get(i).put("absent", absent));
			// listById.get(i).put("absent", absent);
		}

		return listById;
	}

}
