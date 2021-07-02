package com.clockOn.web.controller.emp;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/emp/vacation/")
public class VactionRequestController {
	@Autowired
	private ServletContext ctx;
	
	//��û ������
	@GetMapping("request")
	public String vacReq() {
		
		
		return "emp.vacation.vcRequest";
	}
	
	//��û ������ �Է� ó��
	@PostMapping("request")
	public String sendReq() {
		
		
		return "emp.vacation.vcList";
	}
	
	@GetMapping
	public String vacReqlist() {
		
		return "emp.vacation.vcList";
	}

}
