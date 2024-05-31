package com.product.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.dto.ProductDto;
import com.product.model.ProductEntity;
import com.product.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	ProductRepository productRepository;

	public List<ProductDto> displayAllProducts() {
		List<ProductEntity> productEntity = productRepository.findByActiveStatus(true);
		return productEntity.stream()
				.map(s -> new ProductDto(s.getProductId(), s.getProductName(), s.getCategory(), s.getPrice()))
				.collect(Collectors.toList());
	}

	public String saveProduct(ProductDto productDto) {
		ProductEntity prodEntity = new ProductEntity();
		prodEntity.setProductId(productDto.getProductId());
		prodEntity.setCategory(productDto.getCategory());
		prodEntity.setProductName(productDto.getProductName());
		prodEntity.setPrice(productDto.getPrice());
		productRepository.save(prodEntity);
		return "save";

	}

	public List<ProductDto> displayProduct(ProductDto productDto1) {
		List<ProductEntity> productEntity = productRepository.findByActiveStatusAndCategoryIgnoreCase(true,
				productDto1.getSearchData());
		return productEntity.stream()
				.map(s -> new ProductDto(s.getProductId(), s.getProductName(), s.getCategory(), s.getPrice()))
				.collect(Collectors.toList());
	}

}
