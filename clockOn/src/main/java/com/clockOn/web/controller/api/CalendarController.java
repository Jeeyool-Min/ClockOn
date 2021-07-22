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
import com.clockOn.web.entity.commute.CommuteDetail;
import com.clockOn.web.service.attendance.CommuteService;
import com.clockOn.web.service.empManagement.MemberService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController("CalendarController")
// @ResponseBody�� ���� �ʾƵ� �˾Ƽ� ���̽� ������Ÿ������ ��ȯ (���̽� ���ڿ�)
public class CalendarController {
	
	@Autowired
	private CommuteService commuteService;
	
	@Autowired
	private MemberService memberService;
	
	@PostMapping("/emp/calendar")
	public List<Commute> byCalendar(@RequestParam(value = "dates") String dates, HttpSession session) {
		// �Ķ���� 2 : dates "2021-07"
		// �Ķ���� 1 : emp_id -> ���� ���
		
		String emp_id = session.getAttribute("id").toString();
		Map<String, String> map = new HashMap<>();
		
		map.put("emp_id", emp_id);
		map.put("dates", dates);
		
		
		List<Commute> result = commuteService.listRecord(map);
		// ���࿡ js���� ��ü�� ������ ������ �迭�� �Ѱ��־��ٸ�, 
		//[{field:'emp_name', keyword:'��'},{field:'emp_dept', keyword:'����'}, {field:'work_date', keyword:'7/17'}]
		//[{field:'', keyword:''},{field:'', keyword:''}, {field:'work_date', keyword:'7/17'}]
		// List�� ��ȯ�ؼ� > �Ķ���ͷ� �ָ� List<HashMap<String, String>>
		// �迭�� �����ؼ� �ݺ��� ���鼭 �迭�� 3���� ��� �߰� --> json ���ڿ��� ��ȯ --> ajax�� �ѱ�
		
		return result;
	}
	
	@PostMapping("/emp/byList")
	public List<CommuteDetail> myList(@RequestParam(value = "search") String search, HttpSession session)
			throws JsonMappingException, JsonProcessingException{
		
		String emp_id = session.getAttribute("id").toString();
		
		ObjectMapper mapper = new ObjectMapper();
		List<Map<String, String>> mapList = mapper.readValue(search, new TypeReference<List<Map<String, String>>>(){});
		
		List<CommuteDetail> result = commuteService.myList(mapList);

		return result;
	}
	
	
	@PostMapping("/admin/timeRecord/byList")
	public List<CommuteDetail> allByList(@RequestParam(value = "search") String search) throws JsonMappingException, JsonProcessingException{
		ObjectMapper mapper = new ObjectMapper();
		List<Map<String, String>> mapList = mapper.readValue(search, new TypeReference<List<Map<String, String>>>(){});
		List<CommuteDetail> result = commuteService.allByList(mapList);

		return result;
	}

	//select 1, 2, 3,4,5 ,5, where #{field} like '%keyword%'
	
	//@PostMapping("searchlist")
	//public List<MemberList> searchResult(@RequestParam(value = "search") String search) throws JsonMappingException, JsonProcessingException {
		
		//ObjectMapper mapper = new ObjectMapper();
//		List<Search> list = mapper.readValue(search, new TypeReference<List<Search>>() {});
//		List<MemberList> model =service.searchList(list);
		//List<Map<String, String>> mapList = mapper.readValue(search, new TypeReference<List<Map<String, String>>>(){});
		//System.out.println(search);
//		System.out.println(mapList.get(0).get("field"));
//		System.out.println(mapList.get(0).get("key"));
//		System.out.println(mapList.get(1).get("key"));
//		System.out.println(mapList.get(1).get("field"));
	//	List<MemberList> model =service.searchList(mapList);
      //  return model;
	//}
}
