package com.clockOn.web.dao;

import java.util.HashMap;
import java.util.List;

import com.clockOn.web.entity.member.Member;
import com.clockOn.web.entity.member.MemberLeave;
import com.clockOn.web.entity.member.MemberList;
import com.clockOn.web.entity.member.MemberSal;


public interface MemberDAO {
	/*����*/
	public List list();

	public int add(Member member);
	
	public int count();

	public int editInfo(Member member);

	public int del(String emp_id);

	public int updateAll(List<MemberList> member);
	
	public List<String> getEmpId();

	public List<MemberList> listView();
	
	public List<MemberLeave> listLeave();

	public List<MemberSal> listSal();

	public List<String> listPosi();

	public List<HashMap<String, String>> listTeam();
	
	/*������ level ó�� Ȯ���ϱ�(���̺� ������)*/
	public Member read(String emp_id);
	
	public List<Member> contactsRead(String org_teamname);
	
	/*������*/   
	public int infoUpdate(Member member);
	   
}
