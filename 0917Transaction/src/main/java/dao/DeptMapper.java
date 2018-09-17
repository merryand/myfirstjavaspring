package dao;

import org.apache.ibatis.annotations.Insert;

import vo.Dept;

public interface DeptMapper {

	// dept 테이블에 데이터를 저장하는 메소드F
	@Insert("insert into dept values(#{deptno}, #{dname}, #{loc})")
	public int insertdept(Dept dept);
}
