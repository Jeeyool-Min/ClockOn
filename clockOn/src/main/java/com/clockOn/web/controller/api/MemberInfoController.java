package com.clockOn.web.controller.api;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.clockOn.web.entity.member.MemberList;
import com.clockOn.web.entity.member.Search;
import com.clockOn.web.service.empManagement.MemberService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController("MemberInfoController") // @ResponseBody�� ���� �ʾƵ� �˾Ƽ� ���̽� ������Ÿ������ ��ȯ(���̽� ���ڿ�)
@RequestMapping("/admin/empManagement/")
public class MemberInfoController {
	
	@Autowired
	private MemberService service;
	
	//ResponseBody -- �ٷ� ���̽� ���ڿ��� �ް� ������
	@PostMapping("searchlist")
	public List<MemberList> searchResult(@RequestParam(value = "search") String search) throws JsonMappingException, JsonProcessingException {
		
		ObjectMapper mapper = new ObjectMapper();
//		List<Search> list = mapper.readValue(search, new TypeReference<List<Search>>() {});
//		List<MemberList> model =service.searchList(list);
		List<Map<String, String>> mapList = mapper.readValue(search, new TypeReference<List<Map<String, String>>>(){});
		System.out.println(search);
//		System.out.println(mapList.get(0).get("field"));
//		System.out.println(mapList.get(0).get("key"));
//		System.out.println(mapList.get(1).get("key"));
//		System.out.println(mapList.get(1).get("field"));
		
		List<MemberList> model = service.searchList(mapList);
        return model;
	}
}
