package com.eshop.products.controllers;
import com.eshop.products.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


//TODO its need to look




@Controller
public class AdminController {

    @Autowired
    private AdminService adminService;

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
    @RequestMapping("/deleteCategory")
    public ModelAndView deleteCategory(@RequestParam("id") int id) {
        adminService.deleteCategory(id);
        return new ModelAndView("editCategory");
    }
}
