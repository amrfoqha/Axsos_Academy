package com.example.productsandcategories.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.productsandcategories.models.Product;
import com.example.productsandcategories.models.Category;
import com.example.productsandcategories.services.ProductService;
import com.example.productsandcategories.services.CategoryService;


import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;

@Controller
public class HomeController {
    @Autowired
    ProductService productService;
    @Autowired
    CategoryService categoryService;

    @RequestMapping(value = "/**")
    public String redirect() {
        return "redirect:/";
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        model.addAttribute("categories", categoryService.getAllCategories());
        return "home.jsp";
    }

    @GetMapping("/new/product")
    public String showNewProduct(@ModelAttribute("product") Product product) {
        return "newproduct.jsp";
    }

    @PostMapping("/new/product")
    public String newProduct(@Valid @ModelAttribute("product") Product product, BindingResult result) {
        if (result.hasErrors()) {
            return "newproduct.jsp";
        }
        productService.createProduct(product);
        return "redirect:/";

    }

    @GetMapping("/new/category")
    public String showNewCategory(@ModelAttribute("category") Category category) {
        return "newcategory.jsp";
    }

    @PostMapping("/new/category")
    public String newCategory(@Valid @ModelAttribute("category") Category category, BindingResult result) {
        if (result.hasErrors()) {
            return "newcategory.jsp";
        }
        categoryService.createCategory(category);
        return "redirect:/";
    }
    @GetMapping("/details/product/{id}")
    public String showAddCategory(@ModelAttribute("category") Category category, @PathVariable("id") Long id,
              Model model) {
          model.addAttribute("product", productService.findProductById(id));      
          model.addAttribute("categories", categoryService.categoriesNotON(productService.findProductById(id)));
          return "AddCategory.jsp";
      }
    @GetMapping("/details/category/{id}")
    public String showAddProduct(@ModelAttribute("product") Product product, @PathVariable("id") Long id,
            Model model) {
          model.addAttribute("category", categoryService.findCategoryById(id));      
          model.addAttribute("products", productService.productsNotON(categoryService.findCategoryById(id)));
          return "AddProduct.jsp";
    }
    @PostMapping("/details/category/{id}")
    public String addProduct(@RequestParam(value = "categoryId",required = false )Long productId,
                         @PathVariable("id") Long id,
        Model model) {

                            System.out.println("********************************"+productId);
        if(productId == null) {
        model.addAttribute("category", categoryService.findCategoryById(id));
        model.addAttribute("products", productService.productsNotON(categoryService.findCategoryById(id)));
        model.addAttribute("errorMessage", "Please select a product!");
        return "AddProduct.jsp";
    }

    categoryService.linkTo(productId, id);
    return "redirect:/details/category/" + id;
    }
    @PostMapping("/details/product/{id}")
    public String addCategory(@RequestParam(value = "categoryId",required = false ) Long categoryId,
                         @PathVariable("id") Long id,
        Model model) {

                            System.out.println("********************************"+categoryId);
        if(categoryId==null) {
        model.addAttribute("product", productService.findProductById(id));
        model.addAttribute("products", categoryService.categoriesNotON(productService.findProductById(id)));
        model.addAttribute("errorMessage", "Please select a Category!");
        return "AddProduct.jsp";
    }

    productService.linkTo(categoryId, id);
    return "redirect:/details/product/" + id;
    }


}
