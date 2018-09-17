package com.pk.mybatis.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pk.mybatis.domain.MyUserVO;

//자동으로 bean을 생성해주는 어노테이션
@Repository
public class MyUserDao {
	// 동일한 자료형의 bean이 있으면 자동으로 주입 받는 어노테이션
	//@Autowired - 이게 살아 있으면 다른 위치로 가는 매핑에서 오류 난다고 합니다.
	private SqlSession sqlSession;

	// MyUser 테이블의 전체 데이터를 가져오는 메소드
	public List<MyUserVO> userlist() {
		return sqlSession.selectList("myuser.userlist");
	}

	// MyUser 테이블에서 하나의 데이터를 찾아오는 메소드
	public MyUserVO selectuser(String id) {
		// 하나를 찾아오는 메소드 호출
		// 없으면 null을 리턴
		// 2개 이상이면 예외를 발생시킵니다.
		return sqlSession.selectOne("myuser.selectuser", id);
	}

	// MyUser 테이블에 데이터를 삽입하는 메소드
	// 삽입 메소드의 결과는 정수로 리턴된다
	public int insertuser(MyUserVO vo) {
		return sqlSession.insert("myuser.insertuser", vo);
	}

	public int insertprocedure(MyUserVO vo) {
		return sqlSession.insert("myuser.insertproc", vo);
	}

}
