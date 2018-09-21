package com.study.jara;

import java.util.List;
import java.util.Locale;

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

	@Autowired
	private JaraService jaraService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		List<Jara> list = jaraService.listItem();
		model.addAttribute("list", list);
		return "home";
	}
	
	@RequestMapping(value="detail", method=RequestMethod.GET)
	public String itemCode(@RequestParam("code") int code, Model model) {
		Jara jara = jaraService.itemCode(code);
		model.addAttribute("item", jara);
		return "detail";
	}
	
}
