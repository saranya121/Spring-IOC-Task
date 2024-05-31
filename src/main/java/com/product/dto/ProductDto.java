package com.product.dto;

import org.bson.types.ObjectId;

import com.mongodb.lang.NonNull;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class ProductDto {
	private ObjectId id;
	private String searchData;
    @NonNull
	private String productId;
    @NonNull
	private String productName;
    @NonNull
	private String category;
    @NonNull
	private double price;
	

}
