package com.clockOn.web.controller.api;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.clockOn.web.entity.commute.Commute;
import com.clockOn.web.service.attendance.CommuteService;

@RestController("CalendarController")
// @ResponseBody�� ���� �ʾƵ� �˾Ƽ� ���̽� ������Ÿ������ ��ȯ (���̽� ���ڿ�)
public class CalendarController {
	
	@Autowired
	private CommuteService commuteService;
	
	@PostMapping("/emp/calendar")
	public List<Commute> byCalendar(@RequestParam(value = "dates") String dates, HttpSession session) {
		// �Ķ���� 2 : dates "2021-07"
		// �Ķ���� 1 : emp_id -> ���� ���
		
		String emp_id = session.getAttribute("id").toString();
		Map<String, String> map = new HashMap<>();
		
		map.put("emp_id", emp_id);
		map.put("dates", dates);
		
		
		List<Commute> result = commuteService.listRecord(map);
		// ���࿡ js���� ��ü�� ������ ������ �迭�� �Ѱ��־��ٸ�, [{field:'emp_name',
		// keyword:'��'},{field:'emp_name', keyword:'��'}, {field:'emp_name',
		// keyword:'��'}]
		return result;
	}
}
