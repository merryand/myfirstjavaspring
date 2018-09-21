package com.study.view;

import java.io.File;
import java.io.IOException;
import java.util.Locale;
import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.study.view.aop.domain.Command;

@Controller
public class HomeController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		return "home";
	}

	@RequestMapping(value = "interceptor", method = RequestMethod.GET)
	public String interceptor() {
		// 시작 시간을 측정
		// long start = System.currentTimeMillis();

		int sum = 0;
		for (int i = 1; i <= 100000000; i = i + 1) {
			sum = sum + i;
		}
		// 종료 시간을 측정
		// long end = System.currentTimeMillis();
		// System.out.println(end - start);

		return "";
	}

	@RequestMapping(value = "fileupload", method = RequestMethod.GET)
	public String fileupload(Model model) {
		System.out.println("GET 요청 통과");
		return "fileupload";
	}

	@RequestMapping(value = "fileupload", method = RequestMethod.POST)
	public String fileupload(Command command, Model model) {
		System.out.println("이름:" + command.getName());
		if (command.getReport().isEmpty()) {
			System.out.println("첨부 파일이 없습니다.");
		} else {
			// 업로드 할 디렉토리 이름 설정
			String uploadPath = "/Users/a503-24/Documents/";
			// 파일 경로 만들기
			String filepath = uploadPath + UUID.randomUUID() + command.getReport().getOriginalFilename();
			// 파일 업로드
			try {
				command.getReport().transferTo(new File(filepath));
			} catch (Exception e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
			System.out.println("파일 업로드 성공");
		}
		// 변화를 주는 작업을 수행하면 반드시 리다이렉트 해야 합니다.
		return "redirect:./";
	}

}
