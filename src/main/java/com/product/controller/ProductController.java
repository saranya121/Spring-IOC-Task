package com.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.product.dto.ProductDto;
import com.product.service.ProductService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class ProductController {

	@Autowired
	ProductService productService;

	/**
	 * index page
	 * 
	 * @return
	 */
	@RequestMapping(value = {"/"})
	public String indexProduct() {
		return "product";
	}

	/**
	 * Form Page - Add
	 * 
	 * @param productDto
	 * @param request
	 * @param response
	 * @return
	 */
	@GetMapping("/add")
	public String addProduct(ModelMap model) {
		model.addAttribute("productDto", new ProductDto());
		return "add-edit-product";

	}

	/**
	 * Save Product
	 * 
	 * @param productDto
	 * @param request
	 * @param response
	 * @return
	 */
	@PostMapping("/save")
	public String saveProduct(ProductDto productDto, HttpServletRequest request, HttpServletRequest response) {
		ModelMap model = new ModelMap();
		model.addAttribute("productDto", new ProductDto());
		productService.saveProduct(productDto);
		return "redirect:/displayAll";

	}

	/**
	 * Display All Products
	 * 
	 * @param model
	 * @return
	 */
	@GetMapping("/displayAll")
	public String displayAllProducts(ModelMap model) {
		model.addAttribute("productList", productService.displayAllProducts());
		model.addAttribute("productDto", new ProductDto());
		return "display-product";
	}

	/**
	 * Display a product by Category Name
	 * 
	 * @param model
	 * @param productDto
	 * @return
	 */
	@PostMapping("/display")
	public String displayProduct(ModelMap model, ProductDto productDto) {
		model.addAttribute("productList", productService.displayProduct(productDto));
		model.addAttribute("productDto", productDto);
		return "display-product";
	}

}
