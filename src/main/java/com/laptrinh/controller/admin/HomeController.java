package com.laptrinh.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.laptrinh.dto.User;

import com.laptrinh.service.IUserService;

@Controller(value = "homeControllerOfAdmin")
public class HomeController {
	
	@Autowired
	private IUserService userService;
	

	@RequestMapping(value = "/quan-tri/trang-chu", method = RequestMethod.GET)
	public ModelAndView homePage() {
		ModelAndView mav = new ModelAndView("admin/home");
		return mav;
	}

	
	@RequestMapping(value = "/quan-tri/them-tai-khoan", method = RequestMethod.GET)
	public ModelAndView Register() {
		ModelAndView mav = new ModelAndView("admin/register");
		return mav;
	}
	
	@RequestMapping(value = "/quan-tri/danh-sach", method = RequestMethod.GET)
	public ModelAndView showList(@RequestParam("page") int page, @RequestParam("limit") int limit) {
		User model = new User();
		model.setPage(page);
		model.setLimit(limit);
		ModelAndView mav = new ModelAndView("admin/list");
		Pageable pageable= new PageRequest(page-1, limit);
		model.setListResult(userService.findAll(pageable));
		model.setTotalItem(userService.getToTalItem());
		model.setTotalPage((int)Math.ceil((double)model.getTotalItem()/model.getLimit()));
		mav.addObject("model", model);
		return mav;
	}

}
