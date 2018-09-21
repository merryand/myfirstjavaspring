package com.study.jara.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.jara.dao.MemberDao;

@Service
public class MemberService {
	@Autowired
	private MemberDao memberDao;

	public String idCheck(String id) {
		return memberDao.idCheck(id);
	}

}
