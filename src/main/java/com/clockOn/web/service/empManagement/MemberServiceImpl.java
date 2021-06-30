package com.clockOn.web.service.empManagement;

import java.util.Calendar;
import java.util.List;
import java.util.Random;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.clockOn.web.dao.MemberDAO;
import com.clockOn.web.dao.OrgDAO;
import com.clockOn.web.entity.Member;
import com.clockOn.web.entity.MemberLeave;
import com.clockOn.web.entity.MemberList;
import com.clockOn.web.entity.MemberSal;

import lombok.Setter;

@Service
public class MemberServiceImpl implements MemberService {
	@Setter(onMethod_ = @Autowired)
	PasswordEncoder pwencoder;
	
	@Autowired
	private JavaMailSender mailSender;
	 
	@Autowired
    private MemberDAO memberDao;
	
	@Autowired
	private OrgDAO orgDao;

	@Override
	public int add(Member member) {
		/*������ �Ѿ� �� ��� ��� ���� */
		if(member.getEmp_id()==null || member.getEmp_id().equals("")) member.setEmp_id(makeEmp_id(member));
		System.out.println(member.getEmp_id());
		/*�̸��� ����-1.��й�ȣ(����) ���� �� �߰�*/
		String emp_pwd = makePw();
		member.setEmp_pw(emp_pwd);
		//2.�̸��� ������
		sendEmail(member.getEmp_id(),member.getEmp_email(), emp_pwd, member.getEmp_name());
		//3.��й�ȣ ��ȣȭ
		member.setEmp_pw(pwencoder.encode(member.getEmp_pw()));
		//4.Dao
		int result = memberDao.add(member);

	    return result;
	}

	private String makeEmp_id(Member member) {
		String id = "";
		String teamCode = "";
		//�μ��ڵ�[00-99]
		int teamCode_ = orgDao.getTeamCode(member.getEmp_dept());
		if(teamCode_<10) teamCode="0"+teamCode_;
		else teamCode = String.valueOf(teamCode_);
		id +=teamCode;
		
		//����[0-9]
		String posi="";
		switch(member.getEmp_posi()) {
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
		
		//�Ի翬��[00-99]
		String yy="";
		Calendar today = Calendar.getInstance();
		String yy_=String.valueOf(today.get(Calendar.YEAR));
		yy=yy_.substring(2);
		
		id += yy;
		//����[0-9]
		int no=0;
		id+=no; //01021'0'���ͽ���
		List<String> list =memberDao.getEmpId();
		for(int i=0; i<list.size(); i++) {
			if(id.equals(list.get(i))) {
				no++;
				id = id.substring(0,id.length()-2)+no;
			} else
				break;
		}
		
		return id;
		}
		

	private void sendEmail(String id, String email, String emp_pwd, String emp_name) {
		String setFrom = "jeeyoolmin@gmail.com";
		String setTo = email;
		String title = "���°��� �ý��� clockOn �շ��ϱ�";
		String content =
				emp_name+"���� ���̵�� ��� (" +id +")�Դϴ�. <br>" +
				"�ʱ� ��й�ȣ�� " + emp_pwd +"�Դϴ�. <br>" +
				"���� <a href='http://localhost:8090/index'>clockOn</a>�� �շ��Ͽ� "+
				"�α��� �� ��й�ȣ�� �������ּ���.";
		try {
			MimeMessage message = mailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message, true, "utf-8");
			helper.setFrom(setFrom);
			helper.setTo(setTo);
			helper.setSubject(title);
			helper.setText(content,true);
			mailSender.send(message);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	private String makePw() {
		int charLen = 8;
		final char[] charTable = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','w','x','y','z','1','2','3','4','5','6','7','8','9','0'};
		Random random = new Random(System.currentTimeMillis());
		int tableLen = charTable.length;
		StringBuffer buf = new StringBuffer();
		
		for(int i=0; i<charLen; i++) {
			/*1~36 ������ ������ ������ ��ȯ�ؼ� ������ 0~7�ڸ����� ä���ִ´�. */
			buf.append(charTable[random.nextInt(tableLen)]);
		}
		return buf.toString();
	}

	@Override
	public int edit(String emp_id) {
		return 0;
	}

	@Override
	public int del(String emp_id) {
		return 0;
	}

	@Override
	public List<Member> list() {
		return memberDao.list();
	}

	@Override
	public int update(String emp_id) {
		return 0;
	}
	//������������ -�������� �ϰ� ����
	@Override
	public int update(MemberList member) {
		return memberDao.updateInfo(member);
	}

	@Override
	public List<MemberList> listView() {
		return memberDao.listView();
	}

	@Override
	public List<MemberLeave> listLeave() {
		return memberDao.listLeave();
	}

	@Override
	public List<MemberSal> listSal() {
		return memberDao.listSal();
	}

	@Override
	public int count() {
		return memberDao.count();
	}

}
