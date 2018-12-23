package com.eshop.products.controllers;
import com.eshop.products.entities.Category;
import com.eshop.products.services.AdminService;
import com.eshop.products.services.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


//TODO its need to look




@Controller
public class AdminController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private ProductsService productsService;

    @RequestMapping("/addProduct")
    public ModelAndView addProduct(@RequestParam("catID")int catID,
                                   @RequestParam("name")String name, @RequestParam("author")String author,
                                   @RequestParam("parID")int parID, @RequestParam("price")double price,
                                   @RequestParam("count")int count, @RequestParam("date")int date){
        adminService.addProduct(catID, name, author, parID, price, count, date);
        return new ModelAndView("editProduct");
    }

    @RequestMapping("/deleteProduct")
    public ModelAndView deleteProduct(@RequestParam("id")int id){
        adminService.deleteProduct(id);
        return new ModelAndView("editProduct");
    }

    @RequestMapping("/addCategory")
    public ModelAndView addCategory(@RequestParam("name")String name,
                                    @RequestParam("par_id")int parID){
        adminService.addCategory(name, parID);
        return new ModelAndView("editCategory");
    }

    @RequestMapping(value = "/addUnderCategory/{id}", method = RequestMethod.GET)
    public String addCategory(HttpServletRequest request, @PathVariable("id") int id) {
        adminService.addCategory(request.getParameter("name"), id);
        String referer = request.getHeader("Referer");
        return "redirect:"+ referer;
    }

    @RequestMapping(value = "/removeCategory/{id}", method = RequestMethod.GET)
    public String removeCategory(HttpServletRequest request, @PathVariable("id") int id) {
        adminService.deleteCategory(id);
        String referer = request.getHeader("Referer");
        return "redirect:"+ referer;
    }
    @RequestMapping("/categoryManager")
    public ModelAndView categoryManager() {
        List<Category> categoryList = productsService.showAllCategories();
        return new ModelAndView("categoryManager", "list", categoryList);
    }
}
