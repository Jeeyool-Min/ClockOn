package com.clockOn.web.model;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class MemberDAOImpl implements MemberDAO {
	/*
	 * @Inject SqlSession sqlSession;
	 */
	@Override
	public List<MemberDTO> list() {
		return null;
		/*
		 * return sqlSession.selectList("member.list"); //member ���ӽ����̽� list �±��� ���̵�
		 */	}
}
