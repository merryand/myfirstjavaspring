package com.pk.mybatis.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.pk.mybatis.domain.MyUserVO;

public interface MyUserInterface {
	// myuser 테이블의 데이터를 전부 가져오는 메소드
	@Select("select * from myuser")
	public List<MyUserVO> listuser();

	// myuser 테이블에서 id가 일치하는 데이터 1개를 가져오는 메소드
	@Select("select * from myuser where id=#{id}")
	public MyUserVO selectuser(String id);
}
