package com.clockOn.web.controller.emp;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})

public class VacReqControllerTest {

	@Test
	public void test() {
		// ArrayList �غ�
		ArrayList<String> list = new ArrayList<>(Arrays.asList("7/8", "7/5", "8/20", "8/1","7/3"));
		System.out.println("���� : " + list); // [C, A, B, a]
		// ������������ ����
		Collections.sort(list);
		System.out.println("�������� : " + list); // [A, B, C, a]
	}

}
