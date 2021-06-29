package com.clockOn.web.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.clockOn.web.entity.Organization;

@Repository
public class OrgDAOImpl implements OrgDAO{
	@Autowired
	private SqlSession sqlSession;
	private OrgDAO mapper;
	
	/*������ ���� ����*/
	@Autowired
	public OrgDAOImpl(SqlSession sqlSession) {
		mapper = sqlSession.getMapper(OrgDAO.class);
	}
	
	@Override
	public List<Organization> list() {
		return mapper.list();
	}

	@Override
	public Organization get() {
		return mapper.get();
	}
	@Override
	public int add(Organization org) {
		return mapper.add(org);
	}

	@Override
	public int getTeamCode(String org_teamname) {
		
		return mapper.getTeamCode(org_teamname);
	}

	@Override
	public int del(int org_teamcode) { /*�������̱� ������ Controller���� �߹޾ƾ� ��*/
		return mapper.del(org_teamcode);
	}

	@Override
	public int updateInfo(Organization org) {
		return mapper.updateInfo(org);
	}

}
