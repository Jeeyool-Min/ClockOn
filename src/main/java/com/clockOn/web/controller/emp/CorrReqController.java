package com.clockOn.web.controller.emp;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.clockOn.web.entity.correction.Correction;
import com.clockOn.web.service.correction.CorrectionService;

@Controller
@RequestMapping("/emp/request/")
public class CorrReqController {
	
	@Autowired
	private CorrectionService correctionService;
	
	@GetMapping("corrRequest")
	public String corrReq() {
		return "emp.request.corrRequest";
	}
	//Get��û : DB���� ������ �����ٰ� �𵨷� ������ �ְ� ����ڿ��� ȭ�� ��� 
	//1) � �������� �����ٰ��� jsp : return "menu.emp.dd" 
	//2) � �����͸� �ѷ��ٰ��� : model - data
	//Model ��ü�� GET��û������ Ȱ���Ѵ�.
	
	@PostMapping("corrReq")
	public String corrReq(String period, String reason, HttpSession session) {
		String emp_id= session.getAttribute("id").toString();

		//���� �ް��ϼ��� �������� ��� �ɰ��� DB�� �ֱ�
		//21-07-13 / 21-07-20 / 21-07-21 (3)
		List<Correction> list = new ArrayList<>();
		String[] periods = period.split(" / ");
		for(int i = 0; i<periods.length; i++) {
			Correction corr = new Correction();
			corr.setCor_work_res(reason); 	//�ް� ���� �ֱ�
			corr.setEmp_id(emp_id);
			
			if(i==periods.length-1)	periods[i] = periods[i].substring(0,8);
			corr.setCor_work_day(periods[i]);
			list.add(corr);
		}
		int result = correctionService.corrReq(list);
		return "emp.request.corrRequest";
	}
	
	@GetMapping("corrList")
	public String corrList(Model model, HttpSession session) {
		String emp_id = session.getAttribute("id").toString();
		List<Correction> list = correctionService.corrList(emp_id);
		model.addAttribute("list",list);
		//System.out.println(list.get(0).getCor_work_day());
		return "emp.request.corrList";
	}
	
	@PostMapping("corrList")
	public String corrList(Correction correction) {
		
		
		
		return "emp.request.corrList";
	}

}
