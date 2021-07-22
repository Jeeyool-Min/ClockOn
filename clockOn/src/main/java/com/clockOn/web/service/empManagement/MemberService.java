package com.clockOn.web.service.empManagement;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clockOn.web.entity.member.Member;
import com.clockOn.web.entity.member.MemberLeave;
import com.clockOn.web.entity.member.MemberList;
import com.clockOn.web.entity.member.MemberProfile;
import com.clockOn.web.entity.member.MemberSal;

public interface MemberService {
	/* ������ - �����߰� */
	public int add(Member member);

	/* ������ - ��� ���� ���� �ҷ����� */
	public List<Member> list();

	/* ������ - Ư�� ���� ���� ����(�̿�) */
	public int del(String emp_id);

	/* ������ - Ư�� ���� ���� ����(�̿�) */
	public int update(String emp_id);

	/* ������ - ���� ���� ���� �ϰ� ���� */
	public int updateAll(List<MemberList> list);

	/* ������ - ��� ���� ���� ����� ����(���� ���ԵǾ�� �ؼ� memberList ���θ���) */
	public List<MemberList> listView();

	/* ������ - ��� ���� �������� �������� */
	public List<MemberLeave> listLeave();

	/* ������ - ��� ���� ���� ���� ���� �������� */
	public List<MemberSal> listSal();

	/* ����&������ - ���� �� ���ϱ� */
	public int count();

	/* ������ - ���� �������� ++ ������ ���� ����Ʈ �� ���� �����ϴ� ���޿��� ������(�����ʿ�) */
	public List<String> listPosi();

	/* ���� ���� �� ���(���ڿ�) �������� */
	public List<HashMap<String, String>> listTeam();

	/* �α���, ���� id�� �� ������ ���� �������� */
	public Member read(String emp_id);

	/* ������ �������� */
	public List<MemberProfile> contactsRead(String org_teamname);

	/* ���� �������� ���� */
	public int infoUpdate(MemberProfile memberProfile);

	/* ����&������ - ������ ���� �ҷ����� */
	public MemberProfile profile(String emp_id);

	public List<MemberList> searchList(List<Map<String, String>> list);
}
