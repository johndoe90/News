package com.phillip.news;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.phillip.news.domain.Category;
import com.phillip.news.domain.Media;
import com.phillip.news.domain.MediaProvider;
import com.phillip.news.service.CategoryService;
import com.phillip.news.service.MediaProviderService;
import com.phillip.news.service.MediaService;


@Controller
public class HomeController {
	
	@Inject
	private MediaService mediaService;
	
	@Inject 
	private CategoryService categoryService;
	
	@Inject
	private MediaProviderService mediaProviderService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		return "index";
	}
	
}
