package com.phillip.news.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import javax.inject.Inject;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.phillip.news.domain.dto.DtoListConverter;


/*@Controller
@RequestMapping("/categories")
public class CategoryController {  

	@Inject
	private CategoryService categoryService;  
	
	@Inject
	private LanguageService languageService;
	
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<CategoryDto> getAll(Locale locale){
		List<Category> categories = categoryService.findAllCategories();
		String languageCode = languageService.languageIsSupported(locale.getLanguage()) ? locale.getLanguage() : Languages.DEFAULT.getCode();
		for(Category category : categories){
			for(CategoryTranslation translation : category.getTranslations()){
				if(translation.getLanguage().getCode().equals(languageCode)){
					category.setTranslations(Arrays.asList(translation));
					break;
				}
			}
		}
		
		return DtoListConverter.getInstance().convert(categories, CategoryDto.class);
	}
}*/
