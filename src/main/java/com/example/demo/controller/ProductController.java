package com.example.demo.controller;

import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;
import com.example.demo.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {
	private final ProductService productService;

    @GetMapping
    public String getMainPage() {
        return "index";
    }

    @GetMapping("/form")
    public String getProductForm(Product product) {
        return "product-add";
    }

    @GetMapping("/update")
    public String getUpdateForm(@RequestParam("code") String code, Model model) {
        model.addAttribute("product", productService.getById(code));
        return "product-update";
    }

    @GetMapping("/delete")
    public String getDeleteForm(@RequestParam("code") String code, Model model) {
        model.addAttribute("product", productService.getById(code));
        return "product-delete";
    }

    @GetMapping("/all")
    public String getAllProduct(Model model) {
        model.addAttribute("list", productService.findAll());
        return "product-list";
    }

    @PostMapping("/add")
    public String addProduct(Product product, Model model) {
        boolean codeExist = productService.checkCodeExist(product.getCode());
        if (codeExist) {
            model.addAttribute("error", "Product code is Exist");
            model.addAttribute("product", product);
            return "product-add";
        } else
			productService.save(product);
        return "redirect:/product/all";
    }

    @PostMapping("/update")
    public String updateProduct(Product product) {
		productService.save(product);
        return "redirect:/product/all";
    }

    @PostMapping("/delete")
    public String deleteProduct(@RequestParam("code") String code) {
		productService.deleteById(code);
        return "redirect:/product/all";
    }
}
