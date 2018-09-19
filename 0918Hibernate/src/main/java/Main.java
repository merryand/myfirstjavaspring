import java.util.List;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.pk.dao.GoodDao;
import com.pk.domain.Good;

public class Main {

	public static void main(String[] args) {
		GenericXmlApplicationContext context = new GenericXmlApplicationContext("classpath:applicationContext.xml");

		GoodDao dao = context.getBean(GoodDao.class);

		List<Good> list = dao.list();
		for (Good good : list) {
			System.out.println(good);
		}

		// 데이터 1개 가져오기
		System.out.println("=================");
		System.out.println(dao.get(3));
		System.out.println(dao.get(4));

		/*
		 * Good good = new Good(); good.setCode(7); good.setName("grape");
		 * good.setManufacture("US"); good.setPrice(5000);
		 * 
		 * dao.deleteGood(good);
		 */
		context.close();

	}

}
