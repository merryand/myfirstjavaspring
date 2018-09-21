package com.study.jara.service;

import java.util.List;

import com.study.jara.domain.Jara;

public interface JaraService {
	// 전체 데이터를 가져오는 메소드
	// 파라미터가 없으면 DAO 메소드와 동일한 구조입니다.
	public List<Jara> listItem();
	
	//itemid를 가지고 하나의 데이터를 찾아오는 메소드
	public Jara itemCode(int code);

}
