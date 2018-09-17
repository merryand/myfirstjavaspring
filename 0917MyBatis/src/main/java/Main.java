import java.util.List;
import java.util.Scanner;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.pk.mybatis.dao.MyUserDao;
import com.pk.mybatis.domain.MyUserVO;

public class Main {

	public static void main(String[] args) {
		GenericXmlApplicationContext context = new GenericXmlApplicationContext("classpath:applicationContext.xml");
		MyUserDao dao = context.getBean(MyUserDao.class);

		/*
		 * //테이블 데이터를 전체 조회하는 메소드 호출 List<MyUserVO> list = dao.userlist(); for (MyUserVO
		 * vo : list) { System.out.println(vo); }
		 */

		/*
		 * // id를 가지고 데이터를 조회하는 메소드 호출 MyUserVO vo = dao.selectuser("banana");
		 * System.out.println(vo); vo = dao.selectuser("apple"); System.out.println(vo);
		 */

		Scanner sc = new Scanner(System.in);
		// primary key를 입력받는 경우에는 반드시 중복체크를 해야 합니다.
		String id = "";
		while (true) {
			System.out.println("사용할 id를 입력하세요: ");
			id = sc.nextLine();
			MyUserVO vo = dao.selectuser(id);
			// vo가 null이면 DB에 없는 id값이니 체크 통과
			if (vo == null) {
				break;
			}
			System.out.println(id + "는 사용 불가능한 id 입니다.");
		}

		System.out.println("비밀번호 입력: ");
		String pw = sc.nextLine();

		System.out.println("이름 입력: ");
		String name = sc.nextLine();

		System.out.println("전화번호 입력: ");
		String phone = sc.nextLine();

		MyUserVO newVO = new MyUserVO();
		newVO.setId(id);
		newVO.setPw(pw);
		newVO.setName(name);
		newVO.setPhone(phone);

		// select 이외의 구문은 영향받은 행의 개수를 리턴
		// int result = dao.insertuser(newVO);

		int result = dao.insertprocedure(newVO);

		System.out.println(result);

		sc.close();
		context.close();
	}

}
