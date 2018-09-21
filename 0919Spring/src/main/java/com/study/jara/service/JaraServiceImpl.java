package com.study.jara.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.jara.dao.JaraDao;
import com.study.jara.domain.Jara;

@Service
public class JaraServiceImpl implements JaraService {
	@Autowired
	private JaraDao jaraDao;

	@Override
	// 파라미터가 없는 경우는 Dao 메소드의 결과를 바로 리턴
	public List<Jara> listItem() {
		return jaraDao.listItem();
	}

	@Override
	public Jara itemCode(int code) {
		return jaraDao.itemCode(code);
	}

}
