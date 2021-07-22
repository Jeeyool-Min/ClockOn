package com.clockOn.web.service.correction;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clockOn.web.dao.CorrectionDAO;
import com.clockOn.web.entity.correction.Correction;

@Service
public class CorrectionServiceImpl implements CorrectionService {

	@Autowired
	private CorrectionDAO correctionDAO;

	@Override //���� ��� ����
	public int corrReq(List<Correction> list) {
		
		//��û�ϴ� ��¥�� ���ϳ�¥�� ��
		for(int i=0; i<list.size(); i++) {
				list.get(i).setCor_work_req("����� ����");
		}
		return correctionDAO.corrReq(list); 
	}
		
					
		
		 /* //1) ����� ��� ������ ��� 
		Stirng in_ = correction.getCor_work_in().substring(0,2);
					int in = Integer.parseInt(in);
		if(correction.getCor_work_in() == null && correction.getCor_work_out() == null) {
		  
		  //cor_work_req �߰� //�ش� ���� ����� �Ѵ� null���̹Ƿ� ����� �������� �� �����ؼ� ����
		  correction.setCor_work_req("����� ����");
		  
		  
		  }
		  
		  //��� ������ ���
		else if(correction.getCor_work_out() == null) {
		  
		  correction.setCor_work_state("���");
		  
		  if(correction.getCor_work_in() == null) {
		  
		  correction.setCor_work_in("��� ����");
		  
		  } else {
		  
		  correction.setCor_work_in("��� ����");
		  
		  } 
		  //������ ���  (�߰��ؾ��� )
			
		  
		  //��ٽð��� ��ٽð��� null�� �ƴ����� ������ ����ϴ� ��� 
		  else if(correction.getCor_work_in() != null && correction.getCor_work_out() != null) {
		  
		  //cor_work_in�� cor_work_out�� ������û�� �� �ֱ�
		  correction.setCor_work_in(correction.getCor_work_in());
		  correction.setCor_work_out(correction.getCor_work_out());
		  
		  correction.setCor_work_req("����ٽð� ����");
		  
		  correction.setCor_work_state("������û"); }
		  
		  int result = correctionDAO.corrReq(correction);
		 */
		

	@Override
	public List<Correction> corrList(String emp_id) {
		// ����� ���̺��� ���δ��, ������û ��ư�� ��� �����ϴ����� ���� ���ǹ� �߰�
		// (��û�� ���� ������ ó��)
		return correctionDAO.corrList(emp_id);
	}
	
	@Override
	public List<Correction> corrListAll() {
		
		//���� ��ȸ���� �������� ��û�� ������ �ϹǷ� ���δ�⸸ ���̵��� ���� ó��
		/*
		 * if(correction.getCor_work_state() != "���δ��") { return null; }
		 */
		
		return correctionDAO.corrListAll();
	}

}
