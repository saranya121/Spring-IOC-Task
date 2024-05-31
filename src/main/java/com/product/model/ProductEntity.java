package com.product.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Document(collection = "product")
@Getter
@Setter
public class ProductEntity {
	@Id
	private ObjectId id;
	
	private String productId;

	private String category;

	private String productName;

	private Double price;

	private boolean activeStatus=true;

}
