package com.clockOn.web;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Test {
	@org.junit.Test
	public void test() {
		String[] arr = {"7/8", "7/5", "7/1","8/20", "8/1","7/3", "(7)", "8/31"};
		// ArrayList �غ�
		ArrayList<String> list = new ArrayList<>(Arrays.asList(arr));
		System.out.println("���� : " + list); // [C, A, B, a]
		// ������������ ����
		Collections.sort(list);
		System.out.println("�������� : " + list); // [A, B, C, a]
		String[] m = new String[(arr.length)];
		String[] d = new String[(arr.length)];
		for(int i=1; i<list.size(); i++) {
			m[i] = list.get(i).split("/")[0];
			d[i] = list.get(i).split("/")[1];
			System.out.print(m[i]+"/");
			System.out.println(d[i]);
		}
		
	}
}
