package com.study.jara;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.study.jara.service.MemberService;

@RestController
public class DataController {
	@Autowired
	private MemberService memberService;

	@RequestMapping(value = "idCheck", method = RequestMethod.GET)
	// 반드시 같이 넘겨주어야 합니다.
	public Map<String, String> idCheck(@RequestParam("id") String id) {
		String result = memberService.idCheck(id);
		Map<String, String> map = new HashMap<String, String>();
		// 아이디가 존재하지 않을 때
		if (result == null) {
			map.put("result", "true");
		} else {
			map.put("result", "false");
		}
		return map;
	}

	@RequestMapping(value = "data.csv", method = RequestMethod.GET)
	public String dataCsv() {
		return "csv,xml,json";
	}

	// json을 만들어서 리턴하는 메소드
	@RequestMapping(value = "data.json", method = RequestMethod.GET)
	public List<Map<String, Object>> datajson() {
		List<Map<String, Object>> list = new ArrayList<>();

		Map<String, Object> map = new HashMap<>();

		map.put("name", "고양이");
		map.put("group", "고양잇과");
		list.add(map);

		map = new HashMap<>();
		map.put("name", "개");
		map.put("group", "개과");
		list.add(map);

		map = new HashMap<>();
		map.put("name", "퓨마");
		map.put("group", "고양잇과");
		list.add(map);

		return list;

	}

}