package com.study.view.aop.util;

import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

//bean을 자동생성해주는 어노테이션
//
@Component
public class MeasureInterceptor implements HandlerInterceptor {
	long start;

	@Override
	// Controller가 요청을 처리하기 전에 호출되는 메소드
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		start = System.currentTimeMillis();

		// 어디에서(ip) 언제(시간)서비스를 사용했는지 파일에 기록

		// 오늘 날짜를 만들기
		Calendar cal = Calendar.getInstance();
		Date date = new Date(cal.getTimeInMillis());

		try (FileOutputStream fos = new FileOutputStream("/Users/a503-24/Documents/" + date.toString() + ".txt", true);
				PrintWriter pw = new PrintWriter(fos);) {
			String ip = request.getRemoteAddr();

			String msg = String.format("%04d%02d%02d%02d%02d%02d", cal.get(Calendar.YEAR), cal.get(Calendar.MONTH),
					cal.get(Calendar.DAY_OF_MONTH), cal.get(Calendar.HOUR), cal.get(Calendar.MINUTE),
					cal.get(Calendar.SECOND));
			pw.println(ip + "-" + msg);

		}

		// false를 리턴하면 Controller로 이동하지 않습니다.
		return true;
	}

	@Override
	// Controller가 예외가 발생하지 않은 상태로 작업을 종료하고 View를 출력하기 전에 호출되는 메소드
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

	}

	@Override
	// 에외발생 여부와 상관없이 Controller가 작업을 종료하면 호출되는 메소드
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		long end = System.currentTimeMillis();
		System.out.println(end - start);
	}

}
