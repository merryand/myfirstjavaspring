package com.study.jara;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.study.jara.domain.Jara;
import com.study.jara.service.JaraService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		return "home";
	}

	// excel.xml 요청을 처리하는 메소드
	@RequestMapping(value = "excel.xls", method = RequestMethod.GET)
	public String excel(Model model) {

		// 1.7이상에서만 아래 형태로 사용 가능
		// 그 이하 버전에는 반드시<>안에 자료형 기재
		List<String> list = new ArrayList<>();
		list.add("Java");
		list.add("JavaScript");
		list.add("C");
		list.add("C++");
		list.add("Python");
		list.add("C#");
		list.add("R");
		list.add("Scala");
		list.add("Swift");
		model.addAttribute("list", list);
		return "programming";
	}

	// data.pdf 요청을 처리하는 메소드
	@RequestMapping(value = "data.pdf", method = RequestMethod.GET)
	public String pdf(Model model) {
		List<String> list = new ArrayList<>();
		list.add("Oracle-RDBMS");
		list.add("MS-SQL-RDBMS");
		list.add("MySQL-RDBMS");
		list.add("ACCESS-RDBMS");
		list.add("sqlite-RDBMS");
		list.add("MongoDB-NoSQL");
		list.add("Cassandra-NoSQL");

		// db라는 이름으로 list를 저장
		model.addAttribute("db", list);
		// 출력하는 뷰 이름을 db로 설정
		return "db";
	}

	@RequestMapping(value = "jsonview.json", method = RequestMethod.GET)
	public String jsonview(Model model) {

		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		Map<String, String> map = new HashMap<String, String>();
		map.put("name", "유관순");
		map.put("phone", "01031391993");
		list.add(map);

		map = new HashMap<String, String>();
		map.put("name", "안중근");
		map.put("phone", "01031901994");
		list.add(map);

		map = new HashMap<String, String>();
		map.put("name", "김좌진");
		map.put("phone", "01031381995");
		list.add(map);

		model.addAttribute("list", list);

		return "jsonview";
	}

	@Autowired
	private JaraService jaraService;

	@RequestMapping(value = "item", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		List<Jara> list = jaraService.listItem();
		model.addAttribute("list", list);
		return "item";
	}

	@RequestMapping(value = "detail", method = RequestMethod.GET)
	public String itemCode(@RequestParam("code") int code, Model model) {
		Jara jara = jaraService.itemCode(code);
		model.addAttribute("item", jara);
		return "detail";
	}

}
