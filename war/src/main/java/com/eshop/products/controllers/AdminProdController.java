package com.eshop.products.controllers;

import com.eshop.products.entities.Category;
import com.eshop.products.entities.Product;
import com.eshop.products.services.AdminService;
import com.eshop.products.services.ProductsService;
import com.eshop.products.validator.FormValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * AdminProdController  - class-controller for admin features regarding products
 */
@Controller
@SessionAttributes("modprod")
public class AdminProdController {
    @Autowired
    FormValidator formValidator;
    @Autowired
    private AdminService adminService;
    @Autowired
    private ProductsService productsService;

    @RequestMapping(value = "/removeProduct/{id}", method = RequestMethod.GET)
    public String deleteProduct(@PathVariable("id")int id, HttpServletRequest request){
        adminService.deleteProduct(id);
        String referer = request.getHeader("Referer");
        return "redirect:"+ referer;
    }

    @RequestMapping(value = "/productManager", method = RequestMethod.GET)
    public ModelAndView productManager() {
        List<Product> productList = adminService.productsForProdManagment();
        List<Integer> prodIdList = getProdIdList(productList, -1);
        List<Category> categoryList = productsService.showAllCategories();
        List<Integer> categoryIdList = getCategoryIdList(categoryList);
        Product product = new Product();
        ModelAndView modelAndView = new ModelAndView("productManager", "list", productList);
        modelAndView.addObject("listId", prodIdList);
        modelAndView.addObject("catList", categoryIdList);
        modelAndView.addObject("modprod", product);
        return modelAndView;
    }

    @RequestMapping(value = "/productManager", method = RequestMethod.POST)
    public String addProduct (@ModelAttribute("modprod") @Validated Product product,
                              BindingResult result,
                              HttpServletRequest request) {
        formValidator.validateProduct(product, result);
        String referer = request.getHeader("Referer");
        if (result.hasErrors()) {

            return "redirect:"+ referer;
        }
        if (product.getProductID() > 0) {
            adminService.editProduct(product.getProductID() ,product.getCategoryID(), product.getName(), product.getAuthor(), product.getParentID(),
                    product.getPrice(), product.getCount(), product.getDate(), product.getImgSource()+".jpg");
            return "redirect:"+ referer;
        } else
            adminService.addProduct(product.getCategoryID(), product.getName(), product.getAuthor(), product.getParentID(),
                    product.getPrice(), product.getCount(), product.getDate(), product.getImgSource()+".jpg");
        return "redirect:"+ referer;
    }

    @RequestMapping(value = "/editProduct/{id}", method = RequestMethod.POST)
    public String editProduct (@ModelAttribute("modprod") @Validated Product product,
                              BindingResult result,
                              HttpServletRequest request) {
        addProduct(product, result, request);
        String referer = request.getHeader("Referer");

        return "redirect:"+ referer;
    }

    @RequestMapping(value ="/editProduct/{id}", method = RequestMethod.GET)
    public ModelAndView editProducts(HttpServletRequest request, @PathVariable("id") int id){
        List<Product> productList = adminService.productsForProdManagment();
        List<Integer> prodIdList = getProdIdList(productList, id);
        List<Category> categoryList = productsService.showAllCategories();
        List<Integer> categoryIdList = getCategoryIdList(categoryList);
        Product product = productsService.getProductByID(id);
        ModelAndView modelAndView = new ModelAndView("editProduct", "list", productList);
        modelAndView.addObject("listId", prodIdList);
        modelAndView.addObject("catList", categoryIdList);
        modelAndView.addObject("modprod", product);
        return modelAndView;
    }

    private List<Integer> getCategoryIdList (List<Category> categoryList) {
        List<Integer> categoryIdList = new ArrayList<>();
        for (int i = 0; i < categoryList.size(); i++) {
            categoryIdList.add(categoryList.get(i).getCategoryID());
        }
        return categoryIdList;
    }

    private List<Integer> getProdIdList (List<Product> productList, int id) {
        List<Integer> proIdList = new ArrayList<>();
        proIdList.add(0);
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getProductID() == id) continue;
            proIdList.add(productList.get(i).getProductID());
        }
        return proIdList;
    }
}
