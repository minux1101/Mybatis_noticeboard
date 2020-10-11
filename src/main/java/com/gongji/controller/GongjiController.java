package com.gongji.controller;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.gongji.dto.GongjiVO;
import com.gongji.service.GongjiService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class GongjiController {

	private static final Logger logger = LoggerFactory.getLogger(GongjiController.class);

	SimpleDateFormat sdt = new SimpleDateFormat("yyyy-MM-dd");

	@Inject
	GongjiService gs;

	// selectAll
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String list(Model model) throws Exception {

		List<GongjiVO> gongjiList = gs.selectAll();
		model.addAttribute("selectGongji", gongjiList);

		return "gongji_list";
	}

	// oneView
	@RequestMapping(value = "/view", method = RequestMethod.GET)
	public String view(@RequestParam int id, Model model) throws Exception {

		GongjiVO gongji = gs.selectOne(id);
		model.addAttribute("oneView", gongji);

		return "gongji_view";
	}

	// insert
	@RequestMapping(value = "/insert", method = { RequestMethod.GET, RequestMethod.POST })
	public String insert(HttpServletRequest request, Model model) throws Exception {

		GongjiVO gongjiVO = new GongjiVO();
		LocalDate now = LocalDate.now();
		String format = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		Date date = sdt.parse(format);
		gongjiVO.setDate(date);
		model.addAttribute("insertGongji", gongjiVO);

		return "gongji_insert";
	}

	// result
	@RequestMapping(value = "/result", method = { RequestMethod.GET, RequestMethod.POST })
	public String result(HttpServletRequest request, Model model) throws Exception {

		request.setCharacterEncoding("UTF-8");
		GongjiVO gongjiVO = new GongjiVO();

		if (request.getParameter("title").equals("") || request.getParameter("title") == null || request.getParameter("content").equals("") || request.getParameter("content") == null) {
			return "gongji_insert";
		} else {
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			LocalDate now = LocalDate.now();
			String format = now.plusDays(1).format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
			Date date = sdt.parse(format);

			gongjiVO.setDate(date);
			gongjiVO.setTitle(title);
			gongjiVO.setContent(content);
			model.addAttribute("resultGongji", gongjiVO);
			int insert = gs.insert(gongjiVO); // memberServiceImpl		

			return "gongji_result";
		}
	}

	// delete
	@RequestMapping(value = "/delete", method = { RequestMethod.GET, RequestMethod.POST })
	public String delete(@RequestParam int id, Model model) throws Exception {

		GongjiVO gongji = gs.selectOne(id);
		model.addAttribute("del", gongji);
		int delete = gs.delete(id); // memberServiceImpl

		return "gongji_delete";
	}

	@RequestMapping(value = "/update", method = { RequestMethod.GET, RequestMethod.POST })
	public String update(HttpServletRequest request, Model model) throws Exception {

		request.setCharacterEncoding("UTF-8");
		int id = Integer.parseInt(request.getParameter("id"));
		GongjiVO gongjiVO = gs.selectOne(id);
		model.addAttribute("updateGongji", gongjiVO);

		return "gongji_update";
	}

	// write
	@RequestMapping(value = "/write", method = { RequestMethod.GET, RequestMethod.POST })
	public String write(HttpServletRequest request, Model model) throws Exception {

		request.setCharacterEncoding("UTF-8");
		int id = Integer.parseInt(request.getParameter("id"));
		GongjiVO gongjiVO = gs.selectOne(id);
		model.addAttribute("writeGongji", gongjiVO);

		if (request.getParameter("title").equals("") || request.getParameter("title") == null || request.getParameter("content").equals("") || request.getParameter("content") == null) {
			return "gongji_update";
		} else {
			String title = request.getParameter("title");
			String content = request.getParameter("content");

			gongjiVO.setTitle(title);
			gongjiVO.setContent(content);
			int update = gs.update(gongjiVO); // memberServiceImpl		

			return "gongji_write";
		}
	}

}