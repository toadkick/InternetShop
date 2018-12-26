package com.eshop.products.controllers;
import com.eshop.products.entities.Account;
import com.eshop.products.entities.Category;
import com.eshop.products.entities.Product;
import com.eshop.products.services.AdminService;
import com.eshop.products.services.ProductsService;
import com.eshop.products.validator.FormValidator;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@SessionAttributes("modcategory")

public class AdminController {

    private static final Logger LOGGER = Logger.getLogger(AdminController.class);
    @Autowired
    FormValidator formValidator;
    @Autowired
    private AdminService adminService;

    @Autowired
    private ProductsService productsService;

    @RequestMapping(value ="/editCategory/{id}", method = RequestMethod.GET)
    public ModelAndView editCategory(HttpServletRequest request, @PathVariable("id") int id){
        Category category = productsService.getCategoryByID(id);
        ModelAndView modelAndView = new ModelAndView("editCategory", "category", category);
        List<Category> categoryList = productsService.showAllCategories();
        List<Integer> categoryIdList = getCategoryIdList(categoryList, id);
        modelAndView.addObject ("list", categoryList);
        modelAndView.addObject("listId", categoryIdList);
        modelAndView.addObject("modcategory", category);
        return modelAndView;
    }

    @RequestMapping(method = RequestMethod.POST)
    public String addCategory (@ModelAttribute("modcategory") @Validated Category category,
                                    BindingResult result,
                                    HttpServletRequest request) {
        formValidator.validateCategory(category, result);
        if (result.hasErrors()) {
            String referer = request.getHeader("Referer");
            return "redirect:"+ "/categoryManager";
        }
        if (category.getCategoryID() > 0) {
            adminService.editCategory(category.getCategoryID(), category.getName(), category.getParentID());
            LOGGER.info("edit categor" + category.getCategoryID());
            return "redirect:"+ "/categoryManager";
        } else
        adminService.addCategory(category.getName(), category.getParentID());
        String referer = request.getHeader("Referer");
        return "redirect:"+ referer;
    }

    @RequestMapping(value = "/removeCategory/{id}", method = RequestMethod.GET)
    public String removeCategory(HttpServletRequest request, @PathVariable("id") int id) {
        adminService.deleteCategory(id);
        String referer = request.getHeader("Referer");
        return "redirect:"+ referer;
    }
    @RequestMapping(value = "/categoryManager", method = RequestMethod.GET)
    public ModelAndView categoryManager() {
        List<Category> categoryList = productsService.showAllCategories();
        List<Integer> categoryIdList = getCategoryIdList(categoryList, -1);
        Category category = new Category();
        ModelAndView modelAndView = new ModelAndView("categoryManager", "list", categoryList);
        modelAndView.addObject("listId", categoryIdList);
        modelAndView.addObject("modcategory", category);
        return modelAndView;
    }

    private List<Integer> getCategoryIdList (List<Category> categoryList, int id) {
        List<Integer> categoryIdList = new ArrayList<>();
        categoryIdList.add(0);
        for (int i = 0; i < categoryList.size(); i++) {
            if (categoryList.get(i).getCategoryID() == id) continue;
            categoryIdList.add(categoryList.get(i).getCategoryID());
        }
        return categoryIdList;
    }


}
