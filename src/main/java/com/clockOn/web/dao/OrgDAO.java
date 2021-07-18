package com.clockOn.web.dao;

import java.util.HashMap;
import java.util.List;

import com.clockOn.web.entity.Criteria;
import com.clockOn.web.entity.Organization;

public interface OrgDAO {
	//��� �� ����Ʈ ��� - ������ ������ & ������Ʈ ����Ʈ�ڽ�
	public List<Organization> list(Criteria cri);
	
	//����� - ��� ���ǿ� ���� �� ���� �Ķ���� ���� ��. �ϴ��� ������
	public Organization get();
	
	//���߰�
	public int add(Organization org);
	
	//������
	public int del(int org_teamcode);
	
	//������ ����
	public int updateInfo(Organization org);
	
	//�μ���ȣ ����Ʈ��� (�����߰� ���������� ���)
	public int getTeamCode(String org_teamname);  

	/*������ ��(����, ���μ�)*/
	public HashMap orgCount();
	   
//	public List<Map<String, String>> selectAllMember(); ����� Map�� ��������� �̹��
	
//	public <Map<String, String> selectAllMember(); ����� map�� �ϳ���� �̹��
}
