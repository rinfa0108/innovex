package com.bayan.sigaw.users.dao;

import java.util.Date;

public interface ProjectsDAO {
	void insertProject(String saroNo, String desc, long amount, String region, String purpose, Date issueDate);
}
