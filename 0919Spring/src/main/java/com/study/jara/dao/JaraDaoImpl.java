package com.study.jara.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.study.jara.domain.Jara;

@Repository
public class JaraDaoImpl implements JaraDao {
	// MyBatis 실행 객체를 주입
	@Autowired
	private SqlSession sqlSession;

	@Override
	public List<Jara> listItem() {
		return sqlSession.selectList("jaraMapper.allitem");
	}

	@Override
	public Jara itemCode(int code) {
		return sqlSession.selectOne("jaraMapper.itemcode", code);
	}

}
