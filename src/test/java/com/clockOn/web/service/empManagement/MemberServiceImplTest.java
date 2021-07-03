package com.clockOn.web.service.empManagement;

import java.util.Calendar;
import java.util.List;
import java.util.Random;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.clockOn.web.dao.MemberDAO;
import com.clockOn.web.dao.OrgDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/root-context.xml" })
public class MemberServiceImplTest {
//	@Autowired
//	private JavaMailSender mailSender;

	@Autowired
	private OrgDAO orgDao;
	
	@Autowired
    private MemberDAO memberDao;

	@Test
	public void getAuth() {
		System.out.println(memberDao.read("068210").getAuth().get(0).getEmp_level()+memberDao.read("068210").getAuth().get(0).getEmp_id());
		
	}
	
	@Test
	public void makePW() {
		int charLen = 8;
		final char[] charTable = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q',
				'r', 's', 't', 'u', 'w', 'x', 'y', 'z', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0' };
		Random random = new Random(System.currentTimeMillis());
		int tableLen = charTable.length;
		StringBuffer buf = new StringBuffer();

		for (int i = 0; i < charLen; i++) {
			/* 1~36 ������ ������ ������ ��ȯ�ؼ� ������ 0~7�ڸ����� ä���ִ´�. */
			buf.append(charTable[random.nextInt(tableLen)]);
		}
		System.out.println(buf.toString());
	}

	@Test
	public void makeId() {
		String id = "";
		String teamCode = "";
		//�μ��ڵ�[00-99]
		int teamCode_=0;/* = orgDao.getTeamCode("����1��"); */
		if(teamCode_<10) teamCode="0"+teamCode_;
		else teamCode = String.valueOf(teamCode_);
		id +=teamCode;
		System.out.println("�μ��ڵ�:" + id);
		//����[0-9]
		String posi="";
		switch("���") {
			case "AB": posi ="0"; break;
			case "����": posi ="1"; break;
			case "���": posi ="2"; break;
			case "����": posi ="3"; break;
			case "�븮": posi ="4"; break;
			case "����": posi ="5"; break;
			case "����": posi ="6"; break;
			case "����": posi ="7"; break;
			case "����": posi ="8"; break;
			default: posi ="9"; break;
			
		}
		id +=posi;
		System.out.println("�μ��ڵ�+����:" + id);
		
		//�Ի翬��[00-99]
		String yy="";
		Calendar today = Calendar.getInstance();
		String yy_=String.valueOf(today.get(Calendar.YEAR));
		yy=yy_.substring(2);
		
		id += yy;
		//����[0-9]
		int no=0;
		id+=no; //01021'0'���ͽ���
		System.out.println("�μ��ڵ�+����+����:" + id);
		List<String> list = memberDao.getEmpId();
		for(int i=0; i<list.size(); i++) {
			if(id.equals(list.get(i))) {
				no++;
				id = id.substring(0,id.length()-2)+no;
			} else
				break;
		}
		System.out.println("�ϼ�: " + id);
	}
}
