package com.clockOn.web.service.attendance;

public interface CommuteService {

	// ��� �ο� ī��Ʈ
		public int goWorkCount();
		// ����� �ο� ī��Ʈ
		public int notWorkCount();
		// �ް� �ο� ī��Ʈ
		public int holidayCount();
		// ���� �ο� ī��Ʈ
		public int lateCount();

}
