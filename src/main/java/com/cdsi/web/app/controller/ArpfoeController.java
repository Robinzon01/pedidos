package com.cdsi.web.app.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cdsi.web.app.model.Arpfoe;
import com.cdsi.web.app.model.PagerModel;
import com.cdsi.web.app.service.IArpfoeService;


@Controller
//@RequestMapping("/app")
public class ArpfoeController {
	
	protected static final String ARTICLE_PAGE_VIEW = "pedidos/allArpfoe"; // list with pagination
	protected static final String ARTICLE_EDIT_FORM_VIEW = "pedidos/editArpfoe"; // form for editing an article
	
	// pagination
	private static final int BUTTONS_TO_SHOW = 3;
	private static final int INITIAL_PAGE = 0;
	private static final int INITIAL_PAGE_SIZE = 5;
	private static final int[] PAGE_SIZES = { 5, 10 };
	
	@Autowired
	private IArpfoeService arpfoeService;
	
	@GetMapping("/arpfoes")
    public ModelAndView getAllArticles(@RequestParam("pageSize") Optional<Integer> pageSize,
                                       @RequestParam("page") Optional<Integer> page) {
		
        ModelAndView modelAndView = initPagination(pageSize, page, ARTICLE_PAGE_VIEW);
        return modelAndView;
        
    }
	
	@GetMapping("/arpfoe/{id}/edit")
	public String editArticle(@PathVariable(value = "id") String articleId, Model model) {

	  //	if (!model.containsAttribute("arpfoe")) {
			//model.addAttribute("article", articleService.findById(articleId));
			model.addAttribute("arpfoe", arpfoeService.findByCiaAndOrden("01", articleId) );
	//	}
		return ARTICLE_EDIT_FORM_VIEW;
	}
	
	public ModelAndView initPagination(Optional<Integer> pageSize, Optional<Integer> page, String url) {
		
		ModelAndView initModelView = new ModelAndView(url);
		// If pageSize == null, return initial page size
		int evalPageSize = pageSize.orElse(INITIAL_PAGE_SIZE);

		int evalPage = (page.orElse(0) < 1) ? INITIAL_PAGE : page.get() - 1;
		
		Page<Arpfoe> arpfoeList = arpfoeService.findAll(PageRequest.of(evalPage, evalPageSize) );
		
		PagerModel pager = new PagerModel(arpfoeList.getTotalPages(), arpfoeList.getNumber(), BUTTONS_TO_SHOW);

		initModelView.addObject("articlesList", arpfoeList);
		initModelView.addObject("selectedPageSize", evalPageSize);
		initModelView.addObject("pageSizes", PAGE_SIZES);
		initModelView.addObject("pager", pager);
		return initModelView;
		
	}
	
	
}
