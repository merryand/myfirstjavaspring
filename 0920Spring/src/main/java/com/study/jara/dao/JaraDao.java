package com.study.jara.dao;

import java.util.List;

import com.study.jara.domain.Jara;

public interface JaraDao {
	// 전체 데이터 가져오는 메소드
	public List<Jara> listItem();

	// 상세보기를 위한 메소드
	public Jara itemCode(int code);
}
